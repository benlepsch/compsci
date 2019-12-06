import java.util.*;
public class TriangleSolver {
  int choice;
  double sideA, sideB, sideC, angleA, angleB, angleC;
  double s2deA, s2deB, s2deC, angl2A, angl2B, angl2C;
  boolean ssa = false;
  Scanner input = new Scanner(System.in);
  Shortcuts s = new Shortcuts();
  
  public double locAngle(double a, double b, double c) {
    return Math.acos((b*b+c*c-a*a)/(2*b*c));
  }

  public double locSide(double b, double c, double a) {
    return Math.sqrt((b*b+c*c-2*b*c*Math.cos(a)));
  }

  public double losAngle(double side1, double angle1, double side2) {
    return Math.asin((side2*Math.sin(angle1))/side1);
  }

  public double losSide(double side1, double angle1, double angle2) {
    return (Math.sin(angle2)*side1)/Math.sin(angle1);
  }

  public void SSS() {
    System.out.print("Enter side A: ");
    sideA = input.nextInt();
    System.out.print("Enter side B: ");
    sideB = input.nextInt();
    System.out.print("Enter side C: ");
    sideC = input.nextInt();
    
    angleA = Math.toDegrees(locAngle(sideA, sideB, sideC));
    angleB = Math.toDegrees(locAngle(sideB, sideA, sideC));
    angleC = Math.toDegrees(locAngle(sideC, sideA, sideB));
  }

  public void SAS() {
    System.out.print("Enter side B: ");
    sideB = input.nextInt();
    System.out.print("Enter angle A: ");
    angleA = Math.toRadians(input.nextInt());
    System.out.print("Enter side C: ");
    sideC = input.nextInt();

    sideA = locSide(sideB, sideC, angleA);

    angleB = Math.toDegrees(locAngle(sideB, sideA, sideC));
    angleC = Math.toDegrees(locAngle(sideC, sideA, sideB));
    angleA = Math.toDegrees(angleA);
  }

  public void ASA() {
    System.out.print("Enter angle A: ");
    angleA = input.nextInt();
    System.out.print("Enter side B: ");
    sideB = input.nextInt();
    System.out.print("Enter angle C: ");
    angleC = input.nextInt();

    angleB = Math.toRadians(180 - (angleA + angleC));
    angleA = Math.toRadians(angleA);
    angleC = Math.toRadians(angleC);

    sideA = losSide(sideB, angleB, angleA);
    sideC = losSide(sideB, angleB, angleC);

    angleA = Math.toDegrees(angleA);
    angleB = Math.toDegrees(angleB);
    angleC = Math.toDegrees(angleC);
  }

  public void SSA() {
    ssa = true;
    System.out.print("Enter side A: ");
    sideA = s2deA = input.nextInt();
    System.out.print("Enter side B: ");
    sideB = s2deB = input.nextInt();
    System.out.print("Enter angle A: ");
    angleA = angl2A = Math.toRadians(input.nextInt());

    angleB = losAngle(sideA, angleA, sideB);
    angleC = Math.PI - (angleB + angleA);
    sideC = losSide(sideA, angleA, angleC);

    angleA = Math.toDegrees(angleA);
    angleB = Math.toDegrees(angleB);
    angleC = Math.toDegrees(angleC);

    // ambiguous case because ssa
    angl2B = Math.PI - losAngle(sideA, angleA, sideB);
    angl2C = Math.PI - (angl2A + angl2B);
    s2deC = losSide(s2deA, angl2A, angl2C);

    angl2A = Math.toDegrees(angl2A);
    angl2B = Math.toDegrees(angl2B);
    angl2C = Math.toDegrees(angl2C);
  }
  
  public void menu() {
    System.out.println("Enter 1 for SSS, 2 SAS, 3 ASA, 4 SSA ");
    choice = input.nextInt();
    switch(choice) {
      case 1: SSS();
      case 2: SAS();
      case 3: ASA();
      case 4: SSA();
    }
  }

  public void runner() {
    menu();
    display();
  }

  public void display() {
    if (!ssa) {
      System.out.println("Sides:");
      System.out.println("A: " + sideA + " B: " + sideB + " C: " + sideC);
      System.out.println("Angles:");
      System.out.println("A: " + angleA + " B: " + angleB + " C: " + angleC);
    } else {
      if (sideA == Math.sin(Math.toRadians(angleA)) * sideB) {
        System.out.println("Sides:");
        System.out.println("A: " + sideA + " B: " + sideB + " C: " + sideC);
        System.out.println("Angles:");
        System.out.println("A: " + angleA + " B: " + angleB + " C: " + angleC);
      } else if (sideA < sideB * Math.sin(Math.toRadians(angleA))) {
        System.out.println("No solutions for this triangle");
      } else {
        System.out.println("Sides:");
        System.out.println("A: " + sideA + " B: " + sideB + " C: " + sideC);
        System.out.println("Angles:");
        System.out.println("A: " + angleA + " B: " + angleB + " C: " + angleC);
        System.out.println("Alternative case:\nSides:");
        System.out.println("A: " + s2deA + " B: " + s2deB + " C: " + s2deC);
        System.out.println("Angles:");
        System.out.println("A: " + angl2A + " B: " + angl2B + " C: " + angl2C);
      }
    }
  }

  public static void main( String[] args){
    TriangleSolver triangle = new TriangleSolver();
    triangle.runner();
  }
}