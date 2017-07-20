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


import cinema.services.MovInfData;
import cinema.services.TicketData;
import cinema.forms.CinemaForm;
import cinema.services.MailServicesPortProxy;
import cinema.services.MovInfServicesPortProxy;
import cinema.services.TicketServicesPortProxy;


public class ChangeTicketAction extends Action{
	
	private ActionErrors errors = null;
	
	public ActionForward execute (	ActionMapping mapping,
														 ActionForm form,
														 HttpServletRequest request, 
														 HttpServletResponse response ) throws Exception {

		        CinemaForm cForm = (CinemaForm) form;				
		        ActionForward forward = new ActionForward();
				errors = new ActionErrors();
				MovInfServicesPortProxy miProxy = new MovInfServicesPortProxy();
				TicketServicesPortProxy ticProxy = new TicketServicesPortProxy();
				MailServicesPortProxy mlProxy = new MailServicesPortProxy();
				
				//get Input
				int id = cForm.getId();
				int cquantity = cForm.getCquantity();
			
					
					TicketData qtData = new TicketData();
					qtData.setId(id);
					
					//Get old ticket
					try{
						qtData = ticProxy.retrieveMessage(qtData);
					}
					catch (Exception e){
						errors.add(e.getMessage(), new ActionMessage("Error : " + e.getMessage(),false));
						e.printStackTrace();
					}
					
					
					//update number
					int ntotal = qtData.getPrice() * cquantity;
					int oquantity = qtData.getQuantity();
					
					qtData.setQuantity(cquantity);
					qtData.setTotal(ntotal);
                    
					//update ticket
					try{
						ticProxy.updateMessage(qtData);
					}
					catch (Exception e){
						errors.add(e.getMessage(), new ActionMessage("Error : " + e.getMessage(),false));
						e.printStackTrace();
					}
					
					
					String qname = qtData.getName();
					String qtitle = qtData.getTitle();
					String qscreen = qtData.getScreen();
					int qprice = qtData.getPrice();
					int qquantity = cquantity;
					int qtotal = ntotal;
					
					MovInfData qmData = new MovInfData();
					
					qmData.setTitle(qtData.getTitle());
					qmData.setScreen(qtData.getScreen());
					
					//get movinf
					try{
						qmData = miProxy.retrieveMIMessage(qmData);
					}
					catch (Exception e){
						errors.add(e.getMessage(), new ActionMessage("Error : " + e.getMessage(),false));
						e.printStackTrace();
					}
					
					
					//update seats
					int qseats = qmData.getSeats() + oquantity - cquantity;
					
					qmData.setSeats(qseats);
					
					//update movinf
					try{
						miProxy.updateMIMessage(qmData);
					}
					catch (Exception e){
						errors.add(e.getMessage(), new ActionMessage("Error : " + e.getMessage(),false));
						e.printStackTrace();
					}
					
					
					//Set result
					String result = "Your Order Has CHANGE to : Name ¡¾"
		                 + qname + "¡¿    Title ¡¶" 
		                 + qtitle + "¡·    Screen ¡¾" 
		                 + qscreen + "¡¿    Price ¡¾"
		                 + qprice + "¡¿    QUANTITY ¡¾"
		                 + qquantity + "¡¿     Total price¡¾"
		                 + qtotal +"¡¿";
					
					//Mail
					String sender = "90012005@ntut.edu.tw";
					String receiver = cForm.getReceiver();

					String subject = "V.S Cinema CHANGE Confirmation letter";
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
			            forward = mapping.findForward("CHTKDone");
					}
					else{
			            super.saveErrors(request, errors);
			            forward = mapping.findForward("ActionError");
					}							
					
					return (forward);
					
			
				
	}
		   
	   
 
}
