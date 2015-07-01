package com.mybatis.exam6;

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

public class DynamicSQL {
	
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
	public void testDynamicSQL()
	{
		
		HashMap map = new HashMap();
		map.put("username", "小王");
		ArrayList list = (ArrayList)session.selectList("User.queryUserInfoV1",map);
		System.out.println(list);
	}
	
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	
	public void testDynamicSQLV1()
	{
		
		HashMap map = new HashMap();
		map.put("phone", "13535999538");
		ArrayList list = (ArrayList)session.selectList("User.queryUserInfoV1",map);
		System.out.println(list);
	}
	
	@Test
	@SuppressWarnings({ "rawtypes" })
	public void testDynamicSQLV2()
	{
		
		HashMap map = new HashMap();
		ArrayList list = (ArrayList)session.selectList("User.queryUserInfoV1",map);
		System.out.println(list);
	}
	
	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testDynamicSQLV3()
	{
		
		HashMap map = new HashMap();
		map.put("username", "小王");
		ArrayList list = (ArrayList)session.selectList("User.queryUserInfoV2",map);
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
