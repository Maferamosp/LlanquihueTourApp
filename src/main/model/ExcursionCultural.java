package main.model;

public class ExcursionCultural extends ServicioTuristico implements Registrable {
    private String lugarHistorico;

    public ExcursionCultural(String nombre, int duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);
        this.lugarHistorico = lugarHistorico;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("------EXCURSION CULTURAL-----" + "\n");
        System.out.println("Nombre del servicio: " + nombre + "\n");
        System.out.println("Duración de horas: " + duracionHoras + "\n");
        System.out.println("Lugar hisotrico: " + lugarHistorico + "\n");
    }

    @Override
    public String toString() {
        return "Excursion Cultural" +
                "\n" + super.toString() +
                "\nLugar histórico: " + lugarHistorico;
    }

    @Override
    public String mostrarResumen() {
        return toString();
    }
}