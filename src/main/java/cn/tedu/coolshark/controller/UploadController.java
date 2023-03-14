package cn.tedu.coolshark.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
//图片上传,消化下
@RestController
public class UploadController {
    @RequestMapping("/upload")
    public String upload(MultipartFile picFile) throws IOException {
        String fileName = picFile.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        fileName=UUID.randomUUID()+suffix;

        String dirPath ="d:/files";
        String datePath = new SimpleDateFormat("/yyyy/MM/dd").format(new Date());
        File dirFile = new File(dirPath + datePath);
        if (!dirFile.exists()){
            dirFile.mkdirs();
        }
        picFile.transferTo(new File(dirPath+datePath+fileName));
        return datePath+fileName;
    }

    public void remove(String url){
        new File("d:/files"+url).delete();
    }
}
