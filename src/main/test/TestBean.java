import com.xunmaw.supermarket.pojo.Provider;
import com.xunmaw.supermarket.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 功能说明
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestBean {
    @Autowired
    User user;

    @Autowired
    Provider provider;
    @Test
    public void testAutowired(){
        System.out.println(provider);
    }

    @Test
    public void testGetBean(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        System.out.println(applicationContext);
        System.out.println(applicationContext.getBean("user"));
        System.out.println(applicationContext.getBean("sqlSession"));
    }
}
