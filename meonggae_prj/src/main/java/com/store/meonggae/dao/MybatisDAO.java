package com.store.meonggae.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisDAO {
	
	private static MybatisDAO mbDAO;
	private static SqlSessionFactory ssf;
	
	private MybatisDAO() {
		org.apache.ibatis.logging.LogFactory.useLog4J2Logging();
	}//MybiatisDAO
	
	public static MybatisDAO getInstance() {
		if(mbDAO == null) {
			mbDAO = new MybatisDAO();
		}//end if
		
		return mbDAO;
	}//getInstance
	
	static {
		if(ssf == null) {
			try {
				//1.설정파일 연결
				Reader reader;
				reader = Resources.getResourceAsReader("com/store/meonggae/dao/mybatis-config.xml");
				//2.MyBatis Framework 생성
				ssf = new SqlSessionFactoryBuilder().build(reader);
				//3.스트림 닫기
				if(reader != null) {
					reader.close();
				}//end if
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public SqlSession getMyBatisHandler(boolean autoCommit) {
		if (ssf == null) {
	        throw new NullPointerException("SqlSessionFactory is null");
	    }
		return ssf.openSession(autoCommit);
	}//getMyBatisHandler
	
	public void CloseHandler(SqlSession ss) {
		if(ss != null) {
			ss.close();
		}
	}
}
