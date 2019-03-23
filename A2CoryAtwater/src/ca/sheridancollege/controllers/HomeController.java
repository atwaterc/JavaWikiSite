package ca.sheridancollege.controllers;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

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


/* For extra functionality I added a similar categories dropdown to each viewWiki page.  It will
 * allow the user to see other related pages without going back to the home page
 * */
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

		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Wiki>> constraintViolations = validator.validate(wiki);

		if (constraintViolations.size() > 0) {
			for (ConstraintViolation<Wiki> violation : constraintViolations) {
				model.addAttribute(violation.getPropertyPath().toString().replace(".", "_"), violation.getMessage());
				model.addAttribute("wiki", wiki);
			}
			return "addWiki";
		} else {
			dao.insertWiki(wiki);
		}

		model.addAttribute("wikiList", dao.getWikiList());
		return "home";
	}

	@GetMapping("addWiki")
	public String addWiki(Model model, @ModelAttribute Wiki wiki) {
		return "addWiki";
	}

	@GetMapping("viewWiki/{wikiId}/{wikiCategory}")
	public String viewWiki(Model model, @PathVariable Long wikiId, @PathVariable String wikiCategory) {
		dao.getWikiList().stream().filter(w -> w.getWikiId().equals(wikiId)).findFirst()
				.ifPresent(w -> model.addAttribute("wiki", w));

		List<Wiki> findSimilarWikis = dao.getSimilarWiki(wikiCategory);
		findSimilarWikis.removeIf(w -> w.getWikiId().equals(wikiId));

		model.addAttribute("wikiCategory", findSimilarWikis);

		return "viewWiki";
	}

	@GetMapping("editWiki/{wikiId}")
	public String editWiki(Model model, @PathVariable Long wikiId) {

		dao.getWikiList().stream().filter(w -> w.getWikiId().equals(wikiId)).findFirst()
				.ifPresent(w -> model.addAttribute("wiki", w));

		dao.getWikiList().removeIf(w -> w.getWikiId().equals(wikiId));
		
		Date date = new Date();
		
		model.addAttribute("date", date);

		return "editWiki";
	}

	@GetMapping("deleteWiki/{wikiId}")
	public String deleteWiki(Model model, @PathVariable Long wikiId) {
		
		dao.deleteWiki(wikiId);
		model.addAttribute("wikiList", dao.getWikiList());
		
		return "home";
	}
}
