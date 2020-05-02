package fr.Atlanticity91.Controller;

import fr.Atlanticity91.Base.Observable;
import fr.Atlanticity91.Base.Observer;
import fr.Atlanticity91.Managers.IslaModelManager;

/**
 * Controller abstract class
 * @author : ALVES Quentin
 * @note : Defined controller base code.
 **/
public abstract class Controller extends Observable implements Observer {

    private final IslaModelManager models;

    /**
     * Constructor
     * @author : ALVES Quentin
     * @param models : Current model manager instance.
     **/
    public Controller( IslaModelManager models ) {
        super( );

        this.models = models;
    }

    /**
     * GetModel function
     * @author : ALVES Quentin
     * @note : Get a model form current model manager.
     * @param name : Name of the model.
     * @return : Object
     **/
    protected Object GetModel( String name ) {
        if( this.models != null )
            return this.models.Get( name );

        return null;
    }

}
