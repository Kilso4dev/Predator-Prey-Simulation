package de.Kilso4dev.predatorPreySimulation.window;

import de.Kilso4dev.predatorPreySimulation.SimulationConstants;
import de.Kilso4dev.predatorPreySimulation.core.SimulationCore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// TODO: Add A Testarea with a JScrollPane named outputArea to display the output of every Run/ Generation //ok
public class FrameCore extends JFrame {

    private SimulationCore simulationCore;
    private Container cMainWindow;
    private JPanel headlineMenu;
    private JButton generationRandom;
    private JButton fieldRandom;
    private JButton animalsRandom;
    private JButton abbruchButton;
    private JButton startButton;
    private JButton closeButton;
    private JSpinner    generationInput, fieldInput, preyInput, predatorInput;
    private final Font fAll = new Font("Times New Roman", Font.PLAIN, 17);

    public FrameCore() {
        cMainWindow = getContentPane();
        cMainWindow.setLayout(null);
        createHeadline();
        createBottomLine();
        abbruchButton = new JButton("Abbruch");
    }

    private void createBottomLine() {
        abbruchButton = new JButton("Abbruch");
        abbruchButton.setBounds(540, 620, 120, 30);
        abbruchButton.setVisible(true);
        abbruchButton.setEnabled(false);
        abbruchButton.setFont(fAll);
        abbruchButton.setActionCommand("bCancelPressed");
        abbruchButton.addActionListener(new ButtonListener());
        cMainWindow.add(abbruchButton);

        abbruchButton = new JButton("Start");
        abbruchButton.setBounds(670, 620, 120, 30);
        abbruchButton.setVisible(true);
        abbruchButton.setFont(fAll);
        abbruchButton.setActionCommand("bStartPressed");
        abbruchButton.addActionListener(new ButtonListener());
        cMainWindow.add(abbruchButton);

        abbruchButton = new JButton("Schließen");
        abbruchButton.setBounds(800, 620, 120, 30);
        abbruchButton.setVisible(true);
        abbruchButton.setFont(fAll);
        abbruchButton.setActionCommand("bClosePressed");
        abbruchButton.addActionListener(new ButtonListener());
        cMainWindow.add(abbruchButton);

    }

    private void createHeadline() {
        headlineMenu = new JPanel(null);
        headlineMenu.setBounds(0, 0, 950, 130);
        headlineMenu.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        createGenerations();
        createFieldSize();
        createAnimals();
        headlineMenu.setVisible(true);
        cMainWindow.add(headlineMenu);
    }

    private void createAnimals() {
        JLabel animalInfo = new JLabel("Spielsteinauswahl:");
        animalInfo.setBounds(600, 5, 250, 49);
        animalInfo.setVisible(true);
        animalInfo.setFont(fAll);
        headlineMenu.add(animalInfo);

        JLabel preyInfo = new JLabel("Beute:");
        preyInfo.setBounds(600, 59, 60, 30);
        preyInfo.setVisible(true);
        preyInfo.setFont(fAll);
        headlineMenu.add(preyInfo);

        JLabel predatorInfo = new JLabel("Räuber:");
        predatorInfo.setBounds(600, 89, 60, 30);
        predatorInfo.setVisible(true);
        predatorInfo.setFont(fAll);
        headlineMenu.add(predatorInfo);

        preyInput = new JSpinner(new SpinnerNumberModel(8, 0, Integer.MAX_VALUE, 1));
        preyInput.setBounds(675, 59, 60, 30);
        preyInput.setVisible(true);
        preyInput.setFont(fAll);
        headlineMenu.add(preyInput);

        predatorInput = new JSpinner(new SpinnerNumberModel(8, 0, Integer.MAX_VALUE, 1));
        predatorInput.setBounds(675, 89, 60, 30);
        predatorInput.setVisible(true);
        predatorInput.setFont(fAll);
        headlineMenu.add(predatorInput);

        animalsRandom = new JButton("Zufällige Steine");
        animalsRandom.setBounds(750, 59, 150, 60);
        animalsRandom.setVisible(true);
        animalsRandom.setFont(fAll);
        animalsRandom.setActionCommand("bRandomPreysPredatorsPressed");
        animalsRandom.addActionListener(new ButtonListener());
        headlineMenu.add(animalsRandom);
    }

    private void createFieldSize() {
        JLabel fieldInfo = new JLabel("Spielfeldgröße (quadratisch):");
        fieldInfo.setBounds(300, 5, 250, 49);
        fieldInfo.setVisible(true);
        fieldInfo.setFont(fAll);
        headlineMenu.add(fieldInfo);

        fieldInput = new JSpinner(new SpinnerNumberModel(6, 0, Integer.MAX_VALUE, 1));
        fieldInput.setBounds(300, 59, 60, 30);
        fieldInput.setVisible(true);
        fieldInput.setFont(fAll);
        headlineMenu.add(fieldInput);

        fieldRandom = new JButton("Zufällige Größe");
        fieldRandom.setBounds(370, 59, 150, 30);
        fieldRandom.setVisible(true);
        fieldRandom.setFont(fAll);
        fieldRandom.setActionCommand("bRandomFieldPressed");
        fieldRandom.addActionListener(new ButtonListener());
        headlineMenu.add(fieldRandom);
    }

    private void createGenerations() {
        JLabel generationInfo = new JLabel("Anzahl der Generationen:");
        generationInfo.setBounds(20, 5, 250, 49);
        generationInfo.setVisible(true);
        generationInfo.setFont(fAll);
        headlineMenu.add(generationInfo);


        generationInput = new JSpinner(new SpinnerNumberModel(100, 0, Integer.MAX_VALUE, 10));
        generationInput.setBounds(20, 59, 60, 30);
        generationInput.setVisible(true);
        generationInput.setFont(fAll);
        headlineMenu.add(generationInput);

        generationRandom = new JButton("Zufällige Anzahl");
        generationRandom.setBounds(90, 59, 150, 30);
        generationRandom.setVisible(true);
        generationRandom.setFont(fAll);
        generationRandom.setActionCommand("bRandomAmountPressed");
        generationRandom.addActionListener(new ButtonListener());
        headlineMenu.add(generationRandom);
    }



    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equals("bCancelPressed")) {
                if (simulationCore != null) {
                    simulationCore.interruptSimulation();
                }

            } else if (e.getActionCommand().equals("bClosePressed")) {
                if (simulationCore != null) {
                    simulationCore.interruptSimulation();
                }
                dispose();

            } else if (e.getActionCommand().equals("bStartPressed")) {
                //int xgrid = Integer.parseInt()
            } else if (e.getActionCommand().equals("bRandomPreysPredatorsPressed")) {

            } else if (e.getActionCommand().equals("bRandomFieldPressed")) {

            } else if (e.getActionCommand().equals("bRandomAmountPressed")) {

            }
        }
    }
}
