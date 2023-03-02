package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserDAO;

//삭제
public class DelController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin","*");
		String param1=req.getParameter("id");
		String id=param1.trim();
		UserDAO dao=new UserDAO();
		dao.deleteOne(id);

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