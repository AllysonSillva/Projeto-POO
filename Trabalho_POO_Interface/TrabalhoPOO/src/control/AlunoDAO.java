package control;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Aluno;

public class AlunoDAO implements GenericDAO<Aluno>{
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalho-jpa");
	
	private EntityManager em = emf.createEntityManager();
	
	public void begin() {
		em.getTransaction().begin();
	}
	
	public void commit() {
		em.getTransaction().commit();
	}
	
	public void rollback() {
		em.getTransaction().rollback();
	}
	
	public void close() {
		em.close();
		emf.close();
	}
	
	public void adicionar(Aluno a) {
	
		begin();
		
		em.persist(a);
		
		commit();
		
	}

	public void deletar(Aluno a) {
		
		begin();
		
		em.remove(a);
		
		commit();
		
	}

	public void atualizar(Aluno a) {
		
		begin();
		
		em.merge(a);
		
		commit();
		
	}

	public Aluno consultar(long mat) {
		
		return (Aluno) em.createNamedQuery("alunos.consultar").setParameter("matricula", mat).getSingleResult();
		
	}
	
	public List<Aluno> listar() {
		
       Query query = em.createNamedQuery("alunos.listar");
       List<Aluno> lista = query.getResultList();
       return lista;
       
	}

}
