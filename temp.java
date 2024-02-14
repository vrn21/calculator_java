import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class Threads implements ActionListener{
  JFrame frm;
  JButton bn;
  JTextField texts[];
  JTextField numbers[];
  JButton bg;
  JPanel panel[];
  Threads(){
    frm = new JFrame("hello krabby");
    frm.setSize(800,800);
    frm.setLayout(null);

    JTextField number = new JTextField("Enter how many words u want to write ");
    JButton bn = new JButton("Generate");
    bn.addActionListener(this);
    frm.add(bn);
    frm.add(number);
    frm.setVisible(true);
  }

  public void actionPerformed(ActionEvent ae){
      int n = Integer.parseInt(number.getText() );
    if (ae.getSource() == bn){
      texts = new JTextField[10];
      numbers = new JTextField[10];
      panel = new JPanel[10];
      for(int i = 0; i<n; i++){
        text[i].setText("Add your word");
        numbers[i].setText("Add you times");
        panel[i].add(text[i]);
        panel[i].add(numbers[i]);
        frm.add(panel[i]);
      }
       bg = JButton("Write!");
      bg.addActionListener(this);
      frm.add(bg);
    }
   
    else if (ae.getSource() == bg){
    for(int i = 0; i<n; i++){
      String s = text[i].getText();
      //int n = Integer.parseInt(numbers.getText());
      WordPrinter wp = new WordPrinter(s,n);
    }

  }  
    
  }

  public static void main(String[] args) {
    new Threads();
  }
}

class WordPrinter implements Runnable{
  WordPrinter(String textIn,int nIn){
    String text = textIn;
    int n = nIn;
    Thread t = new Thread(this);
    t.start();
  }

  public void appendToFile(String filename,String content){
    File file = new File(filename);
    file.createNewFile();
    FileWriter writer = new FileWriter(file,true);
    writer.append(content);
    writer.close();
  }

  synchronized public void run(){
   for(int i = 0; i<n; i++){
     System.out.println(this.text + "\n");
    appendToFile("threads.x",""+this.text+"\n");
   } 
  }

}
