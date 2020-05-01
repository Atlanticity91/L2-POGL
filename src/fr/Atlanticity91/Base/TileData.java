package fr.Atlanticity91.Base;

public class TileData {

    private Point position;
    private ETileStates state;

    public TileData( int x, int y ) {
        this.position = new Point( x, y );
        this.state = ETileStates.ETS_NORMAL;
    }

    public void SetState( ETileStates state ) {
        this.state = state;
    }

    public Point GetPosition( ) {
        return this.position;
    }

    public ETileStates GetState( ) {
        return this.state;
    }

}
