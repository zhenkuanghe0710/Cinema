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
import cinema.services.MovInfServicesPortProxy;
import cinema.forms.CinemaForm;

public class DeleteMovInfAction extends Action{
	
	private ActionErrors errors = null;
	
	public ActionForward execute (	ActionMapping mapping,
														 ActionForm form,
														 HttpServletRequest request, 
														 HttpServletResponse response ) throws Exception {

				CinemaForm miForm = (CinemaForm) form;
				ActionForward forward = new ActionForward();
				errors = new ActionErrors();
				MovInfServicesPortProxy miProxy = new MovInfServicesPortProxy();

			
				int id = miForm.getId();
				
				MovInfData miData = new MovInfData();
				
		
			    miData.setId(id);
			    
			    try{
					miData = miProxy.retrieveMIMessage(miData);	
	                }
	                catch (Exception e){
						errors.add(e.getMessage(), new ActionMessage("Error : " + e.getMessage(),false));
						e.printStackTrace();
					}
			    
	            miData.setId(id);
	            
			    try{
			    	miProxy.deleteMIMessage(miData);	
	                }
	                catch (Exception e){
						errors.add(e.getMessage(), new ActionMessage("Error : " + e.getMessage(),false));
						e.printStackTrace();
					}
				
				
				if(errors.isEmpty()){
					
				    String result = "Movie Information is Deleted !";
		            miForm.setResult(result);
		            forward = mapping.findForward("DMIDone");
				}
				else{
		            super.saveErrors(request, errors);
		            forward = mapping.findForward("ActionError");
				}							
				
				return (forward);
	}
}
