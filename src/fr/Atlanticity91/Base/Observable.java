package fr.Atlanticity91.Base;

import java.util.ArrayList;

/**
 * Observable abstract class
 * @author : ALVES Quentin
 * @note : Defined base class for observable objects.
 **/
public abstract class Observable {

    private ArrayList< Observer > observers;

    /**
     * Constructor
     * @author : ALVES Quentin
     **/
    public Observable( ) {
        this.observers = new ArrayList< Observer >( );
    }

    /**
     * Register method
     * @author : ALVES Quentin
     * @note : Register an observer to current object.
     * @param observer : Query observer.
     **/
    public void Register( Observer observer ) {
        if ( observer != null && observer != this )
            this.observers.add( observer );
    }

    /**
     * NotifyAll method
     * @author : ALVES Quentin
     * @note : Send a notification to all observer.
     * @param event : The event to dispatch on observer.
     **/
    protected void NotifyAll(ENotifyEvents event ) {
        for ( Observer observer : this.observers )
            observer.Notify( event );
    }

}
