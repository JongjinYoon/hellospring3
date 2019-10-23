package kr.co.itcen.hellospring.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping("/hello2")
	public ModelAndView hello2() {
		String data = "Hello World2";
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", data);
		mav.setViewName("hello");
		
		return mav;
	}
	
	@RequestMapping("/hello3")
	public String hello3(Model model) {
		String data = "Hello World3";
		model.addAttribute("data",data);
		return "hello";
	}
	
	@RequestMapping("/hello4")
	public String hello4(
			@RequestParam(value = "email", required=true, defaultValue="") String email, //e라는 파라미터로 넘어오는 값을 email에 세팅
			@RequestParam(value = "age", required=true, defaultValue="999") int age,
			Model model) {
		model.addAttribute("email",email);
		model.addAttribute("age",age);
		
		
		return "hello";
	}
	
	@RequestMapping("/hello5")
	public String hello5(
			@ModelAttribute User user, 
			// 여기서 스프링이 User user = new User()를 해줌 
			//ModelAttribute를 쓰면 자동으로 jsp에 넣어줘서 jsp에서 그냥 사용 가능
			Model model) {
		System.out.println(user);
		
		model.addAttribute("email",user.getEmail());
		model.addAttribute("age",user.getAge());// @ModelAttribute를 쓰면 얘네가 필요없어짐
		
		
		return "hello";
	}
	
	
	//기술침투
	//비추천
	@RequestMapping("/hello6")
	public void hello6(
			HttpServletRequest request,
			HttpServletResponse response,
			Writer out,
			Model model) throws ServletException, IOException {
		
		
		//request.getRequestDispatcher("/WEB-INF/views/hello.jsp").forward(request, response);;
		out.write("<h1>hello world</h1>");
	}
	
	@ResponseBody
	@RequestMapping("/hello7")
	public String hello7() {
			
		return "<h1>hello world</h1>";
	}
}
