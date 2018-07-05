package mvc.controller;

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

import mvc.dao.CategoryDao;
import mvc.entity.Category;
import mvc.repositories.CategoryRepository;

@Controller
@RequestMapping("/category")
public class CategoryController {

	private final CategoryDao categoryDao;
	private final CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryController(CategoryDao categoryDao, CategoryRepository categoryRepository) {
		this.categoryDao = categoryDao;
		this.categoryRepository = categoryRepository;
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("category", new Category());
		return "category/add";
	}
	
	@PostMapping("/add")
	public String add(@Validated @ModelAttribute Category category, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "category/add";
		}
//		categoryDao.createCategory(category);
		categoryRepository.save(category);
		return "redirect:/category/list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
//		model.addAttribute("category", categoryDao.readAllCategories());
		model.addAttribute("category", categoryRepository.findAll());
		return "category/list";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable long id) {
//		Category category = categoryDao.readCategory(id);
		Category category = categoryRepository.findOne(id);
		model.addAttribute("category", category);
		return "category/edit";
	}
	
	@PostMapping("/edit")
	public String edit(@Validated @ModelAttribute Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "category/list";
		}
//		categoryDao.updateCategory(category);
		categoryRepository.save(category);
		return "redirect:/category/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
//		categoryDao.deleteCategory(categoryDao.readCategory(id));
		categoryRepository.delete(categoryRepository.findOne(id));
		return "redirect:/category/list";
	}
	
}
