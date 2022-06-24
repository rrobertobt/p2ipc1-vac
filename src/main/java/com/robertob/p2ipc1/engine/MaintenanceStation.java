package com.robertob.p2ipc1.engine;

import com.robertob.p2ipc1.utils.list.DoubleLinkedList;

public class MaintenanceStation {

    private int id;
    private int maxPlanes;
    private DoubleLinkedList<Plane> planesOnMaintenance = new DoubleLinkedList<>();

    private MaintenanceStation(int id, int maxPlanes) {
        this.id = id;
        this.maxPlanes = maxPlanes;
    }
    
    public MaintenanceStation(String[] params){
        this(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
    }
    
    public boolean isAvailable(){
        return maxPlanes != planesOnMaintenance.length();
    }
    
    
}


