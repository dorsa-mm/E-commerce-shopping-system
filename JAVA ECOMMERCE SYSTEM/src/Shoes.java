/*
 * Name: Dorsa Malekahmadi
 * Student ID: 501099909
 * 
 * 
 * A shoe IS A product that has additional information - e.g. color, size
 * A shoe's stock count depends on its color and size (10 combinations in total)
 * 
*/

public class Shoes extends Product
{
	// color and size variables for the pair of shoes
	private String color;
	private String size;
	
	//stock variables for each combination of size and color
	int blackStock6;
	int blackStock7;
	int blackStock8;
	int blackStock9;
	int blackStock10;
	int brownStock6;
	int brownStock7;
	int brownStock8;
	int brownStock9;
	int brownStock10;
	
	
	// Constructor for a Shoes object with inherited variables from superclass
	public Shoes(String name, String id, double price, int blackStock6, int blackStock7, int blackStock8, int blackStock9,
			int blackStock10, int brownStock6, int brownStock7, int brownStock8, int brownStock9, int brownStock10, String color, String size)
	{
		super(name, id, price, 10000, Product.Category.SHOES);
		this.blackStock6 = blackStock6;
		this.blackStock7 = blackStock7;
		this.blackStock8 = blackStock8;
		this.blackStock9 = blackStock9;
		this.blackStock10 = blackStock10;
		this.brownStock6 = brownStock6;
		this.brownStock7 = brownStock7;
		this.brownStock8 = brownStock8;
		this.brownStock9 = brownStock9;
		this.brownStock10 = brownStock10;
		this.color = color; 
		this.size = size;
		
	}
	
	
	// Check if a valid format  
	  public boolean validOptions(String productOptions)
	  {
	  	// check productOptions to see if valid
	  	// if it is one of these 10 combinations, return true, else return false
		  
		  if (productOptions.equals("Black 6") || productOptions.equals("Black 7") || productOptions.equals("Black 8") ||
				  productOptions.equals("Black 9") || productOptions.equals("Black 10") || productOptions.equals("Brown 6") || 
				  productOptions.equals("Brown 7") || productOptions.equals("Brown 8") || productOptions.equals("Brown 9") ||
				  productOptions.equals("Brown 10"))
		  {
			  return true;
		  }
		  return false;   
	  }
	  
	
	// Override getStockCount() in super class.
	  public int getStockCount(String productOptions)
		{
	  	// Use the productOptions to return the appropriate stock count for these 10 combinations
		  
		  if (productOptions.equals("Black 6"))
		  {
			  return blackStock6;
		  }
		  else if (productOptions.equals("Black 7"))
		  {
			  return blackStock7;
		  }
		  else if (productOptions.equals("Black 8"))
		  {
			  return blackStock8;
		  }
		  else if (productOptions.equals("Black 9"))
		  {
			  return blackStock9;
		  }
		  else if (productOptions.equals("Black 10"))
		  {
			  return blackStock10;
		  }
		  else if (productOptions.equals("Brown 6"))
		  {
			  return brownStock6;
		  }
		  else if (productOptions.equals("Brown 7"))
		  {
			  return brownStock7;
		  }
		  else if (productOptions.equals("Brown 8"))
		  {
			  return brownStock8;
		  }
		  else if (productOptions.equals("Brown 9"))
		  {
			  return brownStock9;
		  }
		  else if (productOptions.equals("Brown 10"))
		  {
			  return brownStock10;
		  }
	  	return 1;
		}
	  
	  
	// Override setStockCount() in super class
	  public void setStockCount(int stockCount, String productOptions)
		{
	    // Use the productOptions to set the stock to the appropriate stock variable for these 10 combinations
		  
		  if (productOptions.equals("Black 6"))
		  {
			  this.blackStock6 = stockCount;
		  }
		  else if (productOptions.equals("Black 7"))
		  {
			  this.blackStock7 = stockCount;
		  }
		  else if (productOptions.equals("Black 8"))
		  {
			  this.blackStock8 = stockCount;
		  }
		  else if (productOptions.equals("Black 9"))
		  {
			  this.blackStock9 = stockCount;
		  }
		  else if (productOptions.equals("Black 10"))
		  {
			  this.blackStock10 = stockCount;
		  }
		  else if (productOptions.equals("Brown 6"))
		  {
			  this.brownStock6 = stockCount;
		  }
		  else if (productOptions.equals("Brown 7"))
		  {
			  this.brownStock7 = stockCount;
		  }
		  else if (productOptions.equals("Brown 8"))
		  {
			  this.brownStock8 = stockCount;
		  }
		  else if (productOptions.equals("Brown 9"))
		  {
			  this.brownStock9 = stockCount;
		  }
		  else if (productOptions.equals("Brown 10"))
		  {
			  this.brownStock10 = stockCount;
		  }
		 
		}
	  
	 
	  /*
	   * When a shoe is ordered, reduce the stock count for the specific stock type
	   */
	  public void reduceStockCount(String productOptions)
		{
	  	// Use the productOptions to check which combination to reduce the stock count for
		  
		  if (productOptions.equals("Black 6"))
		  {
			  blackStock6--;
		  }
		  else if (productOptions.equals("Black 7"))
		  {
			  blackStock7--;
		  }
		  else if (productOptions.equals("Black 8"))
		  {
			  blackStock8--;
		  }
		  else if (productOptions.equals("Black 9"))
		  {
			  blackStock9--;
		  }
		  else if (productOptions.equals("Black 10"))
		  {
			  blackStock10--;
		  }
		  else if (productOptions.equals("Brown 6"))
		  {
			  brownStock6--;
		  }
		  else if (productOptions.equals("Brown 7"))
		  {
			  brownStock7--;
		  }
		  else if (productOptions.equals("Brown 8"))
		  {
			  brownStock8--;
		  }
		  else if (productOptions.equals("Brown 9"))
		  {
			  brownStock9--;
		  }
		  else if (productOptions.equals("Brown 10"))
		  {
			  brownStock10--;
		  }
		}
	  
	  
	  /*
	   * Print product information in super class and append shoe specific information color and size
	   */
	  public void print()
	  {
	  	// Make use of the super class print() method and append the color and size info
		  
		  super.print();
		  System.out.print(" Shoe Color: " + color + " Shoe Size: " + size);
	  }
	  
}
