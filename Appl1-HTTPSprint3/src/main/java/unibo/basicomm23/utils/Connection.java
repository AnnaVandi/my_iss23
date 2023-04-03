package unibo.basicomm23.utils;

import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.interfaces.Interaction;

public abstract class Connection implements Interaction {
    @Override
    public void forward(IApplMessage msg) throws Exception {
        forward( msg.toString() );
    }
    @Override
    public IApplMessage request(IApplMessage msg) throws Exception {
        String answer = request(msg.toString());
        return new ApplMessage(answer);
    }
    @Override
    public IApplMessage receive() throws Exception{
        String msg = receiveMsg();
        return new ApplMessage(msg);
    }
    @Override
    public void reply(IApplMessage msg) throws Exception {
        reply(msg.toString());
    }
    @Override
    public abstract void forward(String msg) throws Exception;
    @Override
    public abstract String request(String msg) throws Exception;
    @Override
    public abstract void reply(String reqid) throws Exception;
    @Override
    public abstract String receiveMsg() throws Exception;
    @Override
    public abstract void close() throws Exception;
}
