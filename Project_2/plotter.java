//This program draws line segments on the screen.
//It saves in an Arraylist so it can redraw the entire 
//list of points that are clicked on
//Created by: Paul Murray
//11/3/2016
//Modified 11/29/2017
//Version 2.1
//The output now goes to the screen and a file called Arraypoints.txt
//Modified 11/29/2017
//Version 2.2
//Perhaps I have made this program too easy...now you can just copy all the text in the Arraypoints file and paste
//it inside your paintComponent method....it will work as is as long as currentx and currenty are values you
//are using inside your program to track mouse movement.  You should rename the arrays though.

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class plotter extends JPanel 
{
  private Point point1=null, point2=null, currentpoint=null;
  private ArrayList<Point> clickarray;
  private Image image;
  public plotter()
  {
    
    Scanner scan =new Scanner(System.in);
    System.out.print("Type in the name of the file you wish to use.  Make sure ");
    System.out.print("to include both the filename and extension.  Make sure the ");
    System.out.print("file does not have any spaces in the name.  Also, if the ");
    System.out.print("file is not located in the same drive and folder, the Jframe ");
    System.out.println("will appear empty");
    String user_file=scan.next();
      
    clickarray= new ArrayList<Point>();
    
    LineListener listener = new LineListener();
    addMouseListener(listener);
    addMouseMotionListener(listener);
    
    setBackground(Color.black);
    setPreferredSize(new Dimension(800,600));  //you may need to adjust this size if you have a bigger image
    image=new ImageIcon(user_file).getImage();  //plug whichever file you want in here  
    } //end plotter
   
  
  
  public void paintComponent(Graphics page)
  {
       
    super.paintComponent(page);
    page.drawImage(image,0,0,this);

    page.setColor(Color.red);
    int loc=0;

    /*This code sets up object to output data to a text file
     *It recreates the file every time a new point is registered*/
    java.io.File file = new java.io.File("Arraypoints.txt");
    java.io.PrintWriter output = null;
      try {
         output = new java.io.PrintWriter(file);
          } 
      catch (FileNotFoundException e) {
           e.printStackTrace();
        }
      
    //print all the array X points to user output
    System.out.println();
    System.out.println("********X*********"); //print to screen
   
    output.println("//All you need to do is copy this text into your file and change the name of the two arrays"); 
    output.println("//If you also copy the last line (page.fillPolygon(xloc_changethisname,yloc....) make sure your");
    output.println("//Graphics object is called page and make sure you change the 3 array names inside the fillPolygon method "); 
    output.println();
    output.println("//********X*********"); //print to file
    output.print("int[] xloc_changethisname = {");
    while (loc<clickarray.size())
    {
      if (loc<clickarray.size()-1)
      { 
        System.out.print(clickarray.get(loc).x+",");  //output to screen 
        output.print("currentx+"+clickarray.get(loc).x+",");  //output to file
      }  
      else  //output last value without a trailing comma
      {
         System.out.print(clickarray.get(loc).x);  
         output.print("currentx+"+clickarray.get(loc).x);  
      }
      loc++;
    }
    output.print("};");

    //print all the array Y points to user output
    System.out.println();
    output.println();
    System.out.println("********Y*********"); //print to screen
    output.println();
    output.println("//********Y*********"); //print to file
    output.print("int[] yloc_changethisname = {");
    loc=0;
    while (loc<clickarray.size())
    {
      if (loc<clickarray.size()-1)
      { 
        System.out.print(clickarray.get(loc).y+",");  //output to screen 
        output.print("currenty+"+clickarray.get(loc).y+",");  //output to file
      }  
      else  //output last value without a trailing comma
      {
         System.out.print(clickarray.get(loc).y);  
         output.print("currenty+"+clickarray.get(loc).y);
      }   
            loc++;
    }
    output.println("};");
    output.println();
    output.println("page.fillPolygon(xloc_changethisname,yloc_changethisname,xloc_changethisname.length);"); 
    output.close();  //close file
    
    //draw all the line segments from the array to the Jframe
    loc=0; //reset for next loop
    while (loc<clickarray.size()-1)
     {
       page.drawLine(clickarray.get(loc).x, clickarray.get(loc).y, clickarray.get(loc+1).x, clickarray.get(loc+1).y);
       loc++;
      }
  }
    
   
  private class LineListener implements MouseListener, MouseMotionListener
  {
    public void mousePressed(MouseEvent event)
    {
      if (currentpoint==null)
       { point1=event.getPoint(); //get the location of mouse click
         currentpoint=point1;  //assign this point as the currentpoint
       }
      else
       { point1=currentpoint;
         point2=event.getPoint();
         currentpoint=point2;
         clickarray.add(currentpoint);  //add another point to the array
         repaint();  //redraw the image
       }
    }
    public void mouseDragged(MouseEvent event){}
    public void mouseClicked(MouseEvent event) {} 
    public void mouseReleased(MouseEvent event) {} 
    public void mouseEntered(MouseEvent event) {} 
    public void mouseExited(MouseEvent event) {} 
    public void mouseMoved(MouseEvent event) {} 
    
  }}    
    