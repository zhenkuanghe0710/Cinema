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


public class UpdMovInfAction extends Action{
	
	private ActionErrors errors = null;
	
	public ActionForward execute (	ActionMapping mapping,
														 ActionForm form,
														 HttpServletRequest request, 
														 HttpServletResponse response ) throws Exception {

		        CinemaForm cForm = (CinemaForm) form;				
		        ActionForward forward = new ActionForward();
				errors = new ActionErrors();
				MovInfServicesPortProxy miProxy = new MovInfServicesPortProxy();

				
                int id = cForm.getId();
				
				MovInfData miData = new MovInfData();
				
				miData.setId(id);
				
				MovInfData cData = new MovInfData();
				
				try{
					cData = miProxy.retrieveMIMessage(miData);	
	                }
	                catch (Exception e){
						errors.add(e.getMessage(), new ActionMessage("Error : " + e.getMessage(),false));
						e.printStackTrace();
					}
				
				
				int price = cForm.getPrice();
				int seats = cForm.getSeats();
				
			
				cData.setPrice(price);
				cData.setSeats(seats);
				
				try{
					miProxy.updateMIMessage(cData);
					}
	                catch (Exception e){
						errors.add(e.getMessage(), new ActionMessage("Error : " + e.getMessage(),false));
						e.printStackTrace();
					}
				
				
				String result = "Movie Information is Updated !";


				if(errors.isEmpty()){
					cForm.setResult(result);
		            forward = mapping.findForward("UMIDone");
				}
				else{
		            super.saveErrors(request, errors);
		            forward = mapping.findForward("ActionError");
				}							
				
				return (forward);
	}
	   
 
}
