package com.robertob.p2ipc1.utils.list;

import com.robertob.p2ipc1.engine.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

public class FileHandler {
    
    JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    DoubleLinkedList<Plane> planes = new DoubleLinkedList<>();
    DoubleLinkedList<LandingTrack> landingTracks = new DoubleLinkedList<>();
    DoubleLinkedList<ControlStation> controlStations = new DoubleLinkedList<>();
    DoubleLinkedList<DisembarkStation> disembarkStations = new DoubleLinkedList<>();
    DoubleLinkedList<MaintenanceStation> maintenanceStations = new DoubleLinkedList<>();
    
    
    String planesFileName;
    String tracksFileName;
    String controlStationsFileName;
    String disembarkStationsFileName;
    String maintenanceStationsFileName;
    boolean allFilesLoaded = false;
    
    public void createPlanesFileChooser() throws FileNotFoundException{
        int result = fileChooser.showOpenDialog(null);
        try {
            if (result == JFileChooser.APPROVE_OPTION){
            Scanner scanner = new Scanner(fileChooser.getSelectedFile());
            scanner.useDelimiter("\n");
                if (planes.getFirstNode() != null) {
                    int confirmation = JOptionPane.showConfirmDialog(null, "Ya se ha cargado un archivo previamente, ¿desea sobreescribirlo?", "Sobreescribir archivo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        planes.removeAll();
                        while (scanner.hasNext()) {         
                            Plane plane = new Plane(scanner.next().split(","));
                            planes.add(plane);
                        }
                        planesFileName = fileChooser.getSelectedFile().getName();
                        System.out.println("[LOG] planes length: "+planes.length());
                    }
                } else {
                    while (scanner.hasNext()) {         
                            Plane plane = new Plane(scanner.next().split(","));
                            planes.add(plane);
                        }
                    planesFileName = fileChooser.getSelectedFile().getName();
                    System.out.println("[LOG] planes length: "+planes.length());
                }   
        }
        } catch (Exception e) {
            System.out.println("[LOG] Error: "+e);
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "El archivo cargado no parece ser valido, intente con otro archivo", "Archivo invalido", JOptionPane.ERROR_MESSAGE);
        } 
    }
    public void createTracksFileChooser() throws FileNotFoundException{
        int result = fileChooser.showOpenDialog(null);
        try {
            if (result == JFileChooser.APPROVE_OPTION){
            Scanner scanner = new Scanner(fileChooser.getSelectedFile());
            scanner.useDelimiter("\n");
                if (landingTracks.getFirstNode() != null) {
                    int confirmation = JOptionPane.showConfirmDialog(null, "Ya se ha cargado un archivo previamente, ¿desea sobreescribirlo?", "Sobreescribir archivo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        landingTracks.removeAll();
                        while (scanner.hasNext()) {         
                            LandingTrack landingTrack = new LandingTrack(scanner.next().split(","));
                            landingTracks.add(landingTrack);
                        }
                        tracksFileName = fileChooser.getSelectedFile().getName();
                        System.out.println("[LOG] tracks length: "+landingTracks.length());
                    }
                } else {
                    while (scanner.hasNext()) {         
                            LandingTrack landingTrack = new LandingTrack(scanner.next().split(","));
                            landingTracks.add(landingTrack);
                        }
                    tracksFileName = fileChooser.getSelectedFile().getName();
                    System.out.println("[LOG] tracks length: "+landingTracks.length());
                }   
        }
        } catch (Exception e) {
            System.out.println("[LOG] Error: "+e);
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "El archivo cargado no parece ser valido, intente con otro archivo", "Archivo invalido", JOptionPane.ERROR_MESSAGE);
        } 
    }
    public void createControlStationsFileChooser() throws FileNotFoundException{
        int result = fileChooser.showOpenDialog(null);
        try {
            if (result == JFileChooser.APPROVE_OPTION){
            Scanner scanner = new Scanner(fileChooser.getSelectedFile());
            scanner.useDelimiter("\n");
                if (controlStations.getFirstNode() != null) {
                    int confirmation = JOptionPane.showConfirmDialog(null, "Ya se ha cargado un archivo previamente, ¿desea sobreescribirlo?", "Sobreescribir archivo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        controlStations.removeAll();
                        while (scanner.hasNext()) {         
                            ControlStation controlStation = new ControlStation(scanner.next().split(","));
                            controlStations.add(controlStation);
                        }
                        controlStationsFileName = fileChooser.getSelectedFile().getName();
                        System.out.println("[LOG] control stations length: "+controlStations.length());
                    }
                } else {
                    while (scanner.hasNext()) {         
                            ControlStation controlStation = new ControlStation(scanner.next().split(","));
                            controlStations.add(controlStation);
                        }
                    controlStationsFileName = fileChooser.getSelectedFile().getName();
                    System.out.println("[LOG] control stations length: "+controlStations.length());
                }   
        }
        } catch (Exception e) {
            System.out.println("[LOG] Error: "+e);
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "El archivo cargado no parece ser valido, intente con otro archivo", "Archivo invalido", JOptionPane.ERROR_MESSAGE);
        } 
    }
    public void createDisembarkStationsFileChooser() throws FileNotFoundException{
        int result = fileChooser.showOpenDialog(null);
        try {
            if (result == JFileChooser.APPROVE_OPTION){
            Scanner scanner = new Scanner(fileChooser.getSelectedFile());
            scanner.useDelimiter("\n");
                if (disembarkStations.getFirstNode() != null) {
                    int confirmation = JOptionPane.showConfirmDialog(null, "Ya se ha cargado un archivo previamente, ¿desea sobreescribirlo?", "Sobreescribir archivo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        disembarkStations.removeAll();
                        while (scanner.hasNext()) {         
                            DisembarkStation disembarkStation = new DisembarkStation(scanner.next().split(","));
                            disembarkStations.add(disembarkStation);
                        }
                        disembarkStationsFileName = fileChooser.getSelectedFile().getName();
                        System.out.println("[LOG] disembark stations length: "+disembarkStations.length());
                    }
                } else {
                    while (scanner.hasNext()) {         
                        DisembarkStation disembarkStation = new DisembarkStation(scanner.next().split(","));
                        disembarkStations.add(disembarkStation);
                    }
                    disembarkStationsFileName = fileChooser.getSelectedFile().getName();
                    System.out.println("[LOG] disembark stations length: "+disembarkStations.length());
                }   
        }
        } catch (Exception e) {
            System.out.println("[LOG] Error: "+e);
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "El archivo cargado no parece ser valido, intente con otro archivo", "Archivo invalido", JOptionPane.ERROR_MESSAGE);
        } 
    }
    public void createMaintenanceStationsFileChooser() throws FileNotFoundException{
        int result = fileChooser.showOpenDialog(null);
        try {
            if (result == JFileChooser.APPROVE_OPTION){
            Scanner scanner = new Scanner(fileChooser.getSelectedFile());
            scanner.useDelimiter("\n");
                if (maintenanceStations.getFirstNode() != null) {
                    int confirmation = JOptionPane.showConfirmDialog(null, "Ya se ha cargado un archivo previamente, ¿desea sobreescribirlo?", "Sobreescribir archivo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (confirmation == JOptionPane.YES_OPTION) {
                        maintenanceStations.removeAll();
                        while (scanner.hasNext()) {         
                            MaintenanceStation maintenanceStation = new MaintenanceStation(scanner.next().split(","));
                            maintenanceStations.add(maintenanceStation);
                        }
                        maintenanceStationsFileName = fileChooser.getSelectedFile().getName();
                        System.out.println("[LOG] maintenance stations length: "+maintenanceStations.length());
                    }
                } else {
                    while (scanner.hasNext()) {         
                            MaintenanceStation maintenanceStation = new MaintenanceStation(scanner.next().split(","));
                            maintenanceStations.add(maintenanceStation);
                        }
                    maintenanceStationsFileName = fileChooser.getSelectedFile().getName();
                    System.out.println("[LOG] maintenance stations length: "+maintenanceStations.length());
                }   
        }
        } catch (Exception e) {
            System.out.println("[LOG] Error: "+e);
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "El archivo cargado no parece ser valido, intente con otro archivo", "Archivo invalido", JOptionPane.ERROR_MESSAGE);
        } 
    }

//    String planesFileName;
//    String tracksFileName;
//    String controlStationsFileName;
//    String disembarkStationsFileName;
//    String maintenanceStationsFileName;
//    
    public boolean allFilesLoad(){
        if (planesFileName != null && tracksFileName != null && controlStations != null && disembarkStations != null && maintenanceStations != null) {
            return true;
        }
        return false;
    }
    
    public String getPlanesFileName() {
        return planesFileName;
    }

    public String getTracksFileName() {
        return tracksFileName;
    }

    public String getControlStationsFileName() {
        return controlStationsFileName;
    }

    public String getDisembarkStationsFileName() {
        return disembarkStationsFileName;
    }

    public String getMaintenanceStationsFileName() {
        return maintenanceStationsFileName;
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

    public DoubleLinkedList<DisembarkStation> getDisembarkStations() {
        return disembarkStations;
    }

    public DoubleLinkedList<MaintenanceStation> getMaintenanceStations() {
        return maintenanceStations;
    }
        
    
    
}
