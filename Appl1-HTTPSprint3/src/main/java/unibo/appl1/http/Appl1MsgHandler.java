package unibo.appl1.http;


import unibo.appl1.common.IAppl1Core;
import unibo.basicomm23.interfaces.IApplMessage;
import unibo.basicomm23.interfaces.Interaction;
import unibo.basicomm23.msg.ApplMsgHandler;
import unibo.basicomm23.interfaces.Interaction;

public class Appl1MsgHandler extends ApplMsgHandler {
    private IAppl1Core appl1Core;

    public Appl1MsgHandler(String name, IAppl1Core appl1Core) {
        super(name);
        this.appl1Core = appl1Core;
    }

    @Override
    public void elaborate(IApplMessage msg, Interaction conn) {

        if (msg.msgContent().contains("start")) {
            new Thread() {
                public void run() {
                    try {
                        appl1Core.start();
                    } catch (Exception e) {//... }
                    }
                }
            }.start();
        } else if (msg.msgContent().contains("stop")) {
            appl1Core.stop();
        } else if (msg.msgContent().contains("resume")) {
            appl1Core.resume();
        }

        if (msg.isRequest()) {
            if (msg.msgId().equals("isrunning")) {
                boolean answer = appl1Core.isRunning();
                //Creo e invio reply
                IApplMessage reply = CommUtils.buildReply(
                        name.toLowerCase(Locale.ROOT), "isrunninganswer", "" + answer, msg.msgSender());
                try {
                    conn.reply(reply.toString());
                } catch (Exception e) {}
            }
            if (msg.msgId().equals("getpath")) {
                String curPath = CommUtils.convertToSend(appl1Core.getCurrentPath());
                //Creo e invio reply
                IApplMessage reply = CommUtils.buildReply(
                        name.toLowerCase(Locale.ROOT), "getpathanswer", curPath, msg.msgSender());
                try {
                    conn.reply(reply.toString());
                } catch (Exception e) {}
            }
            return;


        }
    }

        // ...

}