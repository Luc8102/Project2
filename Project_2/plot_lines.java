/* Filename: plot_lines.java
 * Description: This is a support file.
 * Author: Luc Barenghien
 * Date Completed: 12/3/2019
*/ 
import javax.swing.*;

public class plot_lines
{
  public static void main(String[] args)
  {
    JFrame frame=new JFrame("Plot this");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    frame.getContentPane().add(new plotter());
    frame.pack();
    frame.setVisible(true);
  }
}  