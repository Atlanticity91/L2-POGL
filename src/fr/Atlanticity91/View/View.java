package fr.Atlanticity91.View;

import fr.Atlanticity91.Base.Observer;
import fr.Atlanticity91.Controller.Controller;
import fr.Atlanticity91.Managers.IslaControllerManager;
import fr.Atlanticity91.Managers.IslaModelManager;

import javax.swing.*;

public abstract class View extends JPanel implements Observer {

    private IslaModelManager models;
    private IslaControllerManager controllers;

    /**
     * Constructor
     * @author : ALVES Quentin
     * @param models : Current application model manager instance.
     * @param controllers : Current application controller manager instance.
     */
    public View( IslaModelManager models, IslaControllerManager controllers ) {
        this.models = models;
        this.controllers = controllers;
    }

    /**
     * GetControllers function
     * @author : ALVES Quentin
     * @note : Get current controller manager instance.
     * @return : IslaControllerManager
     **/
    protected IslaControllerManager GetControllers( ) {
        return this.controllers;
    }

    /**
     * GetController function
     * @author : ALVES Quentin
     * @note : Get a controller from current controller manager.
     * @param name : Name of the query controller.
     * @return : Controller
     **/
    protected Controller GetController( String name ) {
        if ( this.controllers != null )
            return this.controllers.Get( name );

        return null;
    }

    protected Object GetModel( String name ) {
        if ( this.models != null )
            return this.models.Get( name );

        return null;
    }

}
