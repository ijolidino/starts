package com.blackmagic.ssm.service;

import com.blackmagic.ssm.domain.SysLog;

import java.util.List;

public interface ISysLogService {
    void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll(Integer pageNum, Integer pageSize) throws Exception;
}
