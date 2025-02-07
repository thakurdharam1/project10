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
import com.rays.dto.VehicleDTO;
import com.rays.form.VehicleForm;
import com.rays.service.VehicleServiceInt;

@RestController
@RequestMapping(value = "Vehicle")

public class VehicleCtl extends BaseCtl<VehicleForm, VehicleDTO, VehicleServiceInt> {

    @GetMapping("/preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);

        HashMap<Integer, String> Map = new HashMap<>();
        Map.put(1, "Car");
        Map.put(2, "Bike");
        Map.put(3, "Auto");
        Map.put(4, "Cycle");

        List<Map<String, Object>> VehicleeList = new ArrayList<>();
          Map.forEach((key, value) -> {
            Map<String, Object> item = new HashMap<>();
            item.put("key", key);
            item.put("value", value);
            VehicleeList.add(item);
        });

        res.addResult("VehicleeListtt",VehicleeList );

        return res;
    } 
 

}
