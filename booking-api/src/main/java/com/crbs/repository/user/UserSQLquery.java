package com.crbs.repository.user;

public class UserSQLquery {

	//회원가입
	public static final String INSERT_USER = "insert into CUSTOMER (id, name, password, isadmin ,phonenumber) values (?,?,?,?,?)";

	//회원탈퇴
	public static final String DELETE_USER = "delete from CUSTOMER where id = ?"; 
		
	//회원정보 수정
	public static final String UPDATE_USER = "update CUSTOMER set phonenumber = ? where id = ?"; 
	
	public static final String SELECT_USER_BY_ID_AND_PASSWORD = "select ID, PASSWORD from CUSTOMER where ID = ? and PASSWORD = ?";
	
	public static final String SELECT_USER_BY_ID = "select ID, PASSWORD from CUSTOMER where ID = ?";
}