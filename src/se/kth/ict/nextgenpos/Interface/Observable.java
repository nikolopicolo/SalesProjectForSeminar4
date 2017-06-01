package se.kth.ict.nextgenpos.Interface;

/**
 * Interface for an observable class.
 */

public interface Observable
{

    /**
     * Adds an observer to the class that implements this interface.
     * @param observer is notified when change is made.
     */
    public void addObserver(Observer observer);

}