package modelo;

public class Podcast extends Contenido {
    private int numeroEpisodios;
    private String tema;

    public Podcast(String titulo, String autor, int anio, int numeroEpisodios, String tema) {
        super(titulo, autor, anio);
        this.numeroEpisodios = numeroEpisodios;
        this.tema = tema;
    }

    public int getNumeroEpisodios() {
        return numeroEpisodios;
    }

    public String getTema() {
        return tema;
    }

    @Override
    public String getTipo() {
        return "Podcast";
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Episodios: %d, Tema: %s", numeroEpisodios, tema);
    }
}
