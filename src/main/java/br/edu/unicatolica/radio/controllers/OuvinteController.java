package br.edu.unicatolica.radio.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.unicatolica.radio.daos.OuvinteDao;
import br.edu.unicatolica.radio.models.Ouvinte;

@Controller
@RequestMapping("/ouvinte")
@Transactional
public class OuvinteController {

	@Autowired
	private OuvinteDao ouvinteDao;

	@RequestMapping("/form")
	public ModelAndView form(Ouvinte ouvinte) {
		ModelAndView modelAndView = new ModelAndView("ouvinte/form-add");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Ouvinte ouvinte, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(ouvinte);
		}
		ouvinteDao.save(ouvinte);
		return new ModelAndView("redirect:/ouvinte");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("ouvinte/form-update");
		modelAndView.addObject("ouvinte", ouvinteDao.findById(id));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page) {
		ModelAndView modelAndView = new ModelAndView("ouvinte/list");
		modelAndView.addObject("paginatedList", ouvinteDao.paginated(page, 10));
		return modelAndView;
	}

	// just because get is easier here. Be my guest if you want to change.
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		Ouvinte ouvinte = ouvinteDao.findById(id);
		ouvinteDao.remove(ouvinte);
		return "redirect:/ouvinte";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Integer id, @Valid Ouvinte ouvinte, BindingResult bindingResult) {
		ouvinte.setIdOuvinte(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("ouvinte/form-update");
		}
		ouvinteDao.update(ouvinte);
		return new ModelAndView("redirect:/ouvinte");
	}
}
