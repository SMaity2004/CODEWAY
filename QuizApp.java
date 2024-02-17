import java.util.*;
class QuizApp
{
    private static final int q_count=5;
    private static final int t_count=10; 
    private static Scanner sc=new Scanner(System.in);

    private static String[] questions={"Semper Fidelis is the motto of which military service?\nA. The United States Marine Corps\nB. The United States Air Force\nC. The United States Coast Guard\nD. The United States Navy",
            "Who was the first chief justice of the United States?\nA. William Howard Taft\nB. Earl Warren\nC. John Jay\nD. Charles Evans Hughes",
            "Which is the largest state in the New England region of the United States?\nA. Connecticut\nB. New Hampshire\nC. Vermont\nD. Maine",
            "Which American state was the first to ratify the federal Constitution?\nA. Delaware\nB. Pennsylvania\nC. Connecticut\nD. New Jersey",
            "Who appoints the director of the Federal Bureau of Investigation?\nA. The Chief of Staff,\nB. The U.S. President\nC. The Chief Justice\nD. The U.S. Vice President"};

    private static String[] answers={"A","C","D","A","B"};
    public static void main(String[] args) 
    {
        System.out.println("Welcome to the Quiz Game!\nYou have 10 seconds to answer each question.\n");
        int score=0;
        for (int i=0;i<q_count;i++) 
        {
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            System.out.print("Your answer: ");
            Thread timerThread=new Thread(new TimerRunnable());
            timerThread.start();
            String userAnswer=sc.nextLine();
            timerThread.interrupt(); 
            if (userAnswer.trim().equalsIgnoreCase(answers[i])) 
            {
                System.out.println("Correct!");
                score++;
            } 
            else 
            {
                System.out.println("Sorry! The correct answer is: Option " + answers[i]);
            }
            System.out.println();
        }
        System.out.println("Quiz ended! Your score is: " + score + "/" + q_count);
    }

    static class TimerRunnable implements Runnable 
    {
        @Override
        public void run() 
        {
            try 
            {
                Thread.sleep(t_count * 1000);
                System.out.println("\nTime's up!\nPlease press 'Enter' to display the correct answer and the next question.");
                System.out.println();
            } 
            catch (InterruptedException e) 
            {
            }
        }
    }
}
