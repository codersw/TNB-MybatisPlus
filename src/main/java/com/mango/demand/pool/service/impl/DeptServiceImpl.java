package com.mango.demand.pool.service.impl;

import com.mango.demand.pool.entity.pojo.Dept;
import com.mango.demand.pool.mapper.DeptMapper;
import com.mango.demand.pool.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author swen
 * @since 2020-01-20
 */
@Service
@Transactional
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

}
