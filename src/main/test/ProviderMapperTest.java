import com.xunmaw.supermarket.dao.ProviderDao;
import com.xunmaw.supermarket.pojo.Provider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 功能说明
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ProviderMapperTest {
    
    @Autowired
    ProviderDao providerDao;

    @Test
    public void TestGetAllProvider(){

        System.out.println(providerDao);
        List<Provider> list=providerDao.getAllProvider();
        for (Provider p:list) {
            System.out.println(p);
        }
    }
    @Test
    public void TestCountProvider(){
        int count=providerDao.countProvider();
        System.out.println(count);
    }
    @Test
    public void TestGetProviderById(){
        Provider provider=providerDao.getProviderById("2");
        System.out.println(provider);
    }
    @Test
    public void TestGetProviderAndBillListById() throws InterruptedException {
        Provider provider=providerDao.getProviderAndBillListById(7);
        System.out.println(provider);
    }
    @Test
    public void TestAdd(){

        //Provider provider=new Provider("beijindaxue","北京大学","可以","张北京","1515432555","北京市 海淀区","1215564456",1L,new Date());
        /// System.out.print(providerMapper.add(provider));
    }
    @Test
    public void TestModify(){
//        Provider provider=new Provider();
//        provider.setId(16);
//        provider.setProCode("binjinchubanshe");
//        provider.setProName("北京出版社");
//        provider.setProAddress("北京大学");
//        provider.setModifyDate(new Date());
//        provider.setModifyBy(1);
//        System.out.print(providerMapper.modify(provider));
    }
    @Test
    public void TestDelete(){
        System.out.print(providerDao.delete("17"));
    }

}
