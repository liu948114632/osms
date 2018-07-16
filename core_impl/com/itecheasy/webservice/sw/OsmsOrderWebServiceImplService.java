package com.itecheasy.webservice.sw;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.3-hudson-390-
 * Generated source version: 2.0
 * <p>
 * An example of how this class may be used:
 * 
 * <pre>
 * OsmsOrderWebServiceImplService service = new OsmsOrderWebServiceImplService();
 * OsmsOrderWebService portType = service.getOsmsOrderWebServiceImplPort();
 * portType.addProduct(...);
 * </pre>
 * 
 * </p>
 * 
 */
@WebServiceClient(name = "OsmsOrderWebServiceImplService", targetNamespace = "http://osms.communication.itecheasy.com/", wsdlLocation = "http://192.168.118.3:8080/dm_webservice/webService/OsmsOrderWebService?wsdl")
public class OsmsOrderWebServiceImplService extends Service {

	private final static URL OSMSORDERWEBSERVICEIMPLSERVICE_WSDL_LOCATION;
	private final static Logger logger = Logger
			.getLogger(com.itecheasy.webservice.sw.OsmsOrderWebServiceImplService.class.getName());

	static {
		URL url = null;
		try {
			URL baseUrl;
			baseUrl = com.itecheasy.webservice.sw.OsmsOrderWebServiceImplService.class.getResource(".");
			url = new URL(baseUrl, "http://192.168.118.3:8080/dm_webservice/webService/OsmsOrderWebService?wsdl");
		} catch (MalformedURLException e) {
			logger.warning("Failed to create URL for the wsdl Location: 'http://192.168.118.3:8080/dm_webservice/webService/OsmsOrderWebService?wsdl', retrying as a local file");
			logger.warning(e.getMessage());
		}
		OSMSORDERWEBSERVICEIMPLSERVICE_WSDL_LOCATION = url;
	}

	public OsmsOrderWebServiceImplService(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	public OsmsOrderWebServiceImplService() {
		super(OSMSORDERWEBSERVICEIMPLSERVICE_WSDL_LOCATION, new QName("http://osms.communication.itecheasy.com/",
				"OsmsOrderWebServiceImplService"));
	}

	/**
	 * 
	 * @return returns OsmsOrderWebService
	 */
	@WebEndpoint(name = "OsmsOrderWebServiceImplPort")
	public OsmsOrderWebService getOsmsOrderWebServiceImplPort() {
		return super.getPort(new QName("http://osms.communication.itecheasy.com/", "OsmsOrderWebServiceImplPort"),
				OsmsOrderWebService.class);
	}

}
