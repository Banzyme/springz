package com.springz.springz.api;

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
    public ResponseEntity<List<Asset>> GetAllAssets(){
        List<Asset> results = new ArrayList<>();

        _service.FindAllAssets().forEach(item -> results.add((item)));

        return new ResponseEntity(results, HttpStatus.OK);
    }

    @GetMapping("assets/{id}")
    public  ResponseEntity<Asset> GetAssetById(@PathVariable("id") Long ID){
        return new ResponseEntity(_service.FindAssetByID(ID), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Void> AddAsset(@RequestBody Asset asset){
        var result = _service.CreateAsset(asset);

        if(result == true){
            Object myobj = new Object() {
                public final boolean success = true;
                public  final  String message = "Successfully added item to assets table.";
            };
            return new ResponseEntity(myobj,HttpStatus.OK);
        }else{
            // TODO: Describe
            return  new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("update/{id}")
    public  ResponseEntity<Void> UpdateAsset(@PathVariable("id") Long ID, @RequestBody Asset asset){
        _service.UpdateAsset(ID, asset);

        Object myobj = new Object() {
            public final boolean succeded = true;
            public  final  String message = "Successfully updated asset.";
        };
        return new ResponseEntity(myobj,HttpStatus.OK);
//        return new ResponseEntity("Item "+ ID +" successfully updated!",HttpStatus.NO_CONTENT);
    }


    @DeleteMapping("delete/{id}")
    public  ResponseEntity<Void> DeleteAsset(@PathVariable("id") Long ID){
       // use async await maybe??
        _service.DeleteAsset(ID);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}

