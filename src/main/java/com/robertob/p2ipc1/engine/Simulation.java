package com.robertob.p2ipc1.engine;

import com.robertob.p2ipc1.utils.list.DoubleLinkedList;

public class Simulation {
    
    private DoubleLinkedList<Plane> planes = new DoubleLinkedList<>();
    private DoubleLinkedList<LandingTrack> landingTracks = new DoubleLinkedList<>();
    private DoubleLinkedList<ControlStation> controlStations = new DoubleLinkedList<>();
    private DoubleLinkedList<DisembarkStation> disembarkStations = new DoubleLinkedList<>();
    private DoubleLinkedList<MaintenanceStation> maintenanceStations = new DoubleLinkedList<>();

    // Tiempos 
    private int CONSUME_FUEL_TIME;
    private int LANDING_TIME;
    private int DISEMBARKING_TIME;
    private int MAINTENANCE_TIME;
    private int TAKE_OFF_TIME;
    
    public Simulation() {
    }

    public void setTimes(int CONSUME_FUEL_TIME, int LANDING_TIME, int DISEMBARKING_TIME, int MAINTENANCE_TIME, int TAKE_OFF_TIME){
        this.CONSUME_FUEL_TIME = CONSUME_FUEL_TIME;
        this.LANDING_TIME = LANDING_TIME;
        this.DISEMBARKING_TIME = DISEMBARKING_TIME;
        this.MAINTENANCE_TIME = MAINTENANCE_TIME;
        this.TAKE_OFF_TIME = TAKE_OFF_TIME;
    
    }
    
    public DoubleLinkedList<Plane> getPlanes() {
        return planes;
    }

    public DoubleLinkedList<LandingTrack> getLandingTracks() {
        return landingTracks;
    }

    public DoubleLinkedList<ControlStation> getControlStations() {
        return controlStations;
    }

    public void setPlanes(DoubleLinkedList<Plane> planes) {
        this.planes = planes;
    }

    public void setLandingTracks(DoubleLinkedList<LandingTrack> landingTracks) {
        this.landingTracks = landingTracks;
    }

    public void setControlStations(DoubleLinkedList<ControlStation> controlStations) {
        this.controlStations = controlStations;
    }

    public void setDisembarkStations(DoubleLinkedList<DisembarkStation> disembarkStations) {
        this.disembarkStations = disembarkStations;
    }

    public void setMaintenanceStations(DoubleLinkedList<MaintenanceStation> maintenanceStations) {
        this.maintenanceStations = maintenanceStations;
    }

    public void startSimulation() {
        
    }
    
    
    
    
}
