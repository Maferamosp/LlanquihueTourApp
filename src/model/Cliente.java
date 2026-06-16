package model;

public class Cliente {
    private String nombre;
    private int id;
    private GuiaTuristico guiaTuristico;
    private Tour tour;

    public Cliente(String nombre, int id, GuiaTuristico guiaTuristico, Tour tour) {
        this.guiaTuristico = guiaTuristico;
        this.nombre = nombre;
        this.id = id;
        this.tour = tour;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GuiaTuristico getGuiaTuristico() {
        return guiaTuristico;
    }

    public void setGuiaTuristico(GuiaTuristico guiaTuristico) {
        this.guiaTuristico = guiaTuristico;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "Id: " + id + "\n" +
                "Guia turistico: " + getGuiaTuristico().getNombre() + "\n" +
                "Nombre del tour: " + getTour().getNombre();
    }
}
