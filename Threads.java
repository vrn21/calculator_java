import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Threads implements ActionListener {
    JFrame frm;
    JButton bn;
    JTextField texts[];
    JTextField numbers[];
    JButton bg;
    JPanel panel;
    JTextField number;

    Threads() {
        frm = new JFrame("hello krabby");
        frm.setSize(800, 800);
        frm.setLayout(new FlowLayout());

        number = new JTextField("Enter how many words u want to write ", 20);
        bn = new JButton("Generate");
        bn.addActionListener(this);
        frm.add(number);
        frm.add(bn);

        frm.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        int n = Integer.parseInt(number.getText());
        if (ae.getSource() == bn) {
            panel = new JPanel();
            panel.setLayout(new GridLayout(n, 2));

            texts = new JTextField[n];
            numbers = new JTextField[n];

            for (int i = 0; i < n; i++) {
                texts[i] = new JTextField("Add your word", 15);
                numbers[i] = new JTextField("Add your times", 10);
                panel.add(texts[i]);
                panel.add(numbers[i]);
            }

            bg = new JButton("Write!");
            bg.addActionListener(this);
            frm.add(panel);
            frm.add(bg);
            frm.revalidate();
            frm.repaint();
        } else if (ae.getSource() == bg) {
            for (int i = 0; i < n; i++) {
                String s = texts[i].getText();
                int times = Integer.parseInt(numbers[i].getText());
                WordPrinter wp = new WordPrinter(s, times);
            }
        }
    }

    public static void main(String[] args) {
        new Threads();
    }
}

class WordPrinter implements Runnable {
    String text;
    int n;

    WordPrinter(String textIn, int nIn) {
        text = textIn;
        n = nIn;
        Thread t = new Thread(this);
          System.out.println("" + t.getName());
        t.start();
        try{
          Thread main = Thread.currentThread();
          main.sleep(600);
        }catch(Exception e){
          e.printStackTrace();
        }
    }

    synchronized public void appendToFile(String filename, String content) {
        try {
            File file = new File(filename);
            file.createNewFile();
            FileWriter writer = new FileWriter(file, true);
            writer.append(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    synchronized public void output(){
     for (int i = 0; i < n; i++) {
            System.out.println(this.text + "\n");
            appendToFile("threads.txt", "" + this.              text + "\n");

            
      }
    }
     public void run() {
       synchronized(this){
          output(); 
       }

        }
     }

