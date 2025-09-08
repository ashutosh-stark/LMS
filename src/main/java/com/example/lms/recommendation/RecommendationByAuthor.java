package com.example.lms.recommendation;

import java.util.List;

import com.example.lms.books.Books;
import com.example.lms.members.Members;

public class RecommendationByAuthor extends RecommendationService {

    @Override
    public void getRecommendation(Members member) {
       // so in order to add the recommendation simply 
        // we can check the history of the member and then add the same kind of books
        Books be = member.getTransactionHistory().get(0).getBorrwBooks().get(0);
        // once we have the first book check for the auther and add same kind of books from inventory
        List<Books> recBooks =  inventory.getAllBooksByAuthorName(be.getAuthor());
        recommendationMap.putIfAbsent(member, recBooks);
    }
    
}
