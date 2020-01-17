package ${package.Service};

import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import com.mango.require.model.common.PageRequest;
import com.mango.require.model.common.PageResponse;

/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

     PageResponse<${entity}> ${entity?uncap_first}List(${entity} ${entity?uncap_first}, PageRequest pageRequest);
}
</#if>
