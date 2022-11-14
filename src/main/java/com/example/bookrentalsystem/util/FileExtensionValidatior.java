package com.example.bookrentalsystem.util;

import com.example.bookrentalsystem.globalException.AppException;
import org.springframework.web.multipart.MultipartFile;

public class FileExtensionValidatior {
    public static boolean validateFileExtension(MultipartFile imageFile,String... allowedExtensions){
        if (imageFile==null){
            return false;
        }
        for (String allowedExtension:allowedExtensions){
            if (imageFile.getContentType().contains(allowedExtension)) {
                return true;
            }
            if ((imageFile.getSize()/1024)>250)
                return false;
        }
        return false;
    }


}
