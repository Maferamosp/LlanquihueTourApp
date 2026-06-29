package main.model;

public class RutaGastronomica extends ServicioTuristico {

    private int numeroDeParadas;

    public RutaGastronomica(String nombre, int duracionHoras, int numeroDeParadas) {
        super(nombre, duracionHoras);
        this.numeroDeParadas = numeroDeParadas;
    }

    @Override
    public String toString() {
        return "Ruta Gastronómica" +
                "\n" + super.toString() +
                "\nNúmero de paradas: " + numeroDeParadas;
    }
}