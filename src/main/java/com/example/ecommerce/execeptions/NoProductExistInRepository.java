package com.example.ecommerce.execeptions;

public class NoProductExistInRepository extends RuntimeException{
    public NoProductExistInRepository(String message) {
        super(message);
    }
}
