package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;

public class EliminaProducto {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql8");
		EntityManager em = fabrica.createEntityManager();
		
		Producto p = em.find(Producto.class,"P0032");
		
		if(p == null) {
			System.out.println("Producto no existe");
		}else {
			System.out.println("Producto encontrado");
			System.out.println(p);
			
			em.getTransaction().begin();
			em.remove(p);
			em.getTransaction().commit();
			System.out.println("Producto eliminado");
		}
		em.close();
	}
}
