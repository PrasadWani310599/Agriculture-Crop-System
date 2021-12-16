package com.example.CropDetails;

import com.example.CropDetails.Controller.CropController;
import com.example.CropDetails.Repository.CropRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class CropDetailsApplicationTests {

	@Autowired
	private CropController cropController;
	@MockBean
	 private CropRepository cropRepository;
	@Test
	void contextLoads() {
	}
//	@Test
//	public void findAllDealerTest() {
//		when(cropRepository.findAll()).thenReturn(Stream.of
//						(new CropDetails("101","PrasadWani",3,245.65,"Jalgaon","Wheat","Prasad"),
//								new CropDetails(("102","Prasad Patil",7,765.99,"Jamner","Rice","Amol"))
//				.collect(Collectors.toList()));
//		assertEquals(3,cropController.getAllCrop().size());
//	}
	@Test
	public void findAllCropDetails() {
		when(cropRepository.findAll()).thenReturn(Stream.of
						(new CropDetails("103","Prasad Wani",5,1032.22,"Bhusawal","Maize","Shubham Mirge"),
								new CropDetails("105","SouLRangeR",8,2055.00,"Jalgaon","GOld","Amol Salunkhe"),
								new CropDetails("106","Shubham Patil",10,6000.00,"Agra","Chilli","ASH"))
				.collect(Collectors.toList()));
		assertEquals(3,cropController.getAllCrop().size());
	}


	//this method is for deleting data of dealer by dealer id
	@Test
	public void deleteCropTest() {
		String id = "101";
		cropController. delete(id);
		verify(cropRepository,times(1)).deleteById(id);
	}

	//this method is for getting data of dealer from dealer id
	@Test
	public void getCropDataTest() {
		String id = "101";
		cropController. getById(id);
		verify(cropRepository,times(1)).findById(id);
	}
}
