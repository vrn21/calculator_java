import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class WordWriter implements ActionListener{
  JFrame frm;
    JTextField textBox;
  JButton jb;
  WordWriter(){
    frm = new JFrame("Word Writer");
    jb = new JButton("Write words");
    jb.addActionListener(this);
    jb.setBounds(40,100,150,50);
    textBox = new JTextField("Enter your words");
    frm.setSize(500,500);
    frm.setLayout(null);
    textBox.setBounds(40,20,500,70);
    frm.add(textBox);
    frm.add(jb);
    frm.setVisible(true);
  }

  public void writeToFile(String fileName,String text){ 
    try{
      File file = new File(fileName);
      file.createNewFile();
      FileWriter writer = new FileWriter(file,true);
      writer.append(text);
      writer.close();
    }catch (IOException e){
      System.out.println("Somehting happend ");
      e.printStackTrace();
    }
  }

  public void actionPerformed(ActionEvent e){
    String text = textBox.getText();
    StringTokenizer tokens = new StringTokenizer(text);
    while(tokens.hasMoreTokens() ){
      writeToFile("hi.txt",tokens.nextToken() + "\n");
    }
    System.out.println("The words entered are: "+ text);
  }
  public static void main(String[] args) {
    new WordWriter();
  }
}
