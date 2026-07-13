package main.data;

import main.model.Registrable;

import java.util.ArrayList;
import java.util.List;

public class GestorEntidades {
    private List<Registrable> entidades = new ArrayList<>();

    public GestorEntidades() {
        entidades = new ArrayList<>();
    }

    public void agregarEntidad(Registrable entidad) {
        entidades.add(entidad);
    }

    public void mostrarEntidades() {
        for (Registrable entidad : entidades) {
            System.out.println(entidad.mostrarResumen());
        }
    }

    public List<Registrable> obtenerEntidades() {
        return entidades;
    }
}
