package unibo.appl1.interaction;

import unibo.basicomm23.examples.ActorNaiveCaller;
import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.msg.ApplMessage;
import unibo.basicomm23.msg.ProtocolType;
import unibo.basicomm23.utils.CommUtils;

import java.util.Observable;
import java.util.Observer;

public class CmdConsoleRemote extends ActorNaiveCaller implements Observer {
    private String[] buttonLabels = new String[]{"start", "stop", "resume", "getpath"};
    private String myName;
    private IApplMessage curMsg;
    private IApplMessage applRunningRequest, applGetPathRequest;

    public CmdConsoleRemote(String name, ProtocolType protocol, String hostAddr, String entry) {
        super(name, protocol, hostAddr, entry);
        ButtonAsGui concreteButton = ButtonAsGui.createButtons("", buttonLabels);
        concreteButton.addObserver(this);
        this.myName = name;
        applRunningRequest = CommUtils.buildRequest("gui", "isrunning", "test", myName);
        applGetPathRequest = CommUtils.buildRequest("gui", "getpath", "test", myName);
    }

    @Override
    protected void body() throws Exception {
        connect();
        CommUtils.outmagenta("CmdConsoleRemote simply reacts to buttons");
    }

    @Override
    public void update( Observable o , Object arg ) {
        try {
            if( connSupport == null ){
                CommUtils.outred(" CmdConsoleRemote | Please start Appl1HTTPSprint3"   );
                return;
            }
            String move = arg.toString();
            if( move.equals("getpath")) {  //RICHIESTA DI INFO
                String answer = connSupport.request(applRunningRequest.toString());
                String curPathAnswer = connSupport.request(applGetPathRequest.toString());
                IApplMessage answMsg = new ApplMessage(answer);
                IApplMessage pathMsg = new ApplMessage(curPathAnswer);
                String path          = pathMsg.msgContent();
                if (answMsg.msgContent().equals("true")) {
                    CommUtils.outmagenta("CURRENT PATH="+ path);
                }else{
                    String spath = CommUtils.restoreFromConvertToSend(path);
                    CommUtils.outmagenta("FINAL PATH="+ spath);
                }
            }else { //COMANDO
                curMsg = CommUtils.buildDispatch("gui", move, move, myName);
                connSupport.forward(curMsg.toString());
            }
        } catch (Exception e) {//... }
        }
    }

}