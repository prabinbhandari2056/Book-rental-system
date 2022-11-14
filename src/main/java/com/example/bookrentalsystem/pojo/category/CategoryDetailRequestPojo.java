package com.example.bookrentalsystem.pojo.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class CategoryDetailRequestPojo {
    private  Integer categoryId;

    private  String categoryName;

    private  String categoryDescription;
}
