package com.atguigu.crud.test;

import com.atguigu.crud.bean.Department;
import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.atguigu.crud.dao.DepartmentMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * 测试dao层的工作
 * 推荐使用Spring的项目就可以使用spring的单元测试，可以自动注入我们的组件
 * 1.导入SpringTest模块
 * 2.使用@ContextConfiguration指定配置文件的位置
 * 3.直接autowired要使用的组件即可
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})


public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSession sqlSession;

    /**
     * 测试DepartmentMapper
     */

    @Test
    public void testCRUD(){
      /*  //1. 创建SpringIOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml")
        //2. 从容器中获取mapper
        DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);*/
        System.out.println(departmentMapper);

        //1.插入几个部门
        departmentMapper.insertSelective(new Department(null,"开发部"));
        departmentMapper.insertSelective(new Department(null,"测试部"));


        //2.生成员工数据
        //employeeMapper.insertSelective(new Employee(null,"jerry","M","jerry@126.com",1));

        //3.批量插入员工，批量，可以执行批量操作的sql session
        EmployeeMapper mapper=sqlSession.getMapper(EmployeeMapper.class);
        for(int i=1;i<1001;i++){
            String uuid=UUID.randomUUID().toString().substring(0,5)+i;
            mapper.insertSelective(new Employee(i,uuid,"M",uuid+"@126.com",1));
        }
        System.out.println("批量处理结束");
    }

}
