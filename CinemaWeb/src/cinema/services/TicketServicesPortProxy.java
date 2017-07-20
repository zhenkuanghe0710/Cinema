package cinema.services;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import java.util.List;

public class TicketServicesPortProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private cinema.services.TicketServicesService _service = null;
        private cinema.services.TicketServices _proxy = null;
        private Dispatch<Source> _dispatch = null;

        public Descriptor() {
            _service = new cinema.services.TicketServicesService();
            initCommon();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new cinema.services.TicketServicesService(wsdlLocation, serviceName);
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getTicketServicesPort();
        }

        public cinema.services.TicketServices getProxy() {
            return _proxy;
        }

        public Dispatch<Source> getDispatch() {
            if(_dispatch == null ) {
                QName portQName = new QName("http://services.cinema/", "TicketServicesPort");
                _dispatch = _service.createDispatch(portQName, Source.class, Service.Mode.MESSAGE);

                String proxyEndpointUrl = getEndpoint();
                BindingProvider bp = (BindingProvider) _dispatch;
                String dispatchEndpointUrl = (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
                if(!dispatchEndpointUrl.equals(proxyEndpointUrl))
                    bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, proxyEndpointUrl);
            }
            return _dispatch;
        }

        public String getEndpoint() {
            BindingProvider bp = (BindingProvider) _proxy;
            return (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
        }

        public void setEndpoint(String endpointUrl) {
            BindingProvider bp = (BindingProvider) _proxy;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);

            if(_dispatch != null ) {
            bp = (BindingProvider) _dispatch;
            bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);
            }
        }
    }

    public TicketServicesPortProxy() {
        _descriptor = new Descriptor();
    }

    public TicketServicesPortProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
    }

    public List<TicketData> getMessageList(TicketData arg0) throws Exception_Exception {
        return _getDescriptor().getProxy().getMessageList(arg0);
    }

    public TicketData retrieveMessage(TicketData arg0) throws Exception_Exception {
        return _getDescriptor().getProxy().retrieveMessage(arg0);
    }

    public void updateMessage(TicketData arg0) throws Exception_Exception {
        _getDescriptor().getProxy().updateMessage(arg0);
    }

    public void deleteMessage(TicketData arg0) throws Exception_Exception {
        _getDescriptor().getProxy().deleteMessage(arg0);
    }

    public void createMessage(TicketData arg0) throws Exception_Exception {
        _getDescriptor().getProxy().createMessage(arg0);
    }

}