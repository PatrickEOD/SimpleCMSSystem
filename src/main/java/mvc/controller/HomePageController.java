package mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.dao.ArticleDao;
import mvc.dao.CategoryDao;
import mvc.entity.Category;
import mvc.repositories.ArticleRepository;
import mvc.repositories.CategoryRepository;

@Controller
@RequestMapping("/home")
public class HomePageController {
	
	private final ArticleDao articleDao;
	private final CategoryDao categoryDao;
	private final ArticleRepository articleRepository;
	private final CategoryRepository categoryRepository;
	
	@Autowired
	public HomePageController(ArticleDao articleDao, CategoryDao categoryDao, ArticleRepository articleRepository, CategoryRepository categoryRepository) {
		this.articleDao = articleDao;
		this.categoryDao = categoryDao;
		this.articleRepository = articleRepository;
		this.categoryRepository = categoryRepository;
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories(){
//		return categoryDao.readAllCategories();
		return categoryRepository.findAll();
	}

	@GetMapping("/")
	public String getLastFive(Model model) {
//		model.addAttribute("listLast5", articleDao.getLastFiveArticles());
		model.addAttribute("listLast5", articleRepository.findFirst5ByDraftOrderByCreatedAsc(false));
		return "homePage/homePage";
	}
	
//	@PostMapping("/")
//	public String getByCategories(@ModelAttribute Category articlesByCategory, Model model) {
//		return "homePage/listByCategories";
//	}
	
	@GetMapping("/listByCategories/{id}")
	public String getListByCategories(Model model, @PathVariable Long id) {
//		model.addAttribute("categoryList", articleDao.getListByCategory(id));
		model.addAttribute("categoryList", articleRepository.findByCategoryId(id));
		return "homePage/listByCategories";
	}
}
