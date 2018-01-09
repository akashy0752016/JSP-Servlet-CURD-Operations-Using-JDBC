package com.akash.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.akash.bean.Users;
import com.akash.utility.Utility;

public class UserBOIMP implements UserBO {

	@Override
	public List<Users> getUsers() {
		// TODO Auto-generated method stub
		List<Users> userList = new ArrayList<Users>();
		try {
			Statement st = Utility.getConnection().createStatement();
			ResultSet rs = st.executeQuery("Select * from users order by id DESC");
			while(rs.next()) {
				Users u = new Users();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
				userList.add(u);
			}
			st.close();
			Utility.closeConnection();
			return userList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public Users getUser(int id) {
		// TODO Auto-generated method stub
		Users u = new Users();
		try {
			PreparedStatement ps = Utility.getConnection().prepareStatement("Select * from users where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
			}
			rs.close();
			ps.close();
			Utility.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public int createUser(Users u) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = Utility.getConnection().prepareStatement("Insert into users (name, email, password) values (?,?,?)");
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			int i = ps.executeUpdate();
			ps.close();
			Utility.closeConnection();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = Utility.getConnection().prepareStatement("Delete from users where id = ?");
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			ps.close();
			Utility.closeConnection();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateUser(Users u) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = Utility.getConnection().prepareStatement("Update users set name = ?, email = ?, password = ? where id = ?");
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			ps.setInt(4, u.getId());
			int i = ps.executeUpdate();
			ps.close();
			Utility.closeConnection();
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
