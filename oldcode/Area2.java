import java.util.*;

public class Area2
{
 // Program to compute the area of a rectangle
 // L.L. Wainwright
  
 public static void main(String[] args)
 {
  Scanner input = new Scanner(System.in);
  int area, length, width;
  String name;
 
  System.out.println(" Area Program ");
  System.out.println();

  System.out.println("Enter your name " );
  name=input.nextLine();
  
  System.out.print(" Enter the length: ");
  length = input.nextInt();
  System.out.print(" Enter the width: ");
  width = input.nextInt();
  area = length * width;
  System.out.println("Hello "+ name +" Area = "+ area);
   
 }
}