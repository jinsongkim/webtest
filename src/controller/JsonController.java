package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDAO;
import model.UserDTO;

// 조회
public class JsonController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin","*");
		resp.setCharacterEncoding("utf-8");
		UserDAO dao=new UserDAO();
		PrintWriter out = resp.getWriter();
		try {
			out.println("{\"users\":[");
			List<UserDTO> list=dao.getList();
			for(int i=0; i<list.size(); i++) {
				UserDTO bean=list.get(i);
				if(i!=0)out.print(",");
				  out.println("{\"id\":\""+bean.getId()
				+"\",\"name\":\""+bean.getName()
				+"\",\"title\":\""+bean.getTitle()
				+"\",\"email\":\""+bean.getEmail()+"\"}");
			}
			out.println("]}");
		}finally {
			if(out!=null)out.close();
		}
	}
}