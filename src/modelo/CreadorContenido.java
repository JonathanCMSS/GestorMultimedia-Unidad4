package modelo;

public class CreadorContenido {

    /**
     * Crea un objeto Contenido según el tipo y parámetros recibidos.
     * @param tipo         "pelicula", "podcast" o "videojuego"
     * @param titulo       título del contenido
     * @param autor        autor o creador
     * @param anio         año de lanzamiento
     * @param atributo1    género/plataforma o número episodios, según tipo
     * @param atributo2    duración en minutos o tema, según tipo
     * @return Contenido creado o null si tipo inválido
     */
    public static Contenido crearContenido(String tipo, String titulo, String autor, int anio, String atributo1, String atributo2) {
        switch (tipo.toLowerCase()) {
            case "pelicula":
                int duracion = Integer.parseInt(atributo2);
                return new Pelicula(titulo, autor, anio, atributo1, duracion);
            case "podcast":
                int episodios = Integer.parseInt(atributo1);
                return new Podcast(titulo, autor, anio, episodios, atributo2);
            case "videojuego":
                return new Videojuego(titulo, autor, anio, atributo1, atributo2);
            default:
                return null;
        }
    }
}
