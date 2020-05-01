package fr.Atlanticity91.Base;

import java.util.ArrayList;

public abstract class Observable {

    private ArrayList< Observer > observers;

    public Observable( ) {
        this.observers = new ArrayList< Observer >( );
    }

    public void Register( Observer observer ) {
        if ( observer != null && observer != this )
            this.observers.add( observer );
    }

    protected void NotifyAll(ENotifyEvents event ) {
        for ( Observer observer : this.observers )
            observer.Notify( event );
    }

}
