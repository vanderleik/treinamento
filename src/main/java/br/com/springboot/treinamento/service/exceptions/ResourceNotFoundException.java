package br.com.springboot.treinamento.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    private static final long serialVersionId = 1L;

    public ResourceNotFoundException(Object id) {
        super("Recurso não encontrado. Id " + id);
    }
}
