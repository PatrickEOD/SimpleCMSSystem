
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
	
	public List<Article> getLastFiveArticles(Article entity) {
		Query query = entityManager.createQuery("SELECT a FROM articles a ORDER BY id DESC LIMIT 5");
		List<Article> lastFive= query.getResultList();
		return lastFive;
	}
}
