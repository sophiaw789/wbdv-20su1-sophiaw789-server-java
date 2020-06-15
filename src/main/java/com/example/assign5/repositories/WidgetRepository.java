package com.example.assign5.repositories;

import com.example.assign5.models.Widget;
import org.springframework.data.repository.CrudRepository;

public interface WidgetRepository extends CrudRepository<Widget, Integer> {
    
}