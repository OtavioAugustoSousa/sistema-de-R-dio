package br.edu.unicatolica.radio.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.unicatolica.radio.daos.PedidosDao;
import br.edu.unicatolica.radio.daos.UsuarioDao;
import br.edu.unicatolica.radio.models.Usuario;

@Controller
@RequestMapping("/")
@Transactional
public class HomeController {

	@RequestMapping("")
	public String index() {
		return "index";
	}

	@Autowired
	private PedidosDao pedidosDao;

	@Autowired
	private UsuarioDao usuarioDao;
	
	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("pedidos", pedidosDao.all());
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/singup")
	public String singupGet() {
		return "singup";
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/singup")
	public String singup(Usuario usuario) {
		usuarioDao.save(usuario);
		return "login";
	}
}
