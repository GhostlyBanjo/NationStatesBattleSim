package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Forrest on 2/28/2015.
 */
public class SimulatorScreen {
    private  static JLabel background=new JLabel(new ImageIcon("imgs/For Sadia!.jpeg"));
    public static JFrame simFrame;
    private Simulation simulation;
    private JTextField t1Name;
    private JLabel team1;
    private JLabel team2;
    private JTextField t2Name;
    private JLabel team1Size;
    private JTextField t1SizeInput;
    private JLabel t2SizeInput;
    private JTextField t2ForceCount;
    private JPanel panel1;
    private JButton runButton;
    private JPanel outputPane;
    private JLabel teamOneMorale;
    private JTextField t1MoraleInput;
    private JSlider t1Tech;
    private JSlider t1TR;
    private JLabel t1labels;
    private JLabel eff;
    private JLabel nword;
    private JLabel ugh;
    private JLabel teamOneIntelLabel;
    private JTextField t2Morale;
    private JLabel no;
    private JLabel noMoreVariablesplz;
    private JLabel cantSayTheNWord;
    private JSlider t2Tech;
    private JSlider  t2TR;
    private JSlider  t2CE;
    private JSlider  t2L;
    private JSlider  t2I;
    private JLabel notavirus;
    private JLabel noplzno;
    private JLabel plzgo;
    private JPanel inputPanel;
    private JTabbedPane tabbedPane;
    private JPanel outputPanel;
    private JTextArea outputArea;
    private JSlider t1CE;
    private JSlider t1L;
    private JSlider t1I;
    private JButton resetButton;
    private JComboBox homeTeam;
    private JButton Example;
    private JPanel optinonPanel;
    private JButton enableSadStatesModeButton;
    private JToolBar toolBar;
    private int homeTeamVal = 0;

    public SimulatorScreen() {


        toolBar.setFloatable(false);
        toolBar.setOpaque(false);


        if(homeTeam.getSelectedItem() == "Team Two")
            homeTeamVal = 1;
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                simulation = new Simulation(new Team(
                        t1Name.getText(),
                        Integer.parseInt(t1SizeInput.getText()),
                        Integer.parseInt(t1MoraleInput.getText()),
                        t1Tech.getValue(),
                        t1TR.getValue(),
                        t1CE.getValue(),
                        t1L.getValue(),
                        t1I.getValue(),
                        true,
                        true)
                        ,new Team(
                        t2Name.getText(),
                        Integer.parseInt(t2ForceCount.getText()),
                        Integer.parseInt(t2Morale.getText()),
                        t2Tech.getValue(),
                        t2TR.getValue(),
                        t2CE.getValue(),
                        t2L.getValue(),
                        t2I.getValue(),
                        true,
                        true),
                        homeTeamVal
                );
                outputArea.setText(simulation.Simulate().toString());
                    JOptionPane.showMessageDialog(null, outputArea.getText());
                }
                catch(NumberFormatException exception){
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Try inputing the right things");
                }
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1CE.setValue(5);
                t1I.setValue(5);
                t1L.setValue(5);
                t1TR.setValue(5);
                t1Tech.setValue(5);
                t2CE.setValue(5);
                t2I.setValue(5);
                t2L.setValue(5);
                t2TR.setValue(5);
                t2Tech.setValue(5);

            }
        });
        Example.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1Name.setText("'Murica");
                t2Name.setText("Anti-'Murica");
                t1Tech.setValue(9);
                t2Tech.setValue(4);
                t1MoraleInput.setText("125");
                t2Morale.setText("100");
                t1SizeInput.setText("200");
                t2ForceCount.setText("100");

            }
        });

        enableSadStatesModeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel1.setBackground(new Color(0,0,0,0));
                toolBar.setBackground(new Color(0,0,0,0));

                inputPanel.add(background);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here


    }

    public static void main(String[] args) {
        simFrame = new JFrame("SimulatorScreen");
        simFrame.setContentPane(new SimulatorScreen().tabbedPane);
        simFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        simFrame.pack();
        simFrame.setVisible(true);

    }

}
