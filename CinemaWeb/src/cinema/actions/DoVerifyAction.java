package cinema.actions;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cinema.forms.CinemaForm;

public class DoVerifyAction extends Action{
	
	public ActionForward execute (	ActionMapping mapping,
														 ActionForm form,
														 HttpServletRequest request, 
														 HttpServletResponse response ) throws Exception {

				CinemaForm passForm = (CinemaForm) form;
				ActionForward forward = new ActionForward();
				
				String password = passForm.getPassword();
				
				if(password.equals("123")){
		            forward = mapping.findForward("VFDone");
				}
				else{
					String result = "Password ERROR !!";
					passForm.setResult(result);
		            forward = mapping.findForward("VFWrong");
				}							
				
				return (forward);
	}
	
	
}
