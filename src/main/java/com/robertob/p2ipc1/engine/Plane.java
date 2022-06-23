package com.robertob.p2ipc1.engine;

public class Plane extends Thread{

    private int planeId;
    private String type;
    private int fuel;
    private Simulation currentSimulation;
    private ControlStation currentControlStation;
    private LandingTrack curreLandingTrack;
    private boolean isFlying;
    private boolean waitingLanding;
    private boolean onTrack;
    private boolean onDisembark;
    private boolean onMaintenance;
    private boolean crashed;

    private Plane(int id, String type, int fuel, Simulation currentSimulation) {
        this.planeId = id;
        this.type = type;
        this.fuel = fuel;
        this.currentSimulation = currentSimulation;
    }

    public Plane(String[] params, Simulation currentSimulation) {
        this(Integer.parseInt(params[0]), params[1], Integer.parseInt(params[2]), currentSimulation);
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

    
    
//    public ControlStation searchAvailableControlStation(){
//        for (int i = 0; i < currentSimulation.getControlStations().length(); i++) {
//            currentSimulation.getControlStations().get(i).isAvailable();
//            
//        }
//        return null;
//    }
    
    public void setIsFlying(){
        this.isFlying = true;
        this.waitingLanding = false;
        this.onTrack = false;
        this.onDisembark = false;
        this.onMaintenance = false;
        this.crashed = false;
    }
    public void setWaitingLanding(){
        this.isFlying = false;
        this.waitingLanding = true;
        this.onTrack = false;
        this.onDisembark = false;
        this.onMaintenance = false;
        this.crashed = false;
    }
    public void setOnTrack(){
        this.isFlying = false;
        this.waitingLanding = false;
        this.onTrack = true;
        this.onDisembark = false;
        this.onMaintenance = false;
        this.crashed = false;
    }
    public void setOnDisembark(){
        this.isFlying = false;
        this.waitingLanding = false;
        this.onTrack = false;
        this.onDisembark = true;
        this.onMaintenance = false;
        this.crashed = false;
    }
    public void setOnMaintenance(){
        this.isFlying = false;
        this.waitingLanding = false;
        this.onTrack = false;
        this.onDisembark = false;
        this.onMaintenance = true;
        this.crashed = false;
    }
    public void setCrashed(){
        this.isFlying = false;
        this.waitingLanding = false;
        this.onTrack = false;
        this.onDisembark = false;
        this.onMaintenance = false;
        this.crashed = true;
    }
    
    
    
    
}
