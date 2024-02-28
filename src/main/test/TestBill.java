import com.xunmaw.supermarket.dao.BillDao;
import com.xunmaw.supermarket.pojo.Bill;
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
public class TestBill {
    @Autowired
    BillDao billDao;
    @Test
    public void TestgetBilllist(){
        Bill bill=new Bill();
        List<Bill> bill1= billDao.getBillList(bill);
        System.out.println(bill1.get(0).getProviderName());
    }
}
