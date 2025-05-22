package com.mybatis;

import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: LQL
 * @Date: 2025/01/03
 * @Description: mybatis初始化过程分为两种
 * xml 和 API
 */
public class initFunc {

    /**
     * 通过解析固定的xml文件获取初始化mybatis，解析xml文件中的configuration根node，通过判断子节点有无来获取对应node数据
     * 然后配置mybatis，构建链接，创建sqlSession，最终执行CRUD操作
     * @throws IOException
     */
    public void xmlInitMybatis() throws IOException {
        //mybatis初始化   解析xml文件初始化mybatis的方式
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();//创建sqlSession

        //执行sql，获取执行结果list
        List<String> resultList = sqlSession.selectList("com.anshare.project.problemResolution.mapper.ProblemProcessMapper.selectISRealProblemIdsByProblemId");
    }

    /**
     * 处理方式同上，只不过将SqlSessionFactoryBuilder().build(inputStream);内部解析xml文件方式
     * 直接在代码层面调用获取配置信息
     * @throws IOException
     */
    public void apiInitMybatis() throws IOException{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 手动创建XMLConfigBuilder，并解析创建Configuration对象
        XMLConfigBuilder parser = new XMLConfigBuilder(inputStream, null,null); // 看这里
        Configuration configuration = parser.parse();
        // 使用Configuration对象创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        // 使用MyBatis
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List list = sqlSession.selectList("com.foo.bean.BlogMapper.queryAllBlogInfo");
    }


}
