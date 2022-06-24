package com.robertob.p2ipc1.engine;

import com.robertob.p2ipc1.utils.list.DoubleLinkedList;

public class DisembarkStation {

    private int id;
    private int maxPlanes;
    private boolean isFree;
    private DoubleLinkedList<Plane> planesOnDisembark = new DoubleLinkedList<>();
    
    private DisembarkStation(int id, int maxPlanes){
        this.id = id;
        this.maxPlanes = maxPlanes;
    }
    
    public DisembarkStation(String[] params){
        this(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
    
    }
}
