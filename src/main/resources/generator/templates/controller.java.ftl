package ${package.Controller};

<#if swagger2>
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
</#if>
<#if entityLombokModel>
import lombok.extern.slf4j.Slf4j;
</#if>
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import org.springframework.security.access.prepost.PreAuthorize;
import ${package.Service}.${table.serviceName};
import ${package.Entity}.${entity};
import ${package.Entity}.common.PageRequest;
import ${package.Entity}.common.Result;
import ${package.Entity}.common.ResultGenerator;
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
     @PreAuthorize("hasAuthority('${entity?uncap_first}:list')")
     @GetMapping
     public Result list(${entity} ${entity?uncap_first}, PageRequest pageRequest) {
        return ResultGenerator.genSuccessResult(${table.serviceName?replace("I","")?uncap_first}.${entity?uncap_first}List(${entity?uncap_first}, pageRequest));
     }

     /**
      * ${table.comment!}新增
      * @param ${entity?uncap_first} ${table.comment!}
      * @return Result
      */
     @ApiOperation(value = "${table.comment!}新增", notes = "${table.comment!}新增")
     @PreAuthorize("hasAuthority('${entity?uncap_first}:add')")
     @PostMapping
     public Result add(${entity} ${entity?uncap_first}) {
        return ResultGenerator.genSuccessResult(${table.serviceName?replace("I","")?uncap_first}.save(${entity?uncap_first}));
     }

     /**
      * ${table.comment!}删除
      * @param id ${table.comment!}主键
      * @return Result
      */
     @ApiOperation(value = "${table.comment!}删除", notes = "${table.comment!}删除")
     @PreAuthorize("hasAuthority('${entity?uncap_first}:delete')")
     @DeleteMapping("/{id: \\d+}")
     public Result delete(@PathVariable Integer id) {
        return ResultGenerator.genSuccessResult(${table.serviceName?replace("I","")?uncap_first}.removeById(id));
     }

     /**
      * ${table.comment!}修改
      * @param ${entity?uncap_first} ${table.comment!}
      * @return Result
      */
     @ApiOperation(value = "${table.comment!}修改", notes = "${table.comment!}修改")
     @PreAuthorize("hasAuthority('${entity?uncap_first}:update')")
     @PutMapping
     public Result update(${entity} ${entity?uncap_first}) {
        return ResultGenerator.genSuccessResult(${table.serviceName?replace("I","")?uncap_first}.updateById(${entity?uncap_first}));
     }

     /**
      * ${table.comment!}详情
      * @param id ${table.comment!}主键
      * @return Result
      */
     @ApiOperation(value = "${table.comment!}详情", notes = "${table.comment!}详情")
     @PreAuthorize("hasAuthority('${entity?uncap_first}:detail')")
     @GetMapping("/{id: \\d+}")
     public Result detail(@PathVariable Integer id) {
        return ResultGenerator.genSuccessResult(${table.serviceName?replace("I","")?uncap_first}.getById(id));
     }
}
</#if>
