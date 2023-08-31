package unibo.basicomm23.interfaces;


public interface IObservable  {
	public void addObserver(IObserver obs ); //implemented by Java's Observable
	public void deleteObserver(IObserver obs ); //implemented by Java's Observable
}
