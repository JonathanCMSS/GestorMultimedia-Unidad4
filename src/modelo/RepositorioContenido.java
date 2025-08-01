package modelo;

import java.util.ArrayList;
import java.util.List;

public class RepositorioContenido {
    private final List<Contenido> listaContenido;

    public RepositorioContenido() {
        this.listaContenido = new ArrayList<>();
    }

    public void agregarContenido(Contenido contenido) {
        listaContenido.add(contenido);
    }

    public boolean eliminarContenido(Contenido contenido) {
        return listaContenido.remove(contenido);
    }

    public List<Contenido> getListaContenido() {
        return new ArrayList<>(listaContenido);
    }

    public Contenido buscarPorTitulo(String titulo) {
        for (Contenido c : listaContenido) {
            if (c.getTitulo().equalsIgnoreCase(titulo)) {
                return c;
            }
        }
        return null;
    }

    public int cantidad() {
        return listaContenido.size();
    }
}
