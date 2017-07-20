package cinema.actions;


import cinema.services.MailData;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


import cinema.forms.CinemaForm;
import cinema.services.MailServicesPortProxy;


public class SendMailAction extends Action{
	
	private ActionErrors errors = null;
	
	public ActionForward execute (	ActionMapping mapping,
														 ActionForm form,
														 HttpServletRequest request, 
														 HttpServletResponse response ) throws Exception {

		        CinemaForm cForm = (CinemaForm) form;				
		        ActionForward forward = new ActionForward();
				errors = new ActionErrors();
				MailServicesPortProxy mlProxy = new MailServicesPortProxy();

				String name = cForm.getName();
				String result = cForm.getResult();
				
				String sender = "90012005@ntut.edu.tw";
				String receiver = "victoradward@gmail.com";

				String subject = "Client FEED BACK Message From ¡¾"+ name +"¡¿";
				String content = result;
				
				MailData maildata = new MailData();
				maildata.setSender(sender);
				maildata.setReceiver(receiver);
				maildata.setSubject(subject);
				maildata.setContent(content);
				
				try{
					maildata = mlProxy.sendMail(maildata);	
	                }
	                catch (Exception e){
						errors.add(e.getMessage(), new ActionMessage("Error : " + e.getMessage(),false));
						e.printStackTrace();
					}
				
	                try{
	                	mlProxy.createMail(maildata);	
	                    }
	                    catch (Exception e){
	    					errors.add(e.getMessage(), new ActionMessage("Error : " + e.getMessage(),false));
	    					e.printStackTrace();
	    				}
		        
		        String result2 = "Your Feedback Massage is Sent ! Thank You !";

				if(errors.isEmpty()){
					cForm.setTimestamp(maildata.getTimestamp());
					cForm.setResult(result2);
		            forward = mapping.findForward("SMDone");
				}
				else{
		            super.saveErrors(request, errors);
		            forward = mapping.findForward("ActionError");
				}							
				
				return (forward);
	}
		   
	   
 
}
