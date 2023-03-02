package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDAO;
import model.UserDTO;

//디테일 확인
public class OneController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin","*");		
		resp.setCharacterEncoding("utf-8"); 
		String id=req.getParameter("id");
		UserDAO dao=new UserDAO();
		UserDTO bean=dao.getOne(id);
		resp.setContentType("application/json");
		PrintWriter out=resp.getWriter();
		try {
			out.println("{\"users\":[");
			  out.println("{\"id\":\""+bean.getId()
				+"\",\"name\":\""+bean.getName()
				+"\",\"title\":\""+bean.getTitle()
				+"\",\"txt\":\""+bean.getTxt()
				+"\",\"email\":\""+bean.getEmail()+"\"}");
			out.println("]}");
		}finally{
			if(out!=null)out.close();
		}
	}
}