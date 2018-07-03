
package mvc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import mvc.entity.Article;
import mvc.entity.Author;

@Component
@Transactional
public class ArticleDao {

	@PersistenceContext
	EntityManager entityManager;
	
	//CRUD below
	public void createArticle(Article entity) {
		entityManager.persist(entity);
	}
	
	public Article readArticle(long id) {
		return entityManager.find(Article.class, id);
	}
	
	public List<Article> readAllArticles() {
		Query query = entityManager.createQuery("SELECT a FROM Article a");
		return query.getResultList();
	}
	
	public void updateArticle(Article entity) {
		entityManager.merge(entity);
	}
	
	public void deleteArticle(Article entity) {
//		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
		if(!entityManager.contains(entity)) {
			entity = entityManager.merge(entity);
		}
		entity.getCategory().removeAll(entity.getCategory());
//		entity.setAuthor(new Author());
		entityManager.remove(entity);
		
	}
	
	public List<Article> getLastFiveArticles() {
		Query query = entityManager.createQuery("SELECT a FROM Article a ORDER BY a.id DESC");
		List<Article> lastFive = query.setMaxResults(5).getResultList();
		return lastFive;
	}
	
	public List<Article> getListByCategory(Long id) {
//		Query query = entityManager.createQuery("SELECT a FROM Article a INNER JOIN a.articles_categories b WHERE b.category_id =:id");
		Query query = entityManager.createNativeQuery("SELECT * FROM articles INNER JOIN articles_categories ON " 
				+ "articles.id = articles_categories.articles_id WHERE articles_categories.category_id = ?1", Article.class);
		query.setParameter(1, id);
		return query.getResultList();
	}
	
	public List<Article> readOnlyArticles() {
		Query query = entityManager.createQuery("SELECT a FROM Article a WHERE a.draft = false");
		return query.getResultList();
	}
	
	public List<Article> readOnlyDrafts() {
		Query query = entityManager.createQuery("SELECT a FROM Article a WHERE a.draft = true");
		return query.getResultList();
	}
	
	public void deleteAssociationWithCategories(long id) {
		Query query = entityManager.createNativeQuery("DELETE FROM articles_categories WHERE articles_categories.articles_id = ?1");
		query.setParameter(1, id);
		query.executeUpdate();
		System.out.println("Associations deleted");
	}
	
}
