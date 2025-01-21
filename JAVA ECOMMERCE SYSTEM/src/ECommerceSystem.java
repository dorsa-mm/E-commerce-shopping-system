import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


/*
 * Name: Dorsa Malekahmadi
 * Student ID: 501099909
 * 
 * 
 * Models a simple ECommerce system. Keeps track of products for sale, registered customers, product orders and
 * orders that have been shipped to a customer
 */


public class ECommerceSystem
{
    private ArrayList<Product>  products = new ArrayList<Product>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();	
    private ArrayList<Product> books = new ArrayList<Product>();	
    
    private ArrayList<ProductOrder> orders   = new ArrayList<ProductOrder>();
    private ArrayList<ProductOrder> shippedOrders   = new ArrayList<ProductOrder>();
    
    // These variables are used to generate order numbers, customer id's, product id's 
    private int orderNumber = 500;
    private int customerId = 900;
    private int productId = 700;
    
    // General variable used to store an error message when something is invalid (e.g. customer id does not exist)  
    String errMsg = null;
    
    // Random number generator
    Random random = new Random();
    
    public ECommerceSystem()
    {
    	// NOTE: do not modify or add to these objects!! - the TAs will use for testing
    	// If you do the class Shoes bonus, you may add shoe products
    	
    	// Create some products. Notice how generateProductId() method is used
    	products.add(new Product("Acer Laptop", generateProductId(), 989.0, 99, Product.Category.COMPUTERS));
    	products.add(new Product("Apex Desk", generateProductId(), 1378.0, 12, Product.Category.FURNITURE));
    	products.add(new Book("Book", generateProductId(), 45.0, 4, 2, "Ahm Gonna Make You Learn", "T. McInerney", 1990));
    	products.add(new Product("DadBod Jeans", generateProductId(), 24.0, 50, Product.Category.CLOTHING));
    	products.add(new Product("Polo High Socks", generateProductId(), 5.0, 199, Product.Category.CLOTHING));
    	products.add(new Product("Tightie Whities", generateProductId(), 15.0, 99, Product.Category.CLOTHING));
    	products.add(new Shoes("Shoes", generateProductId(), 125.00, 3, 3, 2, 2, 1, 5, 7, 3, 2, 3, "Black/Brown", "6-10"));
    	products.add(new Shoes("Shoes", generateProductId(), 74.00, 8, 4, 5, 2, 2, 4, 3, 1, 2, 2, "Black/Brown", "6-10"));
    	products.add(new Book("Book", generateProductId(), 35.0, 4, 2, "How to Fool Your Prof", "D. Umbast", 1980));
    	products.add(new Book("Book", generateProductId(), 45.0, 4, 2, "How to Escape from Prison", "A. Fugitive", 1978));
    	products.add(new Book("Book", generateProductId(), 44.0, 14, 12, "Ahm Gonna Make You Learn More", "T. McInerney", 1989));
    	products.add(new Product("Rock Hammer", generateProductId(), 10.0, 22, Product.Category.GENERAL));
    	products.add(new Shoes("Shoes", generateProductId(), 35.00, 4, 4, 5, 3, 4, 7, 4, 5, 2, 10, "Black/Brown", "6-10"));
    	products.add(new Shoes("Shoes", generateProductId(), 50.00, 4, 3, 5, 2, 2, 1, 8, 7, 5, 2, "Black/Brown", "6-10"));
    	
    	
    	// Create some customers. Notice how generateCustomerId() method is used
    	customers.add(new Customer(generateCustomerId(),"Inigo Montoya", "1 SwordMaker Lane, Florin"));
    	customers.add(new Customer(generateCustomerId(),"Prince Humperdinck", "The Castle, Florin"));
    	customers.add(new Customer(generateCustomerId(),"Andy Dufresne", "Shawshank Prison, Maine"));
    	customers.add(new Customer(generateCustomerId(),"Ferris Bueller", "4160 Country Club Drive, Long Beach"));
    }
    
    
    
    private String generateOrderNumber()
    {
    	return "" + orderNumber++;
    }

    private String generateCustomerId()
    {
    	return "" + customerId++;
    }
    
    private String generateProductId()
    {
    	return "" + productId++;
    }
    
    public String getErrorMessage()
    {
    	return errMsg;
    }
    
