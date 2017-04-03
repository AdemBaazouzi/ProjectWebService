package dauphine.webServices.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dauphine.webServices.dao.IDao;
import dauphine.webServices.entity.Personne;
import dauphine.webServices.util.HibernateUtil;

/**
 *
 * @author 
 */
public class PersonneService implements IDao<Personne> {
	Transaction tx = null;
	Session session = null;
	Personne personne = null;

	@Override
	public boolean create(Personne o) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(o);
			tx.commit();
			return true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		return false;
	}

	@Override
	public boolean update(Personne o) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.update(o);
			tx.commit();
			return true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		return false;
	}

	@Override
	public boolean delete(Personne o) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.delete(o);
			tx.commit();
			return true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		return false;
	}

	@Override
	public List<Personne> getAll() {
		List<Personne> liste = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			liste = session.createQuery("from Personne").list();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		return liste;
	}

	@Override
	public List<Personne> getByName(String logins, String pwds) {
		List<Personne> liste = null;
		session = HibernateUtil.getSessionFactory().openSession();
		liste = session.createQuery("from Personne where login='" + logins + "' and pwd='" + pwds + "'").list();
		return liste;

	}

	@Override
	public Personne getById(int id) {
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			personne = (Personne) session.get(Personne.class, id);
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		return personne;
	}

}
// 