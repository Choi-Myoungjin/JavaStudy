package Windows;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Window extends JFrame
{
	
   public static void main(String[] args)
   {
	   Window win = new Window();
	   
	   win.setSize(400,500);
	   win.setTitle("스윙 예제");
	   win.setVisible(true);
   }
            @Override
            public void paint(Graphics g)
            {
            	//원 그리기
            	g.setColor(Color.blue);
            	g.fillOval(10, 50, 100, 100);
            	
            	g.setColor(Color.RED);
             //삼각형 그리기
       
              
              int[] x = {100, 50, 200};
              int[] y = {10, 200, 300};
              
              g.fillPolygon(x,y,3);
              
              g.setColor(Color.GREEN);
              
              //사각형 그리기
              g.fillRect(100, 100, 200, 300);
              
              
            }
            
   }