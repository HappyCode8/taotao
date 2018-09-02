package com.wyj.freemarker;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreemarkerTest {

	@Test
    public void testFreemarkerFirst() throws Exception {
        // 创建一个Configuration对象
        Configuration configuration = new Configuration(Configuration.getVersion());
        // 设置模板所在的目录
        configuration.setDirectoryForTemplateLoading(new File("D:/project/JAVA/taotao-item-web/src/main/resources/ftl"));
        // 设置模板字符集
        configuration.setDefaultEncoding("UTF-8");
        // 加载模板文件
        Template template = configuration.getTemplate("first.htm");
        
        // 创建一个数据集
        Map data = new HashMap();
        data.put("title", "Hello Freemarker!!!");
        // 设置模板输出的目录及输出的文件名
        FileWriter writer = new FileWriter(new File("D:/temp/first.html"));
        // 生成文件
        template.process(data, writer);
        // 关闭流
        writer.close();
    }

}
