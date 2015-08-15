package userinfo.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import userinfo.UserInfo;
import userinfo.dao.IUserInfoDao;
import userinfo.dao.mysql.UserInfoDaoMySql;
import userinfo.dao.oracle.UserInfoDaoOracle;

public class UserInfoWeb {

	public static void main(String[] args) throws IOException {
		
		UserInfo u1 = new UserInfo("Paul1985", "123", "Paul");
		//UserInfo u2 = new UserInfo("kmc5500", "111", "Kim");
		
		FileInputStream fis = new FileInputStream("db.properies");
		Properties prop = new Properties();
		prop.load(fis);
		String dbType = prop.getProperty("DBTYPE");
		
		IUserInfoDao dao = new UserInfoDaoOracle();	
	
		if (dbType.equals("MYSQL")){
			dao = new UserInfoDaoMySql();
		}
		
		dao.insertUserInfo(u1);
		dao.deleteUserInfo(u1);
		dao.updateUserInfo(u1);
		
	}

}