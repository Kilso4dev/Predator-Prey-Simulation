package de.Kilso4dev.predatorPreySimulation;

import de.Kilso4dev.predatorPreySimulation.window.FrameCore;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    public static void main(String[] args) {
        FrameCore mainWindow = new FrameCore();
        mainWindow.setTitle("Simulation: Räuber-Beute-Beziehung - " + SimulationConstants.VERSION);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainWindow.setBounds((int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth()) - 950) /2,
                (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() -700) /2,
                950, 700 );
        mainWindow.setResizable(false);//change from false to true?
        mainWindow.setVisible(true);
    }
}