package fr.Atlanticity91.Base;

/**
 * TileData class
 * @author : ALVES Quentin
 * @note : Defined tile information.
 **/
public class TileData {

    private Point position;
    private ETileStates state;

    /**
     * Constructor
     * @author : ALVES Quentin
     * @param x : Tile x value.
     * @param y : Tile y value.
     **/
    public TileData( int x, int y ) {
        this.position = new Point( x, y );
        this.state = ETileStates.ETS_NORMAL;
    }

    /**
     * SetState method
     * @author : ALVES Quentin
     * @note : Set the state of current tile.
     * @param state : New state of the tile.
     **/
    public void SetState( ETileStates state ) {
        this.state = state;
    }

    /**
     * GetPosition function
     * @author : ALVES Quentin
     * @note : Get current tile position.
     * @return : Point
     **/
    public Point GetPosition( ) {
        return this.position;
    }

    /**
     * GetState function
     * @author : ALVES Quentin
     * @note : Get current tile state.
     * @return : ETileStates
     **/
    public ETileStates GetState( ) {
        return this.state;
    }

}
