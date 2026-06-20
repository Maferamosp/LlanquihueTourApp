package main.java.model;

import java.util.ArrayList;
import java.util.List;

public class Proveedores {
    private String tipoDeServicio;
    private List<Proveedor> listaProveedores;

    public Proveedores(String tipoDeServicio) {
        this.listaProveedores = new ArrayList<Proveedor>();
        this.tipoDeServicio = tipoDeServicio;
    }

    public List<Proveedor> getListaProveedores() {
        return listaProveedores;
    }

    public String getTipoDeServicio() {
        return tipoDeServicio;
    }

    public void setTipoDeServicio(String tipoDeServicio) {
        this.tipoDeServicio = tipoDeServicio;
    }

    public void agregarProveedor(Proveedor proveedor) throws Exception {
        for (Proveedor p : listaProveedores) {
            if (p.getId().equals(proveedor.getId())) {
                throw new Exception("Ya existe un proveedor con el ID: " + proveedor.getId());
            }
        }

        listaProveedores.add(proveedor);
    }
}
