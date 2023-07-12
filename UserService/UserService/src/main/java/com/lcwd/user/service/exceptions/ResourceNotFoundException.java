package com.lcwd.user.service.exceptions;

//import java.net.SocketTimeoutException;

//public class ResourceNotFoundException extends RuntimeException{
//
////    public ResourceNotFoundException(){
////        super("Resource Not Found on server!!");
////    }
//
//    public ResourceNotFoundException(String message){
//        super(message);
//    }
//
//
//}

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(String message){
        super(message);
    }
}
