package mvc.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import mvc.dao.ArticleDao;
import mvc.dao.AuthorDao;
import mvc.dao.CategoryDao;
import mvc.entity.Article;
import mvc.entity.Author;
import mvc.entity.Category;

@Controller
@RequestMapping("/article")
public class ArticleController {

	private final ArticleDao articleDao;
	private final CategoryDao categoryDao;
	private final AuthorDao authorDao;

	@Autowired
	public ArticleController(ArticleDao articleDao, CategoryDao categoryDao, AuthorDao authorDao) {
		this.articleDao = articleDao;
		this.categoryDao = categoryDao;
		this.authorDao = authorDao;
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
		model.addAttribute("article", new Article());
		return "article/add";
	}

	@PostMapping("/add")
	public String add(@ModelAttribute Article article) {
		article.setCreated(getActualDate());
		articleDao.createArticle(article);
		return "redirect:/article/list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("article", articleDao.readAllArticles());
		return "article/list";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("article", articleDao.readArticle(id));
		return "article/edit";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute Article article) {
		article.setUpdated(getActualDate());
		articleDao.updateArticle(article);
		return "redirect:/article/list";
	}

	@GetMapping("/delete/{id}")
	public String deleteArticle(@PathVariable long id) {
		articleDao.deleteArticle(articleDao.readArticle(id));
		return "redirect:/article/list";
	}

	// utils
	
	//java.utils.Date version
	private Date getActualDate() {
		java.util.Date dt = new java.util.Date();
		java.util.Date newdt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(dt);
		try {
			newdt = sdf.parse(currentTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return newdt;
	}
	
	//timestamp version
//	private Timestamp getActualDate() {
//		java.util.Date dt = new java.util.Date();
//		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String currentTime = sdf.format(dt);
//		try {
//			newdt = sdf.parse(currentTime);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return newdt;
//		return Timestamp.valueOf(currentTime);
//	}
}