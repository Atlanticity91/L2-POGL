package fr.Atlanticity91.Managers;

import fr.Atlanticity91.View.MapView;
import fr.Atlanticity91.View.PlayerView;

import javax.swing.*;

public class IslaViewManager {

    private MapView map;
    private PlayerView player;

    public IslaViewManager( JFrame window, IslaModelManager models, IslaControllerManager controllers ) {
        this.map = new MapView( models, controllers );
        this.player = new PlayerView( models, controllers );

        window.add( this.map );
        window.add( this.player );
    }

}
