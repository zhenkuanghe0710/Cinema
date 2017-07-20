package cinema.services;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import java.util.List;

public class MailServicesPortProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private cinema.services.MailServicesService _service = null;
        private cinema.services.MailServices _proxy = null;
        private Dispatch<Source> _dispatch = null;

        public Descriptor() {
            _service = new cinema.services.MailServicesService();
            initCommon();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new cinema.services.MailServicesService(wsdlLocation, serviceName);
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getMailServicesPort();
        }

        public cinema.services.MailServices getProxy() {
            return _proxy;
        }

        public Dispatch<Source> getDispatch() {
            if(_dispatch == null ) {
                QName portQName = new QName("http://services.cinema/", "MailServicesPort");
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

    public MailServicesPortProxy() {
        _descriptor = new Descriptor();
    }

    public MailServicesPortProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
    }

    public void createMail(MailData arg0) throws Exception_Exception {
        _getDescriptor().getProxy().createMail(arg0);
    }

    public List<MailData> getMailList(MailData arg0) throws Exception_Exception {
        return _getDescriptor().getProxy().getMailList(arg0);
    }

    public MailData sendMail(MailData arg0) throws Exception_Exception {
        return _getDescriptor().getProxy().sendMail(arg0);
    }

}