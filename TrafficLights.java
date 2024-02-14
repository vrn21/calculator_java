import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TrafficLights extends JFrame implements ActionListener{
  JFrame frm;
  JRadioButton b0,b1;
  JButton disp;
  //JButtonGroup bgrp;
  JLabel lb;
  TrafficLights(){
    frm = new JFrame("random");
    frm.setSize(800,800);
    frm.setLayout(new FlowLayout());
    b0 = new JRadioButton("0");
    b1 = new JRadioButton("1");
    disp = new JButton("Display!");
    //rbg = new JRadioButton("GO");
    //bgrp.add(b0);
    //bgrp.add(b1);
    //bgrp.add(rbg);
    frm.add(b0);
    frm.add(b1);
    frm.add(disp);
    b0.addActionListener(this);
    b1.addActionListener(this);
    disp.addActionListener(this);
    lb = new JLabel("");
    frm.add(lb);
    lb.setVisible(false);
    frm.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent ae){
    System.out.println(ae.getSource() == disp);
    if(ae.getSource() == disp){
      //frm.add(lb);
      lb.setVisible(true);
     if (b0.isSelected() && b1.isSelected()){
       lb.setText("3");
     }else if (b0.isSelected() && !b1.isSelected()){
       lb.setText("2");
     }else if (!b0.isSelected() && b1.isSelected()){
       lb.setText("1");
     }else if (!b0.isSelected() && !b1.isSelected()){
       lb.setText("0");
     }
    }
    else{
      if (b0.isSelected() && b1.isSelected()){
         lb.setText("3");
       }else if (b0.isSelected() && !b1.isSelected()){
        lb.setText("2");
       }else if (!b0.isSelected() && b1.isSelected()){
        lb.setText("1");
       }else if (!b0.isSelected() && !b1.isSelected()){
        lb.setText("0");


      }
    }
  }

  public static void main(String[] args) {
    new TrafficLights();
  }
}
