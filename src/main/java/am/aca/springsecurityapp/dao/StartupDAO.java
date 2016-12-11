package am.aca.springsecurityapp.dao;


import am.aca.springsecurityapp.model.Startup;

import java.util.List;

public interface StartupDAO {

	public void addStartup(Startup p);
	public void updateStartup(Startup p);
	public List<Startup> listStartups();
	public Startup getStartupById(int id);
	public void removeStartup(int id);
}
