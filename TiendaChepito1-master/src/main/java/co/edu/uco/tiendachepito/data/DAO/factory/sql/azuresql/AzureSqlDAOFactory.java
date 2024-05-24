package co.edu.uco.tiendachepito.data.DAO.factory.sql.azuresql;

import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.custom.DataTiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.SQLHelper;
import co.edu.uco.tiendachepito.data.DAO.CiudadDAO;
import co.edu.uco.tiendachepito.data.DAO.DepartamentoDAO;
import co.edu.uco.tiendachepito.data.DAO.PaisDAO;
import co.edu.uco.tiendachepito.data.DAO.factory.DAOFactory;
import co.edu.uco.tiendachepito.data.DAO.sql.azuresql.CiudadAzureSqlDAO;
import co.edu.uco.tiendachepito.data.DAO.sql.azuresql.DepartamentoAzureSqlDAO;
import co.edu.uco.tiendachepito.data.DAO.sql.azuresql.PaisAzureSqlDAO;
import co.edu.uco.tiendachepito.entity.PaisEntity;
import co.edu.uco.tiendachepito.data.DAO.factory.enums.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.UUID;

public final class AzureSqlDAOFactory extends DAOFactory {

    private Connection connection;

    public AzureSqlDAOFactory() {
        obtenerConexion();
    }

    @Override
    protected void obtenerConexion() {
        final String connectionUrl = "jdbc:sqlserver://wednesday.database.windows.net:1433;databaseName=wednesday;user=wednesdayDmlUser;password=w3dn3sd4y!";
        try {
            connection = DriverManager.getConnection(connectionUrl);
        } catch (final SQLException excepcion) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = "Se ha presentado un problema tratando de obtener la conexión con la base de datos wednesday en el servidor de bases de datos wednesday.database.windows.net. Por favor revise la traza de errores para identificar y solucionar el problema...";

            throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario, excepcion);
        } catch (final Exception excepcion) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de obtener la conexión con la base de datos wednesday en el servidor de bases de datos wednesday.database.windows.net. Por favor revise la traza de errores para identificar y solucionar el problema...";

            throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario, excepcion);
        }
    }

    @Override
    public void iniciarTransaccion() {
        SQLHelper.initTransaction(connection);
    }

    @Override
    public void confirmarTransaccion() {
        SQLHelper.commit(connection);
    }

    @Override
    public void cancelarTransaccion() {
        SQLHelper.rollback(connection);
    }

    @Override
    public void cerrarConexion() {
        SQLHelper.close(connection);
    }

    @Override
    public PaisDAO getPaisDAO() {
        return new PaisAzureSqlDAO(connection);
    }

    @Override
    public DepartamentoDAO getDepartamentoDAO() {
        return new DepartamentoAzureSqlDAO(connection);
    }

    @Override
    public CiudadDAO getCiudadDAO() {
        return new CiudadAzureSqlDAO(connection);
    }

    public static void main(String[] args) {
        try {
            DAOFactory factory = DAOFactory.getFactory(Factory.AZURE_SQL);

            System.out.println("Iniciando transacción...");
            factory.iniciarTransaccion();

            System.out.println("Creando país aleatoriamente");
            factory.getPaisDAO().crear(PaisEntity.build(0, "Colombia-" + UUID.randomUUID().toString()));

            System.out.println("Consultamos países: ");
            var resultados = factory.getPaisDAO().consultar(PaisEntity.build(0));

            for (PaisEntity paisEntity : resultados) {
                System.out.println("id: " + paisEntity.getId() + ", nombre: " + paisEntity.getNombre());
            }

            System.out.println("Confirmando transacción...");
            factory.confirmarTransaccion();
            System.out.println("Cerrando conexión...");
            factory.cerrarConexion();
        } catch (final Exception excepcion) {
            excepcion.printStackTrace();
        }
    }
}

