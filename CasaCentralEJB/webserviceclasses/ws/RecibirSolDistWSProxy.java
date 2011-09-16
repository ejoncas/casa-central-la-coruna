package ws;

public class RecibirSolDistWSProxy implements ws.RecibirSolDistWS {
  private String _endpoint = null;
  private ws.RecibirSolDistWS recibirSolDistWS = null;
  
  public RecibirSolDistWSProxy() {
    _initRecibirSolDistWSProxy();
  }
  
  public RecibirSolDistWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initRecibirSolDistWSProxy();
  }
  
  private void _initRecibirSolDistWSProxy() {
    try {
      recibirSolDistWS = (new ws.RecibirSolDistWSServiceLocator()).getRecibirSolDistWSPort();
      if (recibirSolDistWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)recibirSolDistWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)recibirSolDistWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (recibirSolDistWS != null)
      ((javax.xml.rpc.Stub)recibirSolDistWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ws.RecibirSolDistWS getRecibirSolDistWS() {
    if (recibirSolDistWS == null)
      _initRecibirSolDistWSProxy();
    return recibirSolDistWS;
  }
  
  public boolean recibirSolDist(java.lang.String xmlSolDist) throws java.rmi.RemoteException{
    if (recibirSolDistWS == null)
      _initRecibirSolDistWSProxy();
    return recibirSolDistWS.recibirSolDist(xmlSolDist);
  }
  
  
}