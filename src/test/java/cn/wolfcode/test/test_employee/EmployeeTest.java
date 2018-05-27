package cn.wolfcode.test.test_employee;

import cn.wolfcode.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void test(){
        System.out.println(employeeMapper);
    }

}
