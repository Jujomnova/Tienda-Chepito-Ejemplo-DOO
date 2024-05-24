package co.edu.uco.tiendachepito.business.domain;

import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.TextHelper;

public class CiudadDomain {
    private int id;
    private String nombre;
    private DepartamentoDomain departamento;

    public CiudadDomain(int id, String nombre, DepartamentoDomain departamento) {
        setId(id);
        setNombre(nombre);
        setDepartamento(departamento);
    }

    public static final CiudadDomain crear(final int id, final String nombre, final DepartamentoDomain departamento) {
        return new CiudadDomain(id, nombre, departamento);
    }

    public static final CiudadDomain crear() {
        return new CiudadDomain();
    }

    private CiudadDomain() {
        setNombre(TextHelper.EMPTY);
        setDepartamento(DepartamentoDomain.crear());
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }

    public DepartamentoDomain getDepartamento() {
        return departamento;
    }

    private void setDepartamento(DepartamentoDomain departamento) {
        this.departamento = departamento;
    }
}
