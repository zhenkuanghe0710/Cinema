package cinema.services;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import cinema.dao.movinfDAO;
import cinema.datas.MovInfData;

@Stateless
@Remote( { movinfDAO.class })
public class MovInfDAO implements movinfDAO {

	private SessionFactory hibernateSessionFactory;
	private Session hibernateSession;
	private Criteria hibernateCriteria;

	public MovInfDAO() throws Exception {

		String configXML = "movinfSQL.cfg.xml";

		try {
			Configuration hibernateConfig = new Configuration()
					.configure(configXML);
			hibernateSessionFactory = hibernateConfig.buildSessionFactory();
			hibernateSession = hibernateSessionFactory.openSession();
			hibernateCriteria = hibernateSession
					.createCriteria(MovInfData.class);
		} catch (Exception e) {
			throw e;
		}
	}

	public void createMIMessage(MovInfData data) throws Exception {

		try {
			hibernateSession = hibernateSessionFactory.openSession();

			hibernateSession.save(data);
			hibernateSession.close();
		} catch (HibernateException e) {
			throw e;
		}
	}


	public void deleteMIMessage(MovInfData data) {

		MovInfData helloData = new MovInfData();

		try {
			hibernateSession = hibernateSessionFactory.openSession();
			hibernateCriteria = hibernateSession.createCriteria(MovInfData.class);
			

			int id = 0;
			
			String title = data.getTitle();
			
			if(title!=null)
				hibernateCriteria
				.add(Restrictions.eq("title", title));
			
			else ;
			
			String screen = data.getScreen();
			
			if(screen!=null)
				hibernateCriteria
				.add(Restrictions.eq("screen", screen));
			
			else ;
			
			List queryList = hibernateCriteria.list();
			Iterator iterator = queryList.iterator();

			while (iterator.hasNext()) {
				helloData = (MovInfData) iterator.next();
				id = helloData.getId();
			}

			Transaction tx = hibernateSession.beginTransaction();
			helloData = (MovInfData) hibernateSession.get(MovInfData.class, id);
			hibernateSession.delete(helloData);
			tx.commit();
			
			hibernateSession.close();
		} catch (HibernateException e) {
			 ;
		}

	}

	public List<MovInfData> getMIMessageList(MovInfData data) throws Exception {

		List<MovInfData> resultList = new ArrayList<MovInfData>();

		try {
			hibernateSession = hibernateSessionFactory.openSession();
			hibernateCriteria = hibernateSession.createCriteria(MovInfData.class);
			

         
			
			String title = data.getTitle();
			
			if(title!=null)
				hibernateCriteria
				.add(Restrictions.eq("title", title));
			
			else ;
			
			String screen = data.getScreen();
			
			if(screen!=null)
				hibernateCriteria
				.add(Restrictions.eq("screen", screen));
			
			else ;
			

			List<MovInfData> hibernateList = hibernateCriteria.list();
			hibernateSession.close();

			resultList = hibernateList;
		} catch (HibernateException e) {
			throw e;
		}

		return resultList;
	}

	@Override
	public MovInfData retrieveMIMessage(MovInfData data) throws Exception {
		
		MovInfData helloData = new MovInfData();

		try {
			hibernateSession = hibernateSessionFactory.openSession();
			hibernateCriteria = hibernateSession.createCriteria(MovInfData.class);
			

            int id = data.getId();
			
			if(id!=0)
				hibernateCriteria
				.add(Restrictions.eq("id", id));
			
			else ;
			
			String title = data.getTitle();
			
			if(title!=null)
				hibernateCriteria
				.add(Restrictions.eq("title", title));
			
			else ;
			
			String screen = data.getScreen();
			
			if(screen!=null)
				hibernateCriteria
				.add(Restrictions.eq("screen", screen));
			
			else ;
			
			List queryList = hibernateCriteria.list();
			Iterator iterator = queryList.iterator();

			while (iterator.hasNext()) {
				helloData = (MovInfData) iterator.next();
				
				data.setId(helloData.getId());
				data.setTitle(helloData.getTitle());
				data.setScreen(helloData.getScreen());
				data.setPrice(helloData.getPrice());
				data.setSeats(helloData.getSeats());
			}

			hibernateSession.close();
		} catch (HibernateException e) {
			throw e;
		}

		return data;
	}

	@Override
	public void updateMIMessage(MovInfData data) {

		MovInfData helloData = new MovInfData();
		try {
			hibernateSession = hibernateSessionFactory.openSession();
			hibernateCriteria = hibernateSession.createCriteria(MovInfData.class);
			

            int id = 0;
			
			String title = data.getTitle();
			
			if(title!=null)
				hibernateCriteria
				.add(Restrictions.eq("title", title));
			
			else ;
			
			String screen = data.getScreen();
			
			if(screen!=null)
				hibernateCriteria
				.add(Restrictions.eq("screen", screen));
			
			else ;
			
			List queryList = hibernateCriteria.list();
			Iterator iterator = queryList.iterator();

			while (iterator.hasNext()) {
				helloData = (MovInfData) iterator.next();
				id = helloData.getId();
			}

			Transaction tx = hibernateSession.beginTransaction();
			helloData = (MovInfData) hibernateSession.get(MovInfData.class, id);
			helloData.setPrice(data.getPrice());
			helloData.setSeats(data.getSeats());
			hibernateSession.update(helloData);
			tx.commit();

			hibernateSession.close();
		} catch (HibernateException e) {
			;
		}
	}

	
}
