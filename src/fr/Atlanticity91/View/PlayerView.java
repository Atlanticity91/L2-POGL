package fr.Atlanticity91.View;

import fr.Atlanticity91.Base.ENotifyEvents;
import fr.Atlanticity91.Base.Point;
import fr.Atlanticity91.Managers.IslaControllerManager;
import fr.Atlanticity91.Managers.IslaModelManager;

/**
 * PlayerView class
 * @author : ALVES Quentin
 * @note : Defined player view code.
 **/
public class PlayerView extends View {

    /**
     * Constructor
     * @author : ALVES Quentin
     * @param models : Current application model manager instance.
     * @param controllers : Current application controller manager instance.
     **/
    public PlayerView( IslaModelManager models, IslaControllerManager controllers ) {
        super( models, controllers );

        controllers.RegisterObserver( "Player", this );

        this.CreateButton( new Point( ), new Point( 128, 32 ), "Turn End !", ENotifyEvents.ENE_TURN_END );
    }

}
