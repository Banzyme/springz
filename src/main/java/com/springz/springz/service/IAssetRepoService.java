package com.springz.springz.service;

import com.springz.springz.models.Asset;

import java.util.List;

public interface IAssetRepoService {

    List<Asset> FindAllAssets();
    Iterable<Asset> FindUsersAssets(Long UserId);
    Asset FindAssetByID(Long ID);
    void UpdateAsset(Long ID, Asset updated);
    void DeleteAsset(Long ID);
    boolean CreateAsset(Asset asset);
}
