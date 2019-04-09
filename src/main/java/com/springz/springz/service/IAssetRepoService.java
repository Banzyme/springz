package com.springz.springz.service;

import com.springz.springz.models.Asset;

public interface IAssetRepoService {

    Iterable<Asset> FindAllAssets();
    Iterable<Asset> FindUsersAssets(Long UserId);
    Asset FindAssetByID(Long ID);
    void UpdateAsset(Long ID, Asset updated);
    void DeleteAsset(Long ID);
    void CreateAsset(Asset asset);
}
