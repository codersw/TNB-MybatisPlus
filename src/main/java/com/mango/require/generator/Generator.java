package com.mango.require.generator;

import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.*;

/**
 * 逆向工程
 * @author swen
 */
public class Generator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    private static String scanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入表名,多个英文逗号分割：");
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的表名,多个英文逗号分割！");
    }

    /**
     * 执行代码生成器
     * @param args
     */
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java/");
        gc.setAuthor("swen");
        gc.setSwagger2(true);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setFileOverride(true);
        gc.setOpen(false);
        gc.setDateType(DateType.ONLY_DATE);
        mpg.setGlobalConfig(gc);


        //数据源配置
        DataSourceConfig dc = new DataSourceConfig();
        dc.setUrl("jdbc:mysql://localhost:3306/require?characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false");
        dc.setDriverName("com.mysql.cj.jdbc.Driver");
        dc.setUsername("root");
        dc.setPassword("123456");
        mpg.setDataSource(dc);

        //包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.mango.require");
        pc.setEntity("model");
        //自定义生成路径信息
        Map<String, String> pathInfo = new HashMap<>(6);
        pathInfo.put(ConstVal.ENTITY_PATH, gc.getOutputDir() + pc.getParent().replace(".","/") + "/model/");
        pathInfo.put(ConstVal.MAPPER_PATH,  gc.getOutputDir() + pc.getParent().replace(".","/") + "/mapper/");
        pathInfo.put(ConstVal.XML_PATH, projectPath + "/src/main/resources/mapper/");
        pathInfo.put(ConstVal.SERVICE_PATH, gc.getOutputDir() + pc.getParent().replace(".","/") + "/service/");
        pathInfo.put(ConstVal.SERVICE_IMPL_PATH, gc.getOutputDir() + pc.getParent().replace(".","/") + "/service/impl/" );
        pathInfo.put(ConstVal.CONTROLLER_PATH, gc.getOutputDir() + pc.getParent().replace(".","/") +"/controller/" );
        pc.setPathInfo(pathInfo);
        mpg.setPackageInfo(pc);


        //自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        mpg.setCfg(cfg);

        //配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        templateConfig.setEntity("generator/templates/entity.java");
        templateConfig.setController("generator/templates/controller.java");
        templateConfig.setService("generator/templates/service.java");
        templateConfig.setServiceImpl("generator/templates/serviceImpl.java");
        templateConfig.setMapper("generator/templates/mapper.java");
        templateConfig.setXml("generator/templates/mapper.xml");
        mpg.setTemplate(templateConfig);

        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        //设置命名格式
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setInclude(scanner().split(","));
        //实体是否为lombok模型（默认 false）
        strategy.setEntityLombokModel(true);
        //生成 @RestController 控制器
        strategy.setRestControllerStyle(true);
        //驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        //数据库注释
        strategy.setEntityTableFieldAnnotationEnable(true);
        //逻辑删除字段
        strategy.setLogicDeleteFieldName("is_del");
        //表名前缀
        List<String> tables = Arrays.asList(strategy.getInclude());
        strategy.setTablePrefix(tables.stream().map(table -> table.split("_")[0]).toArray(String[]::new));
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}