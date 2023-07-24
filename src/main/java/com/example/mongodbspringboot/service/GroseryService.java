package com.example.mongodbspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mongodbspringboot.entity.GroseryItem;
import com.example.mongodbspringboot.repository.ItemRepo;


//Bạn có thể tạo bean cho class HelloService.java bằng cách đánh dấu @Named (quản lý bởi CDI), 
//@Service or @Component (quản lý bởi Spring) hoặc @ManagedBean (quản lý bởi JSF)

//Ta có thể thực hiện inject một thể hiện của HelloService.java và HelloBean.java 
/*bằng cách dùng @Autowired (Spring), @Inject (CDI), @ManagedProperty (JSF)*/

@Service
public class GroseryService {
	@Autowired
	private ItemRepo itemRepo;
	
	public GroseryItem addGrosery(GroseryItem groseryItem) {
		if(!itemRepo.existsById(groseryItem.getId())){
			return itemRepo.save(groseryItem);
		}
		return groseryItem;
	}

	public List<GroseryItem> listAllGrosery(){
		return itemRepo.findAll();
	}
	
	public Optional<GroseryItem> detailGrosery(String id) {
		return itemRepo.findById(id);
	}

	public boolean checkIdGrosery(String id){
		return itemRepo.existsById(id);
	}
}

