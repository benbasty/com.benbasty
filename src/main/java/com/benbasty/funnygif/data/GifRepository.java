package com.benbasty.funnygif.data;

import com.benbasty.funnygif.model.Gif;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GifRepository {

    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("homegif1", 1, LocalDate.of(2019,7,13), "Saly Criotti", false),
            new Gif("homegif2", 2, LocalDate.of(2019,7,20), "Raca Jake", true),
            new Gif("homegif3", 3, LocalDate.of(2019,7,03), "Ben Basty", true),
            new Gif("homegif4", 4, LocalDate.of(2019,7,14), "Dania BrightDay", true),
            new Gif("homegif5", 5, LocalDate.of(2019,6,12), "Alissa Harper", false),
            new Gif("homegif6", 6, LocalDate.of(2019,6,10), "May Dayer", true),
            new Gif("homegif7", 1, LocalDate.of(2019,6,9), "Gary Hop", false),
            new Gif("homegif8", 2, LocalDate.of(2019,6,5), "John Mayer", true)
    );

    public Gif findByName(String name) {
        for(Gif gif : ALL_GIFS) {
            if(gif.getName().equals(name)){
                return gif;
            }
        }
        return null;
    }

    public List<Gif> getAllGifs(){
        return ALL_GIFS;
    }

    public List<Gif> findByCategoryId(int id){
        List<Gif> gifs = new ArrayList<>();
        for(Gif gif : ALL_GIFS){
            if(gif.getCategoryID() == id){
                gifs.add(gif);
            }
        }
        return gifs;
    }

    public List<Gif> findbySearch (String search) {
        List<Gif> gifs = new ArrayList<>();
        for(Gif gif : ALL_GIFS) {
            if(gif.getName().toLowerCase().contains(search)){
                gifs.add(gif);
            }
        }
        return gifs;
    }
}
