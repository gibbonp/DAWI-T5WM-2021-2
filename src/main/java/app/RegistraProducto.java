package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;

public class RegistraProducto {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql8");
		EntityManager em = fabrica.createEntityManager();
		
		Producto p = new Producto();
		p.setCodigo("P0032");
		p.setDescripcion("TapsinMigrol");
		p.setStock(10);
		p.setPrecio(2.50);
		p.setIdcategoria(5);
		p.setEstado(1);
		
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		
		System.out.println("Producto Registrado");
		em.close();
	}

}
