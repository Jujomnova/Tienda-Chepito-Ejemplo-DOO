package co.edu.uco.tiendachepito.api.response;

import co.edu.uco.tiendachepito.dto.PaisDTO;

import java.util.ArrayList;
import java.util.List;

public class PaisResponse extends Response<PaisDTO> {

    public static final Response<PaisDTO> build(List<String> mensajes, List<PaisDTO> datos){
        Response<PaisDTO> instance = new PaisResponse();
        instance.setMensajes(mensajes);
        instance.setDatos(datos);

        return instance;
    }
    public static final Response<PaisDTO> build(List<PaisDTO> datos){
        Response<PaisDTO> instance = new PaisResponse();
        instance.setMensajes(new ArrayList<>());
        instance.setDatos(datos);
        return instance;
    }

    public static final PaisResponse build(List<PaisDTO>){
        PaisResponse instance= new PaisResponse();
        instance.setMensajes(new ArrayList<>());
        instance.setDatos(new ArrayList<>());
        return instance;

    }
}
