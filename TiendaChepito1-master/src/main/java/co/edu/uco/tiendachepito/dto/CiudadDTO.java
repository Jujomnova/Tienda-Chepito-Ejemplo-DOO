package co.edu.uco.tiendachepito.dto;

import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.TextHelper;

public final class CiudadDTO {

    private int id;
    private String nombre;
    private DepartamentoDTO departamento;

    public CiudadDTO(final int id, final String nombre, final DepartamentoDTO departamento) {
        setId(id);
        setNombre(nombre);
        setDepartamento(departamento);
    }

    public CiudadDTO() {
        setNombre(TextHelper.EMPTY);
        setDepartamento(DepartamentoDTO.build());
    }

    public final int getId() {
        return id;
    }

    public final CiudadDTO setId(final int id) {
        this.id = id;
        return this;
    }

    public final String getNombre() {
        return nombre;
    }

    public final CiudadDTO setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
        return this;
    }

    public final DepartamentoDTO getDepartamento() {
        return departamento;
    }

    public final CiudadDTO setDepartamento(final DepartamentoDTO departamento) {
        this.departamento = ObjectHelper.getObjectHelper().getDefault(departamento, DepartamentoDTO.build());
        return this;
    }

    public static final CiudadDTO build() {
        return new CiudadDTO();
    }
}
