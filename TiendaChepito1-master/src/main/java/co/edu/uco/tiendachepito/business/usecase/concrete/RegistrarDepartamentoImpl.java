package co.edu.uco.tiendachepito.business.usecase.concrete;

import co.edu.uco.tiendachepito.business.domain.DepartamentoDomain;
import co.edu.uco.tiendachepito.business.usecase.RegistrarDepartamento;
import co.edu.uco.tiendachepito.data.DAO.factory.DAOFactory;

public class RegistrarDepartamentoImpl implements RegistrarDepartamento {

    private final DAOFactory factory;

    public RegistrarDepartamentoImpl(DAOFactory factory) {
        this.factory = factory;
    }

    @Override
    public void ejecutar(DepartamentoDomain departamento) {
        // POL.1 Validar que los datos sean validados a nivel de tipo de dato, longitud, obligatoriedad, formato, rango.
        // POL.2 No debe existir una ciudad con el mismo nombre para el mismo departamento.
        // POL.3 Guardar la informacion de la nueva ciudad.
    }
}
