package cn.itheima.test;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.po.User;

public class MybatisTest {
	
	@Test
	public void queryUserByIdTest() throws IOException {
		//1.加载主配置文件sqlMapConfig.xml
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		
		// 2.读取配置文件内容
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
		// 3.使用sqlSessionFactory对象，创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 4.使用sqlSession调用方法执行
		Object user = sqlSession.selectOne("test.queryUserByID", 16);
		System.out.println(user);
		//5.释放资源
		sqlSession.close();
	}
	
	@Test
	public void queryUserByNameTest() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> userList = sqlSession.selectList("queryUserByName","小");
		for (User user : userList) {
			System.out.println(user);
		}
		sqlSession.close();
	}
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		sqlSessionFactory = builder.build(inputStream);
	}
	
	
	
	@Test
	public void inserUserTest() throws IOException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = new User();
		//user.setId(8);
		user.setUserName("lisi");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("吉山");
		System.out.println("执行前："+user);
		sqlSession.insert("test.inserUser",user);
		System.out.println("执行后："+user);
		sqlSession.commit();
	}
	
	@Test
	public void updateUserById() throws IOException {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		User user = new User();
		user.setId(8);
		user.setUserName("abccc");
		user.setSex("2");
		user.setBirthday(new Date());
		user.setAddress("天河");
		sqlSession.update("test.updateUserById",user);
		//sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void deleteUserById() {
		SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
		sqlSession.delete("test.deleteUserById",40);
		sqlSession.close();
	}
}
