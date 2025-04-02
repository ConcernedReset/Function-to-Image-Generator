package functionToImage;

public class Funcs {
	public static int sumEvens(int num)
	{
		if (num < 10 && num % 2 == 0)
			return num;
		else if (num < 10)
			return 0;
		else if (num >= 10 && num % 2 == 0)
			return num % 10 + sumEvens(num / 10);
		else
			return sumEvens(num / 10);
	}
	
	public static int multiplyEvens(int num)
	{
		if (num == 1)
			return 2;
		else if (num <= 0)
			throw new IllegalArgumentException();
		
		return multiplyEvens(num-1) * num*2;
	}
}
