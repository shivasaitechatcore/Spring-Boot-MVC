package com.hello.firstspringmvc;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hello.firstspringmvc.mobel.Alien;


@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "index";
	}	
	@RequestMapping("add")
	public String add( @RequestParam("num1")int i,@RequestParam("num2")int j,@RequestParam("num3")int k,Model mv) {
		
//		int i = Integer.parseInt(req.getParameter("num1"));
//		int j = Integer.parseInt(req.getParameter("num2"));
//		int k = Integer.parseInt(req.getParameter("num3"));
//		
//		ModelAndView mv = new ModelAndView();
//				mv.setViewName("result");
		int num4 = i+j+k;
		mv.addAttribute("num4",num4);
//		
//		HttpSession httpSession = req.getSession();
//		httpSession.setAttribute("num4", num4);
		return "result"; 
	}
//	@RequestMapping("addAlien")
//	public String addAlien(@RequestParam("aid")int id,@RequestParam("aname")String name,Model m) {
//		Alien a =new Alien();
//		a.setAid(id);
//		a.setAname(name);
//		m.addAttribute("alien",a);
//		return "result";
//	}
	
	
//	MobelAttribute
	@RequestMapping("addAlien")
	public String addAlien(@ModelAttribute("ai") Alien alien) {
		
		return "result";
	}
	
	@GetMapping("getAliens")
	public String getAlien(Model m) {
		List<Alien> aliens = Arrays.asList(new Alien(101,"nzvan"),new Alien(121,"sai"));
		m.addAttribute("aliens", aliens);
		return "showAliens";
	}
}
