package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo05 {
	
	public static void main(String[] args) {

	EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql8");

	EntityManager em = fabrica.createEntityManager();
	
	//Proceso --> listado de usuario
	
	List<Usuario> lstUsuario = em.createQuery("select a from Usuario a", Usuario.class).getResultList();
	System.out.println("Nro de usuarios : " + lstUsuario.size());
	for (Usuario u : lstUsuario) {
		System.out.println(">>> " + u);
	}
	System.out.println("-----------------------------------------------");
	System.out.println("Listado de los Usuarios (Usando TypedQuery");
	
	
	TypedQuery<Usuario> consulta = em.createQuery("select a from Usuario a", Usuario.class);
	List<Usuario> lstUsuario2 = consulta.getResultList();
	System.out.println("Nro de usuarios : " + lstUsuario2.size());
	for (Usuario u : lstUsuario2) {
		System.out.println(">>> " + u);
	}
	
	System.out.println("-----------------------------------------------");
	System.out.println("Listado de los Usuarios (Usando TypedQuery y parametro)");
	
	System.out.println("Listado de Usuario del Tipo: 2");
	TypedQuery<Usuario> consulta2 = em.createQuery("select a from Usuario a where a.tipo = :xtipo", Usuario.class);
	consulta2.setParameter("xtipo", 2);
	List<Usuario> lstUsuario3 = consulta2.getResultList();
	System.out.println("Nro de usuarios : " + lstUsuario3.size());
	for (Usuario u : lstUsuario3) {
		System.out.println(">>> " + u);
	}
	
	System.out.println("-----------------------------------------------");
	System.out.println("Listado de los Usuarios (Usando TypedQuery y parametro)");
	
	System.out.println("Listado de Usuario del Tipo: 1");
	String sql = "select a from Usuario a where a.tipo = :xtipo";
	TypedQuery<Usuario> consulta3 = em.createQuery(sql, Usuario.class);
	consulta3.setParameter("xtipo", 1);
	List<Usuario> lstUsuario4 = consulta3.getResultList();
	System.out.println("Nro de usuarios : " + lstUsuario4.size());
	for (Usuario u : lstUsuario4) {
		System.out.println(">>> " + u);
	}
	
	em.close();
	
	}

}
