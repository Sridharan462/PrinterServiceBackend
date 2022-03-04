package com.example.controller;

import com.example.Repository.ServiceRepository;
import com.example.model.ServiceModel;
import com.example.service.ServiceCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin("http://localhost:8080")
public class ServiceController {

    @Autowired
    public ServiceCenterService serviceCenterService;
    @Autowired
    public ServiceRepository servicerepo;
   @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/admin/add")
    public String add(@RequestBody ServiceModel service)
    {

        serviceCenterService.saveAll(service);
        return "added";
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/allService")
    public List<ServiceModel> display()
    {
        return serviceCenterService.findAll();
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{id}")
    public String deleteService(@PathVariable Long id)
    {
        ServiceModel service=serviceCenterService.findById(id);
        servicerepo.delete(service);
        return "deleted";
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/admin/deleteAllService")
    public String delete()
    {
        serviceCenterService.deleteAll();
        return "completed";
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/update/{id}")
    public ResponseEntity<ServiceModel>  updateService(@PathVariable Long id, @RequestBody ServiceModel service)
    {
       ServiceModel services=serviceCenterService.findById(id);
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
