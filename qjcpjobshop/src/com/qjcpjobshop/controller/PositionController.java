package com.qjcpjobshop.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qjcpjobshop.entity.Position;
import com.qjcpjobshop.entity.Userfindjob;
import com.qjcpjobshop.service.PositionService;
import com.qjcpjobshop.service.UserService;

@Controller
//@RequestMapping("/position")
public class PositionController extends HttpServlet {
	@Resource
	private PositionService positionService;
	
	@RequestMapping(value="/position/addposition1", method=RequestMethod.POST)
	public String addPosition1(@RequestParam("id") String id, @RequestParam("type") String type,@RequestParam("name") String name,@RequestParam("minSalary") String minSalary,@RequestParam("maxSalary") String maxSalary,@RequestParam("city") String city,@RequestParam("experience") String experience,@RequestParam("degree") String degree,@RequestParam("tempation") String tempation,@RequestParam("description") String description,@RequestParam("address") String address,HttpSession session){
		try{
			Position p = new Position();
			p.setId(id+p.getCount());
			p.setCount();
			p.setType(type);
			p.setName(name);
			p.setMinSalary(minSalary);
			p.setMaxSalary(maxSalary);
			p.setCity(city);
			p.setExperience(experience);
			p.setDegree(degree);
			p.setTempation(tempation);
			p.setDescription(description);
			p.setAddress(address);
			positionService.addPosition(p);
			System.out.println("insert OK");
			
			Object[] options = {"继续"}; 
			JOptionPane.showOptionDialog(null, "添加成功，点击以继续", "提示", 
			JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
			null, options, options[0]);
			
			return "index";
		}catch(Exception e){
			e.printStackTrace();
			
			Object[] options = {"继续"}; 
			JOptionPane.showOptionDialog(null, "添加失败，请重新填写", "提示", 
			JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
			null, options, options[0]);
			
			return "create";
		}
		

	}
}