package aytos.es.ejerciciohibernate.controlador;

import java.util.List;

import aytos.es.ejerciciohibernate.modelo.Departamento;

public interface ControladorDepartamento {

	boolean insertDepartamento(final Departamento departamento);

	List<Departamento> listDepartamento();

	boolean actualizaDepartamento(Departamento departamento);

	boolean actualizaDepartamentoWhere(int id, String nombre);

	boolean eliminarDepartamento(Departamento departamento);

}
