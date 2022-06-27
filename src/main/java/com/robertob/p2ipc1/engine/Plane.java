package com.robertob.p2ipc1.engine;

import java.util.Random;
import javax.swing.text.html.HTML;

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
        this.planeState = PLANE_STATE.FLYING;
        try {
            while (planeState != PLANE_STATE.CRASHED) {
                if (this.planeState != PLANE_STATE.ON_TRACK || 
                        this.planeState != PLANE_STATE.ON_DISEMBARK || 
                        this.planeState != PLANE_STATE.ON_MAINTENANCE ||
                        this.planeState != PLANE_STATE.WAITING_DISEMBARK ||
                        this.planeState != PLANE_STATE.WAITING_MAINTENANCE) {
                    fly();
                }
                if (this.planeState != PLANE_STATE.WAITING_FOR_TRACK &&
                        this.planeState != PLANE_STATE.WAITING_LANDING && 
                        this.planeState != PLANE_STATE.ON_TRACK &&
                        this.planeState != PLANE_STATE.ON_DISEMBARK &&
                        this.planeState != PLANE_STATE.ON_MAINTENANCE
                    ) {
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
                    this.fuel = this.maxFuel;
                    this.currentLandingTrack.freeTrack();
                }              
            }
        } catch (Exception e) {
            // Actualizar la UI porque hubo un error
        }
    }
    
    public void fly() throws InterruptedException{
        if (fuel == 0) {
            this.planeState = PLANE_STATE.CRASHED;
        } else {
            sleep(this.currentSimulation.getCONSUME_FUEL_TIME());
            this.fuel--;
        }
    }
    
    public String[] toTableFormat() {
        String id = null, state = null, track = null, controlStation = null, fuel = null;
        id = String.valueOf(this.planeId);
        fuel = String.valueOf(this.fuel);
        if (this.currentLandingTrack != null) {track = String.valueOf(this.currentLandingTrack.getId());} else {controlStation = "Ninguno";}
        if (this.currentControlStation != null) {controlStation = String.valueOf(this.currentControlStation.getId());} else {track = "Ninguno";}
        
        if (planeState == PLANE_STATE.CRASHED) {state = "Estrellado";}
        else if (planeState == PLANE_STATE.FLYING){state = "Volando";}
        else if (planeState == PLANE_STATE.ON_DISEMBARK){state = "Desabordando";}
        else if (planeState == PLANE_STATE.ON_MAINTENANCE){state = "Mantenimiento";}
        else if (planeState == PLANE_STATE.ON_TAKEOFF_TRACK){state = "En pista";}
        else if (planeState == PLANE_STATE.ON_TRACK){state = "En pista";}
        else if (planeState == PLANE_STATE.WAITING_DISEMBARK){state = "Esperando desabordaje";}
        else if (planeState == PLANE_STATE.WAITING_FOR_TRACK){state = "Esperando pista";}
        else if (planeState == PLANE_STATE.WAITING_LANDING){state = "Esperando aterrizaje";}
        else if (planeState == PLANE_STATE.WAITING_MAINTENANCE){state = "Esperando mantenimiento";}
        else if (planeState == PLANE_STATE.WAITING_TAKEOFF){state = "Esperando despegue";}
        else if (planeState == PLANE_STATE.WAITING_TAKEOFF_TRACK){state = "Esperando pista";}
        return new String[]{id, state, track, controlStation, fuel};
    }
    
    public String[] toAlternateTableFormat(){
        String id = null, state = null;
        id = String.valueOf(this.planeId);
        if (planeState == PLANE_STATE.CRASHED) {state = "Estrellado";}
        else if (planeState == PLANE_STATE.FLYING){state = "Volando";}
        else if (planeState == PLANE_STATE.ON_DISEMBARK){state = "Desabordando";}
        else if (planeState == PLANE_STATE.ON_MAINTENANCE){state = "Mantenimiento";}
        else if (planeState == PLANE_STATE.ON_TAKEOFF_TRACK){state = "En pista";}
        else if (planeState == PLANE_STATE.ON_TRACK){state = "En pista";}
        else if (planeState == PLANE_STATE.WAITING_DISEMBARK){state = "Esperando desabordaje";}
        else if (planeState == PLANE_STATE.WAITING_FOR_TRACK){state = "Esperando pista";}
        else if (planeState == PLANE_STATE.WAITING_LANDING){state = "Esperando aterrizaje";}
        else if (planeState == PLANE_STATE.WAITING_MAINTENANCE){state = "Esperando mantenimiento";}
        else if (planeState == PLANE_STATE.WAITING_TAKEOFF){state = "Esperando despegue";}
        else if (planeState == PLANE_STATE.WAITING_TAKEOFF_TRACK){state = "Esperando pista";}
        return new String[]{id, state};
    }

    public void setCurrentSimulation(Simulation currentSimulation) {
        this.currentSimulation = currentSimulation;
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

    public PLANE_STATE getPlaneState() {
        return planeState;
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
