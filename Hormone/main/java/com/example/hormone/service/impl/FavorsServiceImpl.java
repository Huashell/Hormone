package com.example.hormone.service.impl;

/**
 * @param
 * @return
 **/
import com.example.hormone.entity.Favors;
import com.example.hormone.repository.FavorsRepository;
import com.example.hormone.service.FavorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FavorsServiceImpl implements FavorsService {

    private final FavorsRepository favorsRepository;

    @Autowired
    public FavorsServiceImpl(FavorsRepository favorsRepository) {
        this.favorsRepository = favorsRepository;
    }

    @Override
    public Favors saveFavor(Favors favor) {
        return favorsRepository.save(favor);
    }

    @Override
    public Favors getFavorById(int favorId) {
        Optional<Favors> optionalFavors = favorsRepository.findById(favorId);
        return optionalFavors.orElse(null);
    }

    // Implement other service methods if needed
}
