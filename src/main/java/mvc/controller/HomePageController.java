package mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.dao.ArticleDao;

@Controller
@RequestMapping("/home")
public class HomePageController {
	
	private final ArticleDao articleDao;
	
	@Autowired
	public HomePageController(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@GetMapping("/")
	public String getLastFive(Model model) {
		model.addAttribute("listLast5", articleDao.getLastFiveArticles());
		return "homePage/homePage";
	}
}
