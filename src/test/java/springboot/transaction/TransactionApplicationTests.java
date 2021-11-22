package springboot.transaction;

import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import springboot.transaction.service.PeopleService;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class TransactionApplicationTests {

    @Resource
    private PeopleService peopleService;


    @Test
    void insert() {
        peopleService.insert();
    }

    @Test
    void insertInner() {
        peopleService.insertInner();
    }


}
