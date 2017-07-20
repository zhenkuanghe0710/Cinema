package cinema.actions;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


import cinema.services.MailData;
import cinema.services.MovInfData;
import cinema.services.TicketData;
import cinema.forms.CinemaForm;
import cinema.services.MailServicesPortProxy;
import cinema.services.MovInfServicesPortProxy;
import cinema.services.TicketServicesPortProxy;

public class DeleteTicketAction extends Action{
	
	private ActionErrors errors = null;
	
	public ActionForward execute (	ActionMapping mapping,
														 ActionForm form,
														 HttpServletRequest request, 
														 HttpServletResponse response ) throws Exception {

				CinemaForm cForm = (CinemaForm) form;
				ActionForward forward = new ActionForward();
				errors = new ActionErrors();
				TicketServicesPortProxy ticProxy = new TicketServicesPortProxy();
				MovInfServicesPortProxy miProxy = new MovInfServicesPortProxy();
				MailServicesPortProxy mlProxy = new MailServicesPortProxy();
				
				//get Input
				int id = cForm.getId();
			  
				
				TicketData cData = new TicketData();
				cData.setId(id);
				
				//get old ticket
				try{
					cData = ticProxy.retrieveMessage(cData);	
	                }
	                catch (Exception e){
						errors.add(e.getMessage(), new ActionMessage("Error : " + e.getMessage(),false));
						e.printStackTrace();
					}
				
				cData.setId(id);
				

				int oquantity = cData.getQuantity();
				
				String name = cData.getName();
				String title = cData.getTitle();
				String screen = cData.getScreen();
				int price = cData.getPrice();
				int quantity = cData.getQuantity();
				int total = cData.getTotal();
				
                MovInfData cmData = new MovInfData();
				
                cmData.setTitle(cData.getTitle());
                cmData.setScreen(cData.getScreen());
				
				//get movinf
                try{
                	cmData = miProxy.retrieveMIMessage(cmData);          
                	}
                    catch (Exception e){
    					errors.add(e.getMessage(), new ActionMessage("Error : " + e.getMessage(),false));
    					e.printStackTrace();
    				}
                
				
				//update seats
				int cseats = cmData.getSeats() + oquantity;
				
				cmData.setSeats(cseats);
				
				//update movinf
				try{
					miProxy.updateMIMessage(cmData);	
	                }
	                catch (Exception e){
						errors.add(e.getMessage(), new ActionMessage("Error : " + e.getMessage(),false));
						e.printStackTrace();
					}
				
				
				//delete
	                try{
	                	ticProxy.deleteMessage(cData);	          
	                	}
	                    catch (Exception e){
	    					errors.add(e.getMessage(), new ActionMessage("Error : " + e.getMessage(),false));
	    					e.printStackTrace();
	    				}
				
				
				String result = "Your Order : Name ¡¾"
	                 + name + "¡¿    Title ¡¶" 
	                 + title + "¡·    Screen ¡¾" 
	                 + screen + "¡¿    Price ¡¾"
	                 + price + "¡¿    QUANTITY ¡¾"
	                 + quantity + "¡¿     Total price¡¾"
	                 + total +"¡¿ Has been DELETE !";
				
				
				//Mail
				String sender = "90012005@ntut.edu.tw";
				String receiver = cForm.getReceiver();

				String subject = "V.S Cinema DELETE Confirmation letter";
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
		        
			

				if(errors.isEmpty()){
					cForm.setTimestamp(maildata.getTimestamp());
					cForm.setResult(result);
		            forward = mapping.findForward("DTKDone");
				}
				else{
		            super.saveErrors(request, errors);
		            forward = mapping.findForward("ActionError");
				}							
				
				return (forward);
					
	}
}