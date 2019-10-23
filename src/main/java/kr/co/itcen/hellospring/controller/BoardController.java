package kr.co.itcen.hellospring.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//@RequestMapping Type + Method

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@RequestMapping({"/list","","/a/b/c/d"})//배열로도 가능
	@ResponseBody
	public String list() {
		return "BoardController:list()";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	@ResponseBody
	public String write() {
		return "/WEB-INF/views/board/write.jsp";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	@ResponseBody
	public String write(Map<String, Object> map) {
		return "redirect:/board";
	}
	
	@RequestMapping(value="/view/{no}")
	@ResponseBody
	public String view(@PathVariable("no") Long no) {//여기있는 두 no의 이름이 일치해야함 위에는 상관무 남용x
		return "BoardController:view:"+no;
	}
}
