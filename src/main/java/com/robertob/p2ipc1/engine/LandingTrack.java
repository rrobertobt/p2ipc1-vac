package com.robertob.p2ipc1.engine;

import com.robertob.p2ipc1.utils.list.DoubleLinkedList;
import com.robertob.p2ipc1.utils.list.DoubleLinkedListException;

public class LandingTrack {

    private int id;
    private int maxPlanes;
    private DoubleLinkedList<Plane> planesOnQueue = new DoubleLinkedList<>();
    private Simulation currentSimulation;
    private Plane currentPlane;

    private LandingTrack(int id, int maxPlanes) {
        this.id = id;
        this.maxPlanes = maxPlanes;
    }

    public int getId() {
        return id;
    }

    public LandingTrack(String[] params) {
        this(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
    }

    public void setCurrentPlane(Plane currentPlane) {
        this.currentPlane = currentPlane;
    }   
    
    public boolean isTrackFull() {
        return planesOnQueue.length() == maxPlanes;
    }
    
    public boolean addLandingPlaneToTrack(Plane plane) {
        if (isTrackFull()) {
            return false;
        } else {
            plane.setPlaneState(Plane.PLANE_STATE.WAITING_LANDING);
            planesOnQueue.add(plane);
            return true;
        }
    }
    
    public boolean addTakeOffPlaneToTrack(Plane plane) {
        if (isTrackFull()) {
            return false;
        } else {
            plane.setPlaneState(Plane.PLANE_STATE.WAITING_TAKEOFF);
            planesOnQueue.add(plane);
            return true;
        }
    }
    
    public boolean isFirstInLine(Plane plane) throws DoubleLinkedListException {
        return planesOnQueue.get(0).getPlaneId() == plane.getPlaneId();
    }

    public void freeTrack(){
        currentPlane = null;
    }
    
    public DoubleLinkedList<Plane> getPlanesOnQueue() {
        return planesOnQueue;
    }

    public void setCurrentSimulation(Simulation currentSimulation) {
        this.currentSimulation = currentSimulation;
    }
}
