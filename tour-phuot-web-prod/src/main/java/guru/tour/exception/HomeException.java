package guru.tour.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Homepage Not Found") //404
public class HomeException extends Exception{
	
	private static final long serialVersionUID = -3332292346834265371L;
	
	public HomeException(String id){
		super("HomepageNotFoundException occur with id="+id+"when nothing data in server .Please check again :(((((( ");
	}
}
