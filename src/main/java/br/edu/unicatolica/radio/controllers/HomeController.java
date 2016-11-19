package br.edu.unicatolica.radio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.unicatolica.radio.daos.PedidosDao;

@Controller
@RequestMapping("/")
public class HomeController
{

   @RequestMapping("")
   public String index()
   {
      return "index";
   }
   
   @Autowired
   private PedidosDao pedidosDao;
   
   @RequestMapping("/home")
   public String home()
   {
	   ModelAndView modelAndView = new ModelAndView("home");
	   modelAndView.addObject("pedidos", pedidosDao.paginated(0, 100));
      return "home";
   }
}
