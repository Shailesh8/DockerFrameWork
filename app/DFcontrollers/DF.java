
package DFcontrollers;


import play.*;
import play.mvc.*;
import views.html.*;
import com.df.logger.LoggerConstants;


public class DF extends Controller {

    public static Result index() {
        
     	Logger.of(LoggerConstants.DF).debug(LoggerConstants.METHODENTRY);
    	return ok();
    }

}
