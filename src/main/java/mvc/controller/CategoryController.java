package mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.dao.CategoryDao;
import mvc.entity.Category;

@Controller
@RequestMapping("/category")
public class CategoryController {

	private final CategoryDao categoryDao;
	
	@Autowired
	public CategoryController(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("category", new Category());
		return "category/add";
	}
	
	@PostMapping("/add")
	public String add(@ModelAttribute Category category, Model model) {
		categoryDao.createCategory(category);
		return "redirect:/category/list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("category", categoryDao.readAllCategories());
		return "category/list";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable long id) {
		Category category = categoryDao.readCategory(id);
		model.addAttribute("category", category);
		return "category/edit";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute Category category) {
		categoryDao.updateCategory(category);
		return "redirect:/category/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		categoryDao.deleteCategory(categoryDao.readCategory(id));
		return "redirect:/category/list";
	}
	
}
