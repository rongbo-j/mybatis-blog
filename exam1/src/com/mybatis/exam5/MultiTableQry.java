package com.mybatis.exam5;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MultiTableQry {
	
	private Reader reader = null;
	private SqlSessionFactory sessionFactory  = null;
	private SqlSession session = null;
	@Before
	public void before()
	{
		try {
			reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
			//创建一个数据库会话
			 session = sessionFactory.openSession();  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testMultiTableQry()
	{
		
		HashMap map = new HashMap();
		map.put("username", "小王");
		ArrayList list = (ArrayList)session.selectList("User.queryAticleInfo",map);
		System.out.println(list);
	}
	
	@After
	public void after()
	{
		if(null != session)
		{
			session.close();
		}
	}
}
