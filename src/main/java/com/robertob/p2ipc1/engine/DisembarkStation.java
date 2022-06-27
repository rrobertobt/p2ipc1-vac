package com.robertob.p2ipc1.engine;

import com.robertob.p2ipc1.utils.list.DoubleLinkedList;
import com.robertob.p2ipc1.utils.list.DoubleLinkedListException;

public class DisembarkStation {

    private int id = 0;
    private int maxPlanes;
    private Simulation currentSimulation;
    private Plane currentPlane;
    private DoubleLinkedList<Plane> planesOnDisembarkQueue = new DoubleLinkedList<>();
    
    private DisembarkStation(int id, int maxPlanes){
        this.id = id;
        this.maxPlanes = maxPlanes;
    }
    
    public DisembarkStation(String[] params){
        this(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
    
    }
    
    public void planeDisembarkRequest(Plane plane) throws DoubleLinkedListException{
        planesOnDisembarkQueue.add(plane);
        plane.setCurrentDisembarkStation(this);
        if (currentPlane == null) {
            currentPlane = planesOnDisembarkQueue.get(0);
            plane.setPlaneState(Plane.PLANE_STATE.ON_DISEMBARK);
            planesOnDisembarkQueue.removeAtIndex(0);
        } else {
            plane.setPlaneState(Plane.PLANE_STATE.WAITING_DISEMBARK);
        }
    }
    
    public void askForDisembark(Plane plane) throws DoubleLinkedListException{
        if (plane.getPlaneId() == planesOnDisembarkQueue.get(0).getPlaneId()){
            if (currentPlane == null) {
                currentPlane = planesOnDisembarkQueue.get(0);
                plane.setPlaneState(Plane.PLANE_STATE.ON_DISEMBARK);
                planesOnDisembarkQueue.removeAtIndex(0);
            }
        }
        
    }
    
    public String[] toTableFormat(){
        String currentId = this.id == 0 ? "" : String.valueOf(this.id);
        String planeId = this.currentPlane == null ? "" : String.valueOf(this.currentPlane.getPlaneId());
        return new String[]{currentId,planeId};
    }
    
    public boolean isAvailable(){
        return planesOnDisembarkQueue.length() != maxPlanes;
    }

    public void setCurrentPlane(Plane currentPlane) {
        this.currentPlane = currentPlane;
    }

    public void setCurrentSimulation(Simulation currentSimulation) {
        this.currentSimulation = currentSimulation;
    }
}

