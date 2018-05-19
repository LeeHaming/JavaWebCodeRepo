package com.WeChat.leeham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUser(Connection conn, String userNumber) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM user WHERE userNumber = " + userNumber;
		System.out.println("sql:"+sql);

        Statement st = conn.createStatement();
        System.out.println("st:"+st.toString());
        
        ResultSet rt = st.executeQuery(sql);
        System.out.println("rt:"+rt);
        
        if (rt.next()){
            User user = new User();
            user.setUserNumber(rt.getString("userNumber"));
            user.setUserName(rt.getString("userName"));
            user.setTeacherName(rt.getString("teacherName"));
            user.setCheckIn(rt.getInt("checkIn"));
            user.setUserAddress(rt.getString("address"));
            return user;
        }
        else{
            return null;
        }
	}

	@Override
	public void insert(Connection conn, User user) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = conn.prepareCall("INSERT INTO user(userNumber, userName, teacherName, checkIn) VALUES (?, ?, ?, ?)");
		ps.setString(1, user.getUserNumber());
        ps.setString(2, user.getUserName());
        ps.setString(3, user.getTeacherName());
        ps.setInt(4, user.getCheckIn());
        System.out.println("ps:"+ps.toString());
        ps.execute();
	}

	@Override
	public void updateInfo(Connection conn, User user) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = conn.prepareCall("UPDATE user SET userName = ? , teacherName = ? , checkIn = ? WHERE userNumber = ?");
		ps.setString(4, user.getUserNumber());
        ps.setString(1, user.getUserName());
        ps.setString(2, user.getTeacherName());
        ps.setInt(3, user.getCheckIn());
        ps.execute();
	}

	@Override
	public void delete(Connection conn, User user) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = conn.prepareCall("DELETE FROM user WHERE UserNumber = ?");
        ps.setString(1, user.getUserNumber());
        ps.execute();
	}

	@Override
	public void updateCheckIn(Connection conn, String userNumber, String address) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement ps = conn.prepareCall("UPDATE user SET checkIn = 1, address=?  WHERE userNumber = ?");
		System.out.println(ps.toString());
		ps.setString(1, address);
		ps.setString(2, userNumber);
        ps.execute();
		
	}

}
