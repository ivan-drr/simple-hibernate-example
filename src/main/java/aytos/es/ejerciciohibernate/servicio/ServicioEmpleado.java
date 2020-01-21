package aytos.es.ejerciciohibernate.servicio;

import java.util.List;

import aytos.es.ejerciciohibernate.modelo.Empleado;

public interface ServicioEmpleado {

	boolean insertarEmpleado(Empleado empleado);

	boolean actualizarEmpleado(Empleado empleado);

	boolean actualizaEmpleadoDonde(Integer id, String nombre);

	boolean eliminarEmpleado(Empleado empleado);

	List<Empleado> obtenerEmpleados();

}
