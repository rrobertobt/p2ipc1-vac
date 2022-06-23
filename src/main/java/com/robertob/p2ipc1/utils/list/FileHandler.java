package com.robertob.p2ipc1.utils.list;

import com.robertob.p2ipc1.engine.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class FileHandler {
    
    JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    
    public void openFileChooser() throws FileNotFoundException{
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION){
            Scanner scanner = new Scanner(fileChooser.getSelectedFile());
            scanner.useDelimiter("\n");
            DoubleLinkedList<Plane> planes = new DoubleLinkedList<>();

            while (scanner.hasNext()) {         
                Plane plane = new Plane(scanner.next().split(","), null);
                planes.add(plane);
            }
            System.out.println(planes.length());
        }
    }
        
    
}
