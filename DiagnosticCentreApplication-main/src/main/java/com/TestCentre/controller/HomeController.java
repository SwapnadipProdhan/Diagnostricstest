package com.TestCentre.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.TestCentre.enitity.Image;
import com.TestCentre.repository.UploadRepository;

import jakarta.servlet.http.HttpSession;
@Controller
public class HomeController {
	@Autowired
	private UploadRepository uploadRepo;

	@GetMapping("/imageUpload")
	public String upload(Model model) {

	List<Image> list = uploadRepo.findAll();

		model.addAttribute("list", list);
		
		return "upload";
	}
	
	@PostMapping("/imageUpload")
	public String imageUpload(@RequestParam MultipartFile images , HttpSession session)
	{
		Image im=new Image();
		im.setImageName(images.getOriginalFilename());
		Image uploadImg = uploadRepo.save(im);
		
		if(uploadImg!= null)
		{
			try 
			{
				File saveFile=new ClassPathResource("static/images").getFile();
				Path path=Paths.get(saveFile.getAbsolutePath()+File.separator+images.getOriginalFilename());
				System.out.println(path);
				Files.copy(images.getInputStream(), path,StandardCopyOption.REPLACE_EXISTING);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	   }
		
		session.setAttribute("msg", "Image Uploaded Sucessfully");

		return "redirect:/";
	}
	
	
	@GetMapping("/successful")
	public String success() {
		return "success";
	}
}
	

