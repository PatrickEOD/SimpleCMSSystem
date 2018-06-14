package mvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import mvc.entity.Category;

@Repository
@Transactional
public class CategoryDao {

	@PersistenceContext
	EntityManager entityManager;
	
	//CRUD below
	public void createCategory(Category entity) {
		entityManager.persist(entity);
	}
	
	public Category readCategory(long id) {
		return entityManager.find(Category.class, id);
	}
	
	public List<Category> readAllCategories() {
		Query query = entityManager.createQuery("SELECT a FROM Category a");
		return query.getResultList();
	}
	
	public void updateCategory(Category entity) {
		entityManager.merge(entity);
	}
	
	public void deleteCategory(Category entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}
}
