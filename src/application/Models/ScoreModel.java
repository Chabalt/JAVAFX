package application.Models;

import java.util.ArrayList;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import application.DataBase;


public class ScoreModel {
	private int id;
	private int score;


	public ScoreModel(int id, int score) {
		this.id = id;
		this.score = score;

	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}


	@Override
	public String toString() {
		return "ScoreModel [ id=" + id + ", score=" + score +  "]";
	}

	public static void createTable() {
		String sql = "CREATE TABLE IF NOT EXISTS scores("
				+ " id integer PRIMARY KEY,"
				+ " score integer"
				+ ");";
		try {
			Statement s = DataBase.getInstance().creatStatement();
			s.execute(sql);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insert(ScoreModel score) {
		String sql = "INSERT INTO scores(score) VALUES(?);";

		try {
			PreparedStatement ps = DataBase.getInstance().prepareStatement(sql);
			ps.setInt(1, score.getScore());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public static ArrayList <ScoreModel> listAll(){
		String sql = "SELECT * FROM scores;";
		ArrayList<ScoreModel> list = new ArrayList<>();

		try {
			Statement s = DataBase.getInstance().creatStatement();
			ResultSet r = s.executeQuery(sql);
			while(r.next()) {
				list.add(new ScoreModel(r.getInt("id"),r.getInt("score")));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
}


