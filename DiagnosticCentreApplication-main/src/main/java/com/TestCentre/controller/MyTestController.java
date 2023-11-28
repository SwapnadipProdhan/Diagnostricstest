package com.TestCentre.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import com.TestCentre.service.MyTestService;



@Controller
public class MyTestController
{
	@Autowired
	private MyTestService myService;
	
	/*@Autowired
	private MyTestRepository testRepo;*/
	
	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id)
	{
		myService.deleteById(id);
	  return "redirect:/my_tests";
	}
	
	/*@GetMapping("/my_tests")
	public String getMyTests(Model model) {
		List<MyTest> list=testRepo.findAll();
		model.addAttribute("test", list);
		return "myTests";
	}*/

	
	//<!--for image-->
	/*@PostMapping("/imageUpload")
	public String imageUpload(@RequestParam MultipartFile images ,HttpSession session)
	{
		MyTest im=new MyTest();
		im.setImageName(images.getOriginalFilename());
		MyTest uploadImg = testRepo.save(im);
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
		session.setAttribute("msg", "Image Upload Sucessfully");
		return "redirect:/";
	}*/
	
	
}
