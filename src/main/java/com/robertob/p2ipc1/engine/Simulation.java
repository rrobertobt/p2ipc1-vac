package com.robertob.p2ipc1.engine;

import com.robertob.p2ipc1.frames.MainFrame;
import com.robertob.p2ipc1.utils.list.DoubleLinkedList;
import com.robertob.p2ipc1.utils.list.DoubleLinkedListException;

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
    
    public void prepareSimulation() throws DoubleLinkedListException {
        setSimulationToElements();
    }
    
    public void startThreads() throws DoubleLinkedListException {
        for (int i = 0; i < planes.length(); i++) {
            planes.get(i).start();   
        }
    }
    
    public void setSimulationToElements() throws DoubleLinkedListException {
        for (int i = 0; i < planes.length(); i++) {
            planes.get(i).setCurrentSimulation(this);
        }
        for (int i = 0; i < landingTracks.length(); i++) {
            landingTracks.get(i).setCurrentSimulation(this);
        }
        for (int i = 0; i < controlStations.length(); i++) {
            controlStations.get(i).setCurrentSimulation(this);
        }
        for (int i = 0; i < disembarkStations.length(); i++) {
            disembarkStations.get(i).setCurrentSimulation(this);
        }
        for (int i = 0; i < maintenanceStations.length(); i++) {
            maintenanceStations.get(i).setCurrentSimulation(this);
        }
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

    public DoubleLinkedList<DisembarkStation> getDisembarkStations() {
        return disembarkStations;
    }

    public DoubleLinkedList<MaintenanceStation> getMaintenanceStations() {
        return maintenanceStations;
    }

    public int getCONSUME_FUEL_TIME() {
        return CONSUME_FUEL_TIME;
    }

    public int getLANDING_TIME() {
        return LANDING_TIME;
    }

    public int getDISEMBARKING_TIME() {
        return DISEMBARKING_TIME;
    }

    public int getMAINTENANCE_TIME() {
        return MAINTENANCE_TIME;
    }

    public int getTAKE_OFF_TIME() {
        return TAKE_OFF_TIME;
    }

    public ControlStation searchAvailableTowerStation() throws DoubleLinkedListException {
        ControlStation availableStation = null;
        for (int i = 0; i < controlStations.length(); i++) {
            if (controlStations.get(i).isAvailable()) {
                availableStation = controlStations.get(i);
                break;
            }
        }
        return availableStation;
    }
    
    public DisembarkStation searchAvailableDisembarkStation() throws DoubleLinkedListException{
        DisembarkStation availableStation = null;
        for (int i = 0; i < disembarkStations.length(); i++) {
            if (disembarkStations.get(i).isAvailable()) {
                availableStation = disembarkStations.get(i);
                break;
            }
        }
        return availableStation;
    }
    
    public MaintenanceStation searchAvailableMaintenanceStation() throws DoubleLinkedListException{
        MaintenanceStation avaliableStation = null;
        for (int i = 0; i < maintenanceStations.length(); i++) {
            if (maintenanceStations.get(i).isAvailable()) {
                avaliableStation = maintenanceStations.get(i);
                break;
            }
            
        }
        return avaliableStation;
    }
    
    
    
    
    
    
}
