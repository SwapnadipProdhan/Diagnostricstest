package com.TestCentre.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.TestCentre.enitity.MyTest;
import com.TestCentre.enitity.TestOrder;
import com.TestCentre.service.MyTestService;
import com.TestCentre.service.TestService;

@Controller
public class TestController {
	@Autowired
	private TestService testService;

	@Autowired
	private MyTestService myTestService;

	@GetMapping("/")
	public String home() {
		return "home";
	}
		
	@GetMapping("/test_register")//to link with another page 
	public String testRegister() {
		return "testRegister";
	}
	
	@GetMapping("/available_tests")//to link with another page 
	public ModelAndView getAllTest() {
		List<TestOrder> list=testService.getAllTest();
		//ModelAndView mv = new ModelAndView();
		//mv.setViewName("testList");
		//mv.addObject("test" , list);
		return new ModelAndView("testList","test",list);
	}
	
	@PostMapping("/save")
	public String addTest(@ModelAttribute TestOrder testOrder) {
		testService.save(testOrder);
		return "redirect:/available_tests";
	}
	
	
	@GetMapping("/my_tests")
	public String getMyTests(Model model)
	{
		List<MyTest> list=myTestService.getAllMyTest();
		model.addAttribute("test", list);
		return "myTests";
	}
	
     
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id)
	{
		TestOrder testOrder=testService.getTestById(id);
		MyTest mtest= new MyTest(testOrder.getId() , testOrder.getName() , testOrder.getDoctor() , testOrder.getTest());
		myTestService.saveMyTest(mtest);
	    return "redirect:/my_tests"	;
	}
	
	
	@RequestMapping("/editTest/{id}")
	public String editTest(@PathVariable("id") int id, Model model)
	{
		TestOrder testOrder = testService.getTestById(id);
		model.addAttribute("test", testOrder);
		return "testEdit";
	}
	
	@RequestMapping("/deleteTest/{id}")
	public String deleteTest(@PathVariable("id") int id)
	{
		testService.deleteById(id);
		return "redirect:/available_tests";
	}
	
	/*@GetMapping("/successful")
	public String success() {
		return "success";
	}*/
}
