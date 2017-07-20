package cinema.services;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.Transport;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import cinema.dao.Mail;
import cinema.datas.MailData;

@Stateless
@Remote( { Mail.class } )
public class MailServices implements Mail {

			private SessionFactory hibernateSessionFactory;
			private org.hibernate.Session hibernateSession;
			private Criteria hibernateCriteria;
			
			public MailServices() throws Exception {
						
						String configXML = "mailSQL.cfg.xml";
		    	
						try {
									Configuration hibernateConfig = new Configuration().configure(configXML);
									hibernateSessionFactory = hibernateConfig.buildSessionFactory();
						} catch (Exception e) {
									throw e;
						}
			}
		
		
		    public MailData sendMail(MailData data) throws Exception {
		    	
		    	Properties mailProperties = new Properties();
		    	mailProperties.put("mail.smtp.host", "nsmtp.ntut.edu.tw");
		    	mailProperties.put("mail.transport.protocol", "smtp");
		    	mailProperties.put("mail.smtp.auth", "false");
				
		    	try{
		    		Session mailSession = Session.getDefaultInstance(mailProperties);
		    		mailSession.setDebug(false);
		    		
		    		Message message = new MimeMessage(mailSession);
		    		
		    		message.setFrom(new InternetAddress(data.getSender()));
		    		
		    		message.setRecipients(Message.RecipientType.TO, 
		    				InternetAddress.parse(data.getReceiver(), false));
		    		
		    		message.setSubject(data.getSubject());
		    		
		    		message.setText(data.getContent());
		    		
		    		Date date = new Date();
		    		message.setSentDate(date);
		    		data.setTimestamp(date.toString());
		    		
		    		Transport.send(message);
		    		
		    		return data;
		    	}
		    	catch (HibernateException e){
		    		throw e;
		    	}
			    	
			    	
						
		    }
			
			
		    public void createMail(MailData data) throws Exception {
		   
						try {
									hibernateSession = hibernateSessionFactory.openSession();
		
									hibernateSession.save(data);
									hibernateSession.close();
						} 
						catch (HibernateException e) {
									throw e;
						}
		    }
		    
		    
		    public List<MailData> getMailList(MailData data) {
		      
		    			List<MailData> resultList = new ArrayList<MailData>();
		    	
		    			try {
		    				hibernateSession = hibernateSessionFactory.openSession();
		    				hibernateCriteria = hibernateSession.createCriteria(MailData.class);
		    				
		    				String receiver = data.getReceiver();
		    				
		    				if (receiver != null){
		    				hibernateCriteria.add(Restrictions.eq("receiver", receiver));
		    				}
		    				else ;
		    				
		    				List<MailData> hibernateList = hibernateCriteria.list();
		    				
		    				hibernateSession.close();
		   
                            resultList = hibernateList;
		    				
						} 
		    			catch (HibernateException e) {
									throw e;
						}
		
						return resultList;
		    }
}
