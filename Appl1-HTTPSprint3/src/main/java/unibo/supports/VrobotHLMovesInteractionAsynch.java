package unibo.supports;
/*In prospettiva però, potremo anche sfruttare interazioni asincrone con il VirtualRobot usando le WebSocket. Una classe
(come ad esempio VrobotHLMovesInteractionAsynch) realizzerà le mosse di alto livelo del robot usando il supporto
WsConnection per le interazioni con WEnv.*/


import unibo.basicomm23.interfaces.Interaction;
import unibo.appl1.common.CollisionException;
import unibo.appl1.common.IVrobotMoves;


public class VrobotHLMovesInteractionAsynch implements IVrobotMoves{
    public VrobotHLMovesInteractionAsynch(Interaction connToWEnv) {
    }

    //TODO


    @Override
    public boolean step(int time) throws Exception {
        return false;
    }

    @Override
    public void turnLeft() throws Exception {

    }

    @Override
    public void turnRight() throws Exception {

    }

    @Override
    public void forward(int time) throws Exception {

    }

    @Override
    public void backward(int time) throws Exception {

    }

    @Override
    public void halt() throws Exception {

    }
}
