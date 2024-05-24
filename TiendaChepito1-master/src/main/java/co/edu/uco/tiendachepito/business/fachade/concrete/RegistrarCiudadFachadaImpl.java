package co.edu.uco.tiendachepito.business.fachade.concrete;

import co.edu.uco.tiendachepito.business.assembler.dto.concrete.CiudadDTODomainAssembler;
import co.edu.uco.tiendachepito.business.fachade.RegistrarCiudadFachada;
import co.edu.uco.tiendachepito.business.usecase.RegistrarCiudad;
import co.edu.uco.tiendachepito.business.usecase.concrete.RegistrarCiudadImpl;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.TiendaChepitoException;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.exception.custom.BusinessTiendaChepitoException;
import co.edu.uco.tiendachepito.data.DAO.factory.DAOFactory;
import co.edu.uco.tiendachepito.data.DAO.factory.enums.Factory;
import co.edu.uco.tiendachepito.dto.CiudadDTO;

public final class RegistrarCiudadFachadaImpl implements RegistrarCiudadFachada {

    private DAOFactory factory;

    public RegistrarCiudadFachadaImpl(){
        factory = DAOFactory.getFactory(Factory.AZURE_SQL);
    }

    @Override
    public final void ejecutar (CiudadDTO ciudad){
        try {
            factory.iniciarTransaccion();
            var ciudadDomain = CiudadDTODomainAssembler.obtenerInstancia().ensabmblarDominio(ciudad);
            RegistrarCiudad useCase = new RegistrarCiudadImpl(factory);
            useCase.ejecutar(null);
            factory.confirmarTransaccion();
        }catch (TiendaChepitoException exception){
            factory.cancelarTransaccion();
            throw exception;
        }catch (Exception exception){
            factory.cancelarTransaccion();
            var mensajeUsuario = "Se ha presentado un problema tratando de registrar la informacion de la nueva ciudad";
            var mensajeTecnico = "Se ha presentado un problema INESPERADO tratando de registrar la nueva ciudad en el metodo ejecutar de la clase RegistrarFacadaImpls";

            throw new BusinessTiendaChepitoException(mensajeTecnico, mensajeUsuario);
        } finally {
            factory.cerrarConexion();
        }
    }
}
