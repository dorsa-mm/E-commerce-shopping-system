Name: Dorsa Malekahmadi

-----------------------
Project overview: 
This project simulates an E-commerce system like amazon, where there are customers and products (with different categories). 
Customers can order a product, the system can ship the product to the customer, and an unshipped order can be cancelled.
The system keeps track of all products, customers, orders, shipped orders, stockcounts, etc.

How the system works:
Through ECommerceUserInterface.java, the user can type in each action work (eg. PRODS/prods) in the console. The system then does what 
the action is programmed to do. ECommerceSystem is the bulk of the project, and other .java files are classes that help the system run. 

-----------------------
ACTIONS:
1. PRODS
2. BOOKS
3. CUSTS
4. NEWCUST
5. ORDER
6. ORDERBOOK
7. ORDERSHOES
8. SHIP
9. ORDERS
10. SHIPPED
11. CUSTORDERS
12. CANCEL
13. SORTBYPRICE
14. SORTBYNAME
15. SORTCUSTS
16. BOOKSBYAUTHOR (bonus)
17. Q/QUIT
18. Typing nothing
*OTHER*
19. Extra information

-----------------------

ACTIONS EXPLAINED:

1. PRODS action:
When user types in PRODS, all products available to be ordered are printed.

2. BOOKS action:
When user types in BOOKS, all books (products that are books) are printed.

3. CUSTS action:
When user types in CUSTS, all the customers the system already has are printed.

4. NEWCUST action: 
When user types in NEWCUST, they are prompted to type in a name and address, and a new customer is created with those specifics.
By typing in CUSTS again, the new customer is printed after all the previous customers. 
ERROR: If name is empty or address is empty, the system does not create the customers and gives an error message.

5. ORDER action:
When user types in ORDER, they are prompted to type in a product id, which all products have.
User then types in a customer id (for which customer the order is placed), which all customers have.
An order is made and an order number is generated and printed, and added to the ORDERS list. (user can see all orders placed
through the ORDERS action). 
ERROR: If the given product id or customer id are not valid, the order is not created and an error message is given.
ERROR: If the given product id is a BOOK's product id or SHOES's product id, the order is not created and an error message is given. 

6. ORDERBOOK action:
When user types in ORDERBOOK, they are prompted to type in a product id that specifies a Book product.
User then types in a customer id (for which customer the order is placed). 
User is then prompted to choose a book Option (Paperback/Hardcover/EBook), since the product is a book.
An order is made and an order number is generated and printed, and added to the ORDERS list. (user can see all orders placed
through the ORDERS action). 
ERROR: If the given product id or customer id are not valid, the order is not created and an error message is given.
ERROR: If the product id is the product id of a product that is NOT a BOOK, an error message is given. 

7. ORDERSHOES action:
When user types in ORDERSHOES, they are prompted to type in a product id that specifies a Shoes product.
User then types in a customer id (for which customer the order is placed). 
User is then prompted to choose a Shoe color (Black/brown, and Shoe size (6/7/8/9/10), since the product is a Shoes.
An order is made and an order number is generated and printed, and added to the ORDERS list. (user can see all orders placed
through the ORDERS action). 
ERROR: If the given product id or customer id are not valid, the order is not created and an error message is given.
ERROR: If the product id is the product id of a product that is NOT a SHOES, an error message is given.

8. SHIP action:
When user types in SHIP, they are prompted to type in an order's order number for which they want to ship to the customer. 
That order is then removed from the ORDERS list and added to the SHIPPED list, since it is now a shipped order. 
ERROR: If an order with that order number does not exist, an error message is given.

9. ORDERS action:
When user types in ORDERS, a list of all orders placed is printed (it does not include any shipped orders)

10. SHIPPED action:
When user types in SHIPPED, a list of all orders that have been shipped (using the SHIP action) is printed. 

11. CUSTORDERS action:
When user types in CUSTORDERS, they are prompted to type in a customer's customer id for which they want to view all current and 
shipped orders. 
A list of that customer's current orders and shipped orders are printed. 
ERROR: If the customer id is invalid (non existent customer), an error message is given.

12. CANCEL action:
When user types in CANCEL, they are prompted to type in an order's order number for which they want to cancel.
That order is then removed from the ORDERS and is no longer an order in the system (user can only cancel an order that has not yet been
shipped)
ERROR: If the order number is not valid (non existent order (shipped order numbers also do not count)), an error message is given.

13. SORTBYPRICE action:
When user types in SORTBYPRICE, the products are sorted from lowest to highest price. Nothing is printed, PRODS are sorted.
User can then type in PRODS to view all the products sorted by price.

14. SORTBYNAME action:
When user types in SORTBYNAME, the products are sorted by name alphabetically. Nothing is printed, PRODS are sorted.
User can then type in PRODS to view all the products sorted by name alphabetically.

15. SORTCUSTS action:
When user types in SORTBYCUSTS, the customers are sorted by name alphabetically. Nothing is printed, CUSTOMERS are sorted.
User can then type in CUSTS to view all the customers sorted by name alphabetically.

16. BOOKSBYAUTHOR action (bonus question):
When user types in BOOKSBYAUTHOR, they are prompted to type in an author's name, from the list of BOOKS. 
That author's books are then sorted and printed by lowest to highest publication year.
For this bonus action, a publication year was added to each Book product.

17. Q/QUIT action:
When user types in Q or QUIT, they quit/exit the system.

18. Typing nothing:
When user does not type anything (eg. hits Enter), the system continues and user can type something again. 

19. OTHER:
Added author and year variables and getter/setter for both to Product.java (not used) and Book.java to be able to do the bonus question. 

Added year to the products that are a Book in ECommerceSystem.java for the bonus question.

Added Shoes products in ECommerceSystem.java products.

Subclass Shoes is very similar to subclass Book, and has a stockcount for every 10 combinations. 

Stock counts for book and shoes, as well as all othe products: They get reduced according to how many is ordered, and if not 
in stock anymore, an error message is given.

Bonus: The bonus question is done, where a BOOKSBYAUTHOR action has been added to ECommerceUserInterface.java and 
sortByAuthor method has been added to ECommerceSystem.java to sort an author's book by year. 

For any product, after it hasbeen ordered, its stock gets reduced by 1 (depends on what type of product it is - eg. if non-book or non-shoes product,
its stock gets reduced by 1, if books, the stock of the type gets reduced (eg. Hardcover), if shoes, the stock for that size with that color gets reduced.

4 java files (classes which use comparator interface) have been made that are used for the 4 sort methods. 





