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

@WebService(name = "TicketServices", targetNamespace = "http://services.cinema/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TicketServices {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<cinema.services.TicketData>
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMessageList", targetNamespace = "http://services.cinema/", className = "cinema.services.GetMessageList")
    @ResponseWrapper(localName = "getMessageListResponse", targetNamespace = "http://services.cinema/", className = "cinema.services.GetMessageListResponse")
    public List<TicketData> getMessageList(
        @WebParam(name = "arg0", targetNamespace = "")
        TicketData arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns cinema.services.TicketData
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "retrieveMessage", targetNamespace = "http://services.cinema/", className = "cinema.services.RetrieveMessage")
    @ResponseWrapper(localName = "retrieveMessageResponse", targetNamespace = "http://services.cinema/", className = "cinema.services.RetrieveMessageResponse")
    public TicketData retrieveMessage(
        @WebParam(name = "arg0", targetNamespace = "")
        TicketData arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @throws Exception_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "updateMessage", targetNamespace = "http://services.cinema/", className = "cinema.services.UpdateMessage")
    @ResponseWrapper(localName = "updateMessageResponse", targetNamespace = "http://services.cinema/", className = "cinema.services.UpdateMessageResponse")
    public void updateMessage(
        @WebParam(name = "arg0", targetNamespace = "")
        TicketData arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @throws Exception_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "deleteMessage", targetNamespace = "http://services.cinema/", className = "cinema.services.DeleteMessage")
    @ResponseWrapper(localName = "deleteMessageResponse", targetNamespace = "http://services.cinema/", className = "cinema.services.DeleteMessageResponse")
    public void deleteMessage(
        @WebParam(name = "arg0", targetNamespace = "")
        TicketData arg0)
        throws Exception_Exception
    ;

    /**
     * 
     * @param arg0
     * @throws Exception_Exception
     */
    @WebMethod
    @RequestWrapper(localName = "createMessage", targetNamespace = "http://services.cinema/", className = "cinema.services.CreateMessage")
    @ResponseWrapper(localName = "createMessageResponse", targetNamespace = "http://services.cinema/", className = "cinema.services.CreateMessageResponse")
    public void createMessage(
        @WebParam(name = "arg0", targetNamespace = "")
        TicketData arg0)
        throws Exception_Exception
    ;

}
