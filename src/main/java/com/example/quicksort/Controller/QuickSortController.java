package com.example.quicksort.Controller;


import com.example.quicksort.Service.QuickSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api")
public class QuickSortController<T extends Comparable> {

    @Autowired
    private QuickSortService quickSortService;

    @PostMapping
    public T[] QuickSortArray( @RequestParam T[] array){
        return (T[]) quickSortService.sort(array);
    }
}
