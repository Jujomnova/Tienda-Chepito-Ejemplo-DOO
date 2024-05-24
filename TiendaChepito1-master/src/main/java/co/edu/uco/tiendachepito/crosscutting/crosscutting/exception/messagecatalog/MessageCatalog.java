package co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog;

import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog.data.Mensaje;

public interface MessageCatalog {

	void inicializar();

	String obtenerContenidoMensaje(final CodigoMensaje codigo, String... parametros);

	Mensaje obtenerMensaje(final CodigoMensaje codigo, String... parametros);
}