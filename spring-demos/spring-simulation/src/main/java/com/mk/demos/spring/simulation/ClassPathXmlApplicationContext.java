package com.mk.demos.spring.simulation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.mk.demos.spring.simulation.factory.BeanFactory;

/**
 * 模拟ClassPathXmlApplicationContext
 *
 * @author WangChen
 * Created on 2021/1/9 18:50
 * @since 1.0
 */
public class ClassPathXmlApplicationContext implements BeanFactory {

    private Map<String, Object> beanMap = new ConcurrentHashMap<>();
    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    private String location;

    public ClassPathXmlApplicationContext(String location) throws ParserConfigurationException, IOException, SAXException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        this.location = location;
        this.factory = DocumentBuilderFactory.newInstance();
        this.builder = factory.newDocumentBuilder();

        //创建需要解析的文档对象
        File f = new File(location);
        //解析文档，并返回一个Document对象，此时xml文档已加载到内存中
        Document doc = builder.parse(f);
        //获取文档根元素
        Element root = doc.getDocumentElement();
        //上面找到了根节点，这里开始获取根节点下的元素集合
        NodeList beans = root.getElementsByTagName("bean");
        for (int i = 0; i < beans.getLength(); i++) {
            //通过item()方法找到集合中的节点，并向下转型为Element对象
            Element element = (Element) beans.item(i);
            NamedNodeMap namedNodeMap = element.getAttributes();
            String id = "";
            String clazz = "";
            for (int k=0; k<namedNodeMap.getLength(); k++){
                Node node = namedNodeMap.item(k);
                if ("id".equals(node.getNodeName())){
                    id = node.getNodeValue();
//                    break;
                }
                if ("class".equals(node.getNodeName())){
                    clazz = node.getNodeValue();
//                    break;
                }
            }
            Object o = Class.forName(clazz).newInstance();
            beanMap.put(id, o);

            NodeList properties = element.getElementsByTagName("property");
            for (int j=0; j<properties.getLength(); j++){
                Node property = properties.item(j);
                NamedNodeMap propertyMap = property.getAttributes();
                String name = "";
                String ref = "";
                for (int k=0; k<propertyMap.getLength(); k++){
                    Node node = propertyMap.item(k);
                    if ("name".equals(node.getNodeName())){
                        name = node.getNodeValue();
//                    break;
                    }
                    if ("ref".equals(node.getNodeName())){
                        ref = node.getNodeValue();
//                    break;
                    }
                }

                Object beanObject = beanMap.get(ref);
                String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
                System.out.println("method name = " + methodName);

                Method m = o.getClass().getMethod(methodName, beanObject.getClass().getInterfaces()[0]);
                m.invoke(o, beanObject);
            }



            //获取对象中的属性map，用for循环提取并打印
//            NamedNodeMap namedNodeMap = element.getAttributes();
//            for (int x = 0; x < namedNodeMap.getLength(); x++) {
//                Node node = namedNodeMap.item(x);
//                String name = node.getNodeName();
//                String ref = node.getNodeValue();
//                Object beanObject = beanMap.get(ref);
//                String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
//                System.out.println("method name = " + methodName);
//
//                Method m = o.getClass().getMethod(methodName, beanObject.getClass().getInterfaces()[0]);
//                m.invoke(o, beanObject);
//            }

        }
    }

    @Override
    public Object getBean(String beanName) {
        return beanMap.get(beanName);
    }
}
