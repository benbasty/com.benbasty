package com.benbasty.funnygif.controller;

import com.benbasty.funnygif.data.GifRepository;
import com.benbasty.funnygif.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Controller
public class GifController {
    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/")
    public String funnyGifs(ModelMap modelMap) {
        List<Gif> allGifs = gifRepository.getAllGifs();
        modelMap.put("gifs",allGifs);
        return "home";
    }

    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap){
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif",gif);
        return "gif-details";
    }

    @RequestMapping("/search")
    public String listSearch (@RequestParam String q, ModelMap modelMap){
        List<Gif> gifs = gifRepository.findbySearch(q);
        modelMap.put("gifs",gifs);
        return "search";
    }

}
