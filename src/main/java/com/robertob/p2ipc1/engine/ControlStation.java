package com.robertob.p2ipc1.engine;

public class ControlStation {

    private int id;
    private Simulation currentSimulation;
    private int maxPlanes;
    private int currentPlanes;
    
    public boolean isAvailable(){
        return currentPlanes != maxPlanes;
    }

    private ControlStation(int id, int maxPlanes) {
        this.id = id;
        this.maxPlanes = maxPlanes;
    }

    public ControlStation(String[] params) {
        this(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
    }
    
    
    
    
    
}
