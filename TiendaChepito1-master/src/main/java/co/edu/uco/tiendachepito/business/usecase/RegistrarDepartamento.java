package co.edu.uco.tiendachepito.business.usecase;

import co.edu.uco.tiendachepito.business.domain.CiudadDomain;
import co.edu.uco.tiendachepito.business.domain.DepartamentoDomain;

public interface RegistrarDepartamento {
    void ejecutar(DepartamentoDomain departamento);
}
