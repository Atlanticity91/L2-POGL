package fr.Atlanticity91.Base;

/**
 * Observer interface
 * @author : ALVES Quentin
 * @note : Defined interface for Observer implementation.
 **/
public interface Observer {

    /**
     * Notify method
     * @author : ALVES Quentin
     * @note : Notify the current observer of an event.
     * @param event : The event to dispatch.
     **/
    public void Notify( ENotifyEvents event );

}
