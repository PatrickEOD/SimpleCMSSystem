package mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mvc.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
