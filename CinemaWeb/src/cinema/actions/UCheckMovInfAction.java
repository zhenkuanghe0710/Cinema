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


import cinema.services.MovInfData;
import cinema.services.MovInfServicesPortProxy;
import cinema.forms.CinemaForm;

public class UCheckMovInfAction extends Action{
	
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
				
				MovInfData miData = new MovInfData();
				
				miData.setTitle(title);
				miData.setScreen(screen);
				
				List<MovInfData> movinfList = null;
				
				try{
					movinfList = miProxy.getMIMessageList(miData);	
	                }
	                catch (Exception e){
						errors.add(e.getMessage(), new ActionMessage("Error : " + e.getMessage(),false));
						e.printStackTrace();
					}
				
				
				
				if(errors.isEmpty()){
		            miForm.setMovinfList(movinfList);
		            forward = mapping.findForward("UCMIDone");
				}
				else{
		            super.saveErrors(request, errors);
		            forward = mapping.findForward("ActionError");
				}							
				
				return (forward);
	}
}
