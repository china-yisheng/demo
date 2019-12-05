package com.base.utils.log.mapper;

import com.base.utils.log.AopLogPo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper {

    @Insert("")
    void insert(AopLogPo po);
}
