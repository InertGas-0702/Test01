package com.util;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil {


	
	private Connection conn=null;
	private PreparedStatement psmt=null;
	private ResultSet rs = null;
	
	private static final String CLASSNAME="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://127.0.0.1:3306/dbase";
	private static final String USERNAME="root";
	private static final String PASSWORD="root";
	
	static{
		try {
			Class.forName(CLASSNAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public Connection getConn(){
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public void updatePreparedStatement(String sql,Object...params) throws SQLException{
		
			getConn();
			PreparedStatement psmt = conn.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					psmt.setObject(i+1, params[i]);
				}
			}
			psmt.execute();

		
		
	}
	
	
	/**
	 * String sql="select * from tb_book";
	 * QueryPreparedStatement(sql,Book.class)
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 */
	public <T> List<T> queryPreparedStatement(String sql, Class<T> clazz, Object... params){		
		List<T> result = null;
		try {
			
			result = new ArrayList<T>();
			
			getConn();		
			psmt = conn.prepareStatement(sql);
			
			if(params!=null){
				for(int i=0;i<params.length;i++){
					psmt.setObject(i+1, params[i]);
				}
			}
			rs = psmt.executeQuery();
			

			ResultSetMetaData rsmd = rs.getMetaData();

			int count = rsmd.getColumnCount();
			
			List<String> columns = new ArrayList<String>();
			for(int i=1;i<=count;i++){

				String name = rsmd.getColumnName(i);
				columns.add(name);
			}

			
			while(rs.next()){

				T obj = clazz.newInstance();
				
				for(int i=0;i<columns.size();i++){
					String name = columns.get(i);// bname  bid

					Field field = clazz.getDeclaredField(name);
					field.setAccessible(true);

					String type = field.getType().getName();
					
					if("int".equals(type) || "java.lang.Integer".equals(type)){
						int value = rs.getInt(name);
						field.set(obj, value);
					}else if("double".equals(type) || "java.lang.Double".equals(type)){
						double value = rs.getDouble(name);
						field.set(obj, value);
					}else if("float".equals(type) || "java.lang.Float".equals(type)){
						float value = rs.getFloat(name);
						field.set(obj, value);
					}else if("java.lang.String".equals(type)){
						String value = rs.getString(name);
						field.set(obj, value);
					}else if("boolean".equals(type) || "java.lang.Boolean".equals(type)){
						boolean value = rs.getBoolean(name);
						field.set(obj, value);
					}else if("java.sql.Date".equals(type)){
						Date value = rs.getDate(name);
						field.set(obj, value);
					}
					
				}
				
				result.add(obj);
				
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}








