package main.model;

public class ServicioTuristico {

    protected String nombre;
    protected int duracionHoras;

    public ServicioTuristico(String nombre, int duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nDuración: " + duracionHoras + " horas";
    }
}