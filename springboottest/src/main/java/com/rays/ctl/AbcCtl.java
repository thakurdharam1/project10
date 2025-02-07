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
import com.rays.dto.AbcDTO;
import com.rays.form.AbcForm;
import com.rays.service.AbcServiceInt;

@RestController
@RequestMapping(value = "Abc")

public class AbcCtl extends BaseCtl<AbcForm, AbcDTO, AbcServiceInt> {

    @GetMapping("/preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);

        HashMap<Integer, String> Map = new HashMap<>();
        Map.put(1, "CS");
        Map.put(2, "CIVIL");
        Map.put(3, "IT");
        Map.put(4, "MACHENICAL");

        List<Map<String, Object>> AbceList = new ArrayList<>();
          Map.forEach((key, value) -> {
            Map<String, Object> item = new HashMap<>();
            item.put("key", key);
            item.put("value", value);
            AbceList.add(item);
        });

        res.addResult("AbceList", AbceList);

        return res;
    } 
 

}
