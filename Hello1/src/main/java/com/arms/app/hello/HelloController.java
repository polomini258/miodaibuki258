package com.arms.app.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.arms.domain.entity.Hello;
import com.arms.domain.repository.HelloRepository;


@Controller
@RequestMapping("/") 
public class HelloController {
	@Autowired HelloRepository helloRepository;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView modelAndView) { 
		modelAndView.addObject("list", helloRepository.findAll()); 
		modelAndView.setViewName("hello/list"); 
		return modelAndView; 
	}
	@RequestMapping(value = "create",params = "form", method = RequestMethod.GET) 
	public String create() {
		return "hello/create";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST) 
	public String doneCreate(@RequestParam("name") String name) { 
		Hello hello = new Hello(); hello.setName(name); 
		helloRepository.save(hello); 
		return "redirect:/list"; 
	}
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView modelAndView) { 
		modelAndView.addObject("list", helloRepository.findAll()); 
		modelAndView.setViewName("hello/list"); 
		return modelAndView; 
	}
	

}
