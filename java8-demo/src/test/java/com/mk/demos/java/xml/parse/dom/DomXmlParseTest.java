package com.mk.demos.java.xml.parse.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * DOM方式解析XML
 *
 * @author WangChen
 * Created on 2021/1/9 17:59
 * @since 1.0
 */
public class DomXmlParseTest {

    DocumentBuilderFactory factory;
    DocumentBuilder builder;
    @Before
    public void before() throws ParserConfigurationException {
        //创建解析器工厂实例，并生成解析器
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
    }
    @Test
    public void test() throws IOException, SAXException {

        //创建需要解析的文档对象
        File f = new File("src/main/resources/META-INF/test-sax.xml");
        //解析文档，并返回一个Document对象，此时xml文档已加载到内存中
        //好吧，让解析来得更猛烈些吧，其余的事就是获取数据了
        Document doc = builder.parse(f);

        //获取文档根元素
        //你问我为什么这么做?因为文档对象本身就是树形结构，这里就是树根
        //当然，你也可以直接找到元素集合，省略此步骤
        Element root = doc.getDocumentElement();

        //上面找到了根节点，这里开始获取根节点下的元素集合
        NodeList list = root.getElementsByTagName("book");

        for (int i = 0; i < list.getLength(); i++) {
            //通过item()方法找到集合中的节点，并向下转型为Element对象
            Element n = (Element) list.item(i);
            //获取对象中的属性map，用for循环提取并打印
            NamedNodeMap node = n.getAttributes();
            for (int x = 0; x < node.getLength(); x++) {
                Node nn = node.item(x);
                System.out.println(nn.getNodeName() + ": " + nn.getNodeValue());
            }

            //打印元素内容，代码很纠结，差不多是个固定格式
            System.out.println("title: " +n.getElementsByTagName("title").item(0).getFirstChild().getNodeValue());
            System.out.println("author: " + n.getElementsByTagName("author").item(0).getFirstChild().getNodeValue());
            System.out.println();
        }
    }
}
