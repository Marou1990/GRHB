package com.mang.grh.Controllers.Administration;


import com.mang.grh.entities.Administration.RefPages;
import com.mang.grh.entities.DemandeAuto;
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
    @GetMapping("/pagesprt")
    @Operation(summary = "get all pages parent")
    public List<RefPages> getallPagePrt(){
        return refpageser.getallpagesParent();
    }
    @GetMapping("/pagesSM")
    @Operation(summary = "get all sous module")
    public List<RefPages> getallPageSM(){
        return refpageser.getallpagesSModule();
    }
    @GetMapping("/pagesSSM")
    @Operation(summary = "get all sous module")
    public List<RefPages> getPages(){
        return refpageser.getpages();
    }

    @GetMapping("/pagesSM/{cdeprt}")
    @Operation(summary = "get all sous module par code prt")
    public List<RefPages> findSModulebyPrt(@PathVariable Long cdeprt){
        return refpageser.findSModulebyPrt(cdeprt);
    }


    @GetMapping("/pages/{cdeprt}")
    @Operation(summary = "get all page par codeprt")
    public List<RefPages> findPagesbyPrt(@PathVariable Long cdeprt){
        return refpageser.findPagesbyPrt(cdeprt);
    }
}
