package com.universidad.servicios.contratos;

import com.universidad.modelo.entidades.Persona;
import com.universidad.modelo.entidades.enumeradores.TipoEmplado;

public interface EmpleadoDAO extends PersonaDAO{

    Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmplado tipoEmpleado);
}
