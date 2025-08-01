package aplicacion;

import controlador.ContenidoControlador;
import modelo.Contenido;
import modelo.CreadorContenido;
import vista.ConsolaVista;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ContenidoControlador controlador = new ContenidoControlador();
        ConsolaVista vista = new ConsolaVista();

        String rutaCSV = "contenidos.csv";
        controlador.cargarDatosDesdeCSV(rutaCSV);

        boolean salir = false;
        while (!salir) {
            vista.mostrarMenu();
            int opcion = vista.leerOpcion();

            switch (opcion) {
                case 1:
                    List<Contenido> lista = controlador.listarContenidos();
                    vista.mostrarListaContenidos(lista);
                    break;
                case 2:
                    String tipo = vista.leerTexto("Ingrese tipo (pelicula/podcast/videojuego): ").toLowerCase();
                    String titulo = vista.leerTexto("Ingrese título: ");
                    String autor = vista.leerTexto("Ingrese autor: ");
                    int anio = vista.leerEntero("Ingrese año: ");

                    String attr1 = "";
                    String attr2 = "";

                    switch (tipo) {
                        case "pelicula":
                            attr1 = vista.leerTexto("Ingrese género: ");
                            attr2 = String.valueOf(vista.leerEntero("Ingrese duración (minutos): "));
                            break;
                        case "podcast":
                            attr1 = String.valueOf(vista.leerEntero("Ingrese número de episodios: "));
                            attr2 = vista.leerTexto("Ingrese tema: ");
                            break;
                        case "videojuego":
                            attr1 = vista.leerTexto("Ingrese plataforma: ");
                            attr2 = vista.leerTexto("Ingrese género: ");
                            break;
                        default:
                            vista.mostrarMensaje("Tipo inválido.");
                            continue;
                    }

                    Contenido nuevo = CreadorContenido.crearContenido(tipo, titulo, autor, anio, attr1, attr2);
                    if (nuevo != null) {
                        controlador.agregarContenido(nuevo);
                        vista.mostrarMensaje("Contenido agregado con éxito.");
                    } else {
                        vista.mostrarMensaje("Error al crear contenido.");
                    }
                    break;
                case 3:
                    String tituloBusqueda = vista.leerTexto("Ingrese título a buscar: ");
                    Contenido encontrado = controlador.buscarContenido(tituloBusqueda);
                    if (encontrado != null) {
                        vista.mostrarMensaje("Contenido encontrado:");
                        vista.mostrarMensaje(encontrado.toString());
                    } else {
                        vista.mostrarMensaje("No se encontró contenido con ese título.");
                    }
                    break;
                case 4:
                    String tituloEliminar = vista.leerTexto("Ingrese título a eliminar: ");
                    boolean eliminado = controlador.eliminarContenidoPorTitulo(tituloEliminar);
                    if (eliminado) {
                        vista.mostrarMensaje("Contenido eliminado.");
                    } else {
                        vista.mostrarMensaje("No se encontró contenido con ese título.");
                    }
                    break;
                case 5:
                    controlador.guardarDatosEnCSV(rutaCSV);
                    vista.mostrarMensaje("Datos guardados. Saliendo...");
                    salir = true;
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida. Intente nuevamente.");
            }
            System.out.println();
        }
    }
}
