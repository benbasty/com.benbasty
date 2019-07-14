package com.benbasty.funnygif.data;

import com.benbasty.funnygif.model.Category;
import com.benbasty.funnygif.model.Gif;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {
    public List<Category> ALL_CATEGORIES = Arrays.asList(
            new Category(1,"entertainment"),
            new Category(2,"animals"),
            new Category(3,"celebrity"),
            new Category(4,"memes"),
            new Category(5,"music"),
            new Category(6,"sports")
    );

    public List<Category> getAll_Categories() {
        return ALL_CATEGORIES;
    }

    public Category findById(int id){
        for(Category category : ALL_CATEGORIES){
            if(category.getId() == id){
                return category;
            }
        }
        return null;
    }


}
