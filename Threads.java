import java.awt.*;
import java.event.*;
import javax.swing;
import java.io.*;
import java.util.*;

public class Threads implements ActionListener{
  Threads(){
    JFrame frm = new JFrame("hello krabby");
    frm.setSize(800,800);
    frm.setLayout(null);

    JTextField number = new TextField("Enter how many words u want to write ");
    JButton bn = new JButton("Generate");
    bn.addActionListener(this);
    frm.setVisible(true);
  }

  public void actionPerfomed(ActionEvent ae){
      int n = (int) number.getText();
    if (ae.getSource == bn){
      JTextField texts[] = new JTextField[10];
      JTextField numbers[] = new JTextField[10];
      JPanel panel[] = new JPanel[10];
      for(int i = 0; i<n; i++){
        text[i].setText("Add your word");
        numbers[i].setText("Add you times");
        panel[i].add(text[i]);
        panel[i].add(numbers[i]);
        frm.add(panel[i]);
      }
      public JButton bg = JButton("Write!");
      bg.addActionListener(this);
      frm.add(bg);
    }
   
  if (ae.getSource() == bg){
    for(int i = 0;i<n; i++){
      String s = text[i].getText();
      int n = (int)numbers.getText();
      WordPrinter wp = new WordPrinter(s,n);
    }

  }  
    
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
   for(int i = 0; i<this.n; i++){
     System.out.println(this.text + "\n");
    appendToFile("threads.x",""+this.text+"\n");
   } 
  }

}
