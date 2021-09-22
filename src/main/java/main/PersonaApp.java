package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Autor;
import entidades.Domicilio;
import entidades.Libro;
import entidades.Localidad;
import entidades.Persona;

public class PersonaApp {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaAppPU");
		EntityManager em = emf.createEntityManager();

		try{
			em.getTransaction().begin();
			
			Localidad localidad = Localidad.builder().denominacion("Las Heras").build();

			Domicilio dom1 = Domicilio.builder().calle("Espejo").numero(213).build();
			
			Persona persona = Persona.builder().nombre("Mariano").apellido("Grosso").dni(37624614).build();
			
			Autor autor = Autor.builder().nombre("John").apellido("Tolkien").biografia("John Ronald Reuel Tolkien, fue un escritor, poeta, fil�logo, ling�ista y profesor universitario brit�nico.").build();
			
			Libro libro1 = Libro.builder().autor("J.R.R Tolkien").genero("Fantas�a").nombre("Se�or de los Anillos").fecha(1992).paginas(1500).build();
			Libro libro2 = Libro.builder().autor("J.R.R Tolkien").genero("Fantas�a").nombre("The Hobbit").fecha(1995).paginas(900).build();
			
			
			
			
			
			
			System.out.println(libro1.toString());
			
			em.persist(persona);
			em.persist(autor);
			em.persist(localidad);
			em.persist(libro1);
			em.persist(libro2);
			em.persist(dom1);

			em.flush();

			em.getTransaction().commit();

		} catch(Exception e){
			em.getTransaction().rollback();
		}

		em.close();
		emf.close();

	}

}
