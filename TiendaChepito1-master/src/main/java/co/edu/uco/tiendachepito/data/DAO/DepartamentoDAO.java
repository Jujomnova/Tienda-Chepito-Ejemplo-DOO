package co.edu.uco.tiendachepito.data.DAO;

import co.edu.uco.tiendachepito.data.DAO.general.ActualizarDAO;
import co.edu.uco.tiendachepito.data.DAO.general.ConsultarDAO;
import co.edu.uco.tiendachepito.data.DAO.general.CrearDAO;
import co.edu.uco.tiendachepito.data.DAO.general.EliminarDAO;
import co.edu.uco.tiendachepito.entity.DepartamentoEntity;

public interface DepartamentoDAO extends CrearDAO<DepartamentoEntity>, ActualizarDAO<DepartamentoEntity>, EliminarDAO, ConsultarDAO<DepartamentoEntity> {
}
