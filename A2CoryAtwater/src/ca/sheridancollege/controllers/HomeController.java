package ca.sheridancollege.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.beans.Wiki;
import ca.sheridancollege.dao.DAO;
import ca.sheridancollege.dao.WikiDAO;

@Controller
public class HomeController {

	private DAO dao;

	@Autowired
	public HomeController(WikiDAO studentDAO) {
		super();
		this.dao = studentDAO;
		dao.Populate();
	}

	@GetMapping("/")
	public String Home(Model model) {
		model.addAttribute("wiki", new Wiki());
		model.addAttribute("wikiList", dao.getWikiList());
		return "home";
	}

	@PostMapping("saveWiki")
	public String saveWiki(Model model, @ModelAttribute Wiki wiki) {
		
		dao.insertWiki(wiki);
		
		model.addAttribute("wikiList", dao.getWikiList());
		return "home";
	}
	
	@GetMapping("addWiki")
	public String addWiki(Model model, @ModelAttribute Wiki wiki) {
		return "addWiki";
	}
	
	@GetMapping("viewWiki/{wikiId}/{wikiCategory}")
	public String viewWiki(Model model, @PathVariable Long wikiId, @PathVariable String wikiCategory) {
		dao.getWikiList()
		.stream()
		.filter(w -> w.getWikiId().equals(wikiId))
		.findFirst()
		.ifPresent(w -> model.addAttribute("wiki", w));
		
		List<Wiki> t = dao.getSimilarWiki(wikiCategory);
		t.removeIf(w -> w.getWikiId().equals(wikiId));
		
		model.addAttribute("wikiCategory", t);
		
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
