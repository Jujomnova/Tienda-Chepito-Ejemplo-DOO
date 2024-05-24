package co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers;

import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.custom.CrosscuttingTiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog.MessageCatalog;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog.data.CodigoMensaje;

import java.sql.Connection;
import java.sql.SQLException;

public final class SQLHelper {

    private SQLHelper() {
        super();
    }

    public static final boolean isNull (final Connection connection){
        return ObjectHelper.getObjectHelper().isNull(connection);
    }

    public static final boolean isOpen(final Connection connection) {
        try {
            return !isNull(connection) && !connection.isClosed();
        } catch (final SQLException exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00007);
            throw new CrosscuttingTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00008);
            throw new CrosscuttingTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
        }
    }

    public static final void close(final Connection connection) {
        try {
            if (isOpen(connection)) {
                var mensajeUsuario =MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico =MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00009);
                throw new CrosscuttingTiendaChepitoException(mensajeTecnico,mensajeUsuario);
            }
            connection.close();
        } catch (final CrosscuttingTiendaChepitoException exception) {
            throw exception;
        } catch (final SQLException exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000010);
            throw new CrosscuttingTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000011);
            throw new CrosscuttingTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
        }
    }

    public static final void commit(final Connection connection) {
        try {
            if (!isOpen(connection)) {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000012);
                throw new CrosscuttingTiendaChepitoException(mensajeTecnico,mensajeUsuario);
            }
            if (connection.getAutoCommit()){
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000013);
                throw new CrosscuttingTiendaChepitoException(mensajeTecnico,mensajeUsuario);
            }
            connection.commit();
        } catch (final SQLException exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000014);
            throw new CrosscuttingTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000015);
            throw new CrosscuttingTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
        }
    }


    public static final void rollback(final Connection connection) {
        try {
            if (!isOpen(connection)) {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000016);
                throw new CrosscuttingTiendaChepitoException(mensajeTecnico, mensajeUsuario);
            }
            if (connection.getAutoCommit()){
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000017);
                throw new CrosscuttingTiendaChepitoException(mensajeTecnico,mensajeUsuario);
            }
            connection.rollback();
        } catch (final SQLException exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000018);
            throw new CrosscuttingTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000019);
            throw new CrosscuttingTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
        }
    }

    public static final void initTransaction(final Connection connection) {
        try {
            if (!isOpen(connection)) {
                var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
                var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000020);
                throw new CrosscuttingTiendaChepitoException(mensajeTecnico, mensajeUsuario);
            }
            connection.setAutoCommit(false);
        } catch (final SQLException exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000021);
            throw new CrosscuttingTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
        } catch (final Exception exception) {
            var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
            var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M000022);
            throw new CrosscuttingTiendaChepitoException(mensajeTecnico, mensajeUsuario, exception);
        }
    }
}
