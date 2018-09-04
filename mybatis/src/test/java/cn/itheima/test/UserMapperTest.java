package cn.itheima.test;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.mapper.UserMapper;
import com.itheima.po.User;

public class UserMapperTest {
	
	
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		sqlSessionFactory = builder.build(inputStream);
	}
	@Test
	public void queryUserByIdTest() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		System.out.println(userMapper.getClass());
		User user = userMapper.queryUserById(26);
		System.out.println(user);
		sqlSession.close();
	}
	
	@Test
	public void insertUserTest() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUserName("大胖");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("吉山幼儿园");
		userMapper.inserUser(user);
		sqlSession.close();
	}
	
}
