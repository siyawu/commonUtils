package com.wq.common.XMlTools.JAXBContextDemo;

import com.wq.common.FileTools.FileUtils;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * 使用JAXBContext实现Java和XML 之间的互转
 * Created by wuqiang on 2018/4/11
 */
public class JaxbComtextTool
{
    private static String writeStrng(Object ob) throws Exception
    {
        JAXBContext e = JAXBContext.newInstance((new Class[]{ob.getClass()}));
        Marshaller mar = e.createMarshaller();
        mar.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
        mar.setProperty("jaxb.encoding", "UTF-8");
        StringWriter sw = new StringWriter();
        mar.marshal(ob, sw);
        return sw.toString();
    }

    private static SAXParserFactory getSAXParserFactory()
    {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //        factory.setFeature("http://xml.org/sax/features/")
        return factory;
    }

    private static SAXSource getSaxSource(InputSource in) throws Exception
    {
        SAXParserFactory factory = getSAXParserFactory();
        factory.setNamespaceAware(true);
        SAXParser saxparser = factory.newSAXParser();
        XMLReader xmlread = saxparser.getXMLReader();
        xmlread.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        SAXSource saxSource = new SAXSource(xmlread, in);
        return saxSource;
    }

    private static <T> T readConfig(Class obj, InputStream insp) throws Exception
    {
        JAXBContext e = JAXBContext.newInstance(new Class[]{obj});
        Unmarshaller u = e.createUnmarshaller();
        InputSource insour = new InputSource(insp);
        SAXSource sax = getSaxSource(insour);
        return (T) u.unmarshal(sax);
    }

    /** 序列化参数到XML文件
     * @param context
     * @param filePath
     * @param <T>
     * @return
     */
    public static <T> boolean serializeParmToXml(T context, String filePath)
    {
        DataOutputStream outputStream = null;
        try
        {
            String cstr = writeStrng(context);
            if (cstr == null || cstr.length() == 0)
            {
                return false;
            }
            //            new File(filePath).getParentFile().mkdir();
            outputStream = new DataOutputStream(new FileOutputStream(new File(filePath)));
            outputStream.write(cstr.trim().getBytes("utf-8"));
        }
        catch (Exception e)
        {
            return false;
        }
        finally
        {
            FileUtils.CloseStream(outputStream);
        }
        return true;
    }

    /**反序列化
     * @param obj
     * @param filePath
     * @param <T>
     * @return
     */
    public static <T> Object desrializeXmlToParme(final Class obj, String filePath)
    {
        try
        {
            String xml = FileUtils.OpenFileToString(filePath);
            JAXBContext jc = JAXBContext.newInstance(obj);
            Unmarshaller unmar = jc.createUnmarshaller();
            return unmar.unmarshal(new StringReader(xml));
        }
        catch (JAXBException e)
        {
        }
        finally
        {
        }
        return null;
    }

    /**反序列化
     * @param obj
     * @param filePath
     * @return
     */
    public static Object desrializeFromXmlToParme(final Class obj, String filePath)
    {
        DataInputStream dataInputStream = null;
        try
        {
            dataInputStream = new DataInputStream(new FileInputStream(new File(filePath)));
            return readConfig(obj, dataInputStream);
        }
        catch (Exception e)
        {
        }
        finally
        {
            FileUtils.CloseStream(dataInputStream);
        }
        return null;
    }
}