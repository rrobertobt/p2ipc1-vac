package com.robertob.p2ipc1.engine;

import com.robertob.p2ipc1.utils.list.DoubleLinkedList;

public class LandingTrack {

    private int id;
    private int maxPlanes;
    private boolean isFree;
    private DoubleLinkedList<Plane> planesOnTrack = new DoubleLinkedList<>();
    
}
