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
	   win.setTitle("���� ����");
	   win.setVisible(true);
   }
            @Override
            public void paint(Graphics g)
            {
            	//�� �׸���
            	g.setColor(Color.blue);
            	g.fillOval(10, 50, 100, 100);
            	
            	g.setColor(Color.RED);
             //�ﰢ�� �׸���
       
              
              int[] x = {100, 50, 200};
              int[] y = {10, 200, 300};
              
              g.fillPolygon(x,y,3);
              
              g.setColor(Color.GREEN);
              
              //�簢�� �׸���
              g.fillRect(100, 100, 200, 300);
              
              
            }
            
   }