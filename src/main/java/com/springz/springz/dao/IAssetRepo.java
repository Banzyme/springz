package com.springz.springz.dao;

import com.springz.springz.models.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAssetRepo extends JpaRepository<Asset, Long> {
    Iterable<Asset> findByName(String name);
    Iterable<Asset> findByOwnerID(Long OwnerId);
}
