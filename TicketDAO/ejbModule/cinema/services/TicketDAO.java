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

import cinema.dao.ticketDAO;
import cinema.datas.TicketData;

@Stateless
@Remote( { ticketDAO.class })
public class TicketDAO implements ticketDAO {

	private SessionFactory hibernateSessionFactory;
	private Session hibernateSession;
	private Criteria hibernateCriteria;

	public TicketDAO() throws Exception {

		String configXML = "ticketSQL.cfg.xml";

		try {
			Configuration hibernateConfig = new Configuration()
					.configure(configXML);
			hibernateSessionFactory = hibernateConfig.buildSessionFactory();
			hibernateSession = hibernateSessionFactory.openSession();
			hibernateCriteria = hibernateSession.createCriteria(TicketData.class);
		} catch (Exception e) {
			throw e;
		}
	}

	public void createMessage(TicketData data) throws Exception {

		try {
			hibernateSession = hibernateSessionFactory.openSession();

			hibernateSession.save(data);
			hibernateSession.close();
		} catch (HibernateException e) {
			throw e;
		}
	}


	public void deleteMessage(TicketData data) {

		TicketData helloData = new TicketData();

		try {
			hibernateSession = hibernateSessionFactory.openSession();
			hibernateCriteria = hibernateSession.createCriteria(TicketData.class);

			int id = 0;
			hibernateCriteria.add(Restrictions.eq("name", data.getName()));
			hibernateCriteria.add(Restrictions.eq("screen", data.getScreen()));
			hibernateCriteria.add(Restrictions.eq("title", data.getTitle()));
			
			List queryList = hibernateCriteria.list();
			Iterator iterator = queryList.iterator();

			while (iterator.hasNext()) {
				helloData = (TicketData) iterator.next();
				id = helloData.getId();
			}

			Transaction tx = hibernateSession.beginTransaction();
			helloData = (TicketData) hibernateSession.get(TicketData.class, id);
			hibernateSession.delete(helloData);
			tx.commit();

			hibernateSession.close();
		} catch (HibernateException e) {
			;
		}

	}

	public TicketData retrieveMessage(TicketData data) throws Exception {

		TicketData helloData = new TicketData();

		try {
			hibernateSession = hibernateSessionFactory.openSession();
			hibernateCriteria = hibernateSession.createCriteria(TicketData.class);
            
            int id = data.getId();
			
			if(id!=0)
				hibernateCriteria
				.add(Restrictions.eq("id", id));
			
			else ; 
			
			List queryList = hibernateCriteria.list();
			Iterator iterator = queryList.iterator();

			while (iterator.hasNext()) {
				helloData = (TicketData) iterator.next();
				
				data.setId(helloData.getId());
				data.setName(helloData.getName());
				data.setTitle(helloData.getTitle());
				data.setScreen(helloData.getScreen());
				data.setQuantity(helloData.getQuantity());
				data.setPrice(helloData.getPrice());
				data.setTotal(helloData.getTotal());
			}

			hibernateSession.close();
		} catch (HibernateException e) {
			throw e;
		}

		return data;
	}

	public List<TicketData> getMessageList(TicketData data) throws Exception {

		List<TicketData> resultList = new ArrayList<TicketData>();

		try {
			hibernateSession = hibernateSessionFactory.openSession();
			hibernateCriteria = hibernateSession.createCriteria(TicketData.class);
			
			String name=data.getName();
			
			if(name!=null)
				hibernateCriteria
				.add(Restrictions.eq("name", name));
			else
				;
			

			List<TicketData> hibernateList = hibernateCriteria.list();
			hibernateSession.close();

			resultList = hibernateList;
		} catch (HibernateException e) {
			throw e;
		}

		return resultList;
	}

	@Override
	public void updateMessage(TicketData data) {
		TicketData helloData = new TicketData();
		try {
			hibernateSession = hibernateSessionFactory.openSession();
			hibernateCriteria = hibernateSession.createCriteria(TicketData.class);
			

            int id = 0;
            
            String name = data.getName();
			
			if(name!=null)
				hibernateCriteria
				.add(Restrictions.eq("name", name));
			
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
				helloData = (TicketData) iterator.next();
				id = helloData.getId();
			}

			Transaction tx = hibernateSession.beginTransaction();
			helloData = (TicketData) hibernateSession.get(TicketData.class, id);
		
			helloData.setQuantity(data.getQuantity());
			helloData.setTotal(data.getTotal());
			
			hibernateSession.update(helloData);
			tx.commit();

			hibernateSession.close();
		} catch (HibernateException e) {
			;
		}
	}
		
}


