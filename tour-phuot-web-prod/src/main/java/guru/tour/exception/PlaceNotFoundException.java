package guru.tour.exception;

public class PlaceNotFoundException extends Exception{

	private static final long serialVersionUID = -3332292346834265371L;

	public PlaceNotFoundException(int id){
		super("PlaceNotFoundException with id="+id);
	}
}
