package com.springz.springz.service;

import com.springz.springz.api.AssetManagerController;
import com.springz.springz.dao.IAssetRepo;
import com.springz.springz.models.Asset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssetRepoService implements  IAssetRepoService{
    Logger logger = LoggerFactory.getLogger(AssetManagerController.class);

    @Autowired
    private IAssetRepo _assetRepo;


    public AssetRepoService(IAssetRepo _assetRepo) {
        this._assetRepo = _assetRepo;
    }

    public List<Asset> FindAllAssets() {

        try{
            List<Asset> results = new ArrayList<>();
            _assetRepo.findAll().forEach(item -> results.add((item)));
            return results;
        }
        catch (Exception e) {
            throw  new Error("Failed to fetch asset list: " + e.getMessage());
//            return  null;
        }
    }

    public Iterable<Asset> FindUsersAssets(Long UserId) {
        return _assetRepo.findByOwner(UserId);
    }


    public Asset FindAssetByID(Long ID) {
        try{
            return _assetRepo.findById(ID).get();
        }catch (Exception e){
            this.logger.error("Item not found. Received ID " + ID + ". Exception details: " + e.getMessage());
            return null;
        }

    }

    public boolean UpdateAsset(Long ID, Asset updated) {
        try{
            var assetToUpdate = FindAssetByID(ID);

            if( (updated.getName() != "" && updated.getName() != null) ) assetToUpdate.setName( updated.getName());
            if( (updated.getState() != "" && updated.getState() != null) ) assetToUpdate.setState( updated.getState());
            if( (updated.getDescription() != "" && updated.getDescription() != null) ) assetToUpdate.setDescription(updated.getDescription());
            _assetRepo.save(assetToUpdate);

            return  true;
        }catch (Exception e){
            // LOG Error message
            this.logger.error("Failed to update asset with Id: " + ID + ". Exception details: " + e.getMessage());
            return  false;
        }
    }

    public boolean DeleteAsset(Long ID) {
        try{
            _assetRepo.delete(FindAssetByID(ID));
            return  true;
        }catch (Exception e){
            this.logger.error("Failed to delete asset with Id" + ID + ". Exception details: " + e.getMessage());
            return  false;
        }

    }

    public boolean CreateAsset(Asset asset) {
        try {
            _assetRepo.save(asset);
            return true;
        }catch (Exception e){
            this.logger.error("Failed to create asset: " + asset.toString() + ". Exception details: " + e.getMessage());
            return  false;
        }
    }
}
