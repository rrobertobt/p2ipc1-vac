/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.robertob.p2ipc1;

import com.robertob.p2ipc1.engine.Plane;
import com.robertob.p2ipc1.frames.MainFrame;
import com.robertob.p2ipc1.utils.list.DoubleLinkedList;
import com.robertob.p2ipc1.utils.list.DoubleLinkedListException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author robertob
 */
public class Main{

    public static void main(String[] args) throws FileNotFoundException, DoubleLinkedListException {
  
        System.out.println("[LOG] Iniciando programa");
        new MainFrame().setVisible(true);
        
    }
}
