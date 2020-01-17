package ${package.Controller};

<#if swagger2>
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
</#if>
<#if entityLombokModel>
import lombok.extern.slf4j.Slf4j;
</#if>
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import ${package.Service}.${table.serviceName};
import com.mango.require.model.${entity};
import com.mango.require.model.common.PageRequest;
import com.mango.require.model.common.Result;
import com.mango.require.model.common.ResultGenerator;
import javax.annotation.Resource;

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if swagger2>
@Api(value = "${table.comment!}接口", tags = {"${table.comment!}接口"})
</#if>
<#if entityLombokModel>
@Slf4j
</#if>
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

     @Resource
     private ${table.serviceName} ${table.serviceName?replace("I","")?uncap_first};

     /**
     * ${table.comment!}列表
     * @param ${entity?uncap_first} ${table.comment!}
     * @param pageRequest 分页参数
     * @return Result
     */
     @ApiOperation(value = "${table.comment!}列表", notes = "${table.comment!}列表")
     @GetMapping("/list")
     public Result list(${entity} ${entity?uncap_first}, PageRequest pageRequest) {
        return ResultGenerator.genSuccessResult(${table.serviceName?replace("I","")?uncap_first}.${entity?uncap_first}List(${entity?uncap_first}, pageRequest));
     }
}
</#if>
