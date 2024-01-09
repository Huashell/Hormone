package com.example.hormone.service;

import com.example.hormone.entity.Favors;

public interface FavorsService {
    Favors saveFavor(Favors favor);

    Favors getFavorById(int favorId);

    // Other service methods if needed
}
