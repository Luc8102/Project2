/* Filename: Plane.java
 * REQUIRES Seat.java to keep track of what seats are taken.
 * Description: This is The file that dictates what the plane in the window should do.
 * Author: Luc Barenghien
 * Date Completed: 12/4/2019
*/ 

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import javax.swing.*;


public class Plane extends JPanel 
{
  ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor(); 
  private Color lastColor= Color.YELLOW;
  int currenty=0;
  int speed=212;
  int currentx=0;
  public Plane()
  {      
    PolygonPanel listener = new PolygonPanel();
    setBackground(Color.black);   
    setPreferredSize(new Dimension(1000,400));
    setFocusable(true);
    addMouseListener(listener);  
    addMouseMotionListener(listener);  
    addKeyListener(new PolygonPanel());
  }
  
  public void paintComponent(Graphics page)
  {
    super.paintComponent(page);
   //The following lines below draw each of the three stars.
   if(lastColor.equals(Color.YELLOW))
   {
     lastColor = Color.ORANGE;
   }
   else
   {
     lastColor = Color.YELLOW;
   }
   //The if statement seen above and on every other subsequent star in the file are for the flickering.
   page.setColor(lastColor);
   int[] x = {728,751,731,762,727,743,715,715,704,675,692,664,700,670,711,708,727};
   int[] y = {129,143,118,111,97,77,86,63,83,72,93,110,113,145,132,153,129};
   page.fillPolygon(x, y, x.length);
    
   
   if(lastColor.equals(Color.YELLOW))
   {
     lastColor = Color.ORANGE;
   }
   else
   {
     lastColor = Color.YELLOW;
   }
   page.setColor(lastColor);
   int[] x1 = {128,151,131,162,127,143,115,115,104,75,92,64,100,70,111,108,127};
   int[] y1 = {129,143,118,111,97,77,86,63,83,72,93,110,113,145,132,153,129};
   page.fillPolygon(x1, y1, 12);
   
   
   if(lastColor.equals(Color.YELLOW))
   {
     lastColor = Color.ORANGE;
   }
   else
   {
     lastColor = Color.YELLOW;
   }
   page.setColor(lastColor);
   int[] x2 = {228,251,231,262,227,243,215,215,204,275,292,264,300,270,311,308,327};
   int[] y2 = {129,143,118,111,97,77,86,63,83,72,93,110,113,145,132,153,129};
   page.fillPolygon(x2, y2, 11);
   //stars above
   //below, is the code to make the plane
    
   page.setColor(Color.white);  
    
   int[] xplane_window = {currentx+341,currentx+348,currentx+335,currentx+335,currentx+337,currentx+343,currentx+344,currentx+345,currentx+349,currentx+349,currentx+345};
   int[] yplane_window = {currenty+587,currenty+583,currenty+588,currenty+582,currenty+581,currenty+581,currenty+578,currenty+579,currenty+581,currenty+583,currenty+583};
   page.fillPolygon(xplane_window, yplane_window, xplane_window.length);
    
   page.setColor(Color.white); 
   int[] xloc_plane = {currentx+41,currentx+57,currentx+58,currentx+57,currentx+48,currentx+38,currentx+37,currentx+26,currentx-44,currentx-54,currentx-64,currentx-65,currentx-145,currentx-152,currentx-153,currentx-159,currentx-160,currentx-180,currentx-191,currentx-192,currentx-174,currentx-179,currentx-182,currentx-181,currentx-177,currentx-193,currentx-184,currentx-182,currentx-166,currentx-139,currentx-84,currentx-91,currentx-137,currentx-139,currentx-134,currentx-81,currentx-49,currentx-47,currentx-47,currentx-50,currentx-65,currentx-53,currentx-45,currentx-31,currentx+12,currentx+32,currentx+42};
   int[] yloc_plane = {currenty+96,currenty+91,currenty+87,currenty+84,currenty+80,currenty+74,currenty+73,currenty+71,currenty+75,currenty+47,currenty+44,currenty+75,currenty+78,currenty+74,currenty+68,currenty+66,currenty+68,currenty+51,currenty+51,currenty+52,currenty+81,currenty+82,currenty+84,currenty+87,currenty+90,currenty+100,currenty+102,currenty+100,currenty+93,currenty+100,currenty+104,currenty+113,currenty+146,currenty+149,currenty+152,currenty+122,currenty+125,currenty+119,currenty+114,currenty+111,currenty+111,currenty+104,currenty+104,currenty+100,currenty+99,currenty+98,currenty+96};
   page.fillPolygon(xloc_plane,yloc_plane,xloc_plane.length);
   //The lines above is supposed to draw the plane ane make the plane white

   page.setColor(Color.red);
   Font string = new Font("Times_New_Roman", Font.PLAIN, 40 );
   page.drawString("Current Speed: "+speed+" mph", 850, 40);
   repaint();
   //The repaint() method is always used to update the screen.
  } 
 
  private class PolygonPanel implements MouseListener, MouseMotionListener, KeyListener
  {
//The code below is used to determine what is supposed to happen when the user gives input wether it be a button click or a mouse click.
    public void mouseClicked(MouseEvent event)
    {
       currenty=event.getPoint().y;
       currentx=event.getPoint().x;  
        
       repaint(); 
    }   
    public void mouseDragged(MouseEvent event)
    {
    currenty=event.getPoint().y;
    currentx=event.getPoint().x;  
    repaint(); 
    }
    
    public void keyReleased(KeyEvent event){} 
    public void keyTyped(KeyEvent event){}
    
  public void keyPressed(KeyEvent event)
  {
    //The first if statement is supposed to listen for the up arrow button press.
    if (KeyEvent.VK_DOWN==event.getKeyCode())
    {
      if(speed>=150)
      {
        speed = speed - 9;
      }
      else if (150>speed)
      {
        System.out.println("You've reached the minimum speed of the aircraft.");
      }
    }
    //This second if statement is supposed to listen for the down arrow button press.
    else if (KeyEvent.VK_UP==event.getKeyCode())
    {
      if(speed<=1687)
      {
        speed = speed + 5;
      }
      else if(speed>1687)
      {
        System.out.println("You've reached the maximum speed of the aircraft.");
      }
    }
     repaint();
  }

    public void mousePressed(MouseEvent event)
    {
      //This if statement is supposed to listen for the left button of the mouse clicked.
      if (event.getButton() == MouseEvent.BUTTON1)
      {
        speed=1687;
        System.out.println("Afterburners activated.");
      }
    }

    public void mouseReleased(MouseEvent event)
    //When the mouse button is released, the user gets notified that the afterburners got deactivated.
    {
      System.out.println("Afterburners deactivated.");
    }  
    public void mouseEntered(MouseEvent event) {}
    public void mouseExited(MouseEvent event) {}
    public void mouseMoved(MouseEvent event) 
    {
      currenty=event.getPoint().y;
      currentx=event.getPoint().x;  
      repaint(); 
      //Repaint as always to refresh.
    } 
  } 
}  