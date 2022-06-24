package com.robertob.p2ipc1.engine;

import com.robertob.p2ipc1.utils.list.DoubleLinkedList;
import com.robertob.p2ipc1.utils.list.DoubleLinkedListException;

public class DisembarkStation {

    private int id;
    private int maxPlanes;
    private Simulation currentSimulation;
    private Plane currentPlane;
    private DoubleLinkedList<Plane> planesOnDisembarkQueue = new DoubleLinkedList<>();
    
    private DisembarkStation(int id, int maxPlanes){
        this.id = id;
        this.maxPlanes = maxPlanes;
    }
    
    public DisembarkStation(String[] params){
        this(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
    
    }
    
    public void planeDisembarkRequest(Plane plane) throws DoubleLinkedListException{
        planesOnDisembarkQueue.add(plane);
        if (currentPlane == null) {
            currentPlane = planesOnDisembarkQueue.get(0);
        }
    }
    
    public boolean isAvailable(){
        return planesOnDisembarkQueue.length() != maxPlanes;
    }
}
