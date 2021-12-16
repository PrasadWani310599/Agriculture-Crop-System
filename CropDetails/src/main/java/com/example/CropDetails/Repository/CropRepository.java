package com.example.CropDetails.Repository;

import com.example.CropDetails.CropDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CropRepository extends MongoRepository<CropDetails,String > {
}
