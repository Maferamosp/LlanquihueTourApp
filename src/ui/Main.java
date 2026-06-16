package ui;

import data.GestorDatos;
import model.Cliente;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        GestorDatos gestorDatos = new GestorDatos();

        ArrayList<Cliente> clientesColleccion = gestorDatos.cargarClientes();

        for (Cliente cliente : clientesColleccion) {
            System.out.println("Todos los clientes: ");
            System.out.println(cliente);
            System.out.println("\n -----------------");

        }

        for (Cliente cliente : clientesColleccion) {
            if (cliente.getTour().getNombre().contains("Playa")) {
                System.out.println("Tours de playa");
                System.out.println(cliente);
            }
        }
    }
}
