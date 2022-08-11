package com.company.Alien.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.company.Alien.dao.AlienRepo;
import com.company.Alien.model.Alien;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String welcome()
	{
		return "welcome.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String AddAlien(Alien alien)
	{
		repo.save(alien);
		
		return "welcome.jsp";
	}
	
	/*@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam("aid") int id)
	{
		ModelAndView mv = new ModelAndView("ShowAlien.jsp");
		
		Alien alien = repo.findById(id).orElse(new Alien());
		
		System.out.println(repo.findByTech("Java"));
		
		
		mv.addObject(alien);
		return mv;
		
	}*/
	
	@GetMapping("/alien")
	public List<Alien> getAliens()
	{
		return repo.findAll();
	}
	
	
	@GetMapping("/alien/{aid}")
	public Optional<Alien> getAlienById(@PathVariable("aid") int aid)
	{
		
		
		return repo.findById(aid);
		
	}
	
	@PostMapping("/alien")
	public Alien addAlien(@RequestBody Alien alien )
	{
		Alien alien1 =repo.save(alien);
		return alien1;
	}
	
	@DeleteMapping("/alien/{aid}")
	public String deleteAlienById(@PathVariable("aid") int aid)
	{
		Alien alien= repo.getOne(aid);
		
		repo.delete(alien);
		
		return "Deleted";
		
	}
	
	@PutMapping("/alien")
	public Alien saveOrUpdate(@RequestBody Alien alien )
	{
		repo.save(alien);
		return alien;
	}
	
	
	

}
