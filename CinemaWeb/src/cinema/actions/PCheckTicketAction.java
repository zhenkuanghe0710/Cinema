package cinema.actions;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


import cinema.services.TicketData;
import cinema.services.TicketServicesPortProxy;
import cinema.forms.CinemaForm;

public class PCheckTicketAction extends Action{
	
	private ActionErrors errors = null;
	
	public ActionForward execute (	ActionMapping mapping,
														 ActionForm form,
														 HttpServletRequest request, 
														 HttpServletResponse response ) throws Exception {

				CinemaForm ticForm = (CinemaForm) form;
				ActionForward forward = new ActionForward();
				errors = new ActionErrors();
				TicketServicesPortProxy ticProxy = new TicketServicesPortProxy();
				
				String name = ticForm.getName();
				
				TicketData ticData = new TicketData();
				
				ticData.setName(name);
				
				List<TicketData> ticketList = null;
				
				try{
					ticketList = ticProxy.getMessageList(ticData);	
	                }
	                catch (Exception e){
						errors.add(e.getMessage(), new ActionMessage("Error : " + e.getMessage(),false));
						e.printStackTrace();
					}
				
				
				
				
				if(errors.isEmpty()){
					ticForm.setTicketList(ticketList);
		            forward = mapping.findForward("PCTKDone");
				}
				else{
		            super.saveErrors(request, errors);
		            forward = mapping.findForward("ActionError");
				}							
				
				return (forward);
	}
}
