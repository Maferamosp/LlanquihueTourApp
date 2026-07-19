package main.model;

public class Reserva implements Registrable {
    private static final String[] ESTADOS_VALIDOS = {"PENDIENTE", "CONFIRMADA", "CANCELADA"};

    private int id;
    private Cliente cliente;
    private Tour tour;
    private String fecha;
    private String estado;

    public Reserva(int id, Cliente cliente, Tour tour, String fecha) {
        this.id = id;
        this.cliente = cliente;
        this.tour = tour;
        this.fecha = fecha;
        this.estado = "PENDIENTE";
    }

    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Tour getTour() { return tour; }
    public String getFecha() { return fecha; }
    public String getEstado() { return estado; }

    public void setEstado(String estado) throws Exception {
        for (String estadoValido : ESTADOS_VALIDOS) {
            if (estadoValido.equals(estado)) {
                this.estado = estado;
                return;
            }
        }
        throw new Exception("Estado invalido. Use: PENDIENTE, CONFIRMADA o CANCELADA.");
    }

    @Override
    public String mostrarResumen() {
        return "Reserva ID: " + id + "\n" +
                "Cliente: " + cliente.getNombre() + "\n" +
                "Tour: " + tour.getNombre() + "\n" +
                "Fecha: " + fecha + "\n" +
                "Estado: " + estado;
    }

    @Override
    public String toString() {
        return mostrarResumen();
    }
}
