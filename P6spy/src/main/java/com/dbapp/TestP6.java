package com.dbapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestP6 {

	private static String driverClass = "com.p6spy.engine.spy.P6SpyDriver";
	private static String URL = "jdbc:p6spy:mysql://localhost:3306/db";
	private static String userName = "root";
	private static String password = "root123456789";
	
	
	public static long p6spy(){
		long start = 0;
		long end = 0;
		try {
			Class.forName(driverClass);
			start = System.currentTimeMillis();
			Connection conn = DriverManager.getConnection(URL,userName,password);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from ssm_user");
			end = System.currentTimeMillis();
			System.out.println("time:"+(end-start));
			/*while(rs.next()){
				//System.out.println(rs.getString(1)+" "+rs.getString(2));
			}*/
			//System.out.println(conn);
			st.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
		return (end-start);
	}
	public static long normal(){
		long start = 0;
		long end = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			start = System.currentTimeMillis();
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db",userName,password);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from ssm_user");
			end = System.currentTimeMillis();
			System.out.println("time:"+(end-start));
			/*while(rs.next()){
				//System.out.println(rs.getString(1)+" "+rs.getString(2));
			}*/
			//System.out.println(conn);
			st.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
		return (end-start);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long sum = 0;
		for(int i = 0;i < 100;i++){
			sum = sum + normal();
		}
		System.out.println(sum/100.0);
	}

}
