//
// Generated By:JAX-WS RI IBM 2.1.1 in JDK 6 (JAXB RI IBM JAXB 2.1.3 in JDK 1.6)
//


package cinema.services;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "MailServices", targetNamespace = "http://services.cinema/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MailServices {


    /**
     * 
     * @param arg0
     * @throws Exception_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "createMail", targetNamespace = "http://services.cinema/", className = "cinema.services.CreateMail")
    @ResponseWrapper(localName = "createMailResponse", targetNamespace = "http://services.cinema/", className = "cinema.services.CreateMailResponse")
    public void createMail(
        @WebParam(name = "arg0", targetNamespace = "")
        MailData arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<cinema.services.MailData>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMailList", targetNamespace = "http://services.cinema/", className = "cinema.services.GetMailList")
    @ResponseWrapper(localName = "getMailListResponse", targetNamespace = "http://services.cinema/", className = "cinema.services.GetMailListResponse")
    public List<MailData> getMailList(
        @WebParam(name = "arg0", targetNamespace = "")
        MailData arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns cinema.services.MailData
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sendMail", targetNamespace = "http://services.cinema/", className = "cinema.services.SendMail")
    @ResponseWrapper(localName = "sendMailResponse", targetNamespace = "http://services.cinema/", className = "cinema.services.SendMailResponse")
    public MailData sendMail(
        @WebParam(name = "arg0", targetNamespace = "")
        MailData arg0)
        throws Exception_Exception
    ;

}
