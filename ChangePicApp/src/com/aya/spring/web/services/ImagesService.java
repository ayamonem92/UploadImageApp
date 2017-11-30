package com.aya.spring.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aya.spring.web.daos.ImagesDao;
import com.aya.spring.web.daos.Image;
@Service("imagesService")
public class ImagesService {
	private ImagesDao imageDao;
	@Autowired
	public void setImageDao(ImagesDao imageDao) {
		this.imageDao = imageDao;
	}

public List<Image> getImagesService(){
	return imageDao.getImages();
}

public void create(Image image) {
	// TODO Auto-generated method stub
	imageDao.create(image);
	
}
}
