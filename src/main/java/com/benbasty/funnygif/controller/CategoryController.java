package com.benbasty.funnygif.controller;

import com.benbasty.funnygif.data.CategoryRepository;
import com.benbasty.funnygif.data.GifRepository;
import com.benbasty.funnygif.model.Category;
import com.benbasty.funnygif.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap){
        List<Category> categories = categoryRepository.getAll_Categories();
        modelMap.put("categories",categories);
        return "categories";
    }

    @RequestMapping("/category/{id}")
    public String category(ModelMap modelMap, @PathVariable int id){
        Category category = categoryRepository.findById(id);
        modelMap.put("category",category);

        // for the list of gifs with each category, need to use a repository that will fetch all the Gifs within a certain category
        List<Gif> gifs = gifRepository.findByCategoryId(id);
        modelMap.put("gifs",gifs);

        return "category";
    }



}
