package unibo.appl1.common;
/*Se racchiudiamo la logica applicativa in un POJO, allora è opportuno definire il contratto con
i suoi utlizzatori in termini di una interfaccia Java.*/
public interface IAppl1Core {
    public void start() throws Exception;
    public void stop();
    public void resume();
}