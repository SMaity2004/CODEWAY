import java.util.*;
import java.util.Random;
class NumberGame
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        Random random=new Random();
        System.out.println("Welcome to the Number Game\nGuess the number within a set number of attempts to win the round\nEach round won grants 5 points");
        System.out.println();
        System.out.print("Enter starting range: ");
        int lb=sc.nextInt();
        System.out.print("Enter ending range: ");
        int ub=sc.nextInt(); 
        System.out.print("Enter maximum number of attempts (1-10): ");
        int max=sc.nextInt();
        if(max>=1 && max<=10)
        {
            System.out.println("Maximum number of attempts: "+max);
        }
        else
        {
            System.out.println("No more than 10 attempts!");
            System.exit(0);
        }
        System.out.println();
        int rounds=0;
        int total=0;
        boolean playAgain=true;
        int score=0;
        while (playAgain) 
        {
            int num=random.nextInt(ub-lb+1)+lb;
            int attempts=0;
            boolean cguess=false;
            System.out.println("Guess the number between " +lb+" and "+ub+".");
            while (attempts<max) 
            {
                System.out.print("Enter your guess: ");
                int guess=sc.nextInt();
                attempts++;
                if (guess==num) 
                {
                    System.out.println("Congratulations! You guessed the correct number in "+attempts+" attempt(s).\n");
                    cguess=true;
                    score+=5;
                    break;
                } 
                else if (guess<num && (num-guess)<=10) 
                {
                    System.out.println("Your guess is a Little Low!\n");
                }
                else if (guess<num && (num-guess)>10)
                {
                    System.out.println("Your guess is Too Low!\n");
                }
                else if (guess>num && (guess-num)<=10)
                {
                    System.out.println("Your guess is a Little High!\n");
                }
                else 
                {
                    System.out.println("Your guess is Too High!\n");
                }
            }
            if (!cguess) 
            {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: "+num+"\n");
            }
            total+=attempts;
            rounds++;
            System.out.print("Do you want to play again? (yes/no): ");
            String response=sc.next();
            System.out.println();
            if (!response.equalsIgnoreCase("yes")) 
            {
                playAgain = false;
            }
        }
        System.out.println("Game Over!");
        System.out.println("Total rounds played: "+rounds);
        System.out.println("Total attempts made: "+total);
        System.out.println("Score: "+score);
    }
}