package in.ashokit.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import in.ashokit.entity.CoTriggersEntity;

@Repository("coTrgDao")
public class CoTriggersDaoImpl implements CoTriggersDao {

	@Override
	public List<CoTriggersEntity> findPendTrgrsWithOraHash(String status, Integer tb, Integer ci) {

		List<CoTriggersEntity> entities = new ArrayList();

		String sql = "SELECT * FROM CO_TRIGGERS cot " + "WHERE " + "cot.TRG_STATUS=? " + "and ora_hash(cot.TRG_ID,?)=?";
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "IES_DEV", "IES_DEV");
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, status);
			pstmt.setInt(2, tb);
			pstmt.setInt(3, ci);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				CoTriggersEntity entity = new CoTriggersEntity();

				entity.setCaseNum(rs.getLong("CASE_NUM"));
				entity.setTriggerId(rs.getInt("TRG_ID"));
				entity.setTriggerStatus(rs.getString("TRG_STATUS"));

				entities.add(entity);
			}

		} catch (Exception e) {

		} finally {

			if (null != pstmt) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (null != con)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return entities;
	}

	@Override
	public List<CoTriggersEntity> findPendTrgrs(String status) {

		List<CoTriggersEntity> entities = new ArrayList();

		String sql = "SELECT * FROM CO_TRIGGERS cot WHERE " + "cot.TRG_STATUS=? ";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "IES_DEV", "IES_DEV");
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, status);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				CoTriggersEntity entity = new CoTriggersEntity();

				entity.setCaseNum(rs.getLong("CASE_NUM"));
				entity.setTriggerId(rs.getInt("TRG_ID"));
				entity.setTriggerStatus(rs.getString("TRG_STATUS"));

				entities.add(entity);
			}

			pstmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return entities;
	}

}
