package unibo.supports;
import unibo.basicomm23.http.HttpConnection;
import unibo.basicomm23.interfaces.Interaction;
import unibo.basicomm23.msg.ProtocolType;
import unibo.basicomm23.ws.WsConnection;
import unibo.appl1.common.IVrobotMoves;
public class VrobotHLSupportFactory {
    public static IVrobotMoves create(String hostIp, ProtocolType protocol) throws Exception {
       if( protocol == ProtocolType.http ) return supportForHTTP(hostIp);
     else if( protocol == ProtocolType.ws ) return supportForWS(hostIp);
     else throw new Exception("VrobotHLSupportFactory protocol not allowed");
}
    public static IVrobotMoves supportForHTTP(String hostIp){
        Interaction connToWEnv = HttpConnection.create(hostIp+":8090/api/move");
        return new VrobotHLMovesInteractionSync( connToWEnv  );
    }
    public static IVrobotMoves supportForWS(String hostIp){
        Interaction connToWEnv = WsConnection.create(hostIp+":8091");
        return (IVrobotMoves) new VrobotHLMovesInteractionAsynch( connToWEnv  );
    }
}
