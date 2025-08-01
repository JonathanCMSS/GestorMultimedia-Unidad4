package test.modelo;

import modelo.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RepositorioContenidoTest {

    private RepositorioContenido repo;
    private Pelicula peliculaEjemplo;

    @BeforeEach
    public void setUp() {
        repo = new RepositorioContenido();
        peliculaEjemplo = new Pelicula("Inception", "Christopher Nolan", 2010, "Ciencia ficción", 148);
    }

    @Test
    public void testAgregarContenido() {
        assertEquals(0, repo.cantidad());
        repo.agregarContenido(peliculaEjemplo);
        assertEquals(1, repo.cantidad());
    }

    @Test
    public void testBuscarPorTitulo() {
        repo.agregarContenido(peliculaEjemplo);
        Contenido c = repo.buscarPorTitulo("Inception");
        assertNotNull(c);
        assertEquals("Inception", c.getTitulo());
    }

    @Test
    public void testEliminarContenido() {
        repo.agregarContenido(peliculaEjemplo);
        boolean eliminado = repo.eliminarContenido(peliculaEjemplo);
        assertTrue(eliminado);
        assertEquals(0, repo.cantidad());
    }
}
