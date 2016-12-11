package am.aca.springsecurityapp.service;
import am.aca.springsecurityapp.dao.StartupDAO;
import am.aca.springsecurityapp.model.Startup;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StartupServiceImpl implements StartupService {
	
	private StartupDAO startupDAO;

	public void setStartupDAO(StartupDAO startupDAO) {
		this.startupDAO = startupDAO;
	}

	@Override
	@Transactional
	public void addStartup(Startup p) {
		this.startupDAO.addStartup(p);
	}

	@Override
	@Transactional
	public void updateStartup(Startup p) {
		this.startupDAO.updateStartup(p);
	}

	@Override
	@Transactional
	public List<Startup> listStartups() {
		return this.startupDAO.listStartups();
	}

	@Override
	@Transactional
	public Startup getStartupById(int id) {
		return this.startupDAO.getStartupById(id);
	}

	@Override
	@Transactional
	public void removeStartup(int id) {
		this.startupDAO.removeStartup(id);
	}

	/*@Override
	@Transactional
	public Startup getPersonWithAddressById(int id) {
		Startup person  = personDAO.getPersonById(id);
		person.getAddress().size();
		return person;
	}
*/
}
