package co.edu.uco.tiendachepito.data.DAO.sql;

import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.custom.DataTiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.SQLHelper;

import java.sql.Connection;

public class SqlConnection {

    private Connection connection;

    protected SqlConnection(final Connection connection) {
        setConnection(connection);
    }

    private void setConnection(final Connection connection) {
        if (SQLHelper.isOpen(connection)) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = "No es posible crear el DAO deseado, dado que la conexion SQL esta cerrada";
            throw new DataTiendaChepitoException(mensajeTecnico, mensajeUsuario);
        }
        this.connection = connection;
    }

    protected final Connection getConnection() {
        return connection;

    }

//        protected SqlConnection(final Connection connection) {
//            if (connection == null) {
//                throw new NullPointerException("The connection is null");
//            }
//            this.connection = connection;
//        }
//
//        protected Connection getConnection() {
//            return connection;
//        }

}
