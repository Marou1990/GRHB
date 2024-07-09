package com.mang.grh.Controllers.Administration;


import com.mang.grh.entities.Administration.RefPages;
import com.mang.grh.services.Adminstration.RefPageService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/admin/pages")
public class RefPageController {

    @Autowired
    private RefPageService refpageser;


    @PostMapping("/addpage")
    @Operation(summary = "save a page")
    public RefPages addPage(@RequestBody  RefPages page){
       return refpageser.savepage(page) ;
    }

    @Operation(summary = "delete a employee by id")
    @DeleteMapping("/delete-page")
    public void deletePage(@RequestBody  RefPages page){
         refpageser.deletepage(page); ;
    }
    @GetMapping("/pages")
    @Operation(summary = "get all pages")
    public List<RefPages> getallPage(){
       return refpageser.getallpages();
    }

}
