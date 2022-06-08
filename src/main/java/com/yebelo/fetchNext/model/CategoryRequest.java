package com.yebelo.fetchNext.model;

public class CategoryRequest {

    private int categoryCode;

    public CategoryRequest(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }
}
