package co.edu.uco.tiendachepito.business.assembler.entity.concrete;

import co.edu.uco.tiendachepito.business.assembler.entity.EntityDomainAssembler;
import co.edu.uco.tiendachepito.business.domain.DepartamentoDomain;
import co.edu.uco.tiendachepito.business.domain.PaisDomain;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.entity.DepartamentoEntity;
import co.edu.uco.tiendachepito.entity.PaisEntity;

public final class DepartamentoEntityDomainAssembler implements EntityDomainAssembler<DepartamentoDomain, DepartamentoEntity> {

    private static final EntityDomainAssembler<DepartamentoDomain,DepartamentoEntity> instancia = new DepartamentoEntityDomainAssembler();

    private static final EntityDomainAssembler<PaisDomain, PaisEntity> paisAssembler = new PaisEntityDomainAssembler().obtenerInstancia();

    DepartamentoEntityDomainAssembler(){
        super();
    }

    public static final EntityDomainAssembler<DepartamentoDomain, DepartamentoEntity> obtenerInstancia(){
        return instancia;
    }

    @Override
    public DepartamentoDomain ensamblarDominio(DepartamentoEntity entity) {
        var departamentoEntityTemp = ObjectHelper.getObjectHelper().getDefault(entity, DepartamentoEntity.build());
        var paisDomain = PaisEntityDomainAssembler.obtenerInstancia().ensamblarDominio(departamentoEntityTemp.getPais());
        return DepartamentoDomain.crear(departamentoEntityTemp.getId(), departamentoEntityTemp.getNombre(), paisDomain);
    }

    @Override
    public DepartamentoEntity ensamblarEntidad(DepartamentoDomain dominio) {
        var departamentoDomainTemp = ObjectHelper.getObjectHelper().getDefault(dominio, DepartamentoDomain.crear());
        var paisEntity = PaisEntityDomainAssembler.obtenerInstancia().ensamblarEntidad(departamentoDomainTemp.getPais());

        return DepartamentoEntity.build().setId(departamentoDomainTemp.getId()).setNombre(departamentoDomainTemp.getNombre()).setPais(paisEntity);
    }
}
