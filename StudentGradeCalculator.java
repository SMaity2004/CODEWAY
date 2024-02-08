import java.util.*;
class StudentGradeCalculator 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to the Student Grade Calculator\nYou can calculate the Total Marks, Average Percentage and Grade of a student.\n");
        System.out.print("Enter the number of subjects: ");
        int num=sc.nextInt();
        int total=0;
        int sum=num*100;
        for (int i=1;i<=num;i++) 
        {
            System.out.print("Enter the marks obtained in Subject " + i + "(out of 100): ");
            int marks = sc.nextInt();
            total+=marks;
        }
        double avg=(double)total/num;
        System.out.println("\nTotal Marks Obtained: "+total+" out of "+sum);
        System.out.printf("Average Percentage: %.2f%%\n",avg);
        String grade=calculate(avg);
        System.out.println("Grade Obtained: "+grade);
        sc.close();
    }
    public static String calculate(double average) 
    {
        if (average>=90) 
        {
            return "A+";
        } 
        else if (average>=80) 
        {
            return "A";
        } 
        else if (average>=70) 
        {
            return "B";
        } 
        else if (average>=60) 
        {
            return "C";
        } 
        else if (average>=50) 
        {
            return "D";
        } 
        else 
        {
            return "F";
        }
    }
}