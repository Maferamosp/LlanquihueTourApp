package main.model;

public class ProveedorAlojamiento {
    private String id;
    private String nombre;
    private String nombreEstablecimiento;
    private int capacidadMaxima;

    public ProveedorAlojamiento(String id, String nombre, String nombreEstablecimiento, int capacidadMaxima) {
        this.id = id;
        this.nombre = nombre;
        this.nombreEstablecimiento = nombreEstablecimiento;
        this.capacidadMaxima = capacidadMaxima;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNombreEstablecimiento() { return nombreEstablecimiento; }
    public void setNombreEstablecimiento(String nombreEstablecimiento) {
        this.nombreEstablecimiento = nombreEstablecimiento;
    }

    public int getCapacidadMaxima() { return capacidadMaxima; }
    public void setCapacidadMaxima(int capacidadMaxima) { this.capacidadMaxima = capacidadMaxima; }

    @Override
    public String toString() {
        return "Id: " + id + "\n" +
                "Nombre: " + nombre + "\n" +
                "Establecimiento: " + nombreEstablecimiento + "\n" +
                "Capacidad maxima: " + capacidadMaxima;
    }
}
