package fr.Atlanticity91.Base;

/**
 * Point class
 * @author : ALVES Quentin
 * @note : Defined simple 2D point.
 **/
public class Point {

    private int x;
    private int y;

    /**
     * Constructor
     * @author : ALVES Quentin
     **/
    public Point( ) {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Constructor
     * @author : ALVES Quentin
     * @param scalar : Value for x and y.
     **/
    public Point( int scalar ) {
        this.x = scalar;
        this.y = scalar;
    }

    /**
     * Constructor
     * @author : ALVES Quentin
     * @param x : Value for x.
     * @param y : Value for y.
     **/
    public Point( int x, int y ) {
        this.x = x;
        this.y = y;
    }

    /**
     * Set method
     * @author : ALVES Quentin
     * @param scalar : Value for x and y.
     **/
    public void Set( int scalar ) {
        this.x = scalar;
        this.y = scalar;
    }

    /***
     * Set method
     * @author : ALVES Quentin
     * @note : Set point x and y.
     * @param x : Value for x.
     * @param y : Value for y.
     **/
    public void Set( int x, int y ) {
        this.x = x;
        this.y = y;
    }

    /**
     * GetX function
     * @author : ALVES Quentin
     * @note : Get point x value.
     * @return : int
     **/
    public int GetX( ) {
        return this.x;
    }

    /**
     * GetY function
     * @author : ALVES Quentin
     * @note : Get point y value.
     * @return : int
     **/
    public int GetY( ) {
        return this.y;
    }

}
