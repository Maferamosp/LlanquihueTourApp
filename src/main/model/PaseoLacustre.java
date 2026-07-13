package main.model;

public class PaseoLacustre extends ServicioTuristico implements Registrable {

    private String tipoEmbarcacion;

    public PaseoLacustre(String nombre, int duracionHoras, String tipoEmbarcacion) {
        super(nombre, duracionHoras);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("------PASEO LACUSTRE-----" + "\n");
        System.out.println("Nombre del servicio: " + nombre + "\n");
        System.out.println("Duración de horas: " + duracionHoras + "\n");
        System.out.println("Tipo de embarcación: " + tipoEmbarcacion + "\n");
    }

    @Override
    public String toString() {
        return "Paseo Lacustre" +
                "\n" + super.toString() +
                "\nTipo de embarcación: " + tipoEmbarcacion;
    }

    @Override
    public String mostrarResumen() {
        return toString();
    }
}