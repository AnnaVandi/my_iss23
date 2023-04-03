package unibo.basicomm23.enablers;

import unibo.basicomm23.interfaces.IApplMsgHandler;
import unibo.basicomm23.msg.ProtocolType;

/*Realizza un server che riceve messaggi,
delegandone la gestione a un oggetto che implementa IApplMsgHandler.*/
public class ServerFactory extends Thread{

    public ServerFactory(
            String name, int port, ProtocolType protocol, IApplMsgHandler handler ) throws Exception {
        //...
        setServerSupport( port, protocol, handler  );
    }

    protected void setServerSupport(
            int port, ProtocolType protocol, IApplMsgHandler handler) throws Exception{
    /*
    Attiva un server per lo specifico protocol
    */
    }
}
