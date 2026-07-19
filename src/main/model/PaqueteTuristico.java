package main.model;

import java.util.ArrayList;
import java.util.List;

public class PaqueteTuristico implements Registrable {
    private String nombre;
    private int precio;
    private GuiaTuristico guia;
    private OperadorTransporte operador;
    private List<ServicioTuristico> servicios;

    public PaqueteTuristico(String nombre, int precio, GuiaTuristico guia, OperadorTransporte operador) {
        this.nombre = nombre;
        this.precio = precio;
        this.guia = guia;
        this.operador = operador;
        this.servicios = new ArrayList<>();
    }

    public void agregarServicio(ServicioTuristico servicio) {
        servicios.add(servicio);
    }

    public String getNombre() {
        return nombre;
    }
    public int getPrecio() {
        return precio;
    }
    public GuiaTuristico getGuia() {
        return guia;
    }
    public OperadorTransporte getOperador() {
        return operador;
    }
    public List<ServicioTuristico> getServicios() {
        return servicios;
    }

    @Override
    public String mostrarResumen() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paquete: ").append(nombre).append("\n");
        sb.append("Precio: ").append(precio).append("\n");
        sb.append("Guia: ").append(guia.getNombre()).append("\n");
        sb.append("Operador: ").append(operador.getNombre()).append(" (").append(operador.getTipoVehiculo()).append(")\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return mostrarResumen();
    }
}
