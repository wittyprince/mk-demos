package com.mk.demos.java;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.mk.demos.java.sax.SaxHandler;

/**
 * sax handler 测试类
 *
 * @author WangChen
 * Created on 2021/1/9 16:31
 * @since 1.0
 */
public class SaxHandlerTest {

    @Test
    public void test() throws ParserConfigurationException, SAXException, IOException {
        // 1.实例化SAXParserFactory对象
        SAXParserFactory factory = SAXParserFactory.newInstance();
        // 2.创建解析器
        SAXParser parser = factory.newSAXParser();
        // 3.获取需要解析的文档，生成解析器,最后解析文档
        File f = new File("src/main/resources/META-INF/test-sax.xml");
        SaxHandler dh = new SaxHandler();
        parser.parse(f, dh);
    }
}
