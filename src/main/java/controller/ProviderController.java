package controller;

import model.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ProviderService;


import java.util.List;

@RestController
public class ProviderController {
    @Autowired
    public ProviderService providerService;

    @RequestMapping(value = "/providers", method= RequestMethod.GET)
    public List<Provider> getAllProviders(){
        return providerService.getAllProviders();
    }

    @RequestMapping(value = "/providers", method= RequestMethod.GET)
    public List<Provider> getProviderById(@RequestParam(name="id") int id){
        return providerService.getProviderById(id);
    }

    @RequestMapping(value="/providers", method =RequestMethod.POST)
    public int addProvider(@RequestBody Provider provider){
        return providerService.addProvider(provider);
    }

    @RequestMapping(value="/providers", method=RequestMethod.PUT)
    public int updateProvider(@RequestParam(name="id") int id, @RequestBody Provider provider){
        return providerService.updateProvider(id, provider);
    }

    @RequestMapping(value="/providers", method=RequestMethod.DELETE)
    public int deleteProvider(@RequestParam(name="id") int id){
        return providerService.deleteProvider(id);
    }

    @RequestMapping("*")
    public String fallbackMethod() {
        return "No matching endpoint found.\n";
    }
}
