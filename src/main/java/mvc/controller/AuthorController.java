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

import mvc.dao.AuthorDao;
import mvc.entity.Author;

@Controller
@RequestMapping("/author")
public class AuthorController {

	private final AuthorDao authorDao;
	
	@Autowired
	public AuthorController(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("author", new Author());
		return "author/add";
	}
	
	@PostMapping("/add")
	public String add(@Validated @ModelAttribute Author author, BindingResult result) {
		if(result.hasErrors()) {
			return "author/add";
		}
		authorDao.createAuthor(author);
		return "redirect:/author/list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("author", authorDao.readAllAuthors());
		return "author/list";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable Long id) {
		model.addAttribute("author", authorDao.readAuthor(id));
		return "author/edit";
	}
	
	@PostMapping("/edit")
	public String edit(@Validated @ModelAttribute Author author, BindingResult result) {
		if(result.hasErrors()) {
			return "author/list";
		}
		authorDao.updateAuthor(author);
		return "redirect:/author/list";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		authorDao.deleteAuthor(authorDao.readAuthor(id));
		return "redirect:/author/list";
	}
	
}
