package com.yebelo.fetchNext.exception;

/**
 * This class is a custom exception type for the invalid category code
 */
public class CategoryCodeNotFoundException extends Exception{
    public CategoryCodeNotFoundException(int categoryCode) {
        super("category code "+categoryCode+ " not found");
    }
}
