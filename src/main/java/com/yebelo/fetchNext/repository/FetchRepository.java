package com.yebelo.fetchNext.repository;

import com.yebelo.fetchNext.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FetchRepository extends JpaRepository<Category, Integer> {
}
