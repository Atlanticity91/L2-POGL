package fr.Atlanticity91.Model;

import fr.Atlanticity91.Base.ETileStates;
import fr.Atlanticity91.Base.Point;
import fr.Atlanticity91.Base.TileData;

import java.util.ArrayList;

public class MapModel {

    private ArrayList< TileData > tiles;
    private ArrayList< Point > water;

    public MapModel( ) {
        this.tiles = new ArrayList< TileData >( );
        this.water = new ArrayList< Point >( );
    }

    public void Create( int x, int y, int type ) {
        if ( type == 0 )
            this.water.add( new Point( x, y ) );
        else if ( type > 0 )
            this.tiles.add( new TileData( x, y ) );
    }

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

    public void Submerge( int query ) {
        TileData data = this.tiles.get( query );

        if ( data.GetState( ) == ETileStates.ETS_SUBMERGE )
            data.SetState( ETileStates.ETS_GOOD_BYE );
        else
            data.SetState( ETileStates.ETS_SUBMERGE );
    }

    public void Clear( ) {
        this.tiles.clear( );
        this.water.clear( );
    }

    public ArrayList< TileData > GetTiles( ) {
        return this.tiles;
    }

    public ArrayList< Point > GetWater( ) {
        return this.water;
    }

}
