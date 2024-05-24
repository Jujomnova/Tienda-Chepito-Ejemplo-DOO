package co.edu.uco.tiendachepito.data.DAO.factory;

import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.custom.DataTiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import co.edu.uco.tiendachepito.data.DAO.CiudadDAO;
import co.edu.uco.tiendachepito.data.DAO.DepartamentoDAO;
import co.edu.uco.tiendachepito.data.DAO.PaisDAO;
import co.edu.uco.tiendachepito.data.DAO.factory.enums.Factory;
import co.edu.uco.tiendachepito.data.DAO.factory.sql.azuresql.AzureSqlDAOFactory;
import co.edu.uco.tiendachepito.data.DAO.sql.azuresql.PaisAzureSqlDAO;

import java.util.ArrayList;
import java.util.List;

public abstract class DAOFactory {

    public static final DAOFactory getFactory(final Factory factory){
        switch (factory) {
            case AZURE_SQL: {
                return new AzureSqlDAOFactory();
            }
            case POSTGRES_SQL: {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = "No existe una factoria de base de datos configurada para POSTGRES_SQL";

                throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario);
            }
            case SQL_SERVER: {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = "No existe una factoria de base de datos configurada para SQL_SERVER";

                throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario);
            }
            case MYSQL: {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = "No existe una factoria de base de datos configurada para MYSQL";

                throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario);
            }
            case ORACLE: {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = "No existe una factoria de base de datos configurada para ORACLE";

                throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario);
            }
            default:
                return new AzureSqlDAOFactory();
        }
    }
    protected abstract void obtenerConexion();

    public abstract void iniciarTransaccion();

    public abstract void confirmarTransaccion();

    public abstract void cancelarTransaccion();

    public abstract void cerrarConexion();

    public abstract PaisDAO getPaisDAO();

    public abstract DepartamentoDAO getDepartamentoDAO();

    public abstract CiudadDAO getCiudadDAO();

    public static void main(String[] args) {
        DAOFactory.getFactory(Factory.AZURE_SQL).getPaisDAO().crear(null);
        DAOFactory.getFactory(Factory.AZURE_SQL).getPaisDAO().actualizar(null);
        DAOFactory.getFactory(Factory.AZURE_SQL).getPaisDAO().eliminar(0);
//        List<PaisAzureSqlDAO> paisAzureSql = new ArrayList<PaisAzureSqlDAO>();
    }

}
