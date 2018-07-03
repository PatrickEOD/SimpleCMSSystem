package mvc.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.dao.ArticleDao;
import mvc.dao.AuthorDao;
import mvc.dao.CategoryDao;
import mvc.entity.Article;
import mvc.entity.Author;
import mvc.entity.Category;

@Controller
@RequestMapping("/draft")
public class DraftController {

	ArticleDao articleDao;
	CategoryDao categoryDao;
	AuthorDao authorDao;
	
	@Autowired
	public DraftController(ArticleDao articleDao, CategoryDao categoryDao, AuthorDao authorDao) {
		this.articleDao = articleDao;
		this.authorDao = authorDao;
		this.categoryDao = categoryDao;
	}
	
	@ModelAttribute("categories")
    public List<Category> getCategories() {
    	return categoryDao.readAllCategories();
    }
	
	@ModelAttribute("authors")
	public List<Author> getAuthors() {
		return authorDao.readAllAuthors();
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		Article article = new Article();
		article.setDraft(true);
		model.addAttribute("draft", article);
		return "article/draft/add";
	}
	
	@PostMapping("/add")
	public String add(@Validated @ModelAttribute (name = "draft") Article draft, BindingResult result) {
		if(result.hasErrors()) {
			return "article/draft/add";
		}
		draft.setDraft(true);
		draft.setCreated(getActualDate());
		articleDao.createArticle(draft);
		return "redirect:/draft/list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("draft", articleDao.readOnlyDrafts());
		return "article/draft/list";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("draft", articleDao.readArticle(id));
		return "article/draft/edit";
	}
	
	@PostMapping("/edit")
	public String edit(@Validated @ModelAttribute (name = "draft") Article draft, BindingResult result) {
		if(result.hasErrors()) {
			return "article/draft/list";
		}
		draft.setUpdated(getActualDate());
		articleDao.updateArticle(draft);
		return "redirect:/draft/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteArticle(@PathVariable long id) {
		articleDao.deleteArticle(articleDao.readArticle(id));
		return "redirect:/draft/list";
	}
	//utils
	
	private Timestamp getActualDate() {
		LocalDateTime ldt = LocalDateTime.now();
		return Timestamp.valueOf(ldt);
	}
	
}
