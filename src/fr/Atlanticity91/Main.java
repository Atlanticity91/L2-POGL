package fr.Atlanticity91;

import java.awt.*;

/**
 * Main class
 * @author : ALVES Quentin
 * @note : Class to wrap program entry point.
 **/
public class Main {

    /**
     * main method
     * @author : ALVES Quentin
     * @note : Program main method.
     * @param args : Array of arguments passed to the program.
     **/
    public static void main( String args[ ] ) {

        EventQueue.invokeLater( ( ) -> { IslaApp app = new IslaApp( ); } );

    }

}
