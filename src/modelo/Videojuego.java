package modelo;

public class Videojuego extends Contenido {
    private String plataforma;
    private String genero;

    public Videojuego(String titulo, String autor, int anio, String plataforma, String genero) {
        super(titulo, autor, anio);
        this.plataforma = plataforma;
        this.genero = genero;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String getTipo() {
        return "Videojuego";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Plataforma: %s, Género: %s", plataforma, genero);
    }
}
