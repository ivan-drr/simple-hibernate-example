package aytos.es.ejerciciohibernate.controlador;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import aytos.es.ejerciciohibernate.modelo.Departamento;

public class ControladorDepartamentoImpl implements ControladorDepartamento {

	private final SessionFactory sessionFactory = HibernateConfiguration.init();

	@Override
	public boolean insertDepartamento(final Departamento departamento) {
		boolean resultado = false;
		final Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.save(departamento);
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
	public List<Departamento> listDepartamento() {

		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		List<Departamento> departamentos = new ArrayList<>();

		try {
			tx = session.beginTransaction();
			departamentos = session.createQuery("FROM Departamento").list();

			tx.commit();
		} catch (final HibernateException ex) {
			if (tx != null)
				tx.rollback();
		} finally {
			session.close();
		}
		return departamentos;
	}

	@Override
	public boolean actualizaDepartamento(Departamento departamento) {
		boolean resultado = false;
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.update(departamento);
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
	public boolean actualizaDepartamentoWhere(int id, String nombre) {
		boolean resultado = false;
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createQuery("update Departamento set DEP_NOM = :nombre where DEP_ID = :id");
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
	public boolean eliminarDepartamento(Departamento departamento) {
		boolean resultado = false;
		Session session = this.sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.delete(departamento);
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
