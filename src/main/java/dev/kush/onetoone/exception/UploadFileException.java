package dev.kush.onetoone.exception;

public class UploadFileException extends RuntimeException{
    public UploadFileException(String message){
        super(message);
    }

    public UploadFileException(){
        super("error during file update.");
    }
}
