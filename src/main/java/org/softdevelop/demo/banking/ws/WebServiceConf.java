package org.softdevelop.demo.banking.ws;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.service.model.EndpointInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConf {

    @Autowired
    private Bus bus;

    @Autowired
    private BranchesWSImpl sucursalesWS;

    @Bean
    public Endpoint endpoint() {
        EndpointInfo ei = new EndpointInfo();
        ei.setName(new QName("http://ws.banking.demo.softdevelop.org/", "EndpointName"));
        EndpointImpl endpoint = null;
        endpoint = new EndpointImpl(bus,sucursalesWS);
        endpoint.publish("/branchesservice");
        return endpoint;
    }
}
