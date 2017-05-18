package se.kth.ict.nextgenpos.model;

/**
 * If the item does not exist in the product catalog.
 */
public class ItemIdDoesNotExistException extends Exception{
    private int itemId;
    private String message = "Exception thrown in class ProductCatalog on line 38. The item id does not exist.";

    public ItemIdDoesNotExistException(int itemId){

        this.itemId = itemId;
    }

    /**
     *          Shows an error message.
     * @return  The string representation of the error message.
     */
    public String getMessage()
    {
        return message;
    }

    /**
     *          The id number of the failed id-number search.
     * @return  The searched item id.
     */
    public int getItemId() {
        return this.itemId;
    }

}
