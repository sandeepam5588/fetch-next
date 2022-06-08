package com.yebelo.fetchNext.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    private int categoryCode;
    private int codeValue;

    public Category(){}
    public Category(int categoryCode, int codeValue) {
        this.categoryCode = categoryCode;
        this.codeValue = codeValue;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public int getCodeValue() {
        return codeValue;
    }

    public void setCodeValue(int codeValue) {
        this.codeValue = codeValue;
    }
}
