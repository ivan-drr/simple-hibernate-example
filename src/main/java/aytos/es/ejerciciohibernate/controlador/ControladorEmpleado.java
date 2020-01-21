package aytos.es.ejerciciohibernate.controlador;

import java.util.List;

import aytos.es.ejerciciohibernate.modelo.Empleado;

public interface ControladorEmpleado {

	boolean insertEmpleado(final Empleado empleado);

	List<Empleado> listEmpleado();

	boolean actualizaEmpleado(Empleado empleado);

	boolean actualizaEmpleadoWhere(int id, String nombre);

	boolean eliminarEmpleado(Empleado empleado);

}
