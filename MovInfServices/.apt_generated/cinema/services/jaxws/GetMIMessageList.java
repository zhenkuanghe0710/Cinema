//
// Generated By:JAX-WS RI IBM 2.1.1 in JDK 6 (JAXB RI IBM JAXB 2.1.3 in JDK 1.6)
//


package cinema.services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getMIMessageList", namespace = "http://services.cinema/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMIMessageList", namespace = "http://services.cinema/")
public class GetMIMessageList {

    @XmlElement(name = "arg0", namespace = "")
    private cinema.datas.MovInfData arg0;

    /**
     * 
     * @return
     *     returns MovInfData
     */
    public cinema.datas.MovInfData getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(cinema.datas.MovInfData arg0) {
        this.arg0 = arg0;
    }

}
