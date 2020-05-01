package fr.Atlanticity91.Controller;

import fr.Atlanticity91.Base.ENotifyEvents;
import fr.Atlanticity91.Base.ETileStates;
import fr.Atlanticity91.Base.TileData;
import fr.Atlanticity91.Managers.IslaModelManager;
import fr.Atlanticity91.Model.MapModel;

import java.util.ArrayList;
import java.util.Random;

public class MapController extends Controller {

    private Random generator;

    /**
     * Constructor
     * @author : ALVES Quentin
     * @param models : Current model manager instance.
     **/
    public MapController( IslaModelManager models ){
        super( models );

        this.generator = new Random( );
        this.generator.setSeed( 1998 );
    }

    /**
     * Notify method
     * @author : ALVES Quentin
     * @note : Called when the observable object call NotifyAll.
     * @param event : Type of event to process.
     **/
    @Override
    public void Notify( ENotifyEvents event ) {
        if ( event == ENotifyEvents.ENE_GENERATE )
            this.GenerateMap( );
        if ( event == ENotifyEvents.ENE_TURN_END )
            this.Submerge( );
    }

    /**
     * GenerateMap method
     * @author : ALVES Quentin
     * @note : Generate current tile map.
     **/
    private void GenerateMap( ) {
        MapModel map = (MapModel)this.GetModel( "Map" );

        if ( map != null ) {
            System.out.println( "Generating map !" );

            map.Clear( );

            for ( int y = 0; y < 10; y++ ) {
                for ( int x = 0; x < 10; x++ ) {
                    map.Create( x, y, ( y + x ) % 2 );
                }
            }
        }
    }

    /**
     * Submerge method
     * @author : ALVES Quentin
     * @note : Submerge tiles of the map.
     **/
    private void Submerge( ) {
        MapModel map = (MapModel)this.GetModel( "Map" );

        if ( map != null && map.GetTiles( ).size( ) > 0) {

            this.SubmergeTile( map, 3 );

            map.Process( );

            this.NotifyAll( ENotifyEvents.ENE_REPAINT );
        }
    }

    /**
     * SubmergeTile method
     * @author : ALVES Quentin
     * @note : Submerge a certain amount of tile from map.
     * @param map : Current map model instance.
     * @param count : How many tile to submerge.
     **/
    private void SubmergeTile( MapModel map, int count ) {
        ArrayList< TileData > tiles = map.GetTiles( );

        while ( count >0 ) {
            int query_tile = 0;

            // TODO : Prevent infinite loop and disable for all zone submersion.
            do {
                query_tile = this.generator.nextInt( tiles.size( ) );
            } while ( tiles.get( query_tile ).GetState( ) != ETileStates.ETS_NORMAL );

            map.Submerge( query_tile );

            count -= 1;
        }
    }

}
