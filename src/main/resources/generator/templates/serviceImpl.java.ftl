package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import com.mango.require.model.common.PageRequest;
import com.mango.require.model.common.PageResponse;
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
@Transactional
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

     @Override
     public PageResponse<${entity}> ${entity?uncap_first}List(${entity} ${entity?uncap_first}, PageRequest pageRequest) {
           QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>();
           //TODO 设置查询条件

           //返回值
           PageResponse<${entity}> response = PageResponse.<${entity}>builder().build();
           //排序
           if(StringUtils.isNotBlank(pageRequest.getSortColumn())) {
                queryWrapper.orderBy(true, pageRequest.getSortAscend(), pageRequest.getSortColumn());
           }
           //分页
           if(pageRequest.getPaging()) {
                Page<${entity}> page = new Page<>(pageRequest.getPageIndex(), pageRequest.getPageSize());
                IPage<${entity}> userPage = this.baseMapper.selectPage(page, queryWrapper);
                response.setList(userPage.getRecords());
                response.setTotal(userPage.getTotal());
           } else {
                List<${entity}> userList = this.baseMapper.selectList(queryWrapper);
                response.setList(userList);
                response.setTotal((long) userList.size());
           }
           return response;
     }
 }
</#if>
