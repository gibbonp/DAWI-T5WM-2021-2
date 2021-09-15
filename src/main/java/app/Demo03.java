package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql8");
		
		EntityManager em = fabrica.createEntityManager();
		
		// -- proceso -> eliminar datos en la entidad
		
		Usuario u = new Usuario();
		u.setCodigo(123);
		//nombre, apellido, estado, etc.
				
		em.getTransaction().begin();
		em.remove(u); //borra fisicamente todo el registro
		em.getTransaction().commit();
		em.close();

	}
}
