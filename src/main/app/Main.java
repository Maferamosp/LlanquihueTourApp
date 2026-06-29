package main.app;

import main.data.GestorDatos;
import main.model.Cliente;
import main.model.Proveedor;
import main.model.Proveedores;

import java.util.ArrayList;

public class Main {

    public  void main(String[] args) throws Exception {
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

                System.out.println("\n -----------------");

            }
        }

        this.gestorDeProveedores(gestorDatos);

        gestorDatos.mostrarServicios();
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
}
