import java.util.Scanner;
public class revnum
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
		System.out.println("The Reverse of the Number is "+sum);
	}
}
