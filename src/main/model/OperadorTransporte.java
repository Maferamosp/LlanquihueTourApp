package main.model;

public class OperadorTransporte {
    private int id;
    private String nombre;
    private String telefono;
    private String tipoVehiculo;

    public OperadorTransporte(int id, String nombre, String telefono, String tipoVehiculo) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getTipoVehiculo() { return tipoVehiculo; }
    public void setTipoVehiculo(String tipoVehiculo) { this.tipoVehiculo = tipoVehiculo; }

    @Override
    public String toString() {
        return "Id: " + id + "\n" +
                "Nombre: " + nombre + "\n" +
                "Telefono: " + telefono + "\n" +
                "Tipo de vehiculo: " + tipoVehiculo;
    }
}
