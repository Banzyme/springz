package com.springz.springz.dao;

import com.springz.springz.models.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAssetRepo extends JpaRepository<Asset, Long> {
    Iterable<Asset> findByName(String name);
    Iterable<Asset> findByOwner(Long OwnerId);
}
