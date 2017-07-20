package cinema.services;

import cinema.datas.TicketData;
import cinema.dao.ticketDAO;
import java.util.List;
import java.util.Properties;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.naming.Context;
import javax.naming.InitialContext;

@WebService
@Stateless
@Remote( { ticketDAO.class })
public class TicketServices implements ticketDAO {

    
    public TicketServices() {
        
    }
	
    public List<TicketData> getMessageList(TicketData data) throws Exception{
       
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://140.124.141.230:2809/";
        String ejbObject = "ejb/TicketDAO";
       
        List<TicketData> ticketList = null;
               
        try{

                	Properties daoProperties = new Properties();
					daoProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
					daoProperties.put(Context.PROVIDER_URL, jndiServer);             
					Context daoContext = new InitialContext( daoProperties );
	               
					ticketDAO daoProxy = (ticketDAO) daoContext.lookup( ejbObject );
    
					ticketList = daoProxy.getMessageList(data);
               
        }
        catch (Exception e) {
                throw e;
        }
       
        return ticketList;
    }


    public TicketData retrieveMessage(TicketData data) throws Exception{
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://140.124.141.230:2809/";
        String ejbObject = "ejb/TicketDAO";
       
       TicketData ticdata = new TicketData();
               
        try{

                	Properties daoProperties = new Properties();
					daoProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
					daoProperties.put(Context.PROVIDER_URL, jndiServer);             
					Context daoContext = new InitialContext( daoProperties );
	               
					ticketDAO daoProxy = (ticketDAO) daoContext.lookup( ejbObject );
    
					ticdata = daoProxy.retrieveMessage(data);
               
        }
        catch (Exception e) {
                throw e;
        }
       
        return ticdata;
    }

	
    public void updateMessage(TicketData data) throws Exception{
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://140.124.141.230:2809/";
        String ejbObject = "ejb/TicketDAO";
        
        try{
			
           Properties daoProperties = new Properties();
           daoProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
           daoProperties.put(Context.PROVIDER_URL, jndiServer);             
           Context daoContext = new InitialContext( daoProperties );
          
           ticketDAO daoProxy = (ticketDAO) daoContext.lookup( ejbObject );
          
           daoProxy.updateMessage(data);
	                
   }
   catch (Exception e) {
           throw e;
   }		
    }

	
    public void deleteMessage(TicketData data) throws Exception{
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://140.124.141.230:2809/";
        String ejbObject = "ejb/TicketDAO";
        
        try{
    		
                Properties daoProperties = new Properties();
                daoProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
                daoProperties.put(Context.PROVIDER_URL, jndiServer);             
                Context daoContext = new InitialContext( daoProperties );
               
                ticketDAO daoProxy = (ticketDAO) daoContext.lookup( ejbObject );
               
                daoProxy.deleteMessage(data);
    	                
        }
        catch (Exception e) {
               throw e;
        }
    }


    public void createMessage(TicketData data) throws Exception{
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://140.124.141.230:2809/";
        String ejbObject = "ejb/TicketDAO";
        
        try{
			
                Properties daoProperties = new Properties();
                daoProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
                daoProperties.put(Context.PROVIDER_URL, jndiServer);             
                Context daoContext = new InitialContext( daoProperties );
               
                ticketDAO daoProxy = (ticketDAO) daoContext.lookup( ejbObject );
               
                daoProxy.createMessage(data);
     	                
        }
        catch (Exception e) {
                throw e;
        }
    }

}
