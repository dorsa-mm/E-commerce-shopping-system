/*
 * Name: Dorsa Malekahmadi
 * Student ID: 501099909
 * 
 * 
 * A book IS A product that has additional information - e.g. title, author

 	 A book also comes in different formats ("Paperback", "Hardcover", "EBook")
 	 
 	 The format is specified as a specific "stock type" in get/set/reduce stockCount methods.
*/

public class Book extends Product 
{
  private String author;
  private String title;
  
  // Stock related information NOTE: inherited stockCount variable is used for EBooks
  int paperbackStock;
  int hardcoverStock;
  
  // year variable for the bonus (publication year)
  int year; 
  
  public Book(String name, String id, double price, int paperbackStock, int hardcoverStock, String title, String author, int year)
  {
	  // Make use of the constructor in the super class Product. Initialize additional Book instance variables. 
	  // Set category to BOOKS 
	  super(name, id, price, 100000, Product.Category.BOOKS);
	  this.title = title;
	  this.author = author;
	  this.paperbackStock = paperbackStock;
	  this.hardcoverStock = hardcoverStock;
	  this.year = year;
  }
    
  // Check if a valid format  
  public boolean validOptions(String productOptions)
  {
  	// check productOptions for "Paperback" or "Hardcover" or "EBook"
  	// if it is one of these, return true, else return false
	  
	  if (productOptions.equals("Paperback") || productOptions.equals("Hardcover") || productOptions.equals("EBook"))
	  {
		  return true;
	  }
	  return false;   
  }
  
  // getter and setter methods for the author and year for the bonus
  public String getAuthor()
	{
		return author;
	}

  public void setAuthor(String author)
	{
	  this.author = author;
	}

  public int getYear()
  {
	  return year;
  }
  
  public void setYear(int year)
  {
	  this.year = year;
  }
  
  
  // Override getStockCount() in super class.
  public int getStockCount(String productOptions)
	{
  	// Use the productOptions to check for (and return) the number of stock for "Paperback" etc
  	// Use the variables paperbackStock and hardcoverStock at the top. 
  	// For "EBook", use the inherited stockCount variable.
	  
	  if (productOptions.equals("Paperback"))
	  {
		  return paperbackStock;
	  }
	  else if (productOptions.equals("Hardcover"))
	  {
		  return hardcoverStock;
	  }
	  else if (productOptions.equals("EBook"))
	  {
		  return super.getStockCount(productOptions);
	  }
  	return 1;
	}
  
  
  public void setStockCount(int stockCount, String productOptions)
	{
    // Use the productOptions to check for (and set) the number of stock for "Paperback" etc
   	// Use the variables paperbackStock and hardcoverStock at the top. 
   	// For "EBook", set the inherited stockCount variable.
	  
	  if (productOptions.equals("Paperback"))
	  {
		  this.paperbackStock = stockCount;
	  }
	  else if (productOptions.equals("Hardcover"))
	  {
		  this.hardcoverStock = stockCount;
	  }
	  else if (productOptions.equals("EBook"))
	  {
		  super.setStockCount(stockCount, productOptions);	 
	  }
	}
  
  /*
   * When a book is ordered, reduce the stock count for the specific stock type
   */
  public void reduceStockCount(String productOptions)
	{
  	// Use the productOptions to check for (and reduce) the number of stock for "Paperback" etc
   	// Use the variables paperbackStock and hardcoverStock at the top. 
   	// For "EBook", set the inherited stockCount variable.
	  
	  if (productOptions.equals("Paperback"))
	  {
		  paperbackStock--;
	  }
	  else if (productOptions.equals("Hardcover"))
	  {
		  hardcoverStock--;
	  }
	  else if (productOptions.equals("EBook"))
	  {
		  super.reduceStockCount(productOptions);
	  }
	}
  
  
  /*
   * Print product information in super class and append Book specific information title and author
   */
  public void print()
  {
  	// Replace the line below.
  	// Make use of the super class print() method and append the title and author info. See the video
	// Append the year published for the bonus
	  super.print();
	  System.out.print(" Book Title: " + title + " Author: " + author + " Year published: " + year); 
  }
}
