package mvc.validators;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import mvc.entity.Article;

public class ArticleSequenceProvider implements DefaultGroupSequenceProvider<Article> {

	public List<Class<?>> getValidationGroups(Article article) {
		List<Class<?>> sequence = new ArrayList<Class<?>>();
		sequence.add(Article.class);
		if (article != null && !article.isDraft()) {
			sequence.add(ValidationGroupArticles.class);
		} else if(article != null && article.isDraft()){
			sequence.add(ValidationGroupDrafts.class);
		}
//		if(article != null && article.isDraft()) {
//			sequence.add(ValidationGroupDrafts.class);
//		}
		return sequence;
	}

	
}
