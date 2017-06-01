package se.kth.ict.nextgenpos.view;

import se.kth.ict.nextgenpos.Interface.Observer;
import se.kth.ict.nextgenpos.controller.Controller;
import se.kth.ict.nextgenpos.model.ErrorMessageHandler;
import se.kth.ict.nextgenpos.model.ItemIdDoesNotExistException;
import java.util.Collection;
import java.util.logging.Logger;
import se.kth.ict.nextgenpos.model.ProductSpecification;



/**
 * A placeholder for the view.
 */
public class View implements Observer
{
    private Controller cont;
	private static final Logger LOGGER = Logger.getLogger( ItemIdDoesNotExistException.class.getName() );


    /**
     * Creates a new <code>View</code>.
     * @param cont           The controller of the application.
     */
    public View(Controller cont)
	{
		this.cont = cont;
		cont.getCatalog().addObserver(this);
    }

    /**
     * Simulates a view. Makes some calls to the controller.
     */
    public void test() {
	cont.makeNewSale();
	enterItem(1);
	System.out.println(">>>>> NOTE!!\n" +
			   "A null pointer exception will follow since there is no handling" + 
			   " of non-existing item ids. When you have implemented exception" +
			   " handling, there should be some informative printout instead of the" +
			   " exception stack trace.");
	enterItem(10);
    }


	/**
	 *
	 * @param itemId
	 */
	private void enterItem(int itemId)
	{
		try
		{
			int quantity = 1;
			System.out.println("");
			System.out.println("Result for item " + itemId + ": " + cont.enterItem(itemId, quantity));
			System.out.println("");

		} catch (ItemIdDoesNotExistException e)
		{
			ErrorMessageHandler errorMessageHandler = new ErrorMessageHandler();
			errorMessageHandler.showErrorMsgToUser("Item " + e.getItemId() + " does not exist in the product catalog. Please try with a new id-number.");
			LOGGER.info(errorMessageHandler.writeErrorMsgToLog(e.getMessage()));


		} catch (Exception e)
		{
			ErrorMessageHandler errorMessageHandler = new ErrorMessageHandler();
			errorMessageHandler.showErrorMsgToUser("Failed due to unknown reason.");
			LOGGER.info(errorMessageHandler.writeErrorMsgToLog("Failed due to unknown reason."));
		}




	}

		/**
	 	* Is called when the observable state changes.
	 	*/
		@Override
		public void stateHasChanged() {
			Collection<ProductSpecification> products = cont.getCatalog().getAllProducts();
			for (ProductSpecification product : products) {
				LOGGER.info(product.toString());
			}
		}
}
