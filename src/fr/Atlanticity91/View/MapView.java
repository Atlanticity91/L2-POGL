package fr.Atlanticity91.View;

import fr.Atlanticity91.Base.Config;
import fr.Atlanticity91.Base.ENotifyEvents;
import fr.Atlanticity91.Base.ETileStates;
import fr.Atlanticity91.Base.TileData;
import fr.Atlanticity91.Managers.IslaControllerManager;
import fr.Atlanticity91.Managers.IslaModelManager;
import fr.Atlanticity91.Model.MapModel;

import java.awt.*;

public class MapView extends View {

    public MapView( IslaModelManager models, IslaControllerManager controllers ) {
        super( models, controllers );

        controllers.RegisterObserver( "Map", this );

        this.setPreferredSize( new Dimension( 320, 320 ) );
    }

    @Override
    public void Notify( ENotifyEvents event ) {
        if ( event == ENotifyEvents.ENE_REPAINT )
            repaint( );
    }

    private void Paint( Graphics graphics, TileData tile ) {
        int size = Config.TILE_SIZE;

        if ( tile.GetState( ) == ETileStates.ETS_NORMAL )
            graphics.setColor( Color.gray );
        else
            graphics.setColor( Color.blue );

        graphics.fillRect( tile.GetPosition( ).GetX( ) * size, tile.GetPosition( ).GetY( ) * size, size, size );
    }

    private void Paint( Graphics graphics, fr.Atlanticity91.Base.Point point ) {
        int size = Config.TILE_SIZE;

        graphics.setColor( Color.cyan );
        graphics.fillRect( point.GetX( ) * size, point.GetY( ) * size, size, size );
    }

    public void paintComponent( Graphics graphics ) {
        super.repaint( );

        MapModel map = (MapModel)this.GetModel("Map" );

        if ( map != null ) {
            for ( TileData tile : map.GetTiles( ) )
                this.Paint( graphics, tile );

            if ( map.GetWater( ) != null ) {
                for ( fr.Atlanticity91.Base.Point point : map.GetWater( ) )
                    this.Paint( graphics, point );
            }
        }
    }

}
