package com.robertob.p2ipc1.engine;

import com.robertob.p2ipc1.utils.list.DoubleLinkedList;
import com.robertob.p2ipc1.utils.list.DoubleLinkedListException;

public class MaintenanceStation {

    private int id = 0;
    private int maxPlanes;
    private Simulation currentSimulation;
    private Plane currentPlane;
    private DoubleLinkedList<Plane> planesOnMaintenanceQueue = new DoubleLinkedList<>();

    private MaintenanceStation(int id, int maxPlanes) {
        this.id = id;
        this.maxPlanes = maxPlanes;
    }
    
    public MaintenanceStation(String[] params){
        this(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
    }
    
    public boolean isAvailable(){
        return maxPlanes != planesOnMaintenanceQueue.length();
    }
    
    public void planeMaintenanceRequest(Plane plane) throws DoubleLinkedListException{
        planesOnMaintenanceQueue.add(plane);
        plane.setCurrentMaintenanceStation(this);
        if (currentPlane == null) {
            currentPlane = planesOnMaintenanceQueue.get(0);
            plane.setPlaneState(Plane.PLANE_STATE.ON_MAINTENANCE);
        } else {
            plane.setPlaneState(Plane.PLANE_STATE.WAITING_MAINTENANCE);
        }   
    }
    
    public void askForMaintenance(Plane plane) throws DoubleLinkedListException{
        if (plane.getPlaneId() == planesOnMaintenanceQueue.get(0).getPlaneId()) {
            if (currentPlane == null) {
                currentPlane = planesOnMaintenanceQueue.get(0);
                plane.setPlaneState(Plane.PLANE_STATE.ON_MAINTENANCE);
                planesOnMaintenanceQueue.removeAtIndex(0);
            }
        }
    }
    
    public String[] toTableFormat(){
        String currentId = this.id == 0 ? "" : String.valueOf(this.id);
        String planeId = this.currentPlane == null ? "" : String.valueOf(this.currentPlane.getPlaneId());
        
        return new String[]{currentId,planeId};
    }

    public void setCurrentSimulation(Simulation currentSimulation) {
        this.currentSimulation = currentSimulation;
    }

    public int getId() {
        return id;
    }

    public DoubleLinkedList<Plane> getPlanesOnMaintenanceQueue() {
        return planesOnMaintenanceQueue;
    }
}


