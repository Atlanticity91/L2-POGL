package fr.Atlanticity91.Managers;

import java.util.Hashtable;

/**
 * IslaModelManager class
 * @author : ALVES Quentin
 * @note : Defined model management code.
 **/
public final class IslaModelManager {

    private final Hashtable< String, Object > models;

    /**
     * Constructor
     * @author : ALVES Quentin
     **/
    public IslaModelManager( ) {
        this.models = new Hashtable< String, Object >( );
    }

    /**
     * Register method.
     * @author : ALVES Quentin
     * @note : Register a model to the manager.
     * @param name : Name for the model.
     * @param model : Instance of the model.
     **/
    public void Register( String name, Object model ) {
        if ( !this.models.containsKey( name ) && model != null )
            this.models.put( name, model );
    }

    /**
     * Get function
     * @author : ALVES Quentin
     * @note : Get a model from current manager.
     * @param name : Name of the model.
     * @return : Object
     **/
    public Object Get( String name ) {
        return this.models.get( name );
    }

}
