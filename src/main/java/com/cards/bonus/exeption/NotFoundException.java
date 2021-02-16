package com.cards.bonus.exeption;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super("Not Found Exception!");
    }
}
