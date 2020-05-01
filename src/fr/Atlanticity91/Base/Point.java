package fr.Atlanticity91.Base;

public class Point {

    private int x;
    private int y;

    public Point( ) {
        this.x = 0;
        this.y = 0;
    }

    public Point( int scalar ) {
        this.x = scalar;
        this.y = scalar;
    }

    public Point( int x, int y ) {
        this.x = x;
        this.y = y;
    }

    public void Set( int scalar ) {
        this.x = scalar;
        this.y = scalar;
    }

    public void Set( int x, int y ) {
        this.x = x;
        this.y = y;
    }

    public int GetX( ) {
        return this.x;
    }

    public int GetY( ) {
        return this.y;
    }

}
