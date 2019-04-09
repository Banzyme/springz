package com.springz.springz.controller;

import com.springz.springz.models.Asset;
import com.springz.springz.service.IAssetRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("assets")
public class AssetController {

    @Autowired
    private IAssetRepoService _assetService;

    @GetMapping("/create")
    public String AddAssertForm(Model model){
        model.addAttribute("asset", new Asset());
        return  "add-asset";
    }


}
