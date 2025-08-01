package modelo;

public class Pelicula extends Contenido {
    private String genero;
    private int duracionMinutos;

    public Pelicula(String titulo, String autor, int anio, String genero, int duracionMinutos) {
        super(titulo, autor, anio);
        this.genero = genero;
        this.duracionMinutos = duracionMinutos;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    @Override
    public String getTipo() {
        return "Película";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Género: %s, Duración: %d min", genero, duracionMinutos);
    }
}
