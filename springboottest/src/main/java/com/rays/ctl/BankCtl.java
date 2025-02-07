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
import com.rays.dto.BankDTO;
import com.rays.form.BankForm;
import com.rays.service.BankServiceInt;

@RestController
@RequestMapping(value = "Bank")

public class BankCtl extends BaseCtl<BankForm, BankDTO, BankServiceInt> {

    @GetMapping("/preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);

        HashMap<Integer, String> Map = new HashMap<>();
        Map.put(1, "CURRENT");
        Map.put(2, "SAVING");
        Map.put(3, "BUSINESS");

        List<Map<String, Object>> BankeList = new ArrayList<>();
          Map.forEach((key, value) -> {
            Map<String, Object> item = new HashMap<>();
            item.put("key", key);
            item.put("value", value);
            BankeList.add(item);
        });

        res.addResult("BankeListtt",BankeList );

        return res;
    } 
 

}
