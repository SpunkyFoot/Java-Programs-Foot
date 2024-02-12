import java.util.Scanner;
public class palindrome
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
			sum = sum*10 + n;
			temp = temp/10;
		}
		if (sum == num)
		{
			System.out.println("The Number is a Palindrome.");
		}
		else
		{
			System.out.println("The Number is not a Palindrome.");
		}
	}
}
