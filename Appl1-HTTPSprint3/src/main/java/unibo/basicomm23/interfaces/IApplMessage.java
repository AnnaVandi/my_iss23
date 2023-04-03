package unibo.basicomm23.interfaces;
/*Un oggetto che implementa l’interfaccia IApplMessage
rappresenta un messaggio che segue uno standard interno sulla
struttura delle informazioni scambiate via rete.*/

public interface IApplMessage {
    public String msgId();
    public String msgType();
    public String msgSender();
    public String msgReceiver();
    public String msgContent();
    public String msgNum();
    public boolean isDispatch();
    public boolean isRequest();
    public boolean isReply();
    public boolean isEvent();
}
