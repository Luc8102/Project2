//Filename: Flight_LucBarenghien.java
//Created By: Luc Barenghien
//This program does exactly what is described in the document. Simply, it parces through a file of passengers and
//selects meal options for those who dont have one and stores the information in an array.
//12/1/2019

import java.util.Scanner;
import java.io.*;
import java.util.Arrays;
import java.lang.*;
//I must import these things to make it work. io is for parsing the file.
public class Flight_LucBarenghien
{
  public static void main(String[] args) throws IOException
  {
    //creating my variables and making seats.
    Scanner input = new Scanner(new File("PassengerList.txt"));
    String line, userName, userSeat, userAge, userMeal, userEnter;
    int counter=0;
    int forcounter = 0;
    Passengers[] passengers= new Passengers[40];
    Seat firstClass = new Seat(4,1,1);
    Seat business = new Seat(4,2,5);
    Seat economy = new Seat(6,4,9);

  //  arrayRefVar = new String[arraySize];
    input.useDelimiter("\\n");

    while(input.hasNext())
    {
      line=input.nextLine();
      String split[] = line.split(",");
      if(split.length > 3)
      {
        passengers[counter] = new Passengers(split[0],split[1],Integer.valueOf(split[2]),split[3]);
      }
      else
      {
        passengers[counter] = new Passengers(split[0],split[1],Integer.valueOf(split[2]));
      }
      String seat = split[1];
      int row = Integer.valueOf(seat.substring(0,seat.length() - 1));
      boolean assignedOK = false;
      if(row <=4)
      {
        assignedOK = firstClass.assignSeat(seat);
      }
      else if(row <= 8)
      {
        assignedOK = business.assignSeat(seat);
      }
      else
      {
        assignedOK = economy.assignSeat(seat);
      }
    }
    int userCounter = 1;
    //the user needs to choose if he wants to add more passengers or not.
    userEnter = "Y";
    while(userEnter.equals("Y"))
    {
      if(36>=counter)
      {
        Scanner scan= new Scanner(System.in);
      System.out.println("What is the name of your passenger?");
      userName=scan.nextLine();
      
      userSeat = "";
      boolean seatAssigned = false;
      while(seatAssigned == false)
      //This while loop allows the user to enter three more passengers.
      {
        System.out.println("First class seats available: " + firstClass.availableSeats());
        System.out.println("business class seats available: " + business.availableSeats());
        System.out.println("economy class seats available: " + economy.availableSeats());
        System.out.println("What seat will the passenger take?");
        userSeat=scan.nextLine();
        int row = Integer.valueOf(userSeat.substring(0,userSeat.length() - 1));
        if(row <=4)
        {
          seatAssigned = firstClass.assignSeat(userSeat);
        }
        else if(row <= 8)
        {
          seatAssigned = business.assignSeat(userSeat);
        }
        else
        {
          seatAssigned = economy.assignSeat(userSeat);
        }
        
       }
      System.out.println("What age is the passenger?");
      userAge=scan.nextLine();
      System.out.println("What meal will the passenger take? Your options are: Regular, Asian Vegetarian, Hindu vegetarian, Vegan (strict) vegetarian, Vegetarian lacto-ovo, Child, Gluten-intolerant, Jain, Japanese, Kosher, Muslim, and Extra crunchy");
      userMeal=scan.nextLine();
          if(userMeal == null)
          {
            passengers[counter+userCounter] = new Passengers(userName,userSeat,Integer.valueOf(userAge));
          }
          else
          {
            passengers[counter+userCounter] = new Passengers(userName,userSeat,Integer.valueOf(userAge),userMeal);
          }
        System.out.println("Input another Passenger? input Y/N");
        //prompts user if he wants to continue
        userEnter=scan.nextLine();
        userCounter++;
      for(forcounter = 0; forcounter<=36; forcounter++)
      {
        System.out.println(passengers[forcounter]);
      }
     }  
    }
  }//end main
}//end class