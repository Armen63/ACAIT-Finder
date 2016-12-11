package am.aca.springsecurityapp.controller;

import am.aca.springsecurityapp.model.Startup;
import am.aca.springsecurityapp.service.StartupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StartupController {

	private StartupService startupService;

	@Autowired(required=true)
	@Qualifier(value="startupService")
	public void setStartupService(StartupService startupService) {
		this.startupService = startupService;
	}


	/*public void setPersonService(StartupService ps){
		this.startupService = ps;
	}
	*/

	@RequestMapping(value = "/startup", method = RequestMethod.GET)
	public String defaultPath()
	{
		return "redirect:/startups";
	}

	@RequestMapping(value = "/startups", method = RequestMethod.GET)
	public String listStartups(Model model) {
		model.addAttribute("startup", new Startup());
		model.addAttribute("listStartups", this.startupService.listStartups());
		return "startup";
	}

	//For add and update person both
	@RequestMapping(value= "/startup/add", method = RequestMethod.POST)
	public String addStartup(@ModelAttribute("startup") Startup p){

		if(p.getId() == 0){
			//new person, add it
			this.startupService.addStartup(p);
		}else{
			//existing person, call update
			this.startupService.updateStartup(p);
		}

		return "redirect:/startups";

	}

	@RequestMapping("/remove/{id}")
	public String removeStartup(@PathVariable("id") int id){

		this.startupService.removeStartup(id);
		return "redirect:/startups";
	}

	@RequestMapping("/edit/{id}")
	public String editStartup(@PathVariable("id") int id, Model model){
		model.addAttribute("startup", this.startupService.getStartupById(id));
		model.addAttribute("listStartups", this.startupService.listStartups());
		return "startup";
	}
	/*@RequestMapping("/viewa_addresses/{id}")
	public String viewAddresses(@PathVariable("id")int id, Model model){
		Address a = new Address();
		a.setPerson_id(id);
		//a.setId(0);
		//a.setId(id);
		//a.setAddress("s");
		model.addAttribute("address",a);
		model.addAttribute("listAddress",this.personService.getPersonWithAddressById(id).getAddress());
		model.addAttribute("person_id",id);
		return "addresses";
	}
	*/
}
