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

import cinema.services.MailServicesPortProxy;
import cinema.services.MovInfData;
import cinema.services.MovInfServicesPortProxy;
import cinema.services.TicketData;
import cinema.services.TicketServicesPortProxy;
import cinema.forms.CinemaForm;


public class BookTicketAction extends Action{
	
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
				String title = cForm.getTitle();
				String screen = cForm.getScreen();

				MovInfData mdata = new MovInfData();
				
				mdata.setTitle(title);
				mdata.setScreen(screen);
				
				//get MovInf
				MovInfData ndata = new MovInfData();
                
				try{
				ndata = miProxy.retrieveMIMessage(mdata);	
                }
                catch (Exception e){
					errors.add(e.getMessage(), new ActionMessage("Error : " + e.getMessage(),false));
					e.printStackTrace();
				}
				
                String ttitle = ndata.getTitle();
				String tscreen = ndata.getScreen();
				String tname = cForm.getName();

				int tprice = ndata.getPrice();
				int tquantity = cForm.getQuantity();

				int tseats = ndata.getSeats();
	
				
				//Number Update
				int total = tprice * tquantity;
				int nseats = tseats - tquantity;
	
				
				TicketData ticData = new TicketData();

				//Set Ticket
				ticData.setName(tname);
				ticData.setTitle(ttitle);
				ticData.setScreen(tscreen);
				ticData.setPrice(tprice);
				ticData.setQuantity(tquantity);
				ticData.setTotal(total);
				
				try{
				ticProxy.createMessage(ticData);
				}
				catch (Exception e){
					errors.add(e.getMessage(), new ActionMessage("Error : " + e.getMessage(),false));
					e.printStackTrace();
				}
				
				ndata.setSeats(nseats);
				
				try{
				miProxy.updateMIMessage(ndata);
				}
				catch (Exception e){
					errors.add(e.getMessage(), new ActionMessage("Error : " + e.getMessage(),false));
					e.printStackTrace();
				}
				
				//Set result
				String result = "Your Order:  Name ¡¾"
	                 + tname + "¡¿    Title ¡¶" 
	                 + ttitle + "¡·    Screen ¡¾" 
	                 + tscreen + "¡¿    Price ¡¾"
	                 + tprice + "¡¿    Quantity ¡¾"
	                 + tquantity + "¡¿    Total price¡¾"
	                 + total +"¡¿";
				
				//Mail
				String sender = "90012005@ntut.edu.tw";
				String receiver = cForm.getReceiver();

				String subject = "V.S Cinema Confirmation letter";
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
		            forward = mapping.findForward("BookDone");
				}
				else{
		            super.saveErrors(request, errors);
		            forward = mapping.findForward("ActionError");
				}							
				
				return (forward);
	}
	
	
		   
	   
 
}
