package com.store.meonggae.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.meonggae.product.dao.CategoryDAO;
import com.store.meonggae.product.domain.CategoryDomain;

@Service
public class SearchProductService {

    @Autowired
    private CategoryDAO upDAO;
    
    public List<CategoryDomain> selectParentCategory(){
    	return upDAO.selectCategory("0");
    }
    public List<CategoryDomain> selectSubCategory(String subCategory){
    	return upDAO.selectCategory(subCategory);
    }

}
