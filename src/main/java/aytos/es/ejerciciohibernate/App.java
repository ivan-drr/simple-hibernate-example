package aytos.es.ejerciciohibernate;

import aytos.es.ejerciciohibernate.modelo.Departamento;
import aytos.es.ejerciciohibernate.modelo.Empleado;
import aytos.es.ejerciciohibernate.servicio.ServicioDepartamento;
import aytos.es.ejerciciohibernate.servicio.ServicioDepartamentoImpl;
import aytos.es.ejerciciohibernate.servicio.ServicioEmpleado;
import aytos.es.ejerciciohibernate.servicio.ServicioEmpleadoImpl;

public class App {

	public static void main(String[] args) {
		ServicioDepartamento servicioDepartamento = new ServicioDepartamentoImpl();
		ServicioEmpleado servicioEmpleado = new ServicioEmpleadoImpl();
		
		Departamento departamento1 = new Departamento(1, "Society", null);
		Departamento departamento2 = new Departamento(2, "Nullify", null);

		servicioDepartamento.eliminarDepartamento(departamento1);
		servicioDepartamento.eliminarDepartamento(departamento2);

		servicioDepartamento.insertarDepartamento(departamento1);
		servicioDepartamento.insertarDepartamento(departamento2);
		
		departamento1.setNombre("SocietyUpdated");
		servicioDepartamento.actualizarDepartamento(departamento1);

		servicioDepartamento.actualizaDepartamentoDonde(2, "NullifyUpdatedById");

		Empleado empleado1 = new Empleado(1, "Juan", departamento1);
		Empleado empleado2 = new Empleado(2, "Ramon", departamento2);
		Empleado empleado3 = new Empleado(3, "Maria", departamento1);

		servicioEmpleado.eliminarEmpleado(empleado1);
		servicioEmpleado.eliminarEmpleado(empleado2);
		servicioEmpleado.eliminarEmpleado(empleado3);

		servicioEmpleado.insertarEmpleado(empleado1);
		servicioEmpleado.insertarEmpleado(empleado2);
		servicioEmpleado.insertarEmpleado(empleado3);
		
		empleado1.setNombre("JuanUpdated");
		servicioEmpleado.actualizarEmpleado(empleado1);

		servicioEmpleado.actualizaEmpleadoDonde(2, "RamonUpdatedById");

		System.out.println(servicioDepartamento.obtenerDepartamentos());
		System.out.println();
		System.out.println(servicioEmpleado.obtenerEmpleados());

		System.out.println("END");
    }
}
