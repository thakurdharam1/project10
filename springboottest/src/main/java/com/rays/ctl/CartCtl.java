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
import com.rays.dto.CartDTO;
import com.rays.form.CartForm;
import com.rays.service.CartServiceInt;

@RestController
@RequestMapping(value = "Cart")

public class CartCtl extends BaseCtl<CartForm, CartDTO, CartServiceInt> {

    @GetMapping("/preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);

        HashMap<Integer, String> Map = new HashMap<>();
        Map.put(1, "PHONE");
        Map.put(2, "LAPTOP");
        Map.put(3, "TELEVISION");
        Map.put(4, "TABLET");

        List<Map<String, Object>> CarteList = new ArrayList<>();
          Map.forEach((key, value) -> {
            Map<String, Object> item = new HashMap<>();
            item.put("key", key);
            item.put("value", value);
            CarteList.add(item);
        });

        res.addResult("CarteListtt",CarteList );

        return res;
    } 
 

}
