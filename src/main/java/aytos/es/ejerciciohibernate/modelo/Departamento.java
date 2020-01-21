package aytos.es.ejerciciohibernate.modelo;

import java.util.Set;

public class Departamento {

	private int id;
	private String nombre;
	private Set<Empleado> empleados;

	public Departamento() {
	}

	public Departamento(int id, String nombre, Set<Empleado> empleados) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.empleados = empleados;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}

	@Override
	public String toString() {
		return "Departamento [id=" + this.id + ", nombre=" + this.nombre + "]";
	}

}
