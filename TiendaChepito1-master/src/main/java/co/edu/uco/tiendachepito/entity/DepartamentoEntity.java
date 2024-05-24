package co.edu.uco.tiendachepito.entity;

import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.NumericHelper;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.TextHelper;

public final class DepartamentoEntity {

    private int id;
    private String nombre;
    private PaisEntity pais;

    private DepartamentoEntity(final int id, final String nombre, final PaisEntity pais) {
        setId(id);
        setNombre(nombre);
        setPais(pais);
    }

    private DepartamentoEntity(final int id) {
        setId(id);
        setNombre(TextHelper.EMPTY);
        setPais(PaisEntity.build(NumericHelper.ZERO));
    }

    private DepartamentoEntity() {
        this(NumericHelper.ZERO, TextHelper.EMPTY, PaisEntity.build(NumericHelper.ZERO));
    }

    public static final DepartamentoEntity build(final int id) {
        return new DepartamentoEntity(id);
    }

    public static final DepartamentoEntity build(final int id, final String nombre, final PaisEntity pais) {
        return new DepartamentoEntity(id, nombre, pais);
    }

    public static final DepartamentoEntity build() {
        return new DepartamentoEntity();
    }

    public final int getId() {
        return id;
    }

    public final DepartamentoEntity setId(final int id) {
        this.id = id;
        return this;
    }

    public final String getNombre() {
        return nombre;
    }

    public final DepartamentoEntity setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
    }

    public final PaisEntity getPais() {
        return pais;
    }

    public final DepartamentoEntity setPais(final PaisEntity pais) {
        this.pais = ObjectHelper.getObjectHelper().getDefault(pais, PaisEntity.build(NumericHelper.ZERO));
        return this;
    }
}
