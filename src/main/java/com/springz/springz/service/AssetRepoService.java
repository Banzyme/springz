package com.springz.springz.service;

import com.springz.springz.dao.IAssetRepo;
import com.springz.springz.models.Asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetRepoService implements  IAssetRepoService{


    @Autowired
    private IAssetRepo _assetRepo;


    public AssetRepoService(IAssetRepo _assetRepo) {
        this._assetRepo = _assetRepo;
    }

    public Iterable<Asset> FindAllAssets() {
        return _assetRepo.findAll();
    }

    public Iterable<Asset> FindUsersAssets(Long UserId) {
        return _assetRepo.findByOwnerID(UserId);
    }


    public Asset FindAssetByID(Long ID) {
        return _assetRepo.findById(ID).get();
    }

    public void UpdateAsset(Long ID, Asset updated) {
        var assetToUpdate = FindAssetByID(ID);

        assetToUpdate.setName(updated.getName());
        assetToUpdate.setDescription(updated.getDescription());

        _assetRepo.save(assetToUpdate);
    }

    public void DeleteAsset(Long ID) {
        try{
            _assetRepo.delete(FindAssetByID(ID));
        }catch (Exception e){
            // Todo
        }

    }

    public void CreateAsset(Asset asset) {
        try {
            _assetRepo.save(asset);
        }catch (Exception e){
            throw  new Error("Asset cant be created!");
        }
    }
}
