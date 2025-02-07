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
import com.rays.dto.XyzDTO;
import com.rays.form.XyzForm;
import com.rays.service.XyzServiceInt;

@RestController
@RequestMapping(value = "Xyz")

public class XyzCtl extends BaseCtl<XyzForm, XyzDTO, XyzServiceInt> {

    @GetMapping("/preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);

        HashMap<Integer, String> Map = new HashMap<>();
        Map.put(1, "CS");
        Map.put(2, "CIVIL");
        Map.put(3, "IT");
        Map.put(4, "MACHENICAL");

        List<Map<String, Object>> XyzeList = new ArrayList<>();
          Map.forEach((key, value) -> {
            Map<String, Object> item = new HashMap<>();
            item.put("key", key);
            item.put("value", value);
            XyzeList.add(item);
        });

        res.addResult("XyzeList", XyzeList);

        return res;
    } 
 

}
