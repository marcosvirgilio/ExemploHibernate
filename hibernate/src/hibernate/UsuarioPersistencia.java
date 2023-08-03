package hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class UsuarioPersistencia {
	
	 public Usuario consultaUsuarioPorId(int id) {
	        Transaction transaction = null;
	        Usuario usr = null;
	        try (Session session = PersistenciaUtil.getSessionFactory().openSession()) {
	            // start a transaction
	            transaction = session.beginTransaction();
	            // Obtain an entity using get() method
	            usr = session.get(Usuario.class, id);
                /*
	            // Obtain an entity using load() method
	            Usuario usr2 = session.load(Usuario.class, 2L);
	            System.out.println(usr2.getNome());
	            */
	            // Obtain an entity using byId() method
	            //usr = session.byId(Usuario.class).getReference(id);
	                    
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
			return usr;
	    }
	
    public void salvaUsuario(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = PersistenciaUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            //session.saveOrUpdate(usuario);
            session.persist(usuario);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void atualizaUsuario(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = PersistenciaUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            //session.saveOrUpdate(usuario);
            session.merge(usuario);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public void apagaUsuario(Usuario usuario) {
        Transaction transaction = null;
        try (Session session = PersistenciaUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            //session.saveOrUpdate(usuario);
            session.delete(usuario);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public List < Usuario > getUsuarios() {
        try (Session session = PersistenciaUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Usuario", Usuario.class).list();
        }
    }
}
