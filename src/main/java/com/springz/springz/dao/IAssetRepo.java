package com.springz.springz.dao;

import com.springz.springz.models.Asset;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IAssetRepo extends CrudRepository<Asset, Long> {
    List<Asset> findByName(String name);
    List<Asset> findByState(String state);
}
