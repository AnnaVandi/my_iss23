package unibo.supports;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import unibo.basicomm23.http.HTTPCommApache;
import unibo.appl1.common.CollisionException;
import unibo.appl1.common.IVrobotMoves;
import unibo.appl1.common.VrobotMsgs;
import unibo.basicomm23.interfaces.Interaction;

public class VrobotHLMovesInteractionSync implements IVrobotMoves {
    private Interaction httpSupport  ;

    public VrobotHLMovesInteractionSync(Interaction httpSupport) {
        this.httpSupport = httpSupport;
    }
    //Implementazione delle operazioni di  IVrobotMoves
    @Override
    public void turnLeft() throws Exception{
        httpSupport.request(  VrobotMsgs.turnleftcmd  );
    }
    @Override
    public void turnRight() throws Exception{
        httpSupport.request(  VrobotMsgs.turnrightcmd  );
    }
    @Override
    public void forward(int time) throws Exception{
        String result = httpSupport.request(
                VrobotMsgs.forwardcmd.replace("TIME",""+time)  );
        if( result.toString().contains("collision")  ){
            throw new CollisionException(  ) ;
        }
    }
    @Override
    public void backward(int time) throws Exception{
        String result = httpSupport.request(
                VrobotMsgs.backwardcmd.replace("TIME",""+time)  );
        if( result.toString().contains("collision")  ){
            throw new CollisionException(  ) ;
        }
    }
    @Override
    public void halt( ) throws Exception {
        httpSupport.request(  VrobotMsgs.haltcmd  );
    }

    @Override
        /*
    muove in avanti il robot per un tempo dato, restituendo il boolean true se il movimento termina con successo
     e false nel caso il movimento non possa essere completato, per via di una collisione.
     */
    public boolean step(int time) throws Exception{
        String cmd = VrobotMsgs.forwardcmd.replace("TIME", ""+time);
        String result = httpSupport.request(   cmd  );
        //{"endmove":true,"move":"moveForward"}  OPPURE:
        //{"endmove":"false","move":"moveForward-collision"}
        boolean collision = result.toString().contains("collision");
        return ! collision;
    }
}
