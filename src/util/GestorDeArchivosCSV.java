package util;

import modelo.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorDeArchivosCSV {

    private static final String SEPARADOR = ",";

    public List<Contenido> leerContenidosDesdeCSV(String rutaArchivo) {
        List<Contenido> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(SEPARADOR);
                if (partes.length >= 6) {
                    String tipo = partes[0].trim();
                    String titulo = partes[1].trim();
                    String autor = partes[2].trim();
                    int anio = Integer.parseInt(partes[3].trim());
                    String attr1 = partes[4].trim();
                    String attr2 = partes[5].trim();

                    Contenido contenido = CreadorContenido.crearContenido(tipo, titulo, autor, anio, attr1, attr2);
                    if (contenido != null) {
                        lista.add(contenido);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer archivo CSV: " + e.getMessage());
        }
        return lista;
    }

    public void guardarContenidosEnCSV(String rutaArchivo, List<Contenido> lista) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(rutaArchivo))) {
            for (Contenido c : lista) {
                String linea = construirLineaCSV(c);
                pw.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al guardar archivo CSV: " + e.getMessage());
        }
    }

    private String construirLineaCSV(Contenido c) {
        String tipo = c.getTipo().toLowerCase();
        String titulo = c.getTitulo();
        String autor = c.getAutor();
        int anio = c.getAnio();

        if (c instanceof Pelicula) {
            Pelicula p = (Pelicula) c;
            return String.join(SEPARADOR, tipo, titulo, autor, String.valueOf(anio), p.getGenero(), String.valueOf(p.getDuracionMinutos()));
        } else if (c instanceof Podcast) {
            Podcast p = (Podcast) c;
            return String.join(SEPARADOR, tipo, titulo, autor, String.valueOf(anio), String.valueOf(p.getNumeroEpisodios()), p.getTema());
        } else if (c instanceof Videojuego) {
            Videojuego v = (Videojuego) c;
            return String.join(SEPARADOR, tipo, titulo, autor, String.valueOf(anio), v.getPlataforma(), v.getGenero());
        } else {
            return "";
        }
    }
}

