package com.example.controller;

import com.example.Repository.ServiceRepository;
import com.example.model.ServiceModel;
import com.example.service.ServiceCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
@CrossOrigin("http://localhost:8080")
public class ServiceController {

    @Autowired
    public ServiceCenterService serviceCenterService;
    @Autowired
    public ServiceRepository servicerepo;
    //@RequestMapping(value="/admin/add", produces = "application/json", method=RequestMethod.POST)
    @RequestMapping("/admin/add")
    public String add(@RequestBody ServiceModel service)
    {
        serviceCenterService.saveAll(service);
        return "added";
    }
    //@RequestMapping(value = "/allService", produces = "application/json", method = RequestMethod.GET)
    @RequestMapping("/allService")
    public List<ServiceModel> display()
    {
        return serviceCenterService.findAll();
    }
    //@RequestMapping(value = "/{serviceCenterId}",produces = "application/json", method = RequestMethod.DELETE)
    @RequestMapping("/{serviceCenterId}")
    public String deleteService(@PathVariable String serviceCenterId)
    {
        ServiceModel service=serviceCenterService.findById(serviceCenterId);
        servicerepo.delete(service);
        return "deleted";
//        Map<String,Boolean> response=new HashMap<>();
//        response.put("deleted",Boolean.TRUE);
//        return ResponseEntity.ok(response);
    }
    //@RequestMapping(value = "/admin/deleteAllService",produces = "application/json", method = RequestMethod.DELETE)
    @RequestMapping("/admin/deleteAllService")
    public String delete()
    {
        serviceCenterService.deleteAll();
        return "completed";
    }
    //@RequestMapping(value = "/update/{serviceCenterId}",produces = "application/json", method = RequestMethod.PUT)
    @RequestMapping("/update/{serviceCenterId}")
    public ResponseEntity<ServiceModel> updateService(@PathVariable String serviceCenterId, @RequestBody ServiceModel service)
    {
       ServiceModel services=serviceCenterService.findById(serviceCenterId);
       services.setServiceCenterEmail(service.getServiceCenterEmail());
       services.setServiceCenterAddress(service.getServiceCenterAddress());
       services.setServiceCenterImage(service.getServiceCenterImage());
       services.setServiceCenterDes(service.getServiceCenterDes());
       services.setServiceCenterPhone(service.getServiceCenterPhone());
       services.setServiceCenterName(service.getServiceCenterName());
       ServiceModel updatedServices=servicerepo.save(services);
       return ResponseEntity.ok(updatedServices);

    }
}
