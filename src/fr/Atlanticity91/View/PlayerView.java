package fr.Atlanticity91.View;

import fr.Atlanticity91.Base.ENotifyEvents;
import fr.Atlanticity91.Controller.Controller;
import fr.Atlanticity91.Managers.IslaControllerManager;
import fr.Atlanticity91.Managers.IslaModelManager;

import javax.swing.*;

public class PlayerView extends View {

    public PlayerView(IslaModelManager models, IslaControllerManager controllers ) {
        super( models, controllers );

        controllers.RegisterObserver( "Player", this );

        JButton turn_end = new JButton("Turn End !" );
        turn_end.addActionListener( e -> { this.GetControllers( ).NotifyAll( ENotifyEvents.ENE_TURN_END ); } );
        this.add( turn_end );
    }

    @Override
    public void Notify( ENotifyEvents event ) {
        if ( event == ENotifyEvents.ENE_REPAINT )
            repaint( );
    }

}
