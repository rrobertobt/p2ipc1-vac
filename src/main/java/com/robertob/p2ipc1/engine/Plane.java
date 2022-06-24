package com.robertob.p2ipc1.engine;

public class Plane extends Thread{

    private int planeId;
    private String type;
    private int fuel;
    private int maxFuel;
    private int passengers;
    private Simulation currentSimulation;
    private ControlStation currentControlStation;
    private LandingTrack currentLandingTrack;
    
    public enum PLANE_STATE{
        FLYING, WAITING_FOR_TRACK, WAITING_LANDING, ON_TRACK, ON_DISEMBARK, ON_MAINTENANCE, CRASHED
    };
    
    private PLANE_STATE planeState;

    private Plane(int id, String type, int fuel) {
        this.planeId = id;
        this.type = type;
        this.fuel = fuel;
        this.maxFuel = fuel;
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
                        this.planeState != PLANE_STATE.ON_MAINTENANCE) {
                    fly();
                }
                
                if (this.planeState != PLANE_STATE.WAITING_LANDING) {
                    ControlStation availableStation = currentSimulation.searchAvailableTowerStation();
                    if (availableStation != null) {
                        availableStation.planeLandingRequest(this);
                    }                    
                }

                if (this.planeState == PLANE_STATE.ON_TRACK) {
                    sleep(3000);
                    // Buscar primera estación disponible
                    DisembarkStation availableStation = currentSimulation.searchAvailableDisembarkStation();
                    if (availableStation != null) {
                        availableStation.planeDisembarkRequest(this);
                    }
                    /*  Pedir a esa estación, añadir el avión a la cola 
                        Si la estación no está desabordando ninugn avión, pasar
                        el que se acaba de agregar a desabordar
                    */



                    // Estacion de desabordaje
                    // Esperar a pasajeros que desaborden
                    // Pasar a una estacion de mantenimiento
                    // Comunicarse con una torre para solicitar pista para despegue
                    // Esperar pista asignada y autorizacion para despegar
                }            
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
}
