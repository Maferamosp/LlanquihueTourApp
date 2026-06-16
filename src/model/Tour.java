package model;

public class Tour {
    private int id;
    private String nombre;
    private int precio;
    private String description;


    public Tour(int id, String nombre, int precio, String description) {
        this.description = description;
        this.id = id;
        this.nombre = nombre;
        this. precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\n" +
                "Nombre: " + nombre + "\n" +
                "Description: " + description + "\n" +
                "Precio: " + precio;
    }
}
