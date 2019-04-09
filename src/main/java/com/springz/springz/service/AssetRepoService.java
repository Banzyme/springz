package com.springz.springz.service;

import com.springz.springz.dao.IAssetRepo;
import com.springz.springz.models.Asset;
import org.springframework.beans.factory.annotation.Autowired;

public class AssetRepoService implements  IAssetRepoService{

    @Autowired
    private IAssetRepo _assetRepo;

    public Iterable<Asset> FindAllAssets() {
        return null;
    }

    public Iterable<Asset> FindUsersAssets(Long UserId) {
        return null;
    }


    public Asset FindAssetByID(Long ID) {
        return null;
    }

    public void UpdateAsset(Long ID) {

    }

    public void DeleteAsset(Long ID) {

    }

    public void CreateAsset(Asset asset) {
        try {
            _assetRepo.save(asset);
        }catch (Exception e){
            throw  new Error("Asset cant be created!");
        }
    }
}
