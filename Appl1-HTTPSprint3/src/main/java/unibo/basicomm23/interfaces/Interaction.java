package unibo.basicomm23.interfaces;

public interface Interaction {
    public void forward( String msg ) throws Exception;
    public String request(  String msg ) throws Exception;
    public void reply(  String msg ) throws Exception;
    public String receiveMsg(  )  throws Exception;

    public void forward(  IApplMessage msg ) throws Exception;
    public IApplMessage request(  IApplMessage msg ) throws Exception;
    public void reply(  IApplMessage msg ) throws Exception;
    public IApplMessage receive(  ) throws Exception ;
    public void close( )  throws Exception;

}
