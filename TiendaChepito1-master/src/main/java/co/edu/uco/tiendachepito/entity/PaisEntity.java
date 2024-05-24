package co.edu.uco.tiendachepito.entity;


import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.NumericHelper;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.TextHelper;

public final class PaisEntity {

    private int id;
    private String nombre;

    public PaisEntity(final int id, final String nombre) {
        setId(id);
        setNombre(TextHelper.EMPTY);
    }

    private PaisEntity(final int id) {
        setNombre(TextHelper.EMPTY);
    }

    public static final PaisEntity build(final int id){
        return new PaisEntity(id);
    }

    public static final PaisEntity build(final int id, final String nombre){
        return new PaisEntity(id,nombre);
    }

    protected static final PaisEntity build(){
        return new PaisEntity(NumericHelper.ZERO);
    }

    public final int getId() {
        return id;
    }

    public final String getNombre() {
        return nombre;
    }

    private final void setId(final int id) {
        this.id = id;
    }

    private final void setNombre(final String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }
}
