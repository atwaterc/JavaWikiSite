package ca.sheridancollege.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.beans.Student;
import ca.sheridancollege.beans.Wiki;
import ca.sheridancollege.dao.DAO;
import ca.sheridancollege.dao.StudentDAO;

@Controller
public class HomeController {

	private DAO dao;

	@Autowired
	public HomeController(StudentDAO studentDAO) {
		super();
		this.dao = studentDAO;
		dao.Populate();
	}

	@GetMapping("/")
	public String Home(Model model) {
		Wiki wiki = new Wiki();
		model.addAttribute("wiki", wiki);
		model.addAttribute("wikiList", dao.getWikiList());
		return "home";
	}

	@PostMapping("saveWiki")
	public String saveStudent(Model model, @ModelAttribute Wiki wiki) {
		
		dao.insertWiki(wiki);
		
		model.addAttribute("wikiList", dao.getWikiList());
		return "home";
	}
	
	@GetMapping("addWiki")
	public String addWiki(Model model, @ModelAttribute Wiki wiki) {
		return "editWiki";
	}
	
	@GetMapping("viewWiki/{wikiId}")
	public String viewWiki(Model model, @PathVariable Long wikiId) {
		
		dao.getWikiList()
		.stream()
		.filter(w -> w.getWikiId().equals(wikiId))
		.findFirst()
		.ifPresent(w -> model.addAttribute("wiki", w));
		
		return "viewWiki";
	}
	
	@GetMapping("editWiki/{wikiId}")
	public String editWiki(Model model, @PathVariable Long wikiId) {
		
		dao.getWikiList()
			.stream()
			.filter(w -> w.getWikiId().equals(wikiId))
			.findFirst()
			.ifPresent(w -> model.addAttribute("wiki", w));
		
		dao.getWikiList()
			.removeIf(w -> w.getWikiId().equals(wikiId));

		return "editWiki";
	}

	@GetMapping("deleteWiki/{wikiId}")
	public String deleteWiki(Model model, @PathVariable Long wikiId) {
		dao.deleteWiki(wikiId);
		
		model.addAttribute("wikiList", dao.getWikiList());
		return "home";
	}
}
