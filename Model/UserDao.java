package com.WeChat.leeham;
import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {
	
      User getUser(Connection conn, String userNumber) throws SQLException;
      
      void insert(Connection conn, User user) throws SQLException;
      
      void updateInfo(Connection conn, User user) throws SQLException;
      
      void updateCheckIn(Connection conn, String userNumber, String address) throws SQLException;
      //暂不实现
      void delete(Connection conn, User user) throws SQLException;
}
