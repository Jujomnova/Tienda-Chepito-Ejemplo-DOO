package co.edu.uco.tiendachepito.business.domain;

import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.TextHelper;

public class DepartamentoDomain {
    private int id;
    private String nombre;
    private PaisDomain pais;

    public DepartamentoDomain(final int id, final String nombre, final PaisDomain pais) {
        setId(id);
        setNombre(nombre);
        setPais(pais);
    }

    public static final DepartamentoDomain crear(final int id, final String nombre, final PaisDomain pais){
        return new DepartamentoDomain(id, nombre, pais);
    }

    public static final DepartamentoDomain crear(){
        return new DepartamentoDomain();
    }

    private DepartamentoDomain() {
        setNombre(TextHelper.EMPTY);
        setPais(PaisDomain.crear());
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

    public PaisDomain getPais() {
        return pais;
    }

    private void setPais(PaisDomain pais) {
        this.pais = pais;
    }
}
