package data;

import model.Cliente;
import model.GuiaTuristico;
import model.Tour;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorDatos {
    public ArrayList<Cliente>  cargarClientes() throws FileNotFoundException {
        ArrayList<Cliente> cliente = new ArrayList<>();
        File archivo = new File("resources/tour.txt");
        Scanner lector = new Scanner(archivo);


        while (lector.hasNextLine()) {
            String linea = lector.nextLine();

            String[] datos = linea.split(";");

            Cliente nuevoCliente = new Cliente(
                    datos[0],
                    Integer.parseInt(datos[1]),
                    new GuiaTuristico(
                            datos[2],
                            datos[3],
                            Integer.parseInt(datos[4])
                    ),
                    new Tour(
                            Integer.parseInt(datos[5]),
                            datos[6],
                            Integer.parseInt(datos[7]),
                            datos[8]
                    )
            );

            cliente.add(nuevoCliente);
        }

        return cliente;
    }
}
