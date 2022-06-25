package com.robertob.p2ipc1.engine;

import java.util.Random;

public class Plane extends Thread{

    private int planeId;
    private String type;
    private int fuel;
    private int maxFuel;
    private int passengers;
    private Simulation currentSimulation;
    private ControlStation currentControlStation;
    private LandingTrack currentLandingTrack;
    private DisembarkStation currentDisembarkStation;
    private MaintenanceStation currentMaintenanceStation;
    
    public enum PLANE_STATE{
        FLYING, WAITING_FOR_TRACK, WAITING_LANDING, ON_TRACK, WAITING_DISEMBARK, ON_DISEMBARK, WAITING_MAINTENANCE, ON_MAINTENANCE, WAITING_TAKEOFF_TRACK, WAITING_TAKEOFF, ON_TAKEOFF_TRACK, CRASHED
    };
    
    private PLANE_STATE planeState;

    private Plane(int id, String type, int fuel) {
        Random rn = new Random();
        this.planeId = id;
        this.type = type;
        this.fuel = fuel;
        this.maxFuel = fuel;
        
        if (this.type.equals("pequeño")) {
            passengers = rn.nextInt((10-5)+1)+5;
        } else if (this.type.equals("mediano")) {
            passengers = rn.nextInt((25-15)+1)+15;
        } else if (this.type.equals("grande")) {
            passengers = rn.nextInt((40-30)+1)+30;
        }
        
    }

    public Plane(String[] params) {
        this(Integer.parseInt(params[0]), params[1], Integer.parseInt(params[2]));
    }

    @Override
    public void run(){
        try {
            while (planeState != PLANE_STATE.CRASHED) {
                if (this.planeState != PLANE_STATE.ON_TRACK || 
                        this.planeState != PLANE_STATE.ON_DISEMBARK || 
                        this.planeState != PLANE_STATE.ON_MAINTENANCE ||
                        this.planeState != PLANE_STATE.WAITING_DISEMBARK ||
                        this.planeState != PLANE_STATE.WAITING_MAINTENANCE) {
                    fly();
                }
                if (this.planeState != PLANE_STATE.WAITING_FOR_TRACK) {
                    ControlStation availableStation = currentSimulation.searchAvailableTowerStation();
                    this.currentControlStation = availableStation;
                    if (this.currentControlStation != null) {
                        this.currentControlStation.planeLandingRequest(this);
                    }                    
                }
                if (this.planeState == PLANE_STATE.ON_TRACK) {
                    sleep(this.currentSimulation.getLANDING_TIME());
                    this.currentControlStation = null;
                    DisembarkStation availableStation = currentSimulation.searchAvailableDisembarkStation();
                    if (availableStation != null) {
                        availableStation.planeDisembarkRequest(this);
                        this.currentLandingTrack.freeTrack();   
                    }
                    
                }
                if (this.planeState == PLANE_STATE.WAITING_DISEMBARK) {
                    this.currentDisembarkStation.askForDisembark(this);
                }
                if (this.planeState == PLANE_STATE.ON_DISEMBARK) {
                    sleep(this.currentSimulation.getDISEMBARKING_TIME()*passengers);
                    this.currentDisembarkStation.setCurrentPlane(null);
                    MaintenanceStation availableStation = currentSimulation.searchAvailableMaintenanceStation();
                    if (availableStation != null) {
                        availableStation.planeMaintenanceRequest(this);
                    }
                }
                if (this.planeState == PLANE_STATE.ON_MAINTENANCE){
                    sleep(this.currentSimulation.getMAINTENANCE_TIME());
                    ControlStation availableStation = currentSimulation.searchAvailableTowerStation();
                    if (availableStation != null){
                        availableStation.planeTakeOffRequest(this);
                    }
                }
                if (this.planeState == PLANE_STATE.ON_TAKEOFF_TRACK) {
                    sleep(this.currentSimulation.getTAKE_OFF_TIME());
                    this.setPlaneState(PLANE_STATE.FLYING);
                    this.currentLandingTrack.freeTrack();
                }
                
                
                // Comunicarse con una torre para solicitar pista para despegue
                // Esperar pista asignada y autorizacion para despegar
                
            }
        } catch (Exception e) {
            // Actualizar la UI porque hubo un error
        }
    }
    
    public void fly() throws InterruptedException{
        sleep(this.currentSimulation.getCONSUME_FUEL_TIME());
        this.fuel--;
    
    }
    
    public int getPlaneId() {
        return planeId;
    }

    public String getType() {
        return type;
    }

    public int getFuel() {
        return fuel;
    }

    public LandingTrack getCurrentLandingTrack() {
        return currentLandingTrack;
    }
    
    public void setPlaneState(PLANE_STATE planeState) {
        this.planeState = planeState;
    }

    public void setCurrentLandingTrack(LandingTrack currentLandingTrack) {
        this.currentLandingTrack = currentLandingTrack;
    }

    public void setCurrentDisembarkStation(DisembarkStation currentDisembarkStation) {
        this.currentDisembarkStation = currentDisembarkStation;
    }

    public void setCurrentMaintenanceStation(MaintenanceStation currentMaintenanceStation) {
        this.currentMaintenanceStation = currentMaintenanceStation;
    }
    
}
