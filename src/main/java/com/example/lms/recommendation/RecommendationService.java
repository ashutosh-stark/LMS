package com.example.lms.recommendation;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.lms.books.Books;
import com.example.lms.inventory.Inventory;
import com.example.lms.members.Members;

public abstract class RecommendationService {
    
    Map<Members,List<Books>> recommendationMap;
    Inventory inventory;

    public RecommendationService(){
        this.recommendationMap = new HashMap<>();
    }
    
    public abstract void getRecommendation(Members member);

    public List<Books> getRecoomadedBooks(Members member){
        return recommendationMap.get(member);
    }
}
