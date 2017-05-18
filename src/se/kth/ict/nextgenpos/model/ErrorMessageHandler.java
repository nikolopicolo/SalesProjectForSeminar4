package se.kth.ict.nextgenpos.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Used for printing standardized messages to the view in case of errors.
 */
public class ErrorMessageHandler
{
    /**
     *              Shows a standardized message that is shown to the user in the user interface.
     * @param msg   The message that can be hard coded in the view.
     */
    public void showErrorMsgToUser(String msg)
    {
        StringBuilder errorMsgBuilder = new StringBuilder();
        errorMsgBuilder.append(msg);
        System.out.println(errorMsgBuilder);
    }

    /**
     *              Writes a more detailed description of the nature of the error to the log file.
     * @param msg   The message that is written to the log file.
     * @return      The message that is written to the log file.
     */
    public String writeErrorMsgToLog(String msg)
    {
        StringBuilder errorMsgBuilder = new StringBuilder();
        errorMsgBuilder.append(", ERROR: ");
        errorMsgBuilder.append(msg);
        return errorMsgBuilder.toString();

    }

}
