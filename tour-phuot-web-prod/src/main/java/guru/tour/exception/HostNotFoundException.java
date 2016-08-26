package guru.tour.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Host Not Found")
public class HostNotFoundException extends Exception {
	private static final long serialVersionUID = -3332292346834265371L;

	public HostNotFoundException(int id) {
		super("HostNotFoundException with id=" + id);
	}
}
