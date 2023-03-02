package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDAO;

//추가
public class EditController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin","*");
		String param1=req.getParameter("id");
		String param2=req.getParameter("name");
		String param3=req.getParameter("title");
		String param4=req.getParameter("txt");
		String param5=req.getParameter("email");
		
		String id=param1.trim();
		String name=param2.trim();
		String title=param3;
		String txt=param4;
		String email=param5.trim();

		UserDAO dao=new UserDAO();
		dao.editOne(id, name, title, txt, email);

		resp.setStatus(201);
		
//		if(dao.insertOne(id,name,email)) {
//			//성공 : 201=Post요청일 때, 새로운 결과 생성 성공
//			resp.setStatus(201);
//		}else{
//			//실패: 400=request 에러
//			resp.setStatus(400);
//		};
	}
}