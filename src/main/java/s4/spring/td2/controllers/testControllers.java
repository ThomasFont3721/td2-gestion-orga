package s4.spring.td2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import s4.spring.td2.entities.Corganization;
import s4.spring.td2.entities.Cuser;
import s4.spring.td2.repositories.OrgasRepositorie;

@Controller
@RequestMapping("/test/")
public class testControllers {
	@Autowired
	private OrgasRepositorie orgarepo;
	
	@GetMapping("hello")
	public String hello() {
		return "hello";
	}
	@GetMapping("user/{name}")
	public @ResponseBody String user(@PathVariable String name) {
		Cuser user =new Cuser(name, "Dalton");
		Corganization orga =new Corganization();
		orga.setName("Daltons");
		user.setOrganization(orga);
		orga.getUsers().add(user);
		orgarepo.save(orga);
		return user.getFirstname()+" "+user.getLastname()+" "+user.getOrganization().getName();
	}
}
