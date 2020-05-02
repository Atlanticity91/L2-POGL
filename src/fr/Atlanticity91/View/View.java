package fr.Atlanticity91.View;

import fr.Atlanticity91.Base.ENotifyEvents;
import fr.Atlanticity91.Base.Observer;
import fr.Atlanticity91.Base.Point;
import fr.Atlanticity91.Controller.Controller;
import fr.Atlanticity91.Managers.IslaControllerManager;
import fr.Atlanticity91.Managers.IslaModelManager;

import javax.swing.*;
import java.awt.*;

/**
 * View abstract class
 * @author : ALVES Quentin
 * @note : Defined base view code.
 **/
public abstract class View extends JPanel implements Observer {

    private final IslaModelManager models;
    private final IslaControllerManager controllers;

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
     * CreateButton method
     * @author : ALVES Quentin
     * @note : Create a button on the view.
     * @param position : Position of the button.
     * @param size : Size of the button.
     * @param name : Text on the button.
     * @param event : Event send when the button is clicked.
     **/
    protected void CreateButton( Point position, Point size, String name, ENotifyEvents event ) {
        JButton button = new JButton( name );
        button.setLocation( position.GetX( ), position.GetY( ) );
        button.setPreferredSize( new Dimension( size.GetX( ), size.GetY( ) ) );

        button.addActionListener( e -> { this.controllers.NotifyAll( ENotifyEvents.ENE_TURN_END ); } );

        this.add( button );
    }

    /**
     * Notify method
     * @author : ALVES Quentin
     * @note : Dispatch event when observable send event.
     * @param event : The event to dispatch.
     **/
    @Override
    public void Notify( ENotifyEvents event ) {
        if ( event == ENotifyEvents.ENE_REPAINT )
            repaint( );
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

    /**
     * GetModel function
     * @author : ALVES Quentin
     * @note : Get a model from current model manager.
     * @param name : Name of the model.
     * @return : Object
     */
    protected Object GetModel( String name ) {
        if ( this.models != null )
            return this.models.Get( name );

        return null;
    }

}
