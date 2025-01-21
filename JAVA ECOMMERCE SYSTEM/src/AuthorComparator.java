import java.util.Comparator;


public class AuthorComparator implements Comparator<Product>
{

	public int compare(Product b1, Product b2)
	{
		if (b1.getYear() == b2.getYear())
		{
			return 0;
		}
		else if (b1.getYear() > b2.getYear())
		{
			return 1;
		}
		else 
		{
			return -1;
		}
	}
}