    public void printAllProducts()
    {
    	for (Product p : products)
    		p.print();
    }
    
    // Print all products that are books. See getCategory() method in class Product
    public void printAllBooks()
    {
    	for (Product p : products)
    	{
    		if (p.getCategory().equals(Product.Category.BOOKS))
    		{
    			p.print();
    		}
    	}
    }
    
    // Print all current orders
    public void printAllOrders()
    {
    	for (ProductOrder o : orders)
    	{
    		o.print();
    	}
    }
    
    // Print all shipped orders
    public void printAllShippedOrders()
    {
    	for (ProductOrder or : shippedOrders)
    	{
    		or.print();
    	}
    }
    
    // Print all customers
    public void printCustomers()
    {
    	for (Customer c : customers)
    		c.print();
    }
    
    
 
    /*
     * Given a customer id, print all the current orders and shipped orders for them (if any)
     */
    public boolean printOrderHistory(String customerId)
    {
      // Make sure customer exists - check using customerId
    	// If customer does not exist, set errMsg String and return false
    	// see video for an appropriate error message string
    	
    	ArrayList<String> ids = new ArrayList<String>();
    	
    	for (Customer c : customers)
    	{
    		ids.add(c.getId());
    	}
    	
    	if (ids.contains(customerId) == false)
    	{
    		errMsg = "Customer " + customerId + " Not Found";
    		return false;
    	}
    	    	 

    	// Print current orders of this customer 
    	System.out.println("Current Orders of Customer " + customerId);
    	// enter code here
    	for (ProductOrder or : orders)
    	{
    		if (or.getCustomer().getId().equals(customerId))
    		{
    			or.print();
    		}
    	}
      	
    	// Print shipped orders of this customer 
    	System.out.println("\nShipped Orders of Customer " + customerId);
    	//enter code here
    	for (ProductOrder shipped : shippedOrders)
    	{
    		if (shipped.getCustomer().getId().equals(customerId))
    		{
    			shipped.print();
    		}
    	}
    
    	return true;
    }
    
    
    public String orderProduct(String productId, String customerId, String productOptions)
    {
    	// First check to see if customer object with customerId exists in array list customers
    	// if it does not, set errMsg and return null (see video for appropriate error message string)
    	// else get the Customer object

    	ArrayList<String> custIds = new ArrayList<String>();
    	Customer cust = null;
    	
    	for (Customer c : customers)
    	{
    		custIds.add(c.getId());
    	}
    	
    	if (custIds.contains(customerId) == false)
    	{
    		errMsg = "Customer " + customerId + " Not Found";
    		return null;
    	}
    	else
    	{
    		for (Customer c : customers)
    		{
    			if (c.getId().equals(customerId))
    			{
    				cust = c;
    			}
    		}
    	}
    	
    	// Check to see if product object with productId exists in array list of products
    	// if it does not, set errMsg and return null (see video for appropriate error message string)
    	// else get the Product object 

    	ArrayList<String> prodIds = new ArrayList<String>();
    	Product pro = null;
    	
    	for (Product p : products)
    	{
    		prodIds.add(p.getId());
    	}
    	
    	if (prodIds.contains(productId) == false)
    	{
    		errMsg = "Product " + productId + " Not Found";
    		return null;
    	}
    	else
    	{
    		for (Product p : products)
    		{
    			if (p.getId().equals(productId))
    			{
    				pro = p;
    			}
    		}
       	}
    	
    	// Check if the options are valid for this product (e.g. Paperback or Hardcover or EBook for Book product)
    	// See class Product and class Book for the method vaidOptions()
    	// If options are not valid, set errMsg string and return null;
    
    	if (pro.getCategory().equals(Product.Category.BOOKS))
    	{
    		if (!pro.validOptions(productOptions))
        	{
        		errMsg = "Product Book ProductId " + productId + " Invalid Options: " + productOptions;
        		return null;
        	}
    	}
    	else if (pro.getCategory().equals(Product.Category.SHOES))
    	{
    		if (!pro.validOptions(productOptions))
    		{
    			errMsg = "Product Shoes ProductId " + productId + " Invalid Size and/or Color Options: " + productOptions;
    			return null;
    		}
    	}
    	else
    	{
    		if (!pro.validOptions(productOptions))
    		{
    			errMsg = "Use the ORDER action to order this product.";
    			return null;
    		}
    	}
    	
    	// Check if the product has stock available (i.e. not 0)
    	// See class Product and class Book for the method getStockCount()
    	// If no stock available, set errMsg string and return null
    	
    	if (pro.getStockCount(productOptions) == 0)
		{
			errMsg = "Not in stock";
			return null;
		}
    	
    	
      // Create a ProductOrder, (make use of generateOrderNumber() method above)
    	// reduce stock count of product by 1 (see class Product and class Book)
    	// Add to orders list and return order number string
    	
    	ProductOrder newOr = new ProductOrder(generateOrderNumber(), pro, cust, productOptions);
    	orders.add(newOr);
    	pro.reduceStockCount(productOptions);
    	
    	return "Order # " + newOr.getOrderNumber();
    }
    
    
   
