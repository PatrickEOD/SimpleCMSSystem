package mvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import mvc.entity.Author;

@Repository
@Transactional
public class AuthorDao {

	@PersistenceContext
	EntityManager entityManager;
	
	//CRUD below
	public void createAuthor(Author entity) {
		entityManager.persist(entity);
	}
	
	public Author readAuthor(long id) {
		return entityManager.find(Author.class, id);
	}
	
	public List<Author> readAllAuthors() {
		Query query = entityManager.createQuery("SELECT a FROM Author a");
		return query.getResultList();
	}
	
	public void updateAuthor(Author entity) {
		entityManager.merge(entity);
	}
	
	public void deleteAuthor(Author entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}
}
