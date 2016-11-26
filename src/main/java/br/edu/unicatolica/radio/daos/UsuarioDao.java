package br.edu.unicatolica.radio.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.edu.unicatolica.radio.models.PaginatedList;
import br.edu.unicatolica.radio.models.Usuario;

@Repository
public class UsuarioDao {

	@PersistenceContext
	private EntityManager manager;

	public List<Usuario> all() {
		return manager.createQuery("select c from Usuario c", Usuario.class).getResultList();
	}

	public Usuario getByName(String nome) {
		return manager.createQuery("select c from Usuario c where c.nomeUsuario = :nome ", Usuario.class)
				.setParameter("nome", nome).getSingleResult();
	}

	public void save(Usuario usuario) {
		manager.persist(usuario);
	}

	public Usuario findById(Integer id) {
		return manager.find(Usuario.class, id);
	}

	public void remove(Usuario usuario) {
		manager.remove(usuario);
	}

	public void update(Usuario usuario) {
		manager.merge(usuario);
	}

	public PaginatedList paginated(int page, int max) {
		return new PaginatorQueryHelper().list(manager, Usuario.class, page, max);
	}

}
