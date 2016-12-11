package am.aca.springsecurityapp.dao;

import am.aca.springsecurityapp.model.Startup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StartupDAOImpl implements StartupDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(StartupDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addStartup(Startup p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Startup saved successfully, Startup Details="+p);
	}

	@Override
	public void updateStartup(Startup p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Startup updated successfully, Startup Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Startup> listStartups() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Startup> startupList = session.createQuery("from Startup").list();
		for(Startup p : startupList){
			logger.info("Startup List::"+p);
		}
		return startupList;
	}

	@Override
	public Startup getStartupById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Startup p = (Startup) session.load(Startup.class, new Integer(id));
		logger.info("Startup loaded successfully, Startup details="+p);
		return p;
	}

	@Override
	public void removeStartup(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Startup p = (Startup) session.load(Startup.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Startup deleted successfully, startup details="+p);
	}

}
