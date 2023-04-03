package unibo.basicomm23.utils;

import unibo.basicomm23.interfaces.IObserver;

import java.util.Observable;

public abstract class ApplAbstractObserver implements IObserver {

    public void update(Observable o, Object arg) {
        this.update(arg.toString());
    }
    public abstract void update(String var1);
}