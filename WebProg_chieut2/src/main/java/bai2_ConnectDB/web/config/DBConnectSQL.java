package bai2_ConnectDB.web.config;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.net.ssl.SNIServerName;


public class DBConnectSQL {
private final String serverName = "DESKTOP-AS1MQ50";
private final String dbName = "LoGIN";
private final String portNumber = "1433";
private final String instance ="";	//MSSQLSERVER LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
private final String userID = "sa";
private final String password = "123";
public  Connection getConnection()
{
	Connection conn = null;
	//jdk 20 roi ko can dang ky driver nua. Nhung ma hoc cho biet thoai!!!
	
	try {
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName+";encrypt=true;trustServerCertificate=true;";
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName+";encrypt=true;trustServerCertificate=true;";
		conn = DriverManager.getConnection(url, userID, password);
		if(conn  != null)
		{
			DatabaseMetaData dbm = (DatabaseMetaData)conn.getMetaData();
			System.out.println("Driver Name: "+ dbm.getDriverName());
			System.out.println("Driver version: "+ dbm.getDriverVersion());
			System.out.println("Product Name: "+ dbm.getDatabaseProductName());
			System.out.println("Product Version: "+ dbm.getDatabaseProductVersion());

		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return conn;
}



}
