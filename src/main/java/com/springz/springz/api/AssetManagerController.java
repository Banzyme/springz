package com.springz.springz.api;

import com.springz.springz.constants.APIResponseMsg;
import com.springz.springz.models.AjaxResponseCustom;
import com.springz.springz.models.Asset;
import com.springz.springz.service.IAssetRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class AssetManagerController {


    private IAssetRepoService _service;

    @Autowired
    public AssetManagerController(IAssetRepoService _service) {
        this._service = _service;
    }

    @GetMapping("/assets")
    public ResponseEntity<List<Asset>> GetAllAssets() {
        List<Asset> results = new ArrayList<>();

        _service.FindAllAssets().forEach(item -> results.add((item)));

        return new ResponseEntity(results, HttpStatus.OK);
    }

    @GetMapping("assets/{id}")
    public ResponseEntity<Asset> GetAssetById(@PathVariable("id") Long ID) {
        var asset = _service.FindAssetByID(ID);

        if(asset != null){
            return new ResponseEntity(_service.FindAssetByID(ID), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping("add")
    public ResponseEntity<Void> AddAsset(@RequestBody Asset asset) {
        boolean result = _service.CreateAsset(asset);

        return this.GenerateNoContentResponse(result, APIResponseMsg.ERR_MSG_CREATE);
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<Void> UpdateAsset(@PathVariable("id") Long ID, @RequestBody Asset asset) {
        boolean result = _service.UpdateAsset(ID, asset);

        return this.GenerateNoContentResponse(result, APIResponseMsg.ERR_MSG_UPDATE);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> DeleteAsset(@PathVariable("id") Long ID) {
        // use async await maybe??
        boolean result = _service.DeleteAsset(ID);
        return this.GenerateNoContentResponse(result, APIResponseMsg.ERR_MSG_DELETE);
    }


    // private helpers
    private ResponseEntity<Void> GenerateNoContentResponse(boolean result, String msg){
        String errorMsg = msg == null || msg == ""? "Server error." : msg;
        if (result == true) {
            Object resp = new AjaxResponseCustom();
            return new ResponseEntity(resp, HttpStatus.NO_CONTENT);
        } else {
            Object resp = new AjaxResponseCustom(false, errorMsg);
            return new ResponseEntity(
                    resp,
                    HttpStatus.BAD_REQUEST);
        }
    }
}

