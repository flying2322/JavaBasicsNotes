import java.util.*;

public class Retirement
{
  public static void main(String[] args) 
  {
    //read input 
    Scanner in = new Scanner(System.in);

    System.out.print("How much money do you need to retire?");
    double goal = in.nextDouble();

    System.out.print("How much money will you contribute to you account every year? ");
    double payment = in.nextDouble();

    System.out.print("Interest rate in %:");
    double interestRate = in.nextDouble();

    double balance = 0;
    int years = 0;

    while(balance < goal) {
      balance += payment;
      double interest = balance * interestRate / 100;
      balance += interest;
      years++;
    }
    System.out.println("You can retire in " + years + " years.");
    System.out.println("Wow, I am back! Suprice mother fucker");
  }
}
