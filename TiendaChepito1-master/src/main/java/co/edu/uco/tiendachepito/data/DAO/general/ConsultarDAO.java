package co.edu.uco.tiendachepito.data.DAO.general;

import java.util.List;

public interface ConsultarDAO <E>{
    List <E> consultar(E entidad);
}
