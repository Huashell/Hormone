package com.example.hormone.controller;

/**
 * @param
 * @return
 **/
import com.example.hormone.entity.Favors;
import com.example.hormone.service.FavorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/favors")
public class FavorsController {

    private final FavorsService favorsService;

    @Autowired
    public FavorsController(FavorsService favorsService) {
        this.favorsService = favorsService;
    }

    @PostMapping
    public ResponseEntity<Favors> saveFavor(@RequestBody Favors favor) {
        Favors savedFavor = favorsService.saveFavor(favor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFavor);
    }

    @GetMapping("/{favorId}")
    public ResponseEntity<Favors> getFavorById(@PathVariable int favorId) {
        Favors favor = favorsService.getFavorById(favorId);
        if (favor != null) {
            return ResponseEntity.ok(favor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Other controller endpoints if needed
}
