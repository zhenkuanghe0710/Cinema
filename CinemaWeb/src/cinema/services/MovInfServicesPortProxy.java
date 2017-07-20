package cinema.services;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import java.util.List;

public class MovInfServicesPortProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private cinema.services.MovInfServicesService _service = null;
        private cinema.services.MovInfServices _proxy = null;
        private Dispatch<Source> _dispatch = null;

        public Descriptor() {
            _service = new cinema.services.MovInfServicesService();
            initCommon();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new cinema.services.MovInfServicesService(wsdlLocation, serviceName);
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getMovInfServicesPort();
        }

        public cinema.services.MovInfServices getProxy() {
            return _proxy;
        }

        public Dispatch<Source> getDispatch() {
            if(_dispatch == null ) {
                QName portQName = new QName("http://services.cinema/", "MovInfServicesPort");
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

    public MovInfServicesPortProxy() {
        _descriptor = new Descriptor();
    }

    public MovInfServicesPortProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
    }

    public void deleteMIMessage(MovInfData arg0) {
        _getDescriptor().getProxy().deleteMIMessage(arg0);
    }

    public void createMIMessage(MovInfData arg0) throws Exception_Exception {
        _getDescriptor().getProxy().createMIMessage(arg0);
    }

    public List<MovInfData> getMIMessageList(MovInfData arg0) throws Exception_Exception {
        return _getDescriptor().getProxy().getMIMessageList(arg0);
    }

    public void updateMIMessage(MovInfData arg0) {
        _getDescriptor().getProxy().updateMIMessage(arg0);
    }

    public MovInfData retrieveMIMessage(MovInfData arg0) throws Exception_Exception {
        return _getDescriptor().getProxy().retrieveMIMessage(arg0);
    }

}