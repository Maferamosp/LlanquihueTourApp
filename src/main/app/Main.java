package main.app;

import main.data.GestorDatos;
import main.data.GestorEntidades;
import main.data.GestorReservas;
import main.model.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        GestorDatos gestorDatos = new GestorDatos();
        GestorEntidades gestorEntidades = new GestorEntidades();
        GestorReservas gestorReservas = new GestorReservas();

        mostrarMenu(gestorEntidades, gestorReservas);

        mostrarClientes(gestorDatos);
        gestionarProveedores(gestorDatos);
        mostrarServicios(gestorDatos);
    }

    private static void mostrarClientes(GestorDatos gestorDatos) throws Exception {
        ArrayList<Cliente> clientes = gestorDatos.cargarClientes();

        System.out.println("=== Todos los clientes ===");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
            System.out.println("-----------------");
        }

        System.out.println("\n=== Tours de playa ===");
        for (Cliente cliente : clientes) {
            if (cliente.getTour().getNombre().contains("Playa")) {
                System.out.println(cliente);
                System.out.println("-----------------");
            }
        }
    }

    private static void gestionarProveedores(GestorDatos gestorDatos) throws Exception {
        guardarProveedores(gestorDatos);
        leerProveedores(gestorDatos);
        filtrarProveedorPorId(gestorDatos, "L-865");
    }

    private static void guardarProveedores(GestorDatos gestorDatos) throws Exception {
        Proveedores proveedores = new Proveedores("Comida");
        proveedores.agregarProveedor(new Proveedor("Maria", "Economic Corp", "L-123"));
        proveedores.agregarProveedor(new Proveedor("Armando", "Food Corp", "L-456"));
        proveedores.agregarProveedor(new Proveedor("Cristina", "Fund Corp", "L-865"));
        gestorDatos.guardarProveedoresEnTxt(proveedores);
    }

    private static void leerProveedores(GestorDatos gestorDatos) {
        Proveedores guardados = gestorDatos.leerDatosDeProveedorDesdeTxt();
        if (guardados == null) {
            return;
        }

        System.out.println("\n=== Proveedores ===");
        System.out.println("Tipo de servicio: " + guardados.getTipoDeServicio());
        for (Proveedor p : guardados.getListaProveedores()) {
            System.out.println("Id: " + p.getId());
            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Empresa: " + p.getNombreEmpresa());
            System.out.println("-----------------");
        }
    }

    private static void filtrarProveedorPorId(GestorDatos gestorDatos, String id) {
        System.out.println("\n=== Proveedor por ID: " + id + " ===");
        Proveedor proveedor = gestorDatos.obtenerElProveedorPorId(id);
        if (proveedor == null) {
            System.out.println("No hay registros asociados al id.");
            return;
        }
        System.out.println("Id: " + proveedor.getId());
        System.out.println("Nombre: " + proveedor.getNombre());
        System.out.println("Empresa: " + proveedor.getNombreEmpresa());
    }

    private static void mostrarServicios(GestorDatos gestorDatos) {
        System.out.println("\n=== Lista de servicios ===");
        gestorDatos.mostrarServicios();

        System.out.println("\n=== Informacion detallada ===");
        List<ServicioTuristico> lista = gestorDatos.crearListaDeServicios();
        for (ServicioTuristico s : lista) {
            s.mostrarInformacion();
        }
    }

    public static void mostrarMenu(GestorEntidades gestorEntidades, GestorReservas gestorReservas) {
        String opcion;
        do {
            opcion = JOptionPane.showInputDialog(
                    "Seleccione una opcion\n\n"
                    + "1. Crear Ruta Gastronomica\n"
                    + "2. Crear Paseo Lacustre\n"
                    + "3. Crear Excursion Cultural\n"
                    + "4. Crear Paquete Turistico\n"
                    + "5. Registrar Reserva\n"
                    + "6. Mostrar entidades\n"
                    + "7. Mostrar reservas\n"
                    + "8. Salir");

            if (opcion == null) break;

            switch (opcion) {
                case "1":
                    crearRutaGastronomica(gestorEntidades);
                    break;
                case "2":
                    crearPaseoLacustre(gestorEntidades);
                    break;
                case "3":
                    crearExcursionCultural(gestorEntidades);
                    break;
                case "4":
                    crearPaqueteTuristico(gestorEntidades);
                    break;
                case "5":
                    registrarReserva(gestorReservas);
                    break;
                case "6":
                    mostrarEntidades(gestorEntidades);
                    break;
                case "7":
                    mostrarReservas(gestorReservas);
                    break;
                case "8":
                    JOptionPane.showMessageDialog(null, "Programa finalizado.");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida.");
            }
        } while (opcion != null && !opcion.equals("8"));
    }

    private static void crearRutaGastronomica(GestorEntidades gestorEntidades) {
        String nombre = JOptionPane.showInputDialog("Nombre de la Ruta Gastronomica:");
        int duracion = Integer.parseInt(JOptionPane.showInputDialog("Duracion (horas):"));
        int paradas = Integer.parseInt(JOptionPane.showInputDialog("Numero de paradas:"));
        gestorEntidades.agregarEntidad(new RutaGastronomica(nombre, duracion, paradas));
        JOptionPane.showMessageDialog(null, "Ruta gastronomica agregada correctamente.");
    }

    private static void crearPaseoLacustre(GestorEntidades gestorEntidades) {
        String nombre = JOptionPane.showInputDialog("Nombre del Paseo Lacustre:");
        int duracion = Integer.parseInt(JOptionPane.showInputDialog("Duracion (horas):"));
        String embarcacion = JOptionPane.showInputDialog("Tipo de embarcacion:");
        gestorEntidades.agregarEntidad(new PaseoLacustre(nombre, duracion, embarcacion));
        JOptionPane.showMessageDialog(null, "Paseo lacustre agregado correctamente.");
    }

    private static void crearExcursionCultural(GestorEntidades gestorEntidades) {
        String nombre = JOptionPane.showInputDialog("Nombre de la Excursion Cultural:");
        int duracion = Integer.parseInt(JOptionPane.showInputDialog("Duracion (horas):"));
        String lugar = JOptionPane.showInputDialog("Lugar historico:");
        gestorEntidades.agregarEntidad(new ExcursionCultural(nombre, duracion, lugar));
        JOptionPane.showMessageDialog(null, "Excursion cultural agregada correctamente.");
    }

    private static void crearPaqueteTuristico(GestorEntidades gestorEntidades) {
        String nombre = JOptionPane.showInputDialog("Nombre del Paquete Turistico:");
        int precio = Integer.parseInt(JOptionPane.showInputDialog("Precio del paquete ($):"));

        String nombreGuia = JOptionPane.showInputDialog("Nombre del guia turistico:");
        String telGuia = JOptionPane.showInputDialog("Telefono del guia:");
        GuiaTuristico guia = new GuiaTuristico(nombreGuia, telGuia, 1);

        String nombreOperador = JOptionPane.showInputDialog("Nombre del operador de transporte:");
        String telOperador = JOptionPane.showInputDialog("Telefono del operador:");
        String vehiculo = JOptionPane.showInputDialog("Tipo de vehiculo:");
        OperadorTransporte operador = new OperadorTransporte(1, nombreOperador, telOperador, vehiculo);

        PaqueteTuristico paquete = new PaqueteTuristico(nombre, precio, guia, operador);

        gestorEntidades.agregarEntidad(paquete);
        JOptionPane.showMessageDialog(null, "Paquete creado correctamente.\n\n" + paquete.mostrarResumen());
    }

    private static void registrarReserva(GestorReservas gestorReservas) {
        try {
            int idReserva = Integer.parseInt(JOptionPane.showInputDialog("ID de la reserva:"));
            String nombreCliente = JOptionPane.showInputDialog("Nombre del cliente:");
            int idCliente = Integer.parseInt(JOptionPane.showInputDialog("ID del cliente:"));
            String nombreTour = JOptionPane.showInputDialog("Nombre del tour:");
            int idTour = Integer.parseInt(JOptionPane.showInputDialog("ID del tour:"));
            String fecha = JOptionPane.showInputDialog("Fecha de la reserva (AAAA-MM-DD):");

            GuiaTuristico guia = new GuiaTuristico("Por asignar", "Sin telefono", 0);
            Tour tour = new Tour(idTour, nombreTour, 0, "");
            Cliente cliente = new Cliente(nombreCliente, idCliente, guia, tour);

            Reserva reserva = new Reserva(idReserva, cliente, tour, fecha);
            gestorReservas.agregarReserva(reserva);

            JOptionPane.showMessageDialog(null,
                    "Reserva registrada correctamente.\n\n" + reserva.mostrarResumen());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    private static void mostrarEntidades(GestorEntidades gestorEntidades) {
        List<Registrable> entidades = gestorEntidades.obtenerEntidades();
        if (entidades.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay entidades registradas.");
            return;
        }

        StringBuilder mensaje = new StringBuilder();
        for (Registrable entidad : entidades) {
            if (entidad instanceof RutaGastronomica) {
                mensaje.append("---- Ruta Gastronomica ----\n");
            } else if (entidad instanceof PaseoLacustre) {
                mensaje.append("---- Paseo Lacustre ----\n");
            } else if (entidad instanceof ExcursionCultural) {
                mensaje.append("---- Excursion Cultural ----\n");
            } else if (entidad instanceof PaqueteTuristico)  {
                mensaje.append("---- Paquete Turistico ----\n");
            }

            mensaje.append(entidad.mostrarResumen()).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    private static void mostrarReservas(GestorReservas gestorReservas) {
        List<Reserva> reservas = gestorReservas.getReservas();
        if (reservas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay reservas registradas.");
            return;
        }

        StringBuilder mensaje = new StringBuilder("=== Reservas ===\n\n");
        for (Reserva r : reservas) {
            mensaje.append(r.mostrarResumen()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
}
