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
import br.edu.unicatolica.radio.daos.PedidosDao;
import br.edu.unicatolica.radio.models.PedidoMusical;

@Controller
@RequestMapping("/pedidos")
@Transactional
public class PedidosController {

	@Autowired
	private PedidosDao pedidosDao;

	 @RequestMapping("/form")
	   public ModelAndView form(PedidoMusical pedidoMusical)
	   {
	      ModelAndView modelAndView = new ModelAndView("pedidos/form-add");
	      return modelAndView;

	   }

	   @RequestMapping(method = RequestMethod.POST)
	   public ModelAndView save(@Valid PedidoMusical PedidoMusical, BindingResult bindingResult)
	   {
	      if (bindingResult.hasErrors())
	      {
	         return form(PedidoMusical);
	      }
	      pedidosDao.save(PedidoMusical);
	      return new ModelAndView("redirect:/pedidos");
	   }

	   @RequestMapping(method = RequestMethod.GET, value = "/{id}")
	   public ModelAndView load(@PathVariable("id") Integer id)
	   {
	      ModelAndView modelAndView = new ModelAndView("pedidos/form-update");
	      modelAndView.addObject("pedidoMusical", pedidosDao.findById(id));
	      return modelAndView;
	   }

	   @RequestMapping(method = RequestMethod.GET)
	   public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page)
	   {
	      ModelAndView modelAndView = new ModelAndView("pedidos/list");
	      modelAndView.addObject("paginatedList", pedidosDao.paginated(page, 10));
	      return modelAndView;
	   }

	   //just because get is easier here. Be my guest if you want to change.
	   @RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	   public String remove(@PathVariable("id") Integer id)
	   {
	      PedidoMusical PedidoMusical = pedidosDao.findById(id);
	      pedidosDao.remove(PedidoMusical);
	      return "redirect:/pedidos";
	   }

	   @RequestMapping(method = RequestMethod.POST, value = "/{id}")
	   public ModelAndView update(@PathVariable("id") Integer id, @Valid PedidoMusical PedidoMusical, BindingResult bindingResult)
	   {
	      PedidoMusical.setIdPedido(id);
	      if (bindingResult.hasErrors())
	      {
	         return new ModelAndView("pedidos/form-update");
	      }
	      pedidosDao.update(PedidoMusical);
	      return new ModelAndView("redirect:/pedidos");
	   }
}
