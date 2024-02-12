	import java.util.Scanner;
public class armstrong
{
	public static void main(String[] arg)
	{
		int num,sum = 0,temp,n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number:");
		num = sc.nextInt();
		temp = num;
		while(temp != 0)
		{
			n = temp % 10;
			sum = sum + (n * n * n);
			temp = temp/10;
		}
		if (sum == num)
		{
			System.out.println("The Number is an Armstrong Number.");
		}
		else
		{
			System.out.println("The Number is not an Armstrong Number.");
		}
	}
}
