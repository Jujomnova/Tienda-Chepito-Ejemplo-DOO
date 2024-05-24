package co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.custom;


import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.TiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.enums.Lugar;

public final class EntityTiendaChepitoException extends TiendaChepitoException {

	private static final long serialVersionUID = 1L;
	private static final Lugar lugar = Lugar.ENTITY;

	public EntityTiendaChepitoException(final String mensajeUsuario) {
		super(mensajeUsuario, lugar);
	}

	public EntityTiendaChepitoException(final String mensajeTecnico, final String mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario, lugar);
	}

	public EntityTiendaChepitoException(final String mensajeTecnico, final String mensajeUsuario,
			final Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
	}
}
