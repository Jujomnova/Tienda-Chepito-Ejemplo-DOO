package co.edu.uco.tiendachepito.data.DAO.sql.azuresql;

import co.edu.uco.tiendachepito.data.DAO.CiudadDAO;
import co.edu.uco.tiendachepito.data.DAO.sql.SqlConnection;
import co.edu.uco.tiendachepito.entity.CiudadEntity;

import java.sql.Connection;
import java.util.List;

public final class CiudadAzureSqlDAO extends SqlConnection implements CiudadDAO {

    public CiudadAzureSqlDAO(final Connection connection){
        super(connection);
    }

    @Override
    public final void actualizar(final CiudadEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("UPDATE Ciudad");
        sentenciaSql.append("SET Nombre = 'Barranquilla' ");
        sentenciaSql.append("WHERE Id = '1'");
    }

    @Override
    public final List<CiudadEntity> consultar(final CiudadEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT  Id, Nombre");
        sentenciaSql.append("FROM Departamento");
        sentenciaSql.append("ORDER BY Nombre ASC");
        return null;
    }

    @Override
    public final void crear(final CiudadEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("INSERT INTO Ciudad(Nombre)");
        sentenciaSql.append("VALUES('Rionegro')");
    }

    @Override
    public final void eliminar(final int id) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("DELETE FROM Ciudad");
        sentenciaSql.append("WHERE Id = '1'");
    }
}
