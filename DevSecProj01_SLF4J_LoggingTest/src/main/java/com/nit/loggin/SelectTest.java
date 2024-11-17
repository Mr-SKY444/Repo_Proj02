package com.nit.loggin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectTest {
	public void doMultiply(int a, int b)
	{
		System.out.println("Result is : "+a*b);
	}
	public void doSum(int a, int b)
	{
		System.out.println("Result is :"+a+b);
	}
	private static Logger logger=LoggerFactory.getLogger(SelectTest.class);
	
	public static void main(String[] args) {
			logger.debug("SelectTest :: main method started...");
			
			Connection con=null;
			Statement st=null;
			ResultSet rs=null;
		
			try {
				
				    Class.forName("com.mysql.cj.jdbc.Driver");
				    logger.debug("com.nit.logger.SelectTest :: Jdbc driver class loaded...");
				    con=DriverManager.getConnection("jdbc:mysql://localhost/batch30","root","sky@123");
				    logger.info("com.nit.logger.SelectTest :: connection is establish..");
				    
				    if(con!=null){
				    	st=con.createStatement();
				    	logger.debug("com.nit.logger.SelectTest :: jdbc statement object created...");
				    }
				    
				    if(st!=null) {
				    	rs=st.executeQuery("select *from customer");
				    	logger.debug("com.nit.logger.SelectTest :: sql qury is send to be db s/w for execution and ResultSet object created");
				    }
				    
				    if(rs!=null)
				    {
				    	while(rs.next())
				    	{
				    		System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
				    	    logger.warn("com.nit.logging.SelectTest :: The recoeds are comming out from ResultSet using getString() for all change them accordingly...");
				    	
				    	}// while
				    	
				    	logger.debug("com.nit.logging.SelectTest :: ResultSet object is processed...");
				    }//if
			}// try
			catch(SQLException e)
			{
				e.printStackTrace();
				logger.debug("com.nit.logging.SelectTest :: known DB problem "+e.getMessage()+" SQL error code "+e.getErrorCode());
			}// catch
			catch(Exception e)
			{
				e.printStackTrace();
				logger.debug("com.nit.logging.SelectTest :: known DB problem "+e.getMessage());
			}
			
			logger.info("com.nit.logging.SelectTest :: main() ended...");
			
	}//main method end
}
