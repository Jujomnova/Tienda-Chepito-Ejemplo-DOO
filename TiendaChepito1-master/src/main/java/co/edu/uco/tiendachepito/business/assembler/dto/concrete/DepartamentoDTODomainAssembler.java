package co.edu.uco.tiendachepito.business.assembler.dto.concrete;

import co.edu.uco.tiendachepito.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.tiendachepito.business.domain.DepartamentoDomain;
import co.edu.uco.tiendachepito.business.domain.PaisDomain;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.dto.DepartamentoDTO;
import co.edu.uco.tiendachepito.dto.PaisDTO;

public final class DepartamentoDTODomainAssembler implements DTODomainAssembler<DepartamentoDomain, DepartamentoDTO> {

    private final PaisDTODomainAssembler paisAssembler = new PaisDTODomainAssembler();

    @Override
    public DepartamentoDomain ensamblarDominio(DepartamentoDTO dto) {
        var departamentoDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, new DepartamentoDTO());
        PaisDomain paisDomain = paisAssembler.ensamblarDominio(departamentoDtoTmp.getPais());
        return DepartamentoDomain.crear(departamentoDtoTmp.getId(), departamentoDtoTmp.getNombre(), paisDomain);
    }

    @Override
    public DepartamentoDTO ensamblarDTO(DepartamentoDomain dominio) {
        var departamentoDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, new DepartamentoDomain(dominio.getId(), dominio.getNombre(), dominio.getPais()));
        PaisDTO paisDTO = paisAssembler.ensamblarDTO(departamentoDomainTmp.getPais());
        return DepartamentoDTO.build().setId(departamentoDomainTmp.getId()).setNombre(departamentoDomainTmp.getNombre()).setPais(paisDTO);
    }
}
