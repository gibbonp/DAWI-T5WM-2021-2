package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql8");
		
		EntityManager em = fabrica.createEntityManager();
		
		// -- proceso -> actualizar datos en la entidad
		
		Usuario u = new Usuario();
		u.setCodigo(123);
		u.setNombre("Pablo");
		u.setApellido("Gibbons");
		u.setUsuario("pablog@mail.com");
		u.setClave("1234");
		u.setFnacim("1988/06/15");
		u.setTipo(1);
		u.setEstado(1);
		
		em.getTransaction().begin();
		em.merge(u); //actualiza siempre y cuando encuentre el codigo, si no lo agrega como nuevo
		em.getTransaction().commit();
		em.close();

	}
}
