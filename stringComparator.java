import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class stringComparator implements ActionListener{
  JFrame frm;
  JTextField number;
  JTextField words[];
  JButton bn,bsort;
  JLabel output;

  stringComparator(){
    frm = new JFrame("String comparer");
    frm.setLayout(new GridLayout(3,3));
    number = new JTextField("Enter how many words you want to add");
    bn = new JButton("ADD");
    frm.add(number);
    frm.add(bn);
    bn.addActionListener(this);
  }

   void sortWords(String[] words){
    int n = words.length;
    for(int i = 0; i<n; i++){
      for(int j = i; j<n; j++){
        if (words[i].compareTo(words[j]) > 0){
          String temp = words[i];
          words[i] = words[j];
          words[j] = temp;
        }
      }
    }
    //return words;

  }

  public void actionPerformed(ActionEvent ae){
    int n = Integer.parseInt(number.getText());
    if (ae.getSource() == bn) {
      words = new JTextField[n];
      frm.add(words);
      for(int i =0; i<n; i++){
        frm.add(words[i]);
      }
      bsort = new JButton("Sort them!");
      frm.add(bsort);
    }
    if (ae.getSource() == bsort){
      JOptionPane.showMessageDialog(null,"Sorting under process");
      output = new JLabel("");
      String[] out = new String[n];
      for(int k = 0; k<n; k++){
        out[k] = words[k].getText();
      }
      sortWords(out);
      String outString = new String("");
      for(int m = 0; m<n; m++){
        outString = outString+" " + out[m] + " ";
      }
      output.setText(outString);
      frm.add(output);
    }
  }
  public static void main(String[] args) {
    //String[] temp = {"hello","a","ab","zz","sdfg"};
    //sortWords(temp);
    new stringComparator();
    for(int m = 0; m<temp.length; m++){
      System.out.println(" "+ temp[m]);
    }

  }

}
