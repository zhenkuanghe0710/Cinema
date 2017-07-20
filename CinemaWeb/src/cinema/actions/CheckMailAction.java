package cinema.actions;



import java.util.List;

import cinema.services.MailData;
import cinema.services.MailServicesPortProxy;
import cinema.forms.CinemaForm;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckMailAction extends Action {
	
			private ActionErrors errors = null;
	
			public ActionForward execute (	ActionMapping mapping,
																 ActionForm form,
																 HttpServletRequest request, 
																 HttpServletResponse response ) throws Exception {
		
						CinemaForm cForm = (CinemaForm) form;
						ActionForward forward = new ActionForward();
						errors = new ActionErrors();
						MailServicesPortProxy mlProxy = new MailServicesPortProxy();

						
						MailData data = new MailData();
						data.setReceiver(cForm.getReceiver());
						List<MailData> resultList = null;
						
						try{
							resultList = mlProxy.getMailList(data);	
			                }
			                catch (Exception e){
								errors.add(e.getMessage(), new ActionMessage("Error : " + e.getMessage(),false));
								e.printStackTrace();
							}
						
				
						
						if(errors.isEmpty()){
							    cForm.setMailList(resultList);
								forward = mapping.findForward("CMDone");
						}
						else{
								super.saveErrors(request, errors);
								forward = mapping.findForward("ActionError");
						}							
						return (forward);
			}

}