package com.robertob.p2ipc1.engine;

public class ControlStation {

    private int id;
    private Simulation currentSimulation;
    private int maxPlanes;
    private int currentPlanes;
    
    public boolean isAvailable(){
        return currentPlanes != maxPlanes;
    }
    
    
}
