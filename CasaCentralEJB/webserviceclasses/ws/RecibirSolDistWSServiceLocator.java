/**
 * RecibirSolDistWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws;

public class RecibirSolDistWSServiceLocator extends org.apache.axis.client.Service implements ws.RecibirSolDistWSService {

    public RecibirSolDistWSServiceLocator() {
    }


    public RecibirSolDistWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RecibirSolDistWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for RecibirSolDistWSPort
    private java.lang.String RecibirSolDistWSPort_address = "http://localhost:8080/TP_CuatrimestralEAR-TP_Cuatrimestral/RecibirSolDistWS";

    public java.lang.String getRecibirSolDistWSPortAddress() {
        return RecibirSolDistWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RecibirSolDistWSPortWSDDServiceName = "RecibirSolDistWSPort";

    public java.lang.String getRecibirSolDistWSPortWSDDServiceName() {
        return RecibirSolDistWSPortWSDDServiceName;
    }

    public void setRecibirSolDistWSPortWSDDServiceName(java.lang.String name) {
        RecibirSolDistWSPortWSDDServiceName = name;
    }

    public ws.RecibirSolDistWS getRecibirSolDistWSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RecibirSolDistWSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRecibirSolDistWSPort(endpoint);
    }

    public ws.RecibirSolDistWS getRecibirSolDistWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ws.RecibirSolDistWSBindingStub _stub = new ws.RecibirSolDistWSBindingStub(portAddress, this);
            _stub.setPortName(getRecibirSolDistWSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRecibirSolDistWSPortEndpointAddress(java.lang.String address) {
        RecibirSolDistWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ws.RecibirSolDistWS.class.isAssignableFrom(serviceEndpointInterface)) {
                ws.RecibirSolDistWSBindingStub _stub = new ws.RecibirSolDistWSBindingStub(new java.net.URL(RecibirSolDistWSPort_address), this);
                _stub.setPortName(getRecibirSolDistWSPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("RecibirSolDistWSPort".equals(inputPortName)) {
            return getRecibirSolDistWSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws/", "RecibirSolDistWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws/", "RecibirSolDistWSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("RecibirSolDistWSPort".equals(portName)) {
            setRecibirSolDistWSPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
