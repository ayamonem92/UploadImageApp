package com.aya.spring.web.controllers;


import java.util.List;
import org.springframework.web.multipart.commons.CommonsMultipartFile;  
import org.springframework.web.servlet.ModelAndView;  
import java.io.BufferedOutputStream;  
import java.io.File;  
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
import org.apache.commons.fileupload.disk.DiskFileItemFactory;  
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aya.spring.web.daos.Image;
import com.aya.spring.web.services.ImagesService;
@Controller
public class ImagesController {
	@Autowired
	ImagesService imagesService;
	 private static final String UPLOAD_DIRECTORY ="D://temp//";  
@RequestMapping("/images")
public String ShowImages(Model model){
	
	//Now lets send data from controller to jsp home file by using model object
	List<Image> images = imagesService.getImagesService();
	model.addAttribute("images",images);
	
	return "images";
}
@RequestMapping("/createimage")
public String createImage(Model model){
	//model.addAttribute("image", new Image());
	
	return "createimage";
}
@RequestMapping(value="/docreate",method = RequestMethod.POST)
public ModelAndView docreate(@RequestParam("name") CommonsMultipartFile file,  
        HttpSession session,HttpServletRequest request) throws Exception{
	
	
	if(!file.isEmpty()){
        try{
            byte[] bytes=file.getBytes();
            System.out.println("Byte Data :"+bytes);
            String fileName=file.getOriginalFilename();
            String filePath = "/resources/images/";

            // get absolute path of the application
            ServletContext context = request.getServletContext();
            String uploadedPath = context.getRealPath("")+filePath;
        File newFile = new File(uploadedPath);

           if (!newFile.exists()){
                newFile.mkdirs();

            }
            File serverFile = new File(newFile.getAbsolutePath()+File.separator+fileName);
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
            System.out.println(newFile.getAbsolutePath()+File.separator+fileName);
            imagesService.create(new Image(fileName ));   

        }catch(Exception e){
            e.printStackTrace();
        }
    }
 
       
    return new ModelAndView("imagecreated","filesuccess","File successfully saved!");  
}










}
