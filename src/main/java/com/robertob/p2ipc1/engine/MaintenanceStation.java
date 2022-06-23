package com.robertob.p2ipc1.engine;

import com.robertob.p2ipc1.utils.list.DoubleLinkedList;

public class MaintenanceStation {

    private int id;
    private int maxPlanes;
    private boolean isFree;
    private DoubleLinkedList<Plane> planesOnMaintenance = new DoubleLinkedList<>();
}
