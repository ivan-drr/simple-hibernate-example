package aytos.es.ejerciciohibernate.servicio;

import java.util.List;

import aytos.es.ejerciciohibernate.controlador.ControladorEmpleadoImpl;
import aytos.es.ejerciciohibernate.modelo.Empleado;

public class ServicioEmpleadoImpl implements ServicioEmpleado {

	private ControladorEmpleadoImpl empController;

	public ServicioEmpleadoImpl() {
		this.empController = new ControladorEmpleadoImpl();
	}

	@Override
	public boolean insertarEmpleado(Empleado empleado) {
		if (empleado.getClass() == Empleado.class) {
			return this.empController.insertEmpleado(empleado);
		} else
			return false;
	}

	@Override
	public boolean actualizarEmpleado(Empleado empleado) {
		if (empleado.getClass() == Empleado.class) {
			return this.empController.actualizaEmpleado(empleado);
		} else
			return false;
	}

	@Override
	public boolean actualizaEmpleadoDonde(Integer id, String nombre) {
		if (id != null && (nombre != null || nombre != "")) {
			return this.empController.actualizaEmpleadoWhere(id, nombre);
		} else
			return false;
	}

	@Override
	public boolean eliminarEmpleado(Empleado empleado) {
		if (empleado.getClass() == Empleado.class) {
			return this.empController.eliminarEmpleado(empleado);
		} else
			return false;
	}

	@Override
	public List<Empleado> obtenerEmpleados() {
		return this.empController.listEmpleado();
	}

}
