package com.yebelo.fetchNext.model;

public class CategoryResponse {
    private int categoryCode;
    private int oldValue;
    private int newValue;

    public CategoryResponse() {
    }

    public CategoryResponse(int categoryCode, int oldValue, int newValue) {
        this.categoryCode = categoryCode;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public int getOldValue() {
        return oldValue;
    }

    public void setOldValue(int oldValue) {
        this.oldValue = oldValue;
    }

    public int getNewValue() {
        return newValue;
    }

    public void setNewValue(int newValue) {
        this.newValue = newValue;
    }
}
