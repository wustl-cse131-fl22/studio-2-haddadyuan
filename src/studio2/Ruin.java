package studio2;
import java.util.Scanner;
public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double startAmount;
		double amount;
		double winChance;
		int winLimit;
		int days;
		int playCount;
		int loseCount=0;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter Start Amount");
		startAmount = in.nextDouble();
		
		System.out.println("Enter win chance");
		winChance = in.nextDouble();
		
		System.out.println("Enter win limit");
		winLimit = in.nextInt();
		
		System.out.println("Enter num of sim");
		days = in.nextInt();
		
	
		for(int i = 0; i<days; i++)
		{
			amount = startAmount;
			int winCount = 0;
			playCount = 0;
		
		while(amount>0&& winCount< winLimit) {
			
			if (Math.random()<winChance) 
			{
				amount++;
				winCount++;
				
			}
			else 
			{
				amount--;
				

			}
			playCount++;
		}
		if(amount<=0) {
			System.out.println("Simumlation "+i+": "+playCount+" LOSE");
			loseCount++;
			
		}
		else {
			System.out.println("Simumlation "+i+": "+playCount+" WIN");
		}
		

		}
		
		System.out.println("Losses: "+loseCount+" Simulations: "+days);
		
		double ruinRate;
		if(winChance == 0.5) {
			ruinRate = 1-(startAmount/winLimit);
		}
		else {	
		
		double alpha = (1-winChance)/winChance;
		ruinRate= (Math.pow(alpha, startAmount)-Math.pow(alpha,winLimit))/(1-Math.pow(alpha, winLimit));
		}
		System.out.println("Ruin rate from sim: "+(loseCount/(double)days)+" Expected ruin rate:" + ruinRate );
	}

}
