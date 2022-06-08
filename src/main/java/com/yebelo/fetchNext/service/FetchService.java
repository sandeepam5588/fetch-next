package com.yebelo.fetchNext.service;

import com.yebelo.fetchNext.exception.CategoryCodeNotFoundException;
import com.yebelo.fetchNext.model.Category;
import com.yebelo.fetchNext.model.CategoryResponse;
import com.yebelo.fetchNext.repository.FetchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchService {

    /* To inject FetchRepository bean */
    @Autowired
    private FetchRepository fetchRepository;

    public synchronized CategoryResponse fetchNextValue(int categoryCode) throws CategoryCodeNotFoundException {
        // fetch data from the database
        //if not found throws custom exception
        Category category = fetchRepository.findById(categoryCode).orElseThrow(() -> new CategoryCodeNotFoundException(categoryCode));

        int newValue = 0;
        try {
            //calculate new value
            newValue = findNextValue(category.getCodeValue());

            // simulation of 3 seconds delay
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // build the response object
        CategoryResponse response = new CategoryResponse();
        response.setCategoryCode(categoryCode);
        response.setOldValue(category.getCodeValue());
        response.setNewValue(newValue);

        //update the value in database by replacing new value with old value
        updateCategoryValue(category, newValue);
        return response;
    }

    /**
     * This method updates the value field for the corresponding categoryCode field
     * @param category
     * @param newValue
     */
    private void updateCategoryValue(Category category, int newValue) {
        category.setCodeValue(newValue);
        fetchRepository.save(category);
    }

    /**
     * This method calculates the new value based on old value
     * @param oldValue
     * @return
     */
    private static int findNextValue(int oldValue){
        for(int i=oldValue+1;;i++){
            int a = Integer.MAX_VALUE;
            if (sumOfDigits(i))
                return i;
        }
    }

    /**
     * this is an utility mehtod to check whether the sum of individual digits of next number is 1
     * @param num
     * @return
     */
    private static boolean sumOfDigits(int num){
        int sum = 0;

        while (num > 0 ) {
            int rem = num % 10;
            sum += rem;
            num /= 10;
        }
        if (sum == 1)
            return true;
        else if(sum < 10)
            return false;

        return sumOfDigits(sum);
    }
}
