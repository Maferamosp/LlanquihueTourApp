package main.model;

public class ServicioTuristico {

    protected String nombre;
    protected int duracionHoras;

    public ServicioTuristico(String nombre, int duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre del servicio: " + nombre + "\n");
        System.out.println("Duración de horas: " + duracionHoras + "\n");
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nDuración: " + duracionHoras + " horas";
    }
}