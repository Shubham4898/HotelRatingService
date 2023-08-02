package com.hotel.user.service.eceptions;

public class ResourceNotFoundException extends  RuntimeException{

    public ResourceNotFoundException(){
        super("Resource not found exception");
    }


    public ResourceNotFoundException(String message){
        super(message);
    }

}
