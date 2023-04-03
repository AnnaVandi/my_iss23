package unibo.appl1.common;
/*La classe unibo.basicomm23.http.HTTPCommApache si occupa di interazioni low-level HTTP di tipo generale.

Tuttavia, da un punto di vosta logico, la nostra attenzione è rivolta alla comunicazione
con il robot, che conviene sia caratterizzata da concetti di più alto livello,
quali le operazioni definite dalla seguente interfaccia:
*/
public interface IVrobotMoves {
    public boolean step(int time) throws Exception;
    public void turnLeft() throws Exception;
    public void turnRight() throws Exception;
    public void forward( int time ) throws Exception;
    public void backward( int time ) throws Exception;
    public void halt() throws Exception;
}
