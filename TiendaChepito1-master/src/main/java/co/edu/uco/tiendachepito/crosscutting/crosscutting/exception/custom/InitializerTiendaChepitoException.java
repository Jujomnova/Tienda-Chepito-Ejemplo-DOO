package co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.custom;


import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.TiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.enums.Lugar;

public final class InitializerTiendaChepitoException extends TiendaChepitoException {

	private static final long serialVersionUID = 1L;
	private static final Lugar lugar = Lugar.INITIALIZER;

	public InitializerTiendaChepitoException(final String mensajeUsuario) {
		super(mensajeUsuario, lugar);
	}

	public InitializerTiendaChepitoException(final String mensajeTecnico, final String mensajeUsuario) {
		super(mensajeTecnico, mensajeUsuario, lugar);
	}

	public InitializerTiendaChepitoException(final String mensajeTecnico, final String mensajeUsuario,
			final Throwable excepcionRaiz) {
		super(mensajeTecnico, mensajeUsuario, lugar, excepcionRaiz);
	}
}
