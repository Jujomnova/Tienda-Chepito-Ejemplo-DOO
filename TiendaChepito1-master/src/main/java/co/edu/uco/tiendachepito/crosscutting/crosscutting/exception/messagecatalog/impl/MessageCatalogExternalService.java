package co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog.impl;


import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.custom.CrosscuttingTiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog.MessageCatalog;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog.MessageCatalogStrategy;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog.data.CodigoMensaje;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.messagecatalog.data.Mensaje;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.ObjectHelper;

import java.util.HashMap;
import java.util.Map;

public final class MessageCatalogExternalService implements MessageCatalog {

	private final Map<String, Mensaje> mensajes = new HashMap<>();

	@Override
	public final void inicializar() {
		mensajes.clear();
		mensajes.put(CodigoMensaje.M000023.getIdentificador(),
				new Mensaje(CodigoMensaje.M000023, "Se ha presentado un error implementando un insert del pais \"${1}\" en la tabla de \"pais\" de la base de datos Azure SQL..."));
		mensajes.put(CodigoMensaje.M000024.getIdentificador(),
				new Mensaje(CodigoMensaje.M000024, "Se ha presentado un error tratando de realizar un insert del pais \"${1}\" en la tabla de \"pais\" de la base de datos Azure SQL..."));
	}

	@Override
	public final String obtenerContenidoMensaje(final CodigoMensaje codigo, final String... parametros) {
		return obtenerMensaje(codigo, parametros).getContenido();
	}

	@Override
	public final Mensaje obtenerMensaje(CodigoMensaje codigo, final String... parametros) {

		if (ObjectHelper.getObjectHelper().isNull(codigo)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00001);
			throw new CrosscuttingTiendaChepitoException(mensajeTecnico, mensajeUsuario);
		}

		if (codigo.isBase()) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00005,
					codigo.getIdentificador());
			throw new CrosscuttingTiendaChepitoException(mensajeTecnico, mensajeUsuario);
		}

		if (!mensajes.containsKey(codigo.getIdentificador())) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00006,
					codigo.getIdentificador());
			throw new CrosscuttingTiendaChepitoException(mensajeTecnico, mensajeUsuario);
		}

		return mensajes.get(codigo.getIdentificador());
	}

}