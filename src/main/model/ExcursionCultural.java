package main.model;

public class ExcursionCultural extends ServicioTuristico{
    private String lugarHistorico;

    public ExcursionCultural(String nombre, int duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);
        this.lugarHistorico = lugarHistorico;
    }

    @Override
    public String toString() {
        return "Excursión Cultural" +
                "\n" + super.toString() +
                "\nLugar histórico: " + lugarHistorico;
    }
}