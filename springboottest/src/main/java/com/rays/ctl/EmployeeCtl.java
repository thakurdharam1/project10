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
import com.rays.dto.EmployeeDTO;
import com.rays.form.EmployeeForm;
import com.rays.service.EmployeeServiceInt;

@RestController
@RequestMapping(value = "Employee")

public class EmployeeCtl extends BaseCtl<EmployeeForm, EmployeeDTO, EmployeeServiceInt> {

    @GetMapping("/preload")
    public ORSResponse preload() {
        ORSResponse res = new ORSResponse(true);

        HashMap<Integer, String> Map = new HashMap<>();
        Map.put(1, "CS");
        Map.put(2, "CIVIL");
        Map.put(3, "IT");
        Map.put(4, "MACHENICAL");

        List<Map<String, Object>> employeeeList = new ArrayList<>();
          Map.forEach((key, value) -> {
            Map<String, Object> item = new HashMap<>();
            item.put("key", key);
            item.put("value", value);
            employeeeList.add(item);
        });

        res.addResult("employeeeList", employeeeList);

        return res;
    } 
 

}
