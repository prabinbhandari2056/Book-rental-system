package com.example.bookrentalsystem.util;
        import org.apache.commons.io.FilenameUtils;
        import org.springframework.util.FileCopyUtils;
        import org.springframework.util.StringUtils;
        import org.springframework.web.multipart.MultipartFile;

        import javax.servlet.http.HttpServletResponse;
        import java.io.File;
        import java.io.FileInputStream;
        import java.nio.file.Files;
        import java.util.UUID;
public class GenericFileHandler {


    public static final String PRESENT_DIR = System.getProperty("user.dir");

    public static String saveImage(MultipartFile image, String filePath) throws Exception {
        try {
            if (image == null)
                throw new Exception(("Image Not Found!!"));

            String imagePath = PRESENT_DIR + filePath;
            File file = new File(imagePath);
            if (!file.exists()) {
                file.mkdirs();
            }
            String fileName = UUID.randomUUID() + "." + FilenameUtils.getExtension(image.getOriginalFilename());
            String tempFileName = imagePath + fileName;
            image.transferTo(new File(tempFileName));
            return tempFileName;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    public static void getImage(String filePath, HttpServletResponse response) throws Exception {
        if (!StringUtils.isEmpty(filePath)) {
            File imagePath = new File(filePath);
            if (imagePath.exists()) {
                FileCopyUtils.copy(Files.newInputStream(imagePath.toPath()), response.getOutputStream());
            } else {
                throw new RuntimeException("Invalid File Path");
            }
        }
    }
}