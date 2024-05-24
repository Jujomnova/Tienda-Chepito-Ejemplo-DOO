package co.edu.uco.tiendachepito.business.assembler.entity.concrete;

import co.edu.uco.tiendachepito.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.tiendachepito.business.domain.CiudadDomain;
import co.edu.uco.tiendachepito.business.domain.DepartamentoDomain;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.entity.CiudadEntity;
import co.edu.uco.tiendachepito.entity.DepartamentoEntity;

public final class CiudadEntityDomainAssembler implements EntityDomainAssembler<CiudadDomain, CiudadEntity> {

    private static final EntityDomainAssembler<CiudadDomain,CiudadEntity> instancia = new CiudadEntityDomainAssembler();

    private static final EntityDomainAssembler<DepartamentoDomain, DepartamentoEntity> departamentoAssembler = new DepartamentoEntityDomainAssembler().obtenerInstancia();

    private CiudadEntityDomainAssembler(){
        super();
    }

    public static final EntityDomainAssembler<CiudadDomain, CiudadEntity> obtenerInstancia(){
        return instancia;
    }

    @Override
    public CiudadDomain ensamblarDominio(CiudadEntity entity) {
        var ciudadEntityTemp = ObjectHelper.getObjectHelper().getDefault(entity, CiudadEntity.build());
        var departamentoDomain = DepartamentoEntityDomainAssembler.obtenerInstancia().ensamblarDominio(ciudadEntityTemp.getDepartamento());
        return CiudadDomain.crear(ciudadEntityTemp.getId(), ciudadEntityTemp.getNombre(), departamentoDomain);
    }

    @Override
    public CiudadEntity ensamblarEntidad(CiudadDomain dominio) {
        var ciudadDomainTemp = ObjectHelper.getObjectHelper().getDefault(dominio, CiudadDomain.crear());
        var departamentoEntity = DepartamentoEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(ciudadDomainTemp.getDepartamento());
        return CiudadEntity.build().setId(ciudadDomainTemp.getId()).setNombre(ciudadDomainTemp.getNombre()).setDepartamento(departamentoEntity);
    }
}
