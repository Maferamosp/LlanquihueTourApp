package main.model;

public class RutaGastronomica extends ServicioTuristico {

    private int numeroDeParadas;

    public RutaGastronomica(String nombre, int duracionHoras, int numeroDeParadas) {
        super(nombre, duracionHoras);
        this.numeroDeParadas = numeroDeParadas;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("------RUTA GASTRONOMICA-----" + "\n");
        System.out.println("Nombre del servicio: " + nombre + "\n");
        System.out.println("Duración de horas: " + duracionHoras + "\n");
        System.out.println("Numero de paradas: " + numeroDeParadas + "\n");
    }

    @Override
    public String toString() {
        return "Ruta Gastronómica" +
                "\n" + super.toString() +
                "\nNúmero de paradas: " + numeroDeParadas;
    }
}