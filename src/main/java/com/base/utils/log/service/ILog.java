package com.base.utils.log.service;

import com.base.utils.log.AopLog;
import com.base.utils.log.AopLogPo;

public interface ILog {
    /**
     * 保存日志
     * @param po
     */
    void save(AopLogPo po);


}
