package com.robertob.p2ipc1.engine;

import com.robertob.p2ipc1.engine.Plane.PLANE_STATE;
import com.robertob.p2ipc1.utils.list.DoubleLinkedListException;
import com.robertob.p2ipc1.utils.list.DoubleLinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlStation {

    private int id;
    private Simulation currentSimulation;
    private int maxPlanes;
    private DoubleLinkedList<Plane> planesOnControlStation = new DoubleLinkedList<>();
    
    
    public boolean isAvailable(){
        return planesOnControlStation.length() != maxPlanes;
    }

    private ControlStation(int id, int maxPlanes) {
        this.id = id;
        this.maxPlanes = maxPlanes;
    }

    public ControlStation(String[] params) {
        this(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
    }
    
    public synchronized boolean planeLandingRequest(Plane plane) {
        if (isAvailable()) {
            /*
            Actualizamos la UI para decirle al usuario que debe seleccionar
            una pista para el avion que se lo esta solicitando
            */
            plane.setPlaneState(PLANE_STATE.WAITING_FOR_TRACK);
            planesOnControlStation.add(plane);
            return true;
        } else {
            return false;
        }
    }
    
    public synchronized void planeLandingAssignation(Plane plane, LandingTrack track) {
        boolean planeAdded = track.addLandingPlaneToTrack(plane);
        if (planeAdded) {
            plane.setCurrentLandingTrack(track);
            /*
            Actualizamos la UI para informar que el avion ya se encuentra en 
            la pista de aterrizaje
            */
        }
    }
    
    public synchronized void planeLandingApproval(Plane plane) {
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

    public synchronized boolean planeTakeOffRequest(Plane plane) {
        if (isAvailable()) {
            plane.setPlaneState(PLANE_STATE.WAITING_TAKEOFF_TRACK);
            return true;
        } else {
            return false;
        }
    }
    
    public synchronized void planeTakeOffAssignation(Plane plane, LandingTrack track){
        boolean planeAdded = track.addTakeOffPlaneToTrack(plane);
        if (planeAdded) {
            plane.setCurrentLandingTrack(track);
        }
    }
    
    public synchronized void planeTakeOffApproval(Plane plane) throws DoubleLinkedListException{
        if (plane.getCurrentLandingTrack().isFirstInLine(plane)) {
            plane.setPlaneState(PLANE_STATE.ON_TAKEOFF_TRACK);
            plane.getCurrentLandingTrack().setCurrentPlane(plane);
            plane.getCurrentLandingTrack().getPlanesOnQueue().removeAtIndex(0);
        }
    }

    public void setCurrentSimulation(Simulation currentSimulation) {
        this.currentSimulation = currentSimulation;
    }

    public int getId() {
        return id;
    }

    public int getMaxPlanes() {
        return maxPlanes;
    }

    public int getConectedPlanes() {
        return planesOnControlStation.length();
    }

    public DoubleLinkedList<Plane> getPlanesOnControlStation() {
        return planesOnControlStation;
    }
    
}
