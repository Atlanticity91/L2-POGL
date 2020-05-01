package fr.Atlanticity91.Managers;

import java.util.Hashtable;

public class IslaModelManager {

    private Hashtable< String, Object > models;

    public IslaModelManager( ) {
        this.models = new Hashtable< String, Object >( );
    }

    public void Register( String name, Object model ) {
        if ( !this.models.containsKey( name ) && model != null )
            this.models.put( name, model );
    }

    public Object Get( String name ) {
        return this.models.get( name );
    }

}
