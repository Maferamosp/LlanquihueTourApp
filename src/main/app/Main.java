package main.app;

import main.data.GestorDatos;
import main.data.GestorEntidades;
import main.model.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {

    public  void main(String[] args) throws Exception {
        GestorDatos gestorDatos = new GestorDatos();
        GestorEntidades gestorEntidades = new GestorEntidades();

        this.mostrarMenu(gestorEntidades);

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

                System.out.println("\n -----------------");

            }
        }

        this.gestorDeProveedores(gestorDatos);

        gestorDatos.mostrarServicios();
        System.out.println("\n -----------------");
        System.out.println("\n Lista de servicios: \n");


        this.mostrarInformacionDeListaDeServicios(gestorDatos);
    }

    public void gestorDeProveedores(GestorDatos gestorDatos) throws Exception {
        this.agregarProveedoresEnTxt(gestorDatos);

        this.leerProveedoresEnTxt(gestorDatos);

        this.filtrarProveedoresPorId(gestorDatos);
    }

    public void agregarProveedoresEnTxt(GestorDatos gestorDatos) throws Exception {
        Proveedores proveedores = new Proveedores("Comida");

        proveedores.agregarProveedor(new Proveedor("Maria", "Economic Corp", "L-123"));
        proveedores.agregarProveedor(new Proveedor("Armando", "Food Corp", "L-456"));
        proveedores.agregarProveedor(new Proveedor("Cristina", "Fund Corp", "L-865"));

        gestorDatos.guardarProveedoresEnTxt(proveedores);
    }

    public void leerProveedoresEnTxt(GestorDatos gestorDatos) {
        Proveedores proveedoresGuardados = gestorDatos.leerDatosDeProveedorDesdeTxt();

        if (proveedoresGuardados == null) {
            return;
        }
        System.out.println("Proveedores" + "\n");
        System.out.println("Tipo de servicio: " + proveedoresGuardados.getTipoDeServicio() + "\n");
        System.out.println("\n -----------------");


        for (Proveedor pg: proveedoresGuardados.getListaProveedores()) {
            System.out.println("Id: " + pg.getId() + "\n");
            System.out.println("Nombre: " + pg.getNombre() + "\n");
            System.out.println("Nombre de la empresa: " + pg.getNombreEmpresa() + "\n");
            System.out.println("\n -----------------");
        }
    }

    public void filtrarProveedoresPorId(GestorDatos gestorDatos) {
        System.out.println("Obtener el proveedor por el ID: L-865");

        Proveedor proveedorPorId = gestorDatos.obtenerElProveedorPorId("L-865");

        if (proveedorPorId == null) {
            System.out.println("No hay registros asociados al id.");

            return;
        }

        System.out.println("Id: " + proveedorPorId.getId() + "\n");
        System.out.println("Nombre: " + proveedorPorId.getNombre() + "\n");
        System.out.println("Nombre de la empresa: " + proveedorPorId.getNombreEmpresa() + "\n");
        System.out.println("\n -----------------");
    }

    public void mostrarInformacionDeListaDeServicios(GestorDatos gestorDatos) {
        List<ServicioTuristico> listaDeServicios = gestorDatos.crearListaDeServicios();

        for (ServicioTuristico su: listaDeServicios) {
            su.mostrarInformacion();
        }
    }

    public void mostrarMenu(GestorEntidades gestorDatos) {
        String opcion;
        do {
            opcion = JOptionPane.showInputDialog(
                    "Seleccione una opción\n\n"
                            + "1. Crear Ruta Gastronomica\n"
                            + "2. Crear Paseo Lacustre\n"
                            + "3. Mostrar entidades\n"
                            + "4. Salir");

            if (opcion == null) {
                break;
            }

            switch (opcion) {
                case "1":
                    String nombreRuta = JOptionPane.showInputDialog("Nombre de la Ruta Gastronomica:");
                    int duracionRuta = Integer.parseInt(JOptionPane.showInputDialog("Duracion horas:"));
                    int paradas = Integer.parseInt(JOptionPane.showInputDialog("Nro de paradas:"));

                    gestorDatos.agregarEntidad(new RutaGastronomica(nombreRuta, duracionRuta, paradas));
                    JOptionPane.showMessageDialog(null, "Ruta agregada correctamente.");
                    break;
                case "2":
                    String nombrePaseo = JOptionPane.showInputDialog("Nombre Paseo Lacustre:");
                    int duracionPaseo = Integer.parseInt(JOptionPane.showInputDialog("Duracion horas:"));
                    String embarcacion = JOptionPane.showInputDialog("Tipo de embarcacion:");
                    gestorDatos.agregarEntidad(new PaseoLacustre(nombrePaseo, duracionPaseo, embarcacion));
                    JOptionPane.showMessageDialog(null, "Paseo agregado correctamente");
                    break;
                case "3":
                    if (gestorDatos.obtenerEntidades().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay entidades registradas.");
                        break;
                    }

                    String mensaje = "";

                    for (Registrable entidad : gestorDatos.obtenerEntidades()) {
                        if (entidad instanceof RutaGastronomica) {
                            mensaje += "---- Ruta Gastronomica ----\n";
                        } else if (entidad instanceof PaseoLacustre) {
                            mensaje += "---- Paseo Lacustre ----\n";
                        } else if (entidad instanceof ExcursionCultural) {
                            mensaje += "---- Excursion Cultural ----\n";
                        }

                        mensaje += entidad.mostrarResumen() + "\n\n";
                    }
                    JOptionPane.showMessageDialog(null, mensaje);
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "Programa finalizado");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
            }
        } while (!opcion.equals("4"));
    }
}
