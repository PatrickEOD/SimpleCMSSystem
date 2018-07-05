package mvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mvc.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
	
	List<Article> findFirst5ByDraftOrderByCreatedAsc(boolean draft);
	
	List<Article> findByCategoryId(Long id);
}
