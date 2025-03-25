package com.beaver.feb062.board;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.beaver.db.manager.BeaverDBManager;
import com.beaver.feb062.member.Member;

public class BoardDAO {

	private int allBoardMsgCount;

	private static final BoardDAO BDAO = new BoardDAO();

	private BoardDAO() {
		// TODO Auto-generated constructor stub
	}

	public static BoardDAO getBdao() {
		return BDAO;
	}

	public void clearSearch(HttpServletRequest request) {
		request.getSession().setAttribute("search", null);			// 받아온 요청으로부터 세션에 저장된 "search" 값을 null로 설정
	}

	public void countAllBoardMsg() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = BeaverDBManager.connect("beaverPool");
			String sql = "select count(*) from board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allBoardMsgCount = rs.getInt("count(*)");
			System.out.println(allBoardMsgCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BeaverDBManager.close(con, pstmt, rs);
	}
	// 키워드로 검색
	private int countSearchMsg(String search) { // Controller에서 쓸 거 아니니 private로 잠그기
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = BeaverDBManager.connect("beaverPool");							// 서버 연결
			String sql = "select count(*) " + "from board, feb06_SNS "				// 검색어를 찾는 sql문
					+ "where b_writer = m_id and b_text like '%'||?||'%' ";
			pstmt = con.prepareStatement(sql);										// sql 실행
			pstmt.setString(1, search);												// sql을 실행하는데 검색어를 넣어서 실행
			rs = pstmt.executeQuery();												// sql 셀렉문 실행값 rs 저장
			rs.next();																// 검색어에 해당하는 sql 전체 조회
			return rs.getInt("count(*)");											// 검색어에 해당하는 갯수 반환
		} catch (Exception e) {
			e.printStackTrace();
			return 0; // 해당하는 내용이 없으면 0 리턴
		} finally {
			BeaverDBManager.close(con, pstmt, rs);
		}
	}

	public void delete(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = BeaverDBManager.connect("beaverPool");
			
			int b_no = Integer.parseInt(request.getParameter("b_no"));
			
			String sql = "delete from board where b_no= ? ";
		
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b_no);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "삭제 성공");
				allBoardMsgCount--;
			} else {
				request.setAttribute("r", "삭제 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "삭제 실패");
		}
		BeaverDBManager.close(con, pstmt, null);
	}

	public void getBoardMsg(int pageNo, HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = BeaverDBManager.connect("beaverPool");

			int boardCount = allBoardMsgCount; // 일단 전체 갯수(31)
			String search = (String) request.getSession().getAttribute("search"); // 검색어
			if (search == null) {						 				// 검색어가 없다면
				search = "";											// 전체조회?
			} else { 													// 검색어가 있는 경우 = 검색 O
				boardCount = countSearchMsg(search);					// 
				if (boardCount == 0) {
					request.setAttribute("no", "검색 결과가 없습니다.");
				}
			}
			request.setAttribute("boardCount", boardCount);

			// pageNo = 5;
			int boardPerPage = 3; // 페이지당 게시물 3개
			int pageCount = (int) Math.ceil(boardCount / (double) boardPerPage); // 게시물 수에 따라서 나뉘는 페이지 수 (소수점 올림) 
			request.setAttribute("pageCount", pageCount);
			request.setAttribute("pageNo", pageNo);

			int start = boardPerPage * (pageNo - 1) + 1; // 한 페이지에 담을 게시물 첫번째 번호 계산 (1p : 1, 2p: 6, ...)
			int end = (pageNo == pageCount) ? boardCount : (start + boardPerPage - 1); // 한 페이지에 담을 끝 게시물 번호 계산 (1p: 5, 2p: 10, ...) 
																					   // 한 페이지에서 5개 채우면 다음 페이지로 넘어가게

			String sql = "select * " 
					+ "from ( " 
					+ "	select rownum as rn, b_no, b_writer, b_when, b_text, m_photo "
					+ "	from ( " 
					+ "		select * " 
					+ "		from board, feb06_SNS "
					+ "		where b_writer = m_id and b_text like '%'||?||'%' " 
					+ "		order by b_when desc" 
					+ "	)"
					+ ")" 
					+ "where rn >= ? and rn <= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);

			rs = pstmt.executeQuery();

			ArrayList<Board> boards = new ArrayList<Board>();
			Board board = null;
			while (rs.next()) {
				// boards.add(rs.getInt("b_no"), rs.getString("b_writer"), rs.getDate("b_when"),
				// rs.getString("b_text"), rs.getString("m_photo"));
				board = new Board();
				board.setB_no(rs.getInt("b_no"));
				board.setB_writer(rs.getString("b_writer"));
				board.setB_when(rs.getDate("b_when"));
				board.setB_text(rs.getString("b_text"));
				board.setM_photo(URLDecoder.decode(rs.getString("m_photo"), "UTF-8"));
				boards.add(board);
			}
			request.setAttribute("boards", boards);
		} catch (Exception e) {
			e.printStackTrace();
		}
		BeaverDBManager.close(con, pstmt, rs);
	}

	public void searchBoardMsg(HttpServletRequest request) {
		// 새로운 요청을 했을 때(페이지 전환)에도 검색어는 살아있어야
		// 클라이언트 개인의 작업
		String search = request.getParameter("search");
		request.getSession().setAttribute("search", search);
		// 검색(요청) -> 25개 -> 1페이지 10개를 보여줄것
		// 검색한것의 2페이지로(요청)
		// 검색한것의 3페이지로(요청)
	}
	
	public boolean update(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = BeaverDBManager.connect("beaverPool");
			request.setCharacterEncoding("UTF-8");
			
			int b_no = Integer.parseInt(request.getParameter("b_no"));
//			System.out.println(request.getParameter("b_text"));
//			System.out.println(URLDecoder.decode(request.getParameter("b_text"), "UTF-8"));
//			String b_text = URLDecoder.decode(request.getParameter("b_text"), "UTF-8").replace("\r\n", "<br>");
			String b_text = URLDecoder.decode(request.getParameter("b_text"), "UTF-8");

			String sql = "update board set b_text=?, b_when=sysdate where b_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, b_text);
			pstmt.setInt(2, b_no);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "수정 성공");
				return true;
			} else {
				request.setAttribute("r", "수정 실패");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "수정 실패");
			return false;
		} finally {
			BeaverDBManager.close(con, pstmt, null);
		}
	}
	
	public void write(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			request.getSession().setAttribute("search", null); // 새로 작성할때 검색내용 초기화할 것!
			con = BeaverDBManager.connect("beaverPool");
			// insert에 쓸 값 다 책임
			// 글 번호? - seq
			// 글쓴이 아이디?
			Member m = (Member) request.getSession().getAttribute("loginMember");
			String b_writer = m.getM_id();
			// 글쓴 날짜? - sysdate
			// 글 내용?
			String b_text = request.getParameter("b_text").replace("\r\n", "<br>");

			// 새로고침 : 방금했던 그 요청 그대로 다시(파라미터 값 그대로)

			// 1트째) null
			// 2트째 - 다시 글 씀) 11:01:02:123
			// 3트째 - 새로고침) 11:04:12:678
			String formerToken = (String) request.getSession().getAttribute("formerToken");
			System.out.println(formerToken);
			// 1트째) 11:01:02:123
			// 2트째 - 다시 글 씀) 11:04:12:678
			// 3트째 - 새로고침) 11:04:12:678
			String token = request.getParameter("token");
			System.out.println(token);

			// 1트째) formerToken == null => 최종 insert까지 => formerToken이 11:01:02:123
			// 2트째 - 다시 글 씀) formerToken과 token이 다름 => 최종 insert까지 => formerToken이
			// 11:04:12:678	
			// 3트째 - 새로고침) if문 조건에 맞지 않음 => 작업x
			if (formerToken == null || !token.equals(formerToken)) {
				String sql = "insert into board values(board_seq.nextval, ?, sysdate, ?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, b_writer);
				pstmt.setString(2, b_text);

				if (pstmt.executeUpdate() == 1) {
					request.setAttribute("r", "글쓰기 성공");
					request.getSession().setAttribute("formerToken", token);
					allBoardMsgCount++;
				}
			} else {
				request.setAttribute("r", "새로고침");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "글쓰기 실패");
		}
		BeaverDBManager.close(con, pstmt, null);
	}

}
