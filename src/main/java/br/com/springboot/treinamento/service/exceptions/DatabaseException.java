package br.com.springboot.treinamento.service.exceptions;

public class DatabaseException extends RuntimeException{
    private static final long serialVersionId = 1L;

    public DatabaseException(String msg){
        super(msg);
    }
}
