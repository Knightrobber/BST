import java.lang.Math;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author sisirreddy
 */
public class JavaApplication8 extends JFrame{
    
    DrawPanel panel= new DrawPanel();
    JButton button= new JButton("enter");
    JTextField field= new JTextField();
    String p =" ";
    int mov1=0;
    int mov2=0;
    JavaApplication8()
            {
        
        
        
        setLayout(null);
        add(panel);
        setFocusable(true);
        add(button);
        Node nodeMain= new Node(20);
   
    nodeMain.left=null;
    nodeMain.right=null;
button.setBounds(350, 0, 50, 20);
field.setBounds(250, 0, 100, 20);
add(field);
field.setText("-10");
 JLabel label1= new JLabel(String.valueOf(nodeMain.value));
 add(label1);
 label1.setBackground(Color.red);
 label1.setOpaque(true);
 label1.setBounds(300, 100-22,25,25);
 button.addActionListener(new ActionListener(){
   
     
     public void actionPerformed(ActionEvent e){
    int left=300;int down=100;
         int val= Integer.parseInt(field.getText());
        
         JLabel label = new JLabel(field.getText());
         
         String s= insertNode(val,nodeMain,left,down);
         String[] nums= s.split("\\s+");
         add(label);
         int[] numsInt={300,100,300,100};
         numsInt[0]= Integer.parseInt(nums[0]);
         numsInt[1]= Integer.parseInt(nums[1]);
         numsInt[2]= Integer.parseInt(nums[2]);
         numsInt[3]= Integer.parseInt(nums[3]);
         label.setBounds(numsInt[0],numsInt[1]-22, 20, 20);  // messy part
         label.setBackground(Color.red);
         label.setOpaque(true);
         Graphics g=getGraphics();
         g.drawLine(numsInt[2] +10 , numsInt[3] +10 , numsInt[0]+10, numsInt[1]+10); // messy part
         System.out.println(nums[2]+" " +nums[3]+"     " +nums[0]+" " +nums[1]);
         System.out.println(numsInt[0]+  " " +numsInt[1]+  " "+numsInt[2]+  " "+numsInt[3]+  " ");
         System.out.println();
         
         
         
         
         

   }
   
   });


    }
    


    
    
    
    
    public static void main(String[] args) {
      
       
        JFrame frame= new JavaApplication8();
      frame.setSize(800,800);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
    
    
    
    
    
    private class DrawPanel extends JPanel{
     
        DrawPanel(){
        }
    
        void preOrder(Node nodeMain,int left,int down){
     
if(nodeMain==null)
return;
String a= Integer.toString(nodeMain.value);
   JLabel label123 = new JLabel(a);
   label123.setBounds(left,down,30,30);
 System.out.println(left + " " + down);
 add(label123);
      
preOrder(nodeMain.left,left-30,down+30);
preOrder(nodeMain.right,left+30,down+30);

}
        
    
    }
    
    
    
    String insertNode(int value,Node nodeMain,int left,int down){
Node newNode= new Node(value);
if(nodeMain.value>newNode.value && nodeMain.left!=null){
    if(left==300 && down==100)
       insertNode(newNode.value,nodeMain.left,left-100,down+60);
    else
insertNode(newNode.value,nodeMain.left,left-30,down+30);
}

else if(nodeMain.value<newNode.value && nodeMain.right!=null){
    if(left==300 && down==100)
        insertNode(newNode.value,nodeMain.right,left+100,down+60);
    else
insertNode(newNode.value,nodeMain.right,left+30,down+30);
}

else if(nodeMain.left==null && nodeMain.value>newNode.value)
{ 
    nodeMain.left=newNode;

    
    if(left==300 && down==100)
     p= String.valueOf(left-100) +" " +  String.valueOf(down+60)+" " +  String.valueOf(left) +" " +  String.valueOf(down);
    else
        p= String.valueOf(left-30) +" " +  String.valueOf(down+30)+" " +  String.valueOf(left) +" " +  String.valueOf(down);
    return p;
    
    

}
else if(nodeMain.right==null&& nodeMain.value<newNode.value)
{  nodeMain.right=newNode;

    if(left==300 && down==100)
     p= String.valueOf(left+100) +" " +  String.valueOf(down+60) +" " +  String.valueOf(left) +" " +  String.valueOf(down) ;
    
    else
         p= String.valueOf(left+30) +" " +  String.valueOf(down+30) +" " +  String.valueOf(left) +" " +  String.valueOf(down) ;
    return p;
    
}
return p;

        }









class Node{
Node left=null;
Node right=null;
int value;
Node(int val){
this.value=val;
}
}

    
}
