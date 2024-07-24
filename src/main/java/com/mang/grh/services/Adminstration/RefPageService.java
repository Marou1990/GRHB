package com.mang.grh.services.Adminstration;

import com.mang.grh.Repositories.Adminstration.RefPagesRepo;
import com.mang.grh.entities.Administration.RefPages;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RefPageService {

    private RefPagesRepo refpagerepo;
    public RefPageService(RefPagesRepo refpagerepo) {
        this.refpagerepo = refpagerepo;
    }

    public RefPages savepage(RefPages page){
        return  refpagerepo.save(page);
    }

    public void deletepage(RefPages page){

        refpagerepo.delete(page);
    }

    public List<RefPages> getallpages(){
       return   refpagerepo.findAll();

    }

    public List<RefPages> getallpagesParent(){
        return   refpagerepo.findParentPages();

    }
    public List<RefPages> getallpagesSModule(){
        return   refpagerepo.findSModule();

    }
    public List<RefPages> getpages(){
        return   refpagerepo.findPages();

    }

    public List<RefPages> findPagesbyPrt(Long cdeprt){
        return   refpagerepo.findPagesbyPrt(cdeprt);

    }
    public List<RefPages> findSModulebyPrt(Long cdeprt){
        return   refpagerepo.findSModulebyPrt(cdeprt);

    }
}
