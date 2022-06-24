package com.robertob.p2ipc1.engine;

import com.robertob.p2ipc1.utils.list.DoubleLinkedList;

public class LandingTrack {

    private int id;
    private int maxPlanes;
    private boolean isFree;
    private DoubleLinkedList<Plane> planesOnTrack = new DoubleLinkedList<>();
    private Simulation currentSimulation;

    private LandingTrack(int id, int maxPlanes) {
        this.id = id;
        this.maxPlanes = maxPlanes;
    }

    public LandingTrack(String[] params) {
        this(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
    }
    
    
    
    
    
}
