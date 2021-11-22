package springboot.transaction.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.transaction.mapper.PeopleMapper;
import springboot.transaction.model.People;
import springboot.transaction.service.DepartmentService;
import springboot.transaction.service.PeopleService;


@Service(value = "peopleService")
@RequiredArgsConstructor
@Slf4j
public class PeopleServiceImpl extends ServiceImpl<PeopleMapper, People> implements PeopleService {

    private final DepartmentService departmentService;

    @Override
    @Transactional(rollbackFor = NullPointerException.class)
    public void insert() {
        Long departmentId = 1L;
        try {
            departmentId = departmentService.insert();
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        People people = People.builder()
                .name("测试姓名")
                .departmentId(departmentId)
                .build();
        this.save(people);
//        int i = 1 / 0;
    }

    @Override
    public void insertInner() {
        insert();
    }

    private void insertPrivate() {
        insert();
    }
}
