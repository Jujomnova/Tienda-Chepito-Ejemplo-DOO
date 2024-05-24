package co.edu.uco.tiendachepito.business.assembler.dto.concrete;

import co.edu.uco.tiendachepito.business.assembler.dto.DTODomainAssembler;
import co.edu.uco.tiendachepito.business.domain.CiudadDomain;
import co.edu.uco.tiendachepito.business.domain.DepartamentoDomain;
import co.edu.uco.tiendachepito.crosscutting.crosscutting.helpers.ObjectHelper;
import co.edu.uco.tiendachepito.dto.CiudadDTO;
import co.edu.uco.tiendachepito.dto.DepartamentoDTO;

public final class CiudadDTODomainAssembler implements DTODomainAssembler<CiudadDomain, CiudadDTO> {

    private final DepartamentoDTODomainAssembler departamentoAssembler = new DepartamentoDTODomainAssembler();

    @Override
    public CiudadDomain ensamblarDominio(CiudadDTO dto) {
        var ciudadDtoTmp = ObjectHelper.getObjectHelper().getDefault(dto, new CiudadDTO());
        DepartamentoDomain departamentoDomain = departamentoAssembler.ensamblarDominio(ciudadDtoTmp.getDepartamento());
        return CiudadDomain.crear(ciudadDtoTmp.getId(), ciudadDtoTmp.getNombre(), departamentoDomain);
    }

    @Override
    public CiudadDTO ensamblarDTO(CiudadDomain dominio) {
        var ciudadDomainTmp = ObjectHelper.getObjectHelper().getDefault(dominio, new CiudadDomain(dominio.getId(), dominio.getNombre(), dominio.getDepartamento()));
        DepartamentoDTO departamentoDTO = departamentoAssembler.ensamblarDTO(ciudadDomainTmp.getDepartamento());
        return CiudadDTO.build().setId(ciudadDomainTmp.getId()).setNombre(ciudadDomainTmp.getNombre()).setDepartamento(departamentoDTO);
    }
}