    /*
     * Create a new Customer object and add it to the list of customers
     */
    public boolean createCustomer(String name, String address)
    {
    	// Check name parameter to make sure it is not null or ""
    	// If it is not a valid name, set errMsg (see video) and return false
    	// Repeat this check for address parameter
    	// Create a Customer object and add to array list
  
    	if (name == "")
    	{
    		errMsg = "Invalid Customer Name";
    		return false;
    	}
    	if (address == "")
    	{
    		errMsg = "Invalid Customer Address";
    		return false;
    	}

    	Customer newcust = new Customer(generateCustomerId(), name, address);
		customers.add(newcust);
    	return true;
    }
    
    
    public ProductOrder shipOrder(String orderNumber)
    {
      // Check if order number exists first. If it doesn't, set errMsg to a message (see video) 
    	// and return false
    	// Retrieve the order from the orders array list, remove it, then add it to the shippedOrders array list
    	// return a reference to the order
    	
     	ArrayList<String> nums = new ArrayList<String>();
    	ProductOrder ord = null;
    	ProductOrder temp = null;
    	
    	for (int i = 0; i < orders.size(); i++)
    	{
    		nums.add(orders.get(i).getOrderNumber());
    	}

    	if (nums.contains(orderNumber) == false)
    	{
    		errMsg = "Order " + orderNumber + " Not Found";
    		return null;
    	}
    	
    	for (ProductOrder o : orders)
		{
			if (o.getOrderNumber().equals(orderNumber))
			{
				temp = o;
			}
		}
    	orders.remove(temp);
		shippedOrders.add(temp);
		ord = temp;
		
       	return ord;
  
    }
    
    
    /*
     * Cancel a specific order based on order number
     */
    public boolean cancelOrder(String orderNumber)
    {
      // Check if order number exists first. If it doesn't, set errMsg to a message (see video) 
    	// and return false
    	
    	ArrayList<String> nums = new ArrayList<String>();
    	ProductOrder temp = null;
    	
    	for (int i = 0; i < orders.size(); i++)
    	{
    		nums.add(orders.get(i).getOrderNumber());
    	}

    	if (nums.contains(orderNumber) == false)
    	{
    		errMsg = "Order " + orderNumber + " Not Found";
    		return false;
    	}
       	else
    	{
    		for (ProductOrder or : orders)
    		{
    			if (or.getOrderNumber().equals(orderNumber))
    			{
    				temp = or;
    			}
    		}
    	}
    	orders.remove(temp);
    	
       	return true;
    }
    
    
  
    // Sort products by increasing price
    public void sortByPrice()
    {
       	Collections.sort(products, new PriceComparator());
    }
    
    // Sort products alphabetically by product name
    public void sortByName()
    {
  	  Collections.sort(products, new NameComparator());
    }
    
    // Sort customers alphabetically by customer name
    public void sortCustomersByName()
    {
    	Collections.sort(customers, new CustComparator());
    }
    
    //Sort and print books of an author by publication year 
    public void sortByAuthor(String author)
    {
    	if (!books.isEmpty())
    	{
    		books.clear();
    	}
    	
    	for (Product p : products)
    	{
    		if (p.getCategory().equals(Product.Category.BOOKS) && p.getAuthor().equals(author))
    		{
    			books.add(p);
    		}
    	}
    	
    	 Collections.sort(books, new AuthorComparator());
    	 for (Product b : books)
    	 {
    		 b.print();
    	 }
    	
    }
}
