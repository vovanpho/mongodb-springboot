package com.example.mongodbspringboot.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.example.mongodbspringboot.entity.GroseryItem;


@EnableMongoRepositories
public interface ItemRepo extends MongoRepository<GroseryItem, String>{

    @Query("{name:'?0'}")
    GroseryItem findItemByName(String name);

    @Query(value = "{category:'?0'}", fields = "'name':1, 'quantity':1")
    List<GroseryItem> findAll(String category);

    public long count();
    
}
