package com.example.ecommerce.execeptions;

public class NoClientExistInRepository extends RuntimeException {
    public NoClientExistInRepository (String message) {
        super(message);
    }
}
