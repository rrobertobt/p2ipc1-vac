package com.robertob.p2ipc1.engine;

import com.robertob.p2ipc1.utils.list.DoubleLinkedList;

public class Simulation {
    
    private DoubleLinkedList<Plane> planes = new DoubleLinkedList<>();
    private DoubleLinkedList<LandingTrack> landingTracks = new DoubleLinkedList<>();
    private DoubleLinkedList<ControlStation> controlStations = new DoubleLinkedList<>();

    public Simulation() {
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
    
    
}
