package com.heima.minio.test;

import com.heima.file.service.FileStorageService;
import com.heima.minio.MinIOApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest(classes = MinIOApplication.class)
@RunWith(SpringRunner.class)
public class MinIOTest {
    @Autowired
    private FileStorageService fileStorageService;
    @Test
    public void test() throws FileNotFoundException {
        FileInputStream fileInputStream = null;
        fileInputStream =  new FileInputStream("F:\\考研资料\\身份证件资料\\学生证.jpg");
        String s = fileStorageService.uploadHtmlFile("", "学生证.jpg", fileInputStream);
        System.out.println(s);
    }
//    public static void main(String[] args) {
//
//        FileInputStream fileInputStream = null;
//        try {
//
//            fileInputStream =  new FileInputStream("F:\\黑马程序员资料\\day02-app端文章查看，静态化freemarker,分布式文件系统minIO\\资料\\模板文件\\plugins\\js\\axios.min.js");;
//
//            //1.创建minio链接客户端
//            MinioClient minioClient = MinioClient.builder().credentials("admin", "admin123456").endpoint("http://192.168.192.128:9000").build();
//            //2.上传
//            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
//                    .object("plugins/js/axios.min.js")//文件名
//                    .contentType("text/js")//文件类型
//                    .bucket("leadnews")//桶名词  与minio创建的名词一致
//                    .stream(fileInputStream, fileInputStream.available(), -1) //文件流
//                    .build();
//            minioClient.putObject(putObjectArgs);
//
////            System.out.println("http://192.168.192.128:9000/leadnews/list.html");
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }

}