package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04_03 {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql8");
		
		EntityManager em = fabrica.createEntityManager();
		
		// -- proceso -> busca la informacion del usuario con codigo 12
		
		Usuario u = em.find(Usuario.class, 123);
		
		if (u == null) {
			System.out.println("Usuario no existe");
		}else {
			System.out.println("Usuario encontrado");
			System.out.println(u);
			
			em.getTransaction().begin();
			em.remove(u); //borra fisicamente
			em.getTransaction().commit();
			System.out.println("Usuario Eliminado");
		}
		
		em.close();
	}

}