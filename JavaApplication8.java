/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

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
     int k=0;
     int x=100,y=100;
    
    JavaApplication8(){
add(panel);
setFocusable(true);
x=100;
y=0;
repaint();
x=200;y=200;
repaint();

    }
    


    
    
    
    
    public static void main(String[] args) {
      
       
        JFrame frame= new JavaApplication8();
      frame.setSize(800,800);
      frame.setVisible(true);
        
    }
    public void paint(Graphics g){
    Graphics j=this.getGraphics();
    j.drawLine(10, 10, x,y);
    }
    
    private class DrawPanel extends JPanel{
    
        DrawPanel(){
        x=100;y=0;
        repaint();
            
            /*Node nodeMain= new Node(20);
insertNode(10,nodeMain);
insertNode(21,nodeMain);
insertNode(9,nodeMain);
insertNode(8,nodeMain);
insertNode(15,nodeMain);
insertNode(13,nodeMain);
insertNode(16,nodeMain);
System.out.println("i came");
preOrder(nodeMain,200,100);
*/
        

        }
    
    }
    
    
    
    void insertNode(int value,Node nodeMain){
Node newNode= new Node(value);
if(nodeMain.value>newNode.value && nodeMain.left!=null){
insertNode(newNode.value,nodeMain.left);
}

else if(nodeMain.value<newNode.value && nodeMain.right!=null){
insertNode(newNode.value,nodeMain.right);
}

else if(nodeMain.left==null && nodeMain.value>newNode.value)
    nodeMain.left=newNode;

else if(nodeMain.right==null&& nodeMain.value<newNode.value)
    nodeMain.right=newNode;
}

void preOrder(Node nodeMain,int left,int down){
     

    addKeyListener(new KeyAdapter(){
    public void keyPressed(KeyEvent e){
    k=1;
        Graphics g= panel.getGraphics();
        g.drawLine(10, 10, 100, 100);
        
        
    }
    
    });
     
     System.out.println("yo");

    System.out.println(nodeMain.value);
if(k==1){
if(nodeMain.left!=null)
    preOrder(nodeMain.left,left-30,down+30);
if(nodeMain.right!=null)
    preOrder(nodeMain.right,left+30,down+30);

}
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
