import java.util.Scanner;
public class sumofn
{
	public static void main(String[] arg)
	{
		int n,i,sum = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no.of Numbers:");
		n = sc.nextInt();
		for(i = 1;i <= n;i++)
		{
			System.out.println(i);
		}
		for(i = 0;i <= n;i++)
		{
			sum = sum + i;
		}
		System.out.println("The sum of numbers = "+sum);
	}
}
