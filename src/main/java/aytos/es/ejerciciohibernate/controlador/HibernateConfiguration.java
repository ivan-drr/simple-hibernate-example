package aytos.es.ejerciciohibernate.controlador;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import aytos.es.ejerciciohibernate.modelo.Departamento;
import aytos.es.ejerciciohibernate.modelo.Empleado;

public class HibernateConfiguration {

	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;

	public static SessionFactory init() {
		Configuration config = new Configuration();
		config.configure();
		config.addAnnotatedClass(Departamento.class);
		config.addAnnotatedClass(Empleado.class);

		HibernateConfiguration.serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(config.getProperties()).build();
		HibernateConfiguration.factory = config.buildSessionFactory(HibernateConfiguration.serviceRegistry);

		return HibernateConfiguration.factory;
	}

}
