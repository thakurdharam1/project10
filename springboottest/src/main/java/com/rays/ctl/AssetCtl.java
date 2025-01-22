package com.rays.ctl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.AssetDTO;
import com.rays.form.AssetForm;
import com.rays.service.AssetServiceInt;

@RestController
@RequestMapping(value = "Asset")
public class AssetCtl extends BaseCtl<AssetForm, AssetDTO, AssetServiceInt> {

    @GetMapping("/preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);

        HashMap<Integer, String> paintColorMap = new HashMap<>();
        paintColorMap.put(1, "Red");
        paintColorMap.put(2, "Blue");
        paintColorMap.put(3, "Green");
        paintColorMap.put(4, "Black");

        List<Map<String, Object>> paintColorList = new ArrayList<>();
        paintColorMap.forEach((key, value) -> {
            Map<String, Object> item = new HashMap<>();
            item.put("key", key);
            item.put("value", value);
            paintColorList.add(item);
        });

        res.addResult("paintColorList", paintColorList);

        return res;
    }
}
