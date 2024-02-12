import java.util.Scanner;
public class markListi
{
	public static void main(String[] arg)
	{
		int DS_mark,LSD_mark,OOP_mark,SE_mark,DE_mark;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter DS Mark:");
		DS_mark = sc.nextInt();
	
		System.out.println("Enter LSD Mark:");
		LSD_mark = sc.nextInt();
	
		System.out.println("Enter OOP Mark:");
		OOP_mark = sc.nextInt();
	
		System.out.println("Enter SE Mark:");
		SE_mark = sc.nextInt();
			
		System.out.println("Enter DE Mark:");
		DE_mark = sc.nextInt();
		
		System.out.println("DS Mark = "+DS_mark);
	
		System.out.println("LSD Mark = "+LSD_mark);
	
		System.out.println("OOP Mark = "+OOP_mark);
	
		System.out.println("SE Mark = "+SE_mark);
	
		System.out.println("DE Mark = "+DE_mark);
	}
}
