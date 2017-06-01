package se.kth.ict.nextgenpos.model;

import se.kth.ict.nextgenpos.Interface.Observable;
import se.kth.ict.nextgenpos.Interface.Observer;
import java.util.*;
import java.util.Map;
import java.util.HashMap;




/**
 * This class is responsible for all access to the product database.
 */ 
public class ProductCatalog implements Observable {
    private Map<Integer, ProductSpecification> products = 
	new HashMap<Integer, ProductSpecification>();
	private ArrayList<Observer> observers = new ArrayList<>();
	private int counter = 3;




	/**
     * Fills the catalog with some dummy items.
     */
    public ProductCatalog()
	{
	products.put(1, new ProductSpecification(1, "low fat milk", 
	   "a very long description, a very long description, a very long description", 12));
	products.put(2, new ProductSpecification(2, "butter", 
	   "a very long description, a very long description, a very long description", 43));
	products.put(3, new ProductSpecification(3, "bread", 
	   "a very long description, a very long description, a very long description", 22));
    }


	/**
	 * All the products in the current product catalog.
	 * @return The current product catalog.
	 */
	public Collection<ProductSpecification> getAllProducts()
	{
		return products.values();
	}

	/**
	 * Adds a product to the product catalog.
	 * @param productToAdd The specified product to be added
	 */
	public void addProduct(ProductSpecification productToAdd)
	{
		products.put(++counter, productToAdd);
		for (Observer observer:observers)
		{
			observer.stateHasChanged();
		}
	}






	/**
     * Search for an item in the product catalog.
     *
     * @param    itemId The item to look for
     * @return          The specification for the found item or null if no item was found.
     */
    public ProductSpecification findSpecification(int itemId) throws ItemIdDoesNotExistException
	{
		if (products.get(itemId) == null)
		{
			throw new ItemIdDoesNotExistException(itemId);



		}
    	return products.get(itemId);
    }



	/**
	 * Adds an observer to the class that implements this interface.
	 *
	 * @param observer is notified when change is made.
	 */
	@Override
	public void addObserver(Observer observer)
	{
		observers.add(observer);
	}

}
