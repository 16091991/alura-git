package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Autor;

@Stateless
public class AutorDao {
	@PersistenceContext
	EntityManager manager;

	@PostConstruct
	void aposCriacao() {
		System.out.println("AutorDao foi criado");
	}

	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void salva(Autor autor) {
		System.out.println("Salvando Autor " + autor.getNome());
		manager.persist(autor);
		System.out.println("Salvou Autor " + autor.getNome());
	}

	public List<Autor> todosAutores() {
		return manager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.manager.find(Autor.class, autorId);
		return autor;
	}

}
