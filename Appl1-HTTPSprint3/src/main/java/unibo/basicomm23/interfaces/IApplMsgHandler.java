package unibo.basicomm23.interfaces;
/*Un oggetto che implementa l’interfaccia IApplMsgHandler deve essere definito
dall’application designer per specificare, data una Interaction conn, come gestire un messaggio ricevuto
(metodo elaborate) e come inviare repliche o risposte al chiamante su conn.

Oggetti di questo tipo sono usati dai server forniti da ServerFactory.*/
public interface IApplMsgHandler {
    public String getName();
    public void elaborate( IApplMessage message, Interaction  conn );
}
