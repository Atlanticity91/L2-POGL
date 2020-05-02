package fr.Atlanticity91.View;

import fr.Atlanticity91.Base.Config;
import fr.Atlanticity91.Base.ENotifyEvents;
import fr.Atlanticity91.Base.ETileStates;
import fr.Atlanticity91.Base.TileData;
import fr.Atlanticity91.Managers.IslaControllerManager;
import fr.Atlanticity91.Managers.IslaModelManager;
import fr.Atlanticity91.Model.MapModel;

import java.awt.*;

/**
 * MapView class
 * @author : ALVES Quentin
 * @note : Defined map view code.
 **/
public class MapView extends View {

    /**
     * Constructor
     * @author : ALVES Quentin
     * @param models : Current application model manager instance.
     * @param controllers : Current application controller manager instance.
     **/
    public MapView( IslaModelManager models, IslaControllerManager controllers ) {
        super( models, controllers );

        controllers.RegisterObserver( "Map", this );

        this.setPreferredSize( new Dimension( 320, 320 ) );
    }

    /**
     * Paint method
     * @author : ALVES Quentin
     * @note : Draw a tile on the window.
     * @param graphics : Current graphic manager instance.
     * @param tile : Query tile to draw.
     **/
    private void Paint( Graphics graphics, TileData tile ) {
        int size = Config.TILE_SIZE;

        if ( tile.GetState( ) == ETileStates.ETS_NORMAL )
            graphics.setColor( Color.gray );
        else
            graphics.setColor( Color.blue );

        graphics.fillRect( tile.GetPosition( ).GetX( ) * size, tile.GetPosition( ).GetY( ) * size, size, size );
    }

    /**
     * Paint method
     * @author : ALVES Quentin
     * @note : Draw a water tile on the window.
     * @param graphics : Current graphic manager instance.
     * @param point : Query tile to draw.
     **/
    private void Paint( Graphics graphics, fr.Atlanticity91.Base.Point point ) {
        int size = Config.TILE_SIZE;

        graphics.setColor( Color.cyan );
        graphics.fillRect( point.GetX( ) * size, point.GetY( ) * size, size, size );
    }

    /**
     * paintComponent method
     * @author : ALVES Quentin
     * @note : Inherit the paintComponent to draw the view.
     * @param graphics : Current graphic manager instance.
     **/
    public void paintComponent( Graphics graphics ) {
        super.repaint( );

        MapModel map = (MapModel)this.GetModel("Map" );

        if ( map != null ) {
            if ( map.GetTiles( ) != null ) {
                for (TileData tile : map.GetTiles())
                    this.Paint(graphics, tile);
            }

            if ( map.GetWater( ) != null ) {
                for ( fr.Atlanticity91.Base.Point point : map.GetWater( ) )
                    this.Paint( graphics, point );
            }
        }
    }

}
