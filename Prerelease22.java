/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prerelease.pkg2022;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PRIYANKA
 */
public class Prerelease2022 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String ticketType[]={"one adult","one child","one senior","family ticket","groups of six and more"};
        double costPerDay[]={20,12,16,60,15};
        double cost_two_days[]={30,18,24,90,22.5};
        String extra_attraction[]={"Lion feeding","penguin feeding","evening barbecue"};
        double Cost_extra_attraction[]={2.50,2,5};
      
        //tickets available from the start date
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
       
        Date dateobj = new Date();
        String startDate=df.format(dateobj);
        System.out.println("--start date --"+startDate);
       
        Calendar c = Calendar.getInstance();
        try {
           
            c.setTime(df.parse(startDate));
        } catch (ParseException ex) {
            Logger.getLogger(Prerelease2022.class.getName()).log(Level.SEVERE, null, ex);
        }
         //Number of Days to add
        c.add(Calendar.DAY_OF_MONTH, 15);  
	//Date after adding the 15 days to the given date
	String endDate = df.format(c.getTime());  
	//Displaying the new Date after addition of Days
	System.out.println("Date after Addition:    "+endDate );
       
    /*
        
        Task 1 – displaying the ticket options and the extra attractions available
        Set up your program to:
        • display the options, attractions and prices for one-day tickets
        • display the options, attractions and prices for two-day tickets
        • show the days available for booking; assume that there are tickets available for any valid day.
        */ 
        
        
        System.out.println("Below are the bookings that you can make for a WildLife park visit.");
        for(int i=0;i<ticketType.length;i++)
        {
             System.out.print("Ticket Type :  "+ticketType[i]);
             System.out.print(" : Cost(in dollars) Per Day : "+costPerDay[i]);
             System.out.println(" : Cost(in dollars) for two consecutive Days : "+cost_two_days[i]);
        }
        
        System.out.println(" : These are the extra attractions and their prices in dollars : ");
         for(int i=0;i<extra_attraction.length;i++)
        {
             System.out.print(" : Extra attractions :  "+extra_attraction[i]);
             System.out.println(" : Cost(in dollars)  Per Day  : "+Cost_extra_attraction[i]);
           
        }
        System.out.println(" You can book tickets from today which is " + startDate+  " to next fifteen days which is  " +endDate);
    
    //TASK1 ENDS
    
    
    
    /*
    Task 2 – process a booking
    Extend your program for Task 1 to:
    • input the tickets and extra attractions required, then calculate the total cost of the booking
    • allocate a unique booking number
    • display the booking details, including the total cost and the unique booking number
    • repeat as required.
    */
    
    int booking_no=0;
    String ticket_Type,extra_attract;
    double costOne,costTwo;
    String date_booking;
     Date sdate=null,edate=null;
    Scanner s=new Scanner(System.in);
        try {
                sdate=df.parse(startDate);
                edate=df.parse(endDate);
        } catch (ParseException ex) {
            Logger.getLogger(Prerelease2022.class.getName()).log(Level.SEVERE, null, ex);
        }
    Date bookingDate=null;
    do
    {
    System.out.println("enter the date of booking  in yyyy-mm-dd format .It must be within the next 15 days, today inclusive ");
    date_booking=s.next();
            try {
                 bookingDate=df.parse(date_booking);
            } catch (ParseException ex) {
                Logger.getLogger(Prerelease2022.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }while(bookingDate.before(sdate)  || bookingDate.after(edate) );
   
    int choice_day,choice_att,adult_no,child_no,senior_no;
    double total_cost=0;
    double cost_att=0;
    int no_people;
      while(true)  
      {
                
               
                System.out.println("How many people are in your group?");
                no_people=s.nextInt();
                
                
                do
                {
                    System.out.println("enter number of adults");
                    adult_no=s.nextInt();
                    do
                    {
                         System.out.println("enter number of children in a way that only two children's entry is valid with one adult");
                         child_no=s.nextInt();
                     }while(child_no > 2*adult_no); //as an adult may bring upto two children
               
                    System.out.println("enter number of seniors");
                    senior_no=s.nextInt();
                    
                    if((adult_no+child_no+senior_no) > no_people)
                        System.out.println("Your members are exceeding. Please enter the member details again ");
                        
                }while((adult_no+child_no+senior_no) != no_people  );
              
          
                System.out.println("enter your choice for days 1 for one day booking and 2 for two consecutive days  ");
                choice_day=s.nextInt();
                  String attraction=s.nextLine();
                if(choice_day==1)
                {
                
                    System.out.println("Type your choice for  extra attractions 0 for NO Attraction 1 for Lion feeding 2 for penguin feeding");
                    choice_att=s.nextInt();
               
                    if (choice_att==1)
                            cost_att=Cost_extra_attraction[0];
                    else if(choice_att==2)
                            cost_att= Cost_extra_attraction[1];
                         else
                            cost_att=0;

        
                           System.out.println(" ..attraction cost 1 day ---"+cost_att);
                         
                    
                
                    total_cost=adult_no*costPerDay[0] + child_no*costPerDay[1]+senior_no*costPerDay[2]+cost_att*no_people;
             
                            
                }
             else if(choice_day==2)
             {
                  //all three  attractions are valid  for two day booking
                  System.out.println("Type your choice for  extra attractions 0 for NO Attraction 1 for Lion feeding 2 for penguin feeding and 3 for evening barbecue");
                    choice_att=s.nextInt();
               
                    if (choice_att==1)
                            cost_att=Cost_extra_attraction[0];
                    else if(choice_att==2)
                            cost_att= Cost_extra_attraction[1];
                    else if(choice_att==3)
                            cost_att= Cost_extra_attraction[2];
                         else
                            cost_att=0;

        
                           System.out.println(" ..attraction cost 1 day ---"+cost_att);
                         
                    
                  total_cost=adult_no*cost_two_days[0] + child_no*cost_two_days[1]+senior_no*cost_two_days[2]+cost_att*no_people;
                
                 
             }
                booking_no+=1;
            System.out.println("Your Booking Details are as Follows : \n people in your group"+no_people+"\n no of adults : "+adult_no+
                    "\n no of children : "+child_no+" \n no of senior : "+senior_no+"\n extra attraction type"+attraction+
                    " \n Total cost "+total_cost+"\n your unique booking number is : "+booking_no);
            System.out.println("do you want to continue with booking ? type yes or no ")   ;
            String answer=s.next();
            if(answer.equals("no"))
                 break; //come out from the loop
      }
      
   /*
      Task 3 – ensuring each booking is the best value
    Check that the total for each booking gives the best value and offer an alternative if this is not the case.
    For example, buying two family tickets is better than a group ticket for a group of 10 that includes
    four adults and six children.
      */   
   
  
   if(no_people<6 )
   {
       //insert this code in day1..calculate day2 accordingly
        if(  (adult_no==2 || senior_no==2 || (adult_no+senior_no ) ==2) &&    ( (child_no==3) || (child_no ==2) )   )
        {
             System.out.println(" It would be cheaper for you to buy family ticket ");
                 total_cost=costPerDay[3]+cost_att*no_people;
        }
   }
   else
   {
       System.out.println(" It would be cheaper for you buy tickets in group and no of members are greater than 6");
       
       total_cost=no_people*costPerDay[4]+cost_att*no_people;
   }
   
   
    
    
}
    }
