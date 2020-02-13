//Filename: Seat.java
//created by Luc Barenghien
//this file keeps track of the seats that have been taken and what seats are availible
//12/1/2019

public class Seat
{
  private boolean[][] availableSeats;
  private int startRow;
  //private int maxCapacity;
  
  public Seat(int maxRow,int maxCol,int startRow)
  {
    availableSeats = new boolean[maxRow][maxCol];
    for(int i=0;i<maxRow;i++)
    {
      for(int j=0;j<maxCol;j++)
      {
        availableSeats[i][j] = true;
      }
    }
    this.startRow = startRow;
  }
  
  
  public String availableSeats()
  {
    String available = "";
    for(int i=0;i<availableSeats.length;i++)
    {
      for(int j=0;j<availableSeats[i].length;j++)
      {
        if(availableSeats[i][j] == true)
        {
          String row = String.valueOf(i + startRow);
          String col;
          if(j == 0)
          {
            col = "A";
          } 
          else if(j == 1)
          {
            col = "B";
          } 
          else if(j == 2)
          {
            col = "C";
          } 
          else
          {
            col = "D";
          }
          available += row + col + ",";
        }
      }
    }
    if(available.equals(""))
    {
      return "NONE";
    } 
    else
    {
      return available.substring(0,available.length() - 1);
    }
  }
  
   public int numberAvailableSeats()
   {
    int available = 0;
    for(int i=0;i<availableSeats.length;i++)
    {
      for(int j=0;j<availableSeats[i].length;j++)
      {
        if(availableSeats[i][j] == true)
        {
          available++;
        }
      }
    }
     return available;
  }
  //the code below is for the columns.
  public boolean assignSeat(String seat)
  {
    String colStr = seat.substring(seat.length() - 1);
    String rowStr = seat.substring(0,seat.length() - 1);
    int col;
    if(colStr.equals("A"))
    {
      col = 0;
    } 
    else if(colStr.equals("B"))
    {
      col = 1;
    }
    else if(colStr.equals("C"))
    {
      col = 2;
    }
    else
    {
      col = 3;
    }
    //The code below is for the rows
    int row = Integer.valueOf(rowStr) - startRow;
    System.out.println("assigning seat :" + seat + "---" + row + "----" + col);
    if(availableSeats[row][col] == true)
    {
       availableSeats[row][col] = false;
       return true;
    } 
    else
    {
       return false;
    }
    //return true if Ok, false if not available.
  }
  
  //public boolean assignSeat(String seat) {
    //return true if Ok, false if not available.
  //}
}