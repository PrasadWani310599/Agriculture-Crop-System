package com.example.CropDetails.Controller;

import com.example.CropDetails.CropDetails;
import com.example.CropDetails.Repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/crop")
@EnableEurekaClient
public class CropController {

    @Autowired
    private CropRepository cropRepository;

    @GetMapping("/findallcrop")
    public List<CropDetails> getAllCrop(){
        return cropRepository.findAll();
    }

    // Save the Data into Database whichis created into MongoDb
    @PostMapping("/savecrop")
    public String addCrop(@RequestBody CropDetails cropsDetails ) {
        cropRepository.save(cropsDetails);
        return "Crop Details Add Successfully";
    }
    @GetMapping("/getdetails/{id}")
     public Optional<CropDetails> getById(@PathVariable ("id") String id)
    {
       return cropRepository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable ("id") String id)
    {
        cropRepository.deleteById(id);
        return "Crop deleted successfully";
    }
}
