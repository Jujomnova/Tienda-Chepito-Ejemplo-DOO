package co.edu.uco.tiendachepito.business.domain;

import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.TextHelper;

public class PaisDomain {

    private int id;
    private String nombre;

    public final int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public final String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = TextHelper.applyTrim(nombre);
    }

    public PaisDomain(final int id,final String nombre) {
        setId(id);
        setNombre(nombre);
    }

    public static final PaisDomain crear(final int id, final String nombre){
        return new PaisDomain(id,nombre);
    }


    public static final PaisDomain crear(){
        return new PaisDomain();
    }

    private PaisDomain (){
        setNombre(TextHelper.EMPTY);
    }

}
