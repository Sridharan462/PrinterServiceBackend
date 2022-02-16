package com.example.Repository;

import com.example.model.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceModel,Long> {
    public void deleteByServiceCenterId(String serviceCenterId);
    public ServiceModel findByServiceCenterId(String serviceCenterId);
}
