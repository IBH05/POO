import java.io.IOException;
public class Pelicula {
    private final String id;
    private String titulo;
    private String genero;
    private String clasificacion;
    private String sinopsis;
    private int duracion;
    private String posterPath;  

    public Pelicula(String id, String titulo, String genero, String clasificacion, String sinopsis, int duracion, String posterPath) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.clasificacion = clasificacion;
        this.sinopsis = sinopsis;
        this.duracion = duracion;
        this.posterPath = posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public void mostrarPoster() {
        if (posterPath != null) {
            try {
                java.nio.file.Path path = java.nio.file.Paths.get(posterPath);
                String contenidoPoster = java.nio.file.Files.readString(path);
                
                System.out.println("\n===== PÓSTER DE LA PELÍCULA =====");
                System.out.println(contenidoPoster);
            } catch (IOException e) {
                System.out.println("No se pudo cargar el póster de la película.");
            }
        } else {
            System.out.println("No hay póster disponible para esta película.");
        }
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getPosterPath() {
        return posterPath;
    }
}
