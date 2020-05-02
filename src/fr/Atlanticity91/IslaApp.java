package fr.Atlanticity91;

import fr.Atlanticity91.Base.ENotifyEvents;
import fr.Atlanticity91.Managers.IslaControllerManager;
import fr.Atlanticity91.Controller.MapController;
import fr.Atlanticity91.Managers.IslaModelManager;
import fr.Atlanticity91.Managers.IslaViewManager;
import fr.Atlanticity91.Model.MapModel;
import fr.Atlanticity91.Model.PlayerModel;

import javax.swing.*;
import java.awt.*;

/**
 * IslaApp class
 * @author : ALVES Quentin
 * @note : Defined application core class.
 **/
public final class IslaApp extends JFrame {

    private IslaModelManager models;
    private IslaControllerManager controllers;
    private IslaViewManager view;

    /**
     * Constructor
     * @author : ALVES Quentin
     **/
    public IslaApp( ) {
        // Setup the JFrame.
        this.setTitle( "L'ile interdite - POGL" );
        this.setLayout( new FlowLayout( ) );

        // Registers all application models on model manager.
        this.models = new IslaModelManager( );
        this.models.Register( "Map", new MapModel( ) );
        this.models.Register( "Player", new PlayerModel( ) );

        // Registers all application controllers on controller manager.
        this.controllers = new IslaControllerManager( );
        this.controllers.Register( "Map", new MapController( this.models ) );
        this.controllers.Register( "Player", null );

        // Send the default event to controller to generate the island
        // and place objects on it.
        this.controllers.NotifyAll( ENotifyEvents.ENE_GENERATE );

        // Create the application view.
        this.view = new IslaViewManager( this, this.models, this.controllers );

        // JFrame finalisation.
        this.pack( );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setVisible( true );
    }

}
