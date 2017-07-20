package cinema.services;

import java.util.List;
import java.util.Properties;

import cinema.datas.MovInfData;
import cinema.dao.movinfDAO;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.naming.Context;
import javax.naming.InitialContext;





@WebService
@Stateless
@Remote( { movinfDAO.class })
public class MovInfServices implements movinfDAO {


    public MovInfServices() {
        
    }

	
    public void deleteMIMessage(MovInfData data)  {
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://140.124.141.230:2809/";
        String ejbObject = "ejb/MovInfDAO";
        
        try{
			
                Properties daoProperties = new Properties();
                daoProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
                daoProperties.put(Context.PROVIDER_URL, jndiServer);             
                Context daoContext = new InitialContext( daoProperties );
               
                movinfDAO daoProxy = (movinfDAO) daoContext.lookup( ejbObject );
               
                daoProxy.deleteMIMessage(data);
        	                
        }
        catch (Exception e) {
               ;
        }				       		
}
 
    public void createMIMessage(MovInfData data) throws Exception{
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://140.124.141.230:2809/";
        String ejbObject = "ejb/MovInfDAO";
        
        try{
			
                Properties daoProperties = new Properties();
                daoProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
                daoProperties.put(Context.PROVIDER_URL, jndiServer);             
                Context daoContext = new InitialContext( daoProperties );
               
                movinfDAO daoProxy = (movinfDAO) daoContext.lookup( ejbObject );
               
                daoProxy.createMIMessage(data);
        	                
        }
        catch (Exception e) {
                throw e;
        }				  
    }


    
    public List<MovInfData> getMIMessageList(MovInfData data) throws Exception{
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://140.124.141.230:2809/";
        String ejbObject = "ejb/MovInfDAO";
       
        List<MovInfData> movinfList = null;
               
        try{

                	Properties daoProperties = new Properties();
					daoProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
					daoProperties.put(Context.PROVIDER_URL, jndiServer);             
					Context daoContext = new InitialContext( daoProperties );
	               
					movinfDAO daoProxy = (movinfDAO) daoContext.lookup( ejbObject );
    
					movinfList = daoProxy.getMIMessageList(data);
               
        }
        catch (Exception e) {
                throw e;
        }
       
        return movinfList;
			
    }

	
    public void updateMIMessage(MovInfData data){
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://140.124.141.230:2809/";
        String ejbObject = "ejb/MovInfDAO";
        
        try{
			
            Properties daoProperties = new Properties();
            daoProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
            daoProperties.put(Context.PROVIDER_URL, jndiServer);             
            Context daoContext = new InitialContext( daoProperties );
           
            movinfDAO daoProxy = (movinfDAO) daoContext.lookup( ejbObject );
           
            daoProxy.updateMIMessage(data);
 	                
    }
    catch (Exception e) {
           ;
    }		
	   
}


    public MovInfData retrieveMIMessage(MovInfData data) throws Exception{
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://140.124.141.230:2809/";
        String ejbObject = "ejb/MovInfDAO";
       
       MovInfData ticdata = new MovInfData();
               
        try{

                	Properties daoProperties = new Properties();
					daoProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
					daoProperties.put(Context.PROVIDER_URL, jndiServer);             
					Context daoContext = new InitialContext( daoProperties );
	               
					movinfDAO daoProxy = (movinfDAO) daoContext.lookup( ejbObject );
    
					ticdata = daoProxy.retrieveMIMessage(data);
               
        }
        catch (Exception e) {
                throw e;
        }
       
        return ticdata;
    }

}
