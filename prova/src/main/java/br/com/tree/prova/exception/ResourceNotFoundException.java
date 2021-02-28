package br.com.tree.prova.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 3393463142190637176L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}