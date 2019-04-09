package com.springz.springz.dao;

import com.springz.springz.models.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAssetRepo extends JpaRepository<Asset, Long> {
//    List<Asset> findByName(String name);
//    List<Asset> findByState(String state);
}
