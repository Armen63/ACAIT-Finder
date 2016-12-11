package am.aca.springsecurityapp.service;


import am.aca.springsecurityapp.model.Startup;

import java.util.List;

public interface StartupService {

	public void addStartup(Startup p);
	public void updateStartup(Startup p);
	public List<Startup> listStartups();
	public Startup getStartupById(int id);
	public void removeStartup(int id);
	//public Startup getPersonWithAddressById(int id);
	
}
