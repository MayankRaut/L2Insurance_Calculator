package com.codex.kotak;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class LoadPrimaryData {

	public static void main(String[] args) {
		Properties props = new Properties();

		try (FileInputStream fis = new FileInputStream("src/db.properties")) {
			// Load properties file
			props.load(fis);

			// Read properties
			String url = props.getProperty("db.url");
			String user = props.getProperty("db.username");
			String password = props.getProperty("db.password");

			// Load MySQL driver (optional for newer versions)
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Create connection
			Connection conn = DriverManager.getConnection(url, user, password);

			// Create Table and Insert Data
			createTable(conn);
			insertData(conn);

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createTable(Connection connection) {
		String createTableMale = "CREATE TABLE male (age int primary key, tenure_2 decimal(10,3), tenure_3 decimal(10,3), tenure_4 decimal(10,3))";
		try (Statement st = connection.createStatement()) {
			st.execute(createTableMale);
			System.out.println("Table created successfully...");
		} catch (Exception e) {
			System.out.println(e);
		}

		String createTableFemale = "CREATE TABLE female (age int primary key, tenure_2 decimal(10,3), tenure_3 decimal(10,3), tenure_4 decimal(10,3))";
		try (Statement st = connection.createStatement()) {
			st.execute(createTableFemale);
			System.out.println("Table created successfully...");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void insertData(Connection connection) {
		String insertMale = "INSERT INTO `male`\n" + "(`age`, `tenure_2`, `tenure_3`, `tenure_4`) VALUES\n"
				+ "(18, 0.381, 0.707, 1.081),\n" + "(19, 0.381, 0.716, 1.098),\n" + "(20, 0.392, 0.736, 1.134),\n"
				+ "(21, 0.404, 0.763, 1.185),\n" + "(22, 0.420, 0.804, 1.256),\n" + "(23, 0.454, 0.866, 1.344),\n"
				+ "(24, 0.487, 0.923, 1.427),\n" + "(25, 0.512, 0.972, 1.514),\n" + "(26, 0.548, 1.038, 1.634),\n"
				+ "(27, 0.584, 1.141, 1.797),\n" + "(28, 0.652, 1.268, 1.998),\n" + "(29, 0.723, 1.408, 2.215),\n"
				+ "(30, 0.803, 1.566, 2.454),\n" + "(31, 0.893, 1.734, 2.703),\n" + "(32, 0.983, 1.901, 2.960),\n"
				+ "(33, 1.075, 2.075, 3.243),\n" + "(34, 1.169, 2.278, 3.612),\n" + "(35, 1.305, 2.586, 4.138),\n"
				+ "(36, 1.518, 3.018, 4.817),\n" + "(37, 1.791, 3.524, 5.591),\n" + "(38, 2.064, 4.044, 6.386),\n"
				+ "(39, 2.363, 4.597, 7.236),\n" + "(40, 2.661, 5.168, 8.166),\n" + "(41, 2.988, 5.849, 9.134),\n"
				+ "(42, 3.423, 6.634, 10.117),\n" + "(43, 3.839, 7.387, 11.059),\n" + "(44, 4.218, 8.121, 11.994),\n"
				+ "(45, 4.656, 8.860, 13.074),\n" + "(46, 5.096, 9.657, 14.352),\n" + "(47, 5.682, 10.706, 15.857),\n"
				+ "(48, 6.459, 11.865, 17.435),\n" + "(49, 7.101, 12.845, 18.872),\n" + "(50, 7.654, 13.832, 20.433),\n"
				+ "(51, 8.318, 15.092, 22.407),\n" + "(52, 9.116, 16.566, 24.849),\n"
				+ "(53, 10.023, 18.362, 27.723),\n" + "(54, 11.209, 20.536, 30.935),\n"
				+ "(55, 12.548, 22.787, 34.189),\n" + "(56, 13.639, 24.856, 37.278),\n"
				+ "(57, 14.825, 27.121, 40.613),\n" + "(58, 16.148, 29.572, 44.159),\n"
				+ "(59, 17.509, 32.084, 47.763),\n" + "(60, 18.902, 34.622, 51.433),\n"
				+ "(61, 20.301, 37.201, 55.220),\n" + "(62, 21.820, 39.978, 59.281),\n"
				+ "(63, 23.517, 43.008, 63.877),\n" + "(64, 25.295, 46.471, 68.911),\n"
				+ "(65, 27.585, 50.413, 74.278);";

		String insertFemale = "INSERT INTO `female`\n" + "(`age`, `tenure_2`, `tenure_3`, `tenure_4`) VALUES\n"
				+ " (18, '0.459', '0.852', '1.306'),\n" + " (19, '0.459', '0.871', '1.338'),\n"
				+ " (20, '0.483', '0.907', '1.392'),\n" + " (21, '0.500', '0.937', '1.427'),\n"
				+ " (22, '0.508', '0.952', '1.456'),\n" + " (23, '0.520', '0.975', '1.505'),\n"
				+ " (24, '0.528', '1.013', '1.577'),\n" + " (25, '0.572', '1.088', '1.705'),\n"
				+ " (26, '0.607', '1.178', '1.867'),\n" + " (27, '0.673', '1.318', '2.087'),\n"
				+ " (28, '0.763', '1.487', '2.336'),\n" + " (29, '0.848', '1.646', '2.576'),\n"
				+ " (30, '0.929', '1.806', '2.832'),\n" + " (31, '1.023', '1.994', '3.156'),\n"
				+ " (32, '1.136', '2.245', '3.565'),\n" + " (33, '1.306', '2.572', '4.048'),\n"
				+ " (34, '1.498', '2.902', '4.505'),\n" + " (35, '1.651', '3.161', '4.888'),\n"
				+ " (36, '1.771', '3.392', '5.264'),\n" + " (37, '1.896', '3.665', '5.707'),\n"
				+ " (38, '2.087', '4.016', '6.289'),\n" + " (39, '2.279', '4.437', '6.966'),\n"
				+ " (40, '2.559', '4.963', '7.745'),\n" + " (41, '2.862', '5.489', '8.523'),\n"
				+ " (42, '3.107', '5.967', '9.344'),\n" + " (43, '3.393', '6.664', '10.342'),\n"
				+ " (44, '3.907', '7.648', '11.536'),\n" + " (45, '4.493', '8.588', '12.592'),\n"
				+ " (46, '4.869', '9.165', '13.357'),\n" + " (47, '5.159', '9.647', '14.025'),\n"
				+ " (48, '5.482', '10.133', '14.705'),\n" + " (49, '5.807', '10.604', '15.428'),\n"
				+ " (50, '6.078', '11.121', '16.247'),\n" + " (51, '6.543', '11.866', '17.309'),\n"
				+ " (52, '7.057', '12.642', '18.441'),\n" + " (53, '7.512', '13.433', '19.680'),\n"
				+ " (54, '7.991', '14.311', '21.057'),\n" + " (55, '8.535', '15.235', '22.512'),\n"
				+ " (56, '9.041', '16.136', '24.005'),\n" + " (57, '9.571', '17.188', '25.874'),\n"
				+ " (58, '10.223', '18.712', '28.241'),\n" + " (59, '11.305', '20.711', '30.993'),\n"
				+ " (60, '12.440', '22.581', '33.484'),\n" + " (61, '13.207', '23.979', '35.857'),\n"
				+ " (62, '13.913', '25.806', '38.732'),\n" + " (63, '15.314', '28.374', '42.774'),\n"
				+ " (64, '16.928', '31.516', '47.294'),\n" + " (65, '18.855', '34.902', '51.725');";

		try (Statement st = connection.createStatement()) {
			int p = st.executeUpdate(insertMale);
			int q = st.executeUpdate(insertFemale);
			System.out.println("For male " + p + " and for female " + q + " records inserted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}