package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Producto;

public class ListaProducto {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql8");
		EntityManager em = fabrica.createEntityManager();
		
		List<Producto> lstProducto = em.createQuery("select p from Producto p", Producto.class).getResultList();
		System.out.println("Nro de Produtos : "+ lstProducto.size());
		for (Producto p : lstProducto) {
			System.out.println(">>> " + p);
		}
	}
}
