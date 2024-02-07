import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
   
    public String exp = "";
    JLabel expression = new JLabel(exp);
   Calculator(){
    super("Calculator");
   

    JPanel p1 = new JPanel();
    JButton bdigits[] = new JButton[10]; 
    for(int i = 9; i>=0; i--){
      bdigits[i] = new JButton(""+i);
      bdigits[i].setBackground(Color.orange);
      bdigits[i].setOpaque(true);
      p1.add(bdigits[i]);
      bdigits[i].addActionListener(this);
      
    }
    p1.setLayout(new GridLayout(4,3));

    //String op[] = ["beq","badd","bsub","bmult","bmod","bdiv","bclr","bdec"];
    String opfns[] = {"=","+","-","x","%","/","CLR","."};

    JPanel p2 = new JPanel();
    JButton opbuttons[] = new JButton[8];
     
    for (int i = 0; i<8; i++){
      opbuttons[i] = new JButton(opfns[i]);
      p2.add(opbuttons[i]);
      opbuttons[i].addActionListener(this);
    }
       
    JPanel f2 = new JPanel();
    f2.add(p1);
    f2.add(p2);
    add(f2);
    f2.add(expression);
    setVisible(true);

    setSize(250,250);
  }

  public void actionPerformed(ActionEvent e){
    
    String s = e.getActionCommand();
  
     if (s == ".") {
      if (exp.charAt(exp.length()-1) != '.'){
        exp += s;

      }
    }
    else{
      exp += s;
    }
    expression.setText(exp);
  }

   public static void main(String[] args) {
    new Calculator();
   } 
}
