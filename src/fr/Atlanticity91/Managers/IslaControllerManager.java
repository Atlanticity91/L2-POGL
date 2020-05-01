package fr.Atlanticity91.Managers;

import fr.Atlanticity91.Base.ENotifyEvents;
import fr.Atlanticity91.Base.Observer;
import fr.Atlanticity91.Controller.Controller;

import java.util.Hashtable;

public class IslaControllerManager {

    private Hashtable< String, Controller> controllers;

    public IslaControllerManager( ) {
        this.controllers = new Hashtable< String, Controller >( );
    }

    public void Register( String name, Controller controller ){
        if ( !this.controllers.containsKey( name ) && controller != null )
            this.controllers.put( name, controller );
    }

    public void RegisterObserver( String controller, Observer observer ) {
        if( this.controllers.containsKey( controller ) && observer != null ) {
            Controller query = this.controllers.get( controller );

            if ( observer != query )
                query.Register( observer );
        }
    }

    public void NotifyAll(ENotifyEvents event ) {
        for ( Controller controller : this.controllers.values( ) )
            controller.Notify( event );
    }

    public Controller Get( String name ) {
        return this.controllers.get( name );
    }

}
