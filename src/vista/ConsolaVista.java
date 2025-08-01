package vista;

import modelo.Contenido;

import java.util.List;
import java.util.Scanner;

public class ConsolaVista {
    private final Scanner scanner;

    public ConsolaVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("=== Gestor Multimedia ===");
        System.out.println("1. Listar contenidos");
        System.out.println("2. Agregar contenido");
        System.out.println("3. Buscar contenido");
        System.out.println("4. Eliminar contenido");
        System.out.println("5. Salir");
        System.out.print("Seleccione opción: ");
    }

    public int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void mostrarListaContenidos(List<Contenido> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay contenidos disponibles.");
        } else {
            System.out.println("Lista de contenidos:");
            for (Contenido c : lista) {
                System.out.println("- " + c);
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String leerTexto(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int leerEntero(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
            }
        }
    }
}
