package com.javaex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class GuestbookDao {

	// 필드
	
	@Autowired
	private SqlSession sqlSession;
	
	/*

	// 0. import java.sql.*;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private String driver = "com.mysql.cj.jdbc.Driver";
	private	String url = "jdbc:mysql://localhost:3306/guestbook_db";
	private String id = "guestbook";
	private String pw = "guestbook";
*/
	// 생성자
	// 기본 생성자 사용 (그래서 생략)

	// 메서드 gs
	// 필드값을 외부에서 사용하면 안됨 (그래서 생략)
	
	// 메서드 일반

	// DB연결 메소드
	/*
	private void getConnection() {

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);

			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	// 자원정리 메소드
	private void close() {
		// 5. 자원정리
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}
	
	*/
	
	//////////////////////////////////////////////////
	
	
	//사람 정보 삭제
	public int deletePerson(int no, String password) {
		
		System.out.println("Dao.deletePerson()");
		
		Map<String, Object> personMap = new HashMap<String, Object>();
		personMap.put("no", no);
		personMap.put("password", password);

		
		int count = sqlSession.delete("guestbook.delete", personMap);
		
		
		

		/*
		int count = 0; 
		
		this.getConnection();
		
		try {
			// 3. SQL문 준비 / 바인딩 / 실행

			// - sql문 준비
			String query = "";
			query += " delete from person ";
			query += " where no = ? ";
			query += " and password = ? ";

			// - 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			pstmt.setString(2, password);

			// - 실행
			count = pstmt.executeUpdate();



			// 4.결과처리
			System.out.println(count + "건 삭제 되었습니다.");

			
		}  catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();
		*/

		return count;
	}
	
	
	
	
	// 사람 1명 정보 가져오기
	public PersonVo getPersonOne(int no) {
		
		System.out.println("dao.getPersonOne()");
		
		/*
		
		Map<String, Object> personMap = sqlSession.selectOne("guestbook.selectOne", no);
		
		System.out.println("----------------");
		System.out.println(personMap);
		System.out.println(personMap.get("name"));
		System.out.println("----------------");
		*/
		
		
		
		PersonVo personVo = sqlSession.selectOne("guestbook.selectOne", no);
		
		System.out.println("----------------");
		System.out.println(personVo);
		System.out.println("----------------");
		
		/*

		int count = 0;

		this.getConnection();
		
		PersonVo personVo = null;

		try {
			// 3. SQL문 준비 / 바인딩 / 실행

			// - sql문 준비
			String query = "";
			query += " select  no, ";
			query += "  	   name, ";
			query += " 		   password, ";
			query += " 		   content, ";
			query += " 		   reg_date ";
			query += " from person ";
			query += " where no = ? ";

			// - 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);

			// - 실행
			rs = pstmt.executeQuery();

			// 4.결과처리
			//리스트로 만들기
						
			while (rs.next()) {
				/*
				personVo.setNo(rs.getInt("no"));
				personVo.setName(rs.getString("name"));
				personVo.setPassword(rs.getString("password"));
				personVo.setContent(rs.getString("content"));
				personVo.setRegDate(rs.getString("reg_date"));
				
				personVo = new PersonVo( rs.getInt("no"), rs.getString("name"), rs.getString("password"), rs.getString("content"), rs.getString("reg_date") );
								
				count++;
				
			}
			
			System.out.println(count + "건 조회 되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();
		
		*/

		return null;//return personVo;
	}
	
	
	
	
	//사람 정보 저장
	public int insertPerson(PersonVo personVo) {
		
		System.out.println("dao.insertPerson()");
		
		int count = sqlSession.insert("guestbook.insert", personVo);
		
		
		/*
		int count = -1;
		
		System.out.println("사람정보저장");
		System.out.println("insertPerson()" + personVo);
		
		this.getConnection();
		
		
		try {
			// 3. SQL문 준비 / 바인딩 / 실행
			
			// - sql문 준비
			String query = "";
			query += " insert into person ";
			query += " values ( null, ?, ?, ?, now() ) "; 
			
			// - 바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, personVo.getName());
			pstmt.setString(2, personVo.getPassword());
			pstmt.setString(3, personVo.getContent());
			
			// - 실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println( count + "건 등록 되었습니다.");

		
		}  catch (SQLException e) {
			System.out.println("error:" + e);
		}
		
		
		this.close();
		System.out.println(count);
		*/
		
		return count;
		
	}
	
	
	
	//리스트 가져오기
	public List<PersonVo> getPersonList() {
		
		System.out.println("dao.getPersonList()");
		
		List<PersonVo> personList = sqlSession.selectList("guestbook.selectList");
		
		System.out.println("===============");
		System.out.println(personList);
		System.out.println("===============");
		

		
		return personList;
		
	}
	
	
	
	

}
