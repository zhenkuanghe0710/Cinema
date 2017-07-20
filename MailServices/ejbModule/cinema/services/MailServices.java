package cinema.services;

import cinema.dao.Mail;
import cinema.datas.MailData;
import java.util.List;
import java.util.Properties;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.naming.Context;
import javax.naming.InitialContext;



@WebService
@Stateless
@Remote( { Mail.class })
public class MailServices implements Mail {


    public MailServices() {
    }


    public void createMail(MailData data) throws Exception{
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://140.124.141.230:2809/";
        String ejbObject = "ejb/Mail";
        
        try{
			
                Properties mailProperties = new Properties();
                mailProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
                mailProperties.put(Context.PROVIDER_URL, jndiServer);             
                Context mailContext = new InitialContext( mailProperties );
               
                Mail mailProxy = (Mail) mailContext.lookup( ejbObject );
               
                mailProxy.createMail(data);
       	                
        }
        catch (Exception e){
        	throw e;
        }				       		
    }

	
    public List<MailData> getMailList(MailData data) throws Exception{
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
		String jndiServer = "iiop://140.124.141.230:2809/";
		String ejbObject = "ejb/Mail";
   
		List<MailData> resultList = null;
           
		try{
            	Properties mailProperties = new Properties();
            	mailProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
            	mailProperties.put(Context.PROVIDER_URL, jndiServer);             
				Context mailContext = new InitialContext( mailProperties );
               
				Mail mailProxy = (Mail) mailContext.lookup( ejbObject );
				
				resultList = mailProxy.getMailList(data);

		}
		catch (Exception e) {
            throw e;
		}
   
		return resultList;
}


    public MailData sendMail(MailData data) throws Exception{
    	String jndiFactory = "com.ibm.websphere.naming.WsnInitialContextFactory";                                
        String jndiServer = "iiop://140.124.141.230:2809/";
        String ejbObject = "ejb/Mail";		        
               
        try{

                Properties mailProperties = new Properties();
                mailProperties.put(Context.INITIAL_CONTEXT_FACTORY, jndiFactory);
                mailProperties.put(Context.PROVIDER_URL, jndiServer);             
                Context mailContext = new InitialContext( mailProperties );
               
                Mail mailProxy = (Mail) mailContext.lookup( ejbObject );
               
                data = mailProxy.sendMail(data);

        }
        catch (Exception e) {
					data.setTimestamp(e.getMessage());
					throw e;
        }		
        
        return data;		   		       
    }

}
