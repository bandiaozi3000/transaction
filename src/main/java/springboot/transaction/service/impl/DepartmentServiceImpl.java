package springboot.transaction.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import springboot.transaction.mapper.DepartmentMapper;
import springboot.transaction.mapper.PeopleMapper;
import springboot.transaction.model.Department;
import springboot.transaction.model.People;
import springboot.transaction.service.DepartmentService;
import springboot.transaction.service.PeopleService;


@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Override
//    @Transactional(rollbackFor = NullPointerException.class,propagation = Propagation.REQUIRES_NEW)
    @Transactional(rollbackFor = NullPointerException.class)
    public Long insert() {
        Department department = Department.builder()
                .departmentName("测试部门")
                .build();
        this.save(department);
        int i = 1/0;
        return department.getId();
    }
}
