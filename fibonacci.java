import java.util.Scanner;
public class fibonacci
{
	public static void main(String[] arg)
	{
		int a = 0,b = 1,c = 0;
		System.out.println(a);
		System.out.println(b);
		do
		{
			c = a + b;
			a = b;
			b = c;
			if(c < 100)
			{
				System.out.println(c);
			}
		}while(c < 100);
	}
}
