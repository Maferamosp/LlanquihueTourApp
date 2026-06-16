package model;

public class GuiaTuristico {
    private String nombre;
    private String telefono;
    private int id;

    public GuiaTuristico(String nombre, String telefono, int id) {
        this.id = id;
        this.telefono = telefono;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\n" +
                "Nombre: " + nombre + "\n" +
                "Telefono: " + telefono;
    }
}
