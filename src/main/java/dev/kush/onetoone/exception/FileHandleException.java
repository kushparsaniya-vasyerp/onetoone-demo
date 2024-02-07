package dev.kush.onetoone.exception;

public class FileHandleException extends RuntimeException{
    public FileHandleException(String message){
        super(message);
    }

    public FileHandleException(){
        super("error during file update.");
    }
}
