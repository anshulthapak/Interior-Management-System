package com.anshul.interiormanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;





@SpringBootApplication
public class InteriorManagementSystemApplication{

	public static void main(String[] args) {
		SpringApplication.run(InteriorManagementSystemApplication.class, args);
	}
	
/*	@Autowired
	private ItemService itemService;

	@Override
	public void run(String... args) throws Exception {
		Item i = new Item();
		i.setBrand("Tata");
		i.setName("pipe");
		i.setQty((long) 500);
		i.setPrice(BigDecimal.valueOf(40.5));
		i.setGst(18);
		i.setMrp(BigDecimal.valueOf(105.8));
		i.setDate("2022-01-23T03:39:40");
		i.setUpdateDate("2022-01-23T03:39:40");
		itemService.saveItem(i);
		
	}
*/	
	
	
	
}
