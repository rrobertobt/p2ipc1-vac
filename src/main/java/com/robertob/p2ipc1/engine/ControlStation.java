package com.robertob.p2ipc1.engine;

import com.robertob.p2ipc1.engine.Plane.PLANE_STATE;
import com.robertob.p2ipc1.utils.list.DoubleLinkedListException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlStation {

    private int id;
    private Simulation currentSimulation;
    private int maxPlanes;
    private int currentPlanes;
    
    public boolean isAvailable(){
        return currentPlanes != maxPlanes;
    }

    private ControlStation(int id, int maxPlanes) {
        this.id = id;
        this.maxPlanes = maxPlanes;
    }

    public ControlStation(String[] params) {
        this(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
    }
    
    public boolean planeLandingRequest(Plane plane) {
        if (isAvailable()) {
            /*
            Actualizamos la UI para decirle al usuario que debe seleccionar
            una pista para el avion que se lo esta solicitando
            */
            plane.setPlaneState(PLANE_STATE.WAITING_LANDING);
            return true;
        } else {
            return false;
        }
    }
    
    public void planeLandingAssignation(Plane plane, LandingTrack track) {
        boolean planeAdded = track.addPlaneToTrack(plane);
        if (planeAdded) {
            plane.setCurrentLandingTrack(track);
            /*
            Actualizamos la UI para informar que el avion ya se encuentra en 
            la pista de aterrizaje
            */
        }
    }
    
    public void planeLandingApproval(Plane plane) {
        try {
            if (plane.getCurrentLandingTrack().isFirstInLine(plane)) {
                plane.setPlaneState(PLANE_STATE.ON_TRACK);
                plane.getCurrentLandingTrack().setCurrentPlane(plane);
                plane.getCurrentLandingTrack().getPlanesOnQueue().removeAtIndex(0);
                /*
                Actualizar la UI con la lista de aviones y sus estados actuales
                y las pistas
                */
            }
        } catch (DoubleLinkedListException ex) {
            
        }
    }
}
