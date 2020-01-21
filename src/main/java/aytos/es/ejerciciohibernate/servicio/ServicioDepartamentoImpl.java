package aytos.es.ejerciciohibernate.servicio;

import java.util.List;

import aytos.es.ejerciciohibernate.controlador.ControladorDepartamentoImpl;
import aytos.es.ejerciciohibernate.modelo.Departamento;

public class ServicioDepartamentoImpl implements ServicioDepartamento {

	private ControladorDepartamentoImpl depController;

	public ServicioDepartamentoImpl() {
		this.depController = new ControladorDepartamentoImpl();
	}

	@Override
	public boolean insertarDepartamento(Departamento departamento) {
		if (departamento.getClass() == Departamento.class) {
			return this.depController.insertDepartamento(departamento);
		} else
			return false;
	}

	@Override
	public boolean actualizarDepartamento(Departamento departamento) {
		if (departamento.getClass() == Departamento.class) {
			return this.depController.actualizaDepartamento(departamento);
		} else
			return false;
	}

	@Override
	public boolean actualizaDepartamentoDonde(Integer id, String nombre) {
		if (id != null && (nombre != null || nombre != "")) {
			return this.depController.actualizaDepartamentoWhere(id, nombre);
		} else
			return false;
	}

	@Override
	public boolean eliminarDepartamento(Departamento departamento) {
		if (departamento.getClass() == Departamento.class) {
			return this.depController.eliminarDepartamento(departamento);
		} else
			return false;
	}

	@Override
	public List<Departamento> obtenerDepartamentos() {
		return this.depController.listDepartamento();
	}

}
