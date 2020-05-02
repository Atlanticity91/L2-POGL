package fr.Atlanticity91.Model;

import fr.Atlanticity91.Base.ETileStates;
import fr.Atlanticity91.Base.Point;
import fr.Atlanticity91.Base.TileData;

import java.util.ArrayList;

/**
 * MapModel class
 * @author : ALVES Quentin
 * @note :
 **/
public final class MapModel {

    private ArrayList< TileData > tiles;
    private ArrayList< Point > water;

    /**
     * Constructor
     * @author : ALVES Quentin
     **/
    public MapModel( ) {
        this.tiles = new ArrayList< TileData >( );
        this.water = new ArrayList< Point >( );
    }

    /**
     * Create method
     * @author : ALVES Quentin
     * @note : Create a tile at a position with a certain type.
     * @param x : Tile x value.
     * @param y : Tile y value.
     * @param type : Type of the new tile.
     **/
    public void Create( int x, int y, int type ) {
        if ( type == 0 )
            this.water.add( new Point( x, y ) );
        else if ( type > 0 )
            this.tiles.add( new TileData( x, y ) );
    }

    /**
     * Process method
     * @author : ALVES Quentin
     * @note : Update tiles for tile to water conversion.
     **/
    public void Process( ) {
        for ( int i = 0; i < this.tiles.size( ); i++ ) {
            TileData tile = this.tiles.get( i );

            if ( tile.GetState( ) != ETileStates.ETS_GOOD_BYE )
                continue;
            else {
                this.water.add( tile.GetPosition( ) );
                this.tiles.remove( tile );

                i -= 1;
            }
        }
    }

    /**
     * Submerge method
     * @author : ALVES Quentin
     * @note : Submerge a tile.
     * @param query : Index of the query tile.
     **/
    public void Submerge( int query ) {
        TileData data = this.tiles.get( query );

        if ( data.GetState( ) == ETileStates.ETS_SUBMERGE )
            data.SetState( ETileStates.ETS_GOOD_BYE );
        else
            data.SetState( ETileStates.ETS_SUBMERGE );
    }

    /**
     * Clear method
     * @author : ALVES Quentin
     * @note : Clear all tiles.
     **/
    public void Clear( ) {
        this.tiles.clear( );
        this.water.clear( );
    }

    /**
     * GetTiles function
     * @author : ALVES Quentin
     * @note : Get a reference to tile list.
     * @return : ArrayList< TileData >
     */
    public ArrayList< TileData > GetTiles( ) {
        return this.tiles;
    }

    /**
     * GetWater function
     * @author : ALVES Quentin
     * @note : Get a reference to water tile list.
     * @return : ArrayList< Point >
     */
    public ArrayList< Point > GetWater( ) {
        return this.water;
    }

}
