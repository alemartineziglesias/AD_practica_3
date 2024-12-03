package practica;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HotelManager
{
	public void crearCliente(Cliente cliente)
	{
		SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Cliente.class).configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(cliente);
		tx.commit();
		session.close();
	}

	public List<Cliente> leerCliente() 
	{
		SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Cliente.class).configure().buildSessionFactory();
		String consulta = "FROM " + Cliente.class.getName();
		Session sessionObj = sessionFactory.openSession();
		List<Cliente> listaResultado = sessionObj.createQuery(consulta, Cliente.class).list();
		for(Cliente u : listaResultado) 
		{
			System.out.println(u.getIdCliente() + " - " + u.getNombre() + " - " + u.getClave() );
		}
		sessionObj.close();
		return listaResultado;
	}
	
	public Cliente encontrarCliente(int id)
	{
		SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Cliente.class).configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Cliente existente = session.find(Cliente.class, id);
		session.close();
		return existente;
	}
	
	public void actualizarCliente(Cliente cliente)
	{
		SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Cliente.class).configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.merge(cliente);
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("deprecation")
	public void eliminarCliente(Cliente cliente)
	{
		SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Cliente.class).configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(cliente);
		tx.commit();
		session.close();
	}
}
