package fr.Atlanticity91.Managers;

import fr.Atlanticity91.View.MapView;
import fr.Atlanticity91.View.PlayerView;

import javax.swing.*;

/**
 * IslaViewManager class
 * @author : ALVES Quentin
 * @note : Defined view management code.
 **/
public final class IslaViewManager {

    private final MapView map;
    private final PlayerView player;

    /**
     * Constructor
     * @author : ALVES Quentin
     * @param window : Current window instance.
     * @param models : Current model manager instance.
     * @param controllers : Current controller manager instance.
     **/
    public IslaViewManager( JFrame window, IslaModelManager models, IslaControllerManager controllers ) {
        this.map = new MapView( models, controllers );
        this.player = new PlayerView( models, controllers );

        window.add( this.map );
        window.add( this.player );
    }

}
