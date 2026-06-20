package main.java.data;

import main.java.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GestorDatos {
    public static final String DATA_FILE_OUTPUT = "listaDeProveedores.txt";

    public ArrayList<Cliente>  cargarClientes() throws FileNotFoundException {
        ArrayList<Cliente> clientes = new ArrayList<>();
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

            clientes.add(nuevoCliente);
        }

        return clientes;
    }

    public void guardarProveedoresEnTxt(Proveedores proveedores) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE_OUTPUT))){
            writer.write(proveedores.getTipoDeServicio() + "\n");

            for (Object proveedor : proveedores.getListaProveedores()) {
                writer.write(proveedor.toString()+"\n");
            }
        } catch (Exception e) {
            System.out.println("Error al guardar proveedores: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Proveedores leerDatosDeProveedorDesdeTxt() {
        Proveedores proveedores = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE_OUTPUT));
            String tipoDeServicio = reader.readLine();

            if (tipoDeServicio != null) {
                proveedores = new Proveedores(tipoDeServicio);
                String proveedor;

                while ( (proveedor = reader.readLine()) != null ) {
                    String[] datos = proveedor.split(",");
                    String idDelProveedor = datos[0];
                    String nombre = datos[1];
                    String nombreEmpresa = datos[2];

                    Proveedor nuevoProveedor = new Proveedor(
                            nombre,
                            nombreEmpresa,
                            idDelProveedor
                    );

                    proveedores.agregarProveedor(nuevoProveedor);
                }
            }

        } catch (Exception e) {
            System.out.println("Error al leer proveedores: " + e.getMessage());
            throw new RuntimeException(e);
        }

        return proveedores;
    }

    public Proveedor obtenerElProveedorPorId(String id) {
        Proveedor proveedorFiltrado = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE_OUTPUT));
            String tipoDeServicio = reader.readLine();

            if (tipoDeServicio != null) {
                String proveedor;

                while ( (proveedor = reader.readLine()) != null ) {
                    String[] datos = proveedor.split(",");
                    String idDelProveedor = datos[0];

                    if (idDelProveedor.equals(id)) {
                        proveedorFiltrado = new Proveedor(
                                datos[1],
                                datos[2],
                                datos[0]
                        );
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error al leer proveedores: " + e.getMessage());
            throw new RuntimeException(e);
        }

        return proveedorFiltrado;
    }
}
