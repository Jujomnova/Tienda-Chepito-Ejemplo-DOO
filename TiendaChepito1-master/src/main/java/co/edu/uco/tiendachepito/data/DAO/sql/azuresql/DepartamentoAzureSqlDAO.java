package co.edu.uco.tiendachepito.data.DAO.sql.azuresql;

import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.custom.DataTiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import co.edu.uco.tiendachepito.data.DAO.DepartamentoDAO;
import co.edu.uco.tiendachepito.data.DAO.sql.SqlConnection;
import co.edu.uco.tiendachepito.entity.DepartamentoEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public final class DepartamentoAzureSqlDAO extends SqlConnection implements DepartamentoDAO {

    public DepartamentoAzureSqlDAO(final Connection connection){
        super(connection);
    }

    @Override
    public final void actualizar(final DepartamentoEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("UPDATE Departamento");
        sentenciaSql.append("SET Nombre = ? ");
        sentenciaSql.append("WHERE Id = ?");

        try (final PreparedStatement sentenciaPreparada = getConnection().prepareStatement(sentenciaSql.toString())) {
            sentenciaPreparada.setString(1, entidad.getNombre());
            sentenciaPreparada.setInt(2, entidad.getId());
            sentenciaPreparada.executeUpdate();
        } catch (final SQLException exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la actualización de la información del país. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000023, entidad.getNombre());
            throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = "No ha sido posible llevar a cabo la actualización de la información del país. Por favor intente de nuevo y en caso de persistir el problema comuníquese con el administrador de la app tiendaChepito";
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000024, entidad.getNombre());
            throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
        }

    }

    @Override
    public final List<DepartamentoEntity> consultar(final DepartamentoEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("SELECT  Id, Nombre");
        sentenciaSql.append("FROM Departamento");
        sentenciaSql.append("ORDER BY Nombre ASC");
        return null;
    }

    @Override
    public final void crear(final DepartamentoEntity entidad) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("INSERT INTO Departamento(Nombre)");
        sentenciaSql.append("VALUES('Antioquia')");
    }

    @Override
    public final void eliminar(final int id) {
        final var sentenciaSql = new StringBuilder();
        sentenciaSql.append("DELETE FROM Departamento");
        sentenciaSql.append("WHERE Id = '1'");
    }
}
