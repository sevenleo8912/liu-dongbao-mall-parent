package com.msb.msbdongbaogeverator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 马士兵教育:chaopengfei
 * @date 2020/12/23
 */
public class DongbaoGenerator {

    public static void main(String[] args) {
        // 构建一个代码生成对象
        AutoGenerator mpg = new AutoGenerator();

        // 1.全局配置
        GlobalConfig gc = new GlobalConfig();
        // 目录分隔符
        String separator = File.separator;
        // 项目路径
        String projectPath = System.getProperty("user.dir");
        // 父模块
        String parentModule = "liu-dongbao-service";
        // 子模块
        String subModule = "liu-dongbao-ums";
        // 设置代码生成路径
        gc.setOutputDir(projectPath + separator + parentModule + separator + subModule + File.separator + "/src/main/java");
        gc.setAuthor("刘晓坤");
        // 打开目录
        gc.setOpen(false);
        // 是否覆盖
        gc.setFileOverride(true);
        // 去Service的I前缀。
        gc.setServiceName("%sService");
        gc.setIdType(IdType.AUTO);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(false);

        mpg.setGlobalConfig(gc);

        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://192.168.134.130:3306/liu_dongbao?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root123");
        dsc.setDbType(DbType.MYSQL);

        mpg.setDataSource(dsc);

        // 包设置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.liu.dongbao.ums");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setController("controller");

        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //表名
        strategy.setInclude("ums_member");
        // 下划线转他驼峰
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 列 下划线转驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //lombok开启
        strategy.setEntityLombokModel(true);
        strategy.setLogicDeleteFieldName("deleted");

        // 自动填充
        TableFill gmtCreate = new TableFill("create_time", FieldFill.INSERT);
        TableFill gmtModify = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        List<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModify);

        strategy.setTableFillList(tableFills);

        //乐观锁
        strategy.setVersionFieldName("version");

        // restcontroller
        strategy.setRestControllerStyle(true);
        // localhost:xxx/hello_2
        strategy.setControllerMappingHyphenStyle(true);

        mpg.setStrategy(strategy);

        mpg.execute();
    }
}
