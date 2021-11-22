package springboot.transaction.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import springboot.transaction.model.People;

@Mapper
public interface PeopleMapper extends BaseMapper<People> {

}
