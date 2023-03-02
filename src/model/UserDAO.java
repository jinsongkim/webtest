package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.UserDTO;
import util.BitSql;

public class UserDAO {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public int insertOne(String id, String name, String title, String txt, String email) {
		String sql="insert into users value ('"+id+"','"+name+"','"+title+"','"+txt+"','"+email+"')";
		try {
			conn=BitSql.getConnection();
			stmt=conn.createStatement();
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			//sql 수행을 못했을 경우 리턴 0
			return 0;
		}finally {
			try {
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int editOne(String id, String name, String title, String txt, String email) {
		String sql="update users set id='"+id+"',name='"+name+"',title='"+title+"',txt='"+txt+"',email='"+email+"' where id='"+id+"'";
		try {
			conn=BitSql.getConnection();
			stmt=conn.createStatement();
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			//sql 수행을 못했을 경우 리턴 0
			return 0;
		}finally {
			try {
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//삭제
	public int deleteOne(String id) {
		String sql="delete from users where id='"+id+"'";
		try {
			conn=BitSql.getConnection();
			stmt=conn.createStatement();
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			//sql 수행을 못했을 경우 리턴 0
			return 0;
		}finally {
			try {
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public List<UserDTO> getList(){
		String sql="select * from users";
		List<UserDTO> list=new ArrayList<UserDTO>();
		try {
			conn=BitSql.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				UserDTO bean=new UserDTO();
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setTitle(rs.getString("title"));
				bean.setEmail(rs.getString("email"));
				list.add(bean);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
				try {
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();
					if(conn!=null)conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return list;
	}

	public UserDTO getOne(String id) {
		String sql="select * from users where id='"+id+"'";
		UserDTO bean=new UserDTO();
		try {
			conn=BitSql.getConnection();
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs.next()) {
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setTitle(rs.getString("title"));
				bean.setTxt(rs.getString("txt"));
				bean.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bean;
	}
}