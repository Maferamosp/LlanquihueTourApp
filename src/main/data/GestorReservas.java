package main.data;

import main.model.Reserva;

import java.util.ArrayList;
import java.util.List;

public class GestorReservas {
    private List<Reserva> reservas = new ArrayList<>();

    public void agregarReserva(Reserva reserva) throws Exception {
        for (Reserva r : reservas) {
            if (r.getId() == reserva.getId()) {
                throw new Exception("Ya existe una reserva con el ID: " + reserva.getId());
            }
            if (r.getCliente().getId() == reserva.getCliente().getId()
                    && r.getTour().getId() == reserva.getTour().getId()
                    && r.getFecha().equals(reserva.getFecha())) {
                throw new Exception("El cliente ya tiene una reserva para ese tour en esa fecha.");
            }
        }
        reservas.add(reserva);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public Reserva buscarPorId(int id) {
        for (Reserva r : reservas) {
            if (r.getId() == id) return r;
        }
        return null;
    }
}
