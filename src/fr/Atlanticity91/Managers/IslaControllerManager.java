package fr.Atlanticity91.Managers;

import fr.Atlanticity91.Base.ENotifyEvents;
import fr.Atlanticity91.Base.Observer;
import fr.Atlanticity91.Controller.Controller;

/**
 * IslaControllerManager class
 * @author : ALVES Quentin
 * @note : Defined controller management code.
 **/
import java.util.Hashtable;

public final class IslaControllerManager {

    private final Hashtable< String, Controller> controllers;

    /**
     * Constructor
     * @author : ALVES Quentin
     **/
    public IslaControllerManager( ) {
        this.controllers = new Hashtable< String, Controller >( );
    }

    /**
     * Register method
     * @author : ALVES Quentin
     * @note : Register a controller.
     * @param name : Name of the controller.
     * @param controller : Instance of the controller.
     */
    public void Register( String name, Controller controller ){
        if ( !this.controllers.containsKey( name ) && controller != null )
            this.controllers.put( name, controller );
    }

    /**
     * RegisterObserver method
     * @author : ALVES Quentin
     * @note : Register an observer to a controller.
     * @param controller : Name of the query controller.
     * @param observer : Reference to query observer.
     **/
    public void RegisterObserver( String controller, Observer observer ) {
        if( this.controllers.containsKey( controller ) && observer != null ) {
            Controller query = this.controllers.get( controller );

            if ( observer != query )
                query.Register( observer );
        }
    }

    /**
     * NotifyAll method
     * @author : ALVES Quentin
     * @note : Notify all controller of an event.
     * @param event : Query event to dispatch.
     **/
    public void NotifyAll(ENotifyEvents event ) {
        for ( Controller controller : this.controllers.values( ) )
            controller.Notify( event );
    }

    /**
     * Get function
     * @author : ALVES Quentin
     * @note : Get a controller from current manager.
     * @param name : Name of the controller.
     * @return : Controller.
     */
    public Controller Get( String name ) {
        return this.controllers.get( name );
    }

}
