package aytos.es.ejerciciohibernate.controlador;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import aytos.es.ejerciciohibernate.modelo.Empleado;

public class ControladorEmpleadoImpl implements ControladorEmpleado {

	private final SessionFactory sessionFactory = HibernateConfiguration.init();

	@Override
	public boolean insertEmpleado(final Empleado empleado) {
		boolean resultado = false;
		final Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(empleado);
			tx.commit();
			resultado = true;
		} catch (final HibernateException ex) {
			if (tx != null)
				tx.rollback();
			return false;
		} finally {
			session.close();
		}
		return resultado;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> listEmpleado() {
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		List<Empleado> empleados = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			empleados = session.createQuery("FROM Empleado").list();

			tx.commit();
		} catch (final HibernateException ex) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}
		return empleados;
	}

	@Override
	public boolean actualizaEmpleado(Empleado empleado) {
		boolean resultado = false;
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.update(empleado);
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
			}
			resultado = true;
		} finally {
			session.close();
		}
		return resultado;
	}

	@Override
	public boolean actualizaEmpleadoWhere(int id, String nombre) {
		boolean resultado = false;
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("update Empleado set EMP_NOM = :nombre where EMP_ID = :id");
			query.setParameter("id", id);
			query.setParameter("nombre", nombre);
			resultado = query.executeUpdate() == 0 ? false : true;
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return resultado;
	}

	@Override
	public boolean eliminarEmpleado(Empleado empleado) {
		boolean resultado = false;
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(empleado);
			tx.commit();
			resultado = true;
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
				return false;
			}
		} finally {
			session.close();
		}
		return resultado;
	}

}
