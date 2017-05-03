package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class SampleTable {
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static String url = "jdbc:mysql://127.0.0.1:3306/test";
	static  String user = "user";
	static String pass = "pass";
	static String SQL = "SELECT * FROM products;";
	static String q1;
	static String q2;
 static void main(String srgs[]){
		try {
			// データベースへ接続
			conn = DriverManager.getConnection(url, user, pass);

			// ステートメントオブジェクトを生成
			stmt = conn.createStatement();

			// SQLを実行して結果セットを取得
			rs = stmt.executeQuery(SQL);

			// 取得した行数分ループ
			while (rs.next()) {
				q1 = rs.getString("item_No.");
				q2 = rs.getString("item_name");

				System.out.println(q1 + " " + q2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// close処理
				if (rs != null) {
					rs.close();
				}
				// close処理
				if (stmt != null) {
					stmt.close();
				}
				// close処理
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

 }

