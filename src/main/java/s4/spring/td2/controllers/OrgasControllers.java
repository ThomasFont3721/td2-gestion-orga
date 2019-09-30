package s4.spring.td2.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import s4.spring.td2.entities.Cgroupe;
import s4.spring.td2.entities.Corganization;
import s4.spring.td2.entities.Cuser;
import s4.spring.td2.repositories.GroupRepositorie;
import s4.spring.td2.repositories.OrgasRepositorie;
import s4.spring.td2.repositories.UserRepositorie;

@Controller
@RequestMapping("/orgas/")
public class OrgasControllers {
	@Autowired
	private OrgasRepositorie orgarepo;
	@Autowired
	private GroupRepositorie grouprepo;
	@Autowired
	private UserRepositorie userrepo;
	
	@GetMapping("index")
	public String index(ModelMap map) {
		List<Corganization> orga =orgarepo.findAll();
		map.put("orga", orga);
		return "index";
	}
	
	@GetMapping("new")
	public String newOrga() {
		return "newOrga";
	}
	
	@PostMapping("addNew")
	public RedirectView addNew(@RequestParam String name, @RequestParam String domain,@RequestParam String alias) {
	    Corganization neworga = new Corganization();
	    neworga.setName(name);
	    neworga.setDomaine(domain);
	    neworga.setAlias(alias); 
	    orgarepo.save(neworga);
	    return new RedirectView("index");
	}
	
	@GetMapping("edit/{id}")
	public String editOrga(@PathVariable String id, ModelMap map, HttpServletResponse reponse) throws IOException {
		Optional<Corganization> org =orgarepo.findById(Long.parseLong(id));
		if (org.isPresent()) {
			Corganization orga=org.get();
			map.put("orga",orga);
			return "editOrga";
		}
		reponse.sendRedirect("/orgas/index");
		return "index";
	}
	
	@PostMapping("editOrga/{id}")
	public RedirectView editorga(@PathVariable String id, @RequestParam String name, @RequestParam String domain,@RequestParam String alias) {
	    Corganization neworga = new Corganization();
	    neworga.setName(name);
	    neworga.setDomaine(domain);
	    neworga.setAlias(alias);
	    neworga.setId(Long.parseLong(id));
	    orgarepo.save(neworga);
	    return new RedirectView("/orgas/index");
	}
	
	@GetMapping("delete/{id}")
	public RedirectView deleteOrga(@PathVariable String id) {
		orgarepo.deleteById(Long.parseLong(id));
	    return new RedirectView("/orgas/index");
	}
	
	@GetMapping("delete/conf/{id}")
	public String deleteConfOrga(@PathVariable String id, ModelMap map) {
		Corganization org =orgarepo.getOne(Long.parseLong(id));
		map.put("organization", org);
	    return "confdelete";
	}
	
	@GetMapping("displayOrga/{id}")
	public String displayOrga(@PathVariable String id, ModelMap map, HttpServletResponse reponse) throws IOException {
		Optional<Corganization> org =orgarepo.findById(Long.parseLong(id));
		if (org.isPresent()) {
			Corganization orga=org.get();
			map.put("orga",orga);
			return "displayOrga";
		}
		reponse.sendRedirect("/orgas/index");
		return "index";
	}
	
	@GetMapping("detail/{id}")
	public String detailOrga(@PathVariable String id, ModelMap map) {
		Corganization org =orgarepo.getOne(Long.parseLong(id));
		map.put("organization", org);
		map.put("nbG", org.getGroupes().size());
		map.put("nbU", org.getUsers().size());
	    return "detailOrga";
	}
	
	@GetMapping("search/{text}/{yn}")
	public String searchOrga(@PathVariable String text, @PathVariable int yn, ModelMap map) {
		List<Corganization> orga =orgarepo.findAll();
		if (yn == 1) {
			orga =orgarepo.findByText(text);
		}
		map.put("research", text);
		map.put("organi", orga);
	    return "search";
	}	
}
