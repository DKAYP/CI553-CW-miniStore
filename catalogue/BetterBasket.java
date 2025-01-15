package catalogue;

import java.io.Serializable;
import java.util.Collections;

/**
 * Write a description of class BetterBasket here.
 * 
 * @author  Your Name 
 * @version 1.0
 */
public class BetterBasket extends Basket implements Serializable
{
  private static final long serialVersionUID = 1L;
  
  // Example Change 11
  // You need to add code here
  // merge the items for same product,
  // or sort the item based on the product number
  
  @Override
  public boolean add( Product newProduct )
  {               
	  int i = 0;
	  int countProducts = this.size();
	  
	  // loop to look at every location in the arraylist
	  for(i = 0; i < countProducts; i++)
	  {
		  //get the product from the basket
		  Product basketProduct = this.get(i);
		  
		  // check if the product numbers match
		  if (basketProduct.getProductNum() == newProduct.getProductNum())
		  {
			  // increase the quantity
			  basketProduct.setQuantity(1 + basketProduct.getQuantity());
			  // save it back in the array
			  this.set(i, basketProduct);
			  // no point checking anything else so return
			  return true;
		  }
	  }
	// we didnt find the product in the basket so add it instead
    return super.add( newProduct );   
  }
  
  @Override
  public String getDetails()
  {
	  //added  a comparator function to Product class so that java can sort the array
	  this.sort(null);
	  return super.getDetails();
  }
}
