package com.example.bookrentalsystem.pojo.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Service
public class CategoryDetailRequestPojo {
    private  Integer categoryId;
    @NotNull
    private  String categoryName;
    @NotNull
    private  String categoryDescription;
}
