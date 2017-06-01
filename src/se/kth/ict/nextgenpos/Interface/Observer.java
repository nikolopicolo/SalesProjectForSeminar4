package se.kth.ict.nextgenpos.Interface;

/**
 * Interface for an observer.This is an listening interface that is responsible to give information about the current state of the
 * product catalog. The class that is interested in listening to the changes and the current state of the
 * ProductCatalog is the View.
 */


public interface Observer
{

    /**
     * Invoked when the catalog has been updated.
     */
    public void stateHasChanged();

}
