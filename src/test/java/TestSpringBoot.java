import com.SpringBootMain;
import com.dao.EmployeesMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.DataProperties;
import com.model.Employees;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootMain.class)
public class TestSpringBoot {

    @Autowired
    ApplicationContext ac;

    @Autowired
    EmployeesMapper employeesMapper;

    @Autowired(required=false)
    DataProperties dataProperties;

    @Test
    public void test1() {

        System.out.println("****test1");
        System.out.println(dataProperties);

    }

    @Test
    public void testemp() {
        PageHelper.startPage(1,5);
        List<Employees> list=employeesMapper.list();
        PageInfo<Employees> pageInfo = new PageInfo<>(list);
        for (Employees emp:pageInfo.getList()){
            System.out.println(emp);
        }
    }


}
