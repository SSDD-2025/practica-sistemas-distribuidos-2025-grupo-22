import java.sql.Blob;

package cartas.demo.model;

public class Card {
    private Long id;
    @Lob
    private Blob imagen;
    private String nombre;
    private String descripcion;
    private int coste; 

    // Constructor vacío
    public Card() {
    }

    // Constructor con parámetros
    public Card(Long id, Blob imagen, String nombre, String descripcion, int coste) { // Cambiado a int
        this.id = id;
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.coste = coste;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCoste() { 
        return coste;
    }

    public void setCoste(int coste) { 
        this.coste = coste;
    }
}
