package com.heima.utils.common;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilterTheXml {

    public static void main(String[] args) {
        filterTheXMLFIle("F:\\黑马程序员资料\\heima-leadnews\\heima-leadnews\\heima-leadnews-service\\heima-leadnews-admin\\src\\main\\resources\\mapper\\","com.heima.admin.mapper.");
    }
    public static void filterTheXMLFIle(String dirPath,String packagePrefix) {

        File dirFile = new File(dirPath);
        String[] nameList = dirFile.list();
        for (String fileName:nameList) {
            try {
                // 指定XML文件路径
                fileName=fileName.substring(0,fileName.indexOf("."));
                File xmlFile = new File(dirPath+fileName+".xml");
//            System.setProperty("javax.xml.parsers.DocumentBuilderFactory", "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
                // 通过DocumentBuilderFactory创建DocumentBuilder
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

                // 通过DocumentBuilder解析XML文件，获取Document对象
                Document doc = dBuilder.parse(xmlFile);

                // 可选：如果XML文件中包含DOCTYPE声明，可能需要禁用DTD验证
                // doc.getDocumentElement().normalize();

                // 获取包含所有元素的NodeList
                NodeList nodeList = doc.getElementsByTagName("mapper");

                // 假设我们要修改的属性是"yourAttributeName"
                String attributeName = "namespace";
                String newValue = packagePrefix + fileName;

                // 遍历NodeList，找到包含特定属性的元素并修改其属性值
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    System.out.println(node);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;

                        // 检查元素是否包含指定的属性
                        if (element.hasAttribute(attributeName)) {
                            // 修改属性值
                            element.setAttribute(attributeName, newValue);
                            System.out.println("Attribute value updated successfully.");
                        }
                    }
                }
                saveDocumentToFile(doc,xmlFile);
                // 保存修改后的Document到文件
                // 可选：使用TransformerFactory将Document写回XML文件
                // ...
                scan(xmlFile);
            } catch (ParserConfigurationException | SAXException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void saveDocumentToFile(Document document, File file) {
        try {
            // 使用TransformerFactory创建Transformer
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // 将Document转换为DOMSource
            DOMSource source = new DOMSource(document);

            // 创建一个StreamResult对象，指定要保存的文件
            StreamResult result = new StreamResult(new FileOutputStream(file));

            // 将DOMSource写入StreamResult，保存到文件
            transformer.transform(source, result);

            System.out.println("File saved successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void scan(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        List<String> inputLines = new  ArrayList<String>(10);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            inputLines.add(line);
        }

        String firstLine = inputLines.get(0);
        System.out.println(firstLine.indexOf(">"));
        Integer index = firstLine.indexOf(">");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
        bufferedWriter.write(firstLine.substring(0,index + 1));
        bufferedWriter.newLine();
        bufferedWriter.write("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">");
        bufferedWriter.newLine();
        bufferedWriter.write(firstLine.substring(index + 1,firstLine.length()));
        bufferedWriter.newLine();
        bufferedWriter.write("</mapper>");
        bufferedWriter.close();
        bufferedReader.close();
    }
}
