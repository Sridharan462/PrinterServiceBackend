package com.example.service;

import com.example.Repository.ServiceRepository;
import com.example.model.ServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCenterService{
    @Autowired
    public ServiceRepository servicerepo;
    public void saveAll(ServiceModel service)
    {
        servicerepo.save(service);
    }
    public ServiceModel findById(String serviceCenterId)
    {
        return servicerepo.findByServiceCenterId(serviceCenterId);
    }
    public void deleteAll()
    {
        servicerepo.deleteAll();
    }
    public List<ServiceModel> findAll()
    {
        return servicerepo.findAll();
    }
}
