package co.edu.uco.tiendachepito.entity;

import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.NumericHelper;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.TextHelper;

public final class CiudadEntity {

    private int id;
    private String nombre;
    private DepartamentoEntity departamento;

    private CiudadEntity(final int id, final String nombre, final DepartamentoEntity departamento) {
        setId(id);
        setNombre(nombre);
        setDepartamento(departamento);
    }

    private CiudadEntity(final int id) {
        setId(id);
        setNombre(TextHelper.EMPTY);
        setDepartamento(DepartamentoEntity.build(NumericHelper.ZERO));
    }

    private CiudadEntity() {
        this(NumericHelper.ZERO, TextHelper.EMPTY, DepartamentoEntity.build(NumericHelper.ZERO));
    }

    public static final CiudadEntity build(final int id) {
        return new CiudadEntity(id);
    }

    public static final CiudadEntity build(final int id, final String nombre, final DepartamentoEntity departamento) {
        return new CiudadEntity(id, nombre, departamento);
    }

    public static final CiudadEntity build() {
        return new CiudadEntity();
    }

    public final int getId() {
        return id;
    }

    public final CiudadEntity setId(final int id) {
        this.id = id;
        return this;
    }

    public final String getNombre() {
        return nombre;
    }

    public final CiudadEntity setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
    }

    public final DepartamentoEntity getDepartamento() {
        return departamento;
    }

    public final CiudadEntity setDepartamento(final DepartamentoEntity departamento) {
        this.departamento = ObjectHelper.getObjectHelper().getDefault(departamento, DepartamentoEntity.build(NumericHelper.ZERO));
        return this;
    }
}
