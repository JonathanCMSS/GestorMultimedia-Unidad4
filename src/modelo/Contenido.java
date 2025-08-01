package modelo;

public abstract class Contenido {
    private String titulo;
    private String autor;
    private int anio;

    public Contenido(String titulo, String autor, int anio) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return String.format("%s - %s (Autor: %s, Año: %d)", getTipo(), titulo, autor, anio);
    }
}
