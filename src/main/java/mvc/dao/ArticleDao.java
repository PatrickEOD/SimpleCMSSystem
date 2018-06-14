
package mvc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import mvc.entity.Article;

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
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}
	
	public List<Article> getLastFiveArticles() {
		Query query = entityManager.createQuery("SELECT a FROM Article a ORDER BY a.id DESC");
		List<Article> lastFive = query.setMaxResults(5).getResultList();
		return lastFive;
	}
}
