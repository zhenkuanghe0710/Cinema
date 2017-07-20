package cinema.actions;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


import cinema.services.MovInfData;
import cinema.forms.CinemaForm;
import cinema.services.MovInfServicesPortProxy;

public class SetMovInfAction extends Action{
	
	private ActionErrors errors = null;
	
	public ActionForward execute (	ActionMapping mapping,
														 ActionForm form,
														 HttpServletRequest request, 
														 HttpServletResponse response ) throws Exception {

				CinemaForm miForm = (CinemaForm) form;
				ActionForward forward = new ActionForward();
				errors = new ActionErrors();
				MovInfServicesPortProxy miProxy = new MovInfServicesPortProxy();
				
				String title = miForm.getTitle();
				String screen = miForm.getScreen();
				int price = miForm.getPrice();
				int seats = miForm.getSeats();
				
				MovInfData miData = new MovInfData();
				
			    miData.setTitle(title);
			    miData.setScreen(screen);
			    miData.setPrice(price);
			    miData.setSeats(seats);
				
			    try{
			    	miProxy.createMIMessage(miData);	
	                }
	                catch (Exception e){
						errors.add(e.getMessage(), new ActionMessage("Error : " + e.getMessage(),false));
						e.printStackTrace();
					}
	                
				
				if(errors.isEmpty()){
					
				    String result = "Movie Information is Set !";
		            miForm.setResult(result);
		            forward = mapping.findForward("SMIDone");
				}
				else{
		            super.saveErrors(request, errors);
		            forward = mapping.findForward("ActionError");
				}							
				
				return (forward);
	}
}
