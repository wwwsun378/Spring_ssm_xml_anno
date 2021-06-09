package com.yg.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yg.dao.UserMapper;
import com.yg.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yg
 * @Date 2021/6/8 9:26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:sqlMapConfig.xml")
public class MybatisTest {


    @Test
    //删除操作
    public void test8() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数：namespace+id

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //设置分页相关参数   当前页+每页显示的条数
        PageHelper.startPage(1,2);
        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }

//        PageInfo<User> userPageInfo = new PageInfo<>(userList);

        //获得与分页相关参数
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        System.out.println("当前页："+pageInfo.getPageNum());
        System.out.println("每页显示条数："+pageInfo.getPageSize());
        System.out.println("总条数："+pageInfo.getTotal());
        System.out.println("总页数："+pageInfo.getPages());
        System.out.println("上一页："+pageInfo.getPrePage());
        System.out.println("下一页："+pageInfo.getNextPage());
        System.out.println("是否是第一个："+pageInfo.isIsFirstPage());
        System.out.println("是否是最后一个："+pageInfo.isIsLastPage());
        System.out.println("getFirstPage："+pageInfo.getFirstPage());
        System.out.println("getEndRow："+pageInfo.getEndRow());

        System.out.println(pageInfo);
        //释放资源
        sqlSession.close();
    }

    @Test
    //删除操作
    public void test7() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数：namespace+id

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userfind = new User();
//        userfind.setId(3);
        userfind.setPassword("123456");
        userfind.setUsername("ygygyg");
        userfind.setBirthday(new Date());
        mapper.save(userfind);

        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    @Test
    //删除操作
    public void test6() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数：namespace+id

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> all = mapper.findAll();
        System.out.println("findAll = " + all);

        User user = mapper.findById(2);
        System.out.println("findById = " + user);

        User userfind = new User();
        userfind.setId(3);
        userfind.setPassword("34234");
        userfind.setUsername("xxx");
        System.out.println("findByCondition = " + mapper.findByCondition(userfind));

        List list = new ArrayList();
        list.add(4);
        list.add(2);
        System.out.println("findByUserList = " + mapper.findByUserList(list));


        //释放资源
        sqlSession.close();
    }


    @Test
    //删除操作
    public void test4() throws IOException {

        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数：namespace+id
        sqlSession.delete("userMapper.delete", 1);

        //mybatis执行更新操作  提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    @Test
    //修改操作
    public void test3() throws IOException {

        //模拟user对象
        User user = new User();
        user.setId(1);
        user.setUsername("lucy");
        user.setPassword("123");

        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数：namespace+id
        sqlSession.update("userMapper.update", user);

        //mybatis执行更新操作  提交事务
        sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    @Test
    //插入操作
    public void test2() throws IOException {

        //模拟user对象
        User user = new User();
        user.setUsername("rrerwer");
        user.setPassword("3fdsfaf");

        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //执行操作  参数：namespace+id
        sqlSession.insert("userMapper.save", user);

        //mybatis执行更新操作  提交事务
        //sqlSession.commit();

        //释放资源
        sqlSession.close();
    }

    @Test
    //查询操作
    public void test1() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数：namespace+id
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        //打印数据
        System.out.println(userList);
        //释放资源
        sqlSession.close();
    }

    @Test
    //查询一个对象
    public void test5() throws IOException {
        //获得核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获得session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获得session回话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作  参数：namespace+id
        User user = sqlSession.selectOne("userMapper.findById", 2);
        //打印数据
        System.out.println(user);
        //释放资源
        sqlSession.close();
    }

}
