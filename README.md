# GestorMedia

GestorMedia es una aplicación para la gestión integral de contenido audiovisual, que incluye películas, podcasts y videojuegos. El proyecto está diseñado bajo los principios de programación orientada a objetos y se enfoca en la calidad del código mediante la aplicación de principios SOLID, código limpio y el patrón arquitectónico Modelo-Vista-Controlador (MVC). Además, implementa persistencia de datos usando archivos CSV y cuenta con pruebas unitarias para asegurar su correcto funcionamiento.

## Características principales

- Gestión de contenido audiovisual: agregar, buscar y eliminar películas, podcasts y videojuegos.
- Persistencia de datos mediante lectura y escritura en archivos CSV.
- Diseño modular y mantenible aplicando principios SOLID.
- Separación de responsabilidades mediante el patrón MVC.
- Pruebas unitarias con JUnit 5 para validar las funcionalidades clave.
- Interfaz basada en consola para una interacción sencilla.

## Estructura del proyecto
/GestorMedia
│
├── src/
│   ├── aplicacion/
│   │   └── Main.java
│   ├── controlador/
│   │   └── ContenidoControlador.java
│   ├── modelo/
│   │   ├── Contenido.java
│   │   ├── Pelicula.java
│   │   ├── Podcast.java
│   │   ├── Videojuego.java
│   │   ├── CreadorContenido.java
│   │   └── RepositorioContenido.java
│   ├── util/
│   │   └── GestorDeArchivosCSV.java
│   └── vista/
│       └── ConsolaVista.java
│
├── test/
│   └── modelo/
│       └── RepositorioContenidoTest.java
│
├── README.md
└── .gitignore
## Requisitos

- JDK 11 o superior.
- IDE recomendado: Eclipse, IntelliJ IDEA u otro compatible con Java.
- JUnit 5 para pruebas unitarias.
  
## Instalación y ejecución

1. Clona este repositorio:

```bash
git clone https://github.com/tu_usuario/GestorMedia.git
