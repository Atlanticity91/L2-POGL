package fr.Atlanticity91.Controller;

import fr.Atlanticity91.Base.Observable;
import fr.Atlanticity91.Base.Observer;
import fr.Atlanticity91.Managers.IslaModelManager;

public abstract class Controller extends Observable implements Observer {

    private IslaModelManager models;

    public Controller( IslaModelManager models ) {
        super( );

        this.models = models;
    }

    protected Object GetModel( String name ) {
        if( this.models != null )
            return this.models.Get( name );

        return null;
    }

}
