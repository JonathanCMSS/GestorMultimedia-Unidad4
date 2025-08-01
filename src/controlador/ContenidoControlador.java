package controlador;

import modelo.*;
import util.GestorDeArchivosCSV;

import java.util.List;

public class ContenidoControlador {

    private final RepositorioContenido repo;
    private final GestorDeArchivosCSV gestorCSV;

    public ContenidoControlador() {
        repo = new RepositorioContenido();
        gestorCSV = new GestorDeArchivosCSV();
    }

    public void cargarDatosDesdeCSV(String rutaArchivo) {
        List<Contenido> lista = gestorCSV.leerContenidosDesdeCSV(rutaArchivo);
        for (Contenido c : lista) {
            repo.agregarContenido(c);
        }
    }

    public void guardarDatosEnCSV(String rutaArchivo) {
        gestorCSV.guardarContenidosEnCSV(rutaArchivo, repo.getListaContenido());
    }

    public void agregarContenido(Contenido contenido) {
        repo.agregarContenido(contenido);
    }

    public boolean eliminarContenidoPorTitulo(String titulo) {
        Contenido c = repo.buscarPorTitulo(titulo);
        if (c != null) {
            return repo.eliminarContenido(c);
        }
        return false;
    }

    public List<Contenido> listarContenidos() {
        return repo.getListaContenido();
    }

    public Contenido buscarContenido(String titulo) {
        return repo.buscarPorTitulo(titulo);
    }

    public int cantidadContenidos() {
        return repo.cantidad();
    }
}
