package kh.git.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Git_membersDAO {
	
	private Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";

		return DriverManager.getConnection(url, user, password);
	}
	
	public int insertMember(String name, String msg) throws Exception{
		String sql = "insert into git_members values(?,?)";
		try(
				Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				){
			pstat.setString(1, name);
			pstat.setString(2, msg);
			int result = pstat.executeUpdate();
			con.commit();
			return result;			
		}
	}
	
	public List<String> selectAll() throws Exception{
		String sql = "select * from git_members";
		try(
				Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();
				){
			List<String> list = new ArrayList<>();
			while(rs.next()) {
				String name = rs.getString("name");
				String msg = rs.getString("msg");
				
				list.add(name + " : " + msg);
			}
			return list;
		}
	}
}
