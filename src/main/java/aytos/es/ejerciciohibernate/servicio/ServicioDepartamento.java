package aytos.es.ejerciciohibernate.servicio;

import java.util.List;

import aytos.es.ejerciciohibernate.modelo.Departamento;

public interface ServicioDepartamento {

	boolean insertarDepartamento(Departamento departamento);

	boolean actualizarDepartamento(Departamento departamento);

	boolean actualizaDepartamentoDonde(Integer id, String nombre);

	boolean eliminarDepartamento(Departamento departamento);

	List<Departamento> obtenerDepartamentos();

}
