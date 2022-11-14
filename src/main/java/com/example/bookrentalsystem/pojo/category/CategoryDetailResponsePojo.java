package com.example.bookrentalsystem.pojo.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDetailResponsePojo {
    private  Integer categoryId;

    private  String categoryName;

    private  String categoryDescription;
}
