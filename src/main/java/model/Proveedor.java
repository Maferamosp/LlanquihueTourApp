package main.java.model;

public class Proveedor {
    private String nombre;
    private String nombreEmpresa;
    private String id;

    public Proveedor(String nombre, String nombreEmpresa, String id) {
        this.nombre = nombre;
        this.nombreEmpresa = nombreEmpresa;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    @Override
    public String toString() {
        return id + "," + nombre + "," + nombreEmpresa;
    }
}

