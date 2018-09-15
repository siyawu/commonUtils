package com.wq.common.XMlTools.JAXBContextDemo;

import org.junit.Test;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuqiang on 2018/4/12
 */
public class JaxbComtextToolTest
{
    private static final String xmlPath = "./src/main/resources/items.xml";

    @Test
    public void serializeParmToXml()
    {
        Items items = new Items();
        items.setTotalResults("totalResults");
        items.setTotalResultsAll("totalResultsAll");
        List<Rows> ls = new ArrayList<Rows>();
        Rows rows = new Rows();
        rows.setColor("red");
        rows.setProductBrand("100");
        ls.add(rows);
        items.setRows(ls);

        Boolean result = JaxbComtextTool.serializeParmToXml(items, xmlPath);
        System.out.println(result);
    }

    @Test
    public void desrializeXmlToParme()
    {
        Items items = (Items) JaxbComtextTool.desrializeXmlToParme(Items.class, xmlPath);
        System.out.println(items.getTotalResults());
    }

    @Test
    public void desrializeFromXmlToParme()
    {
        Items items = (Items) JaxbComtextTool.desrializeFromXmlToParme(Items.class, xmlPath);
        System.out.println(items.getTotalResults());
    }
}

@XmlRootElement
@Root(name = "items")
class Items
{
    @Element(name = "totalResults", required = false)
    private String totalResults;

    @Element(name = "totalResultsAll", required = false)
    private String totalResultsAll;

    @Element(name = "Rows", required = false)
    private List<Rows> rows;

    public String getTotalResults()
    {
        return totalResults;
    }

    public void setTotalResults(String totalResults)
    {
        this.totalResults = totalResults;
    }

    public String getTotalResultsAll()
    {
        return totalResultsAll;
    }

    public void setTotalResultsAll(String totalResultsAll)
    {
        this.totalResultsAll = totalResultsAll;
    }

    public List<Rows> getRows()
    {
        return rows;
    }

    public void setRows(List<Rows> rows)
    {
        this.rows = rows;
    }
}

@Root(name = "Rows")
class Rows
{
    @Element(name = "productCategory", required = false)
    private String productCategory;

    @Element(name = "sortName", required = false)
    private String sortName;

    @Element(name = "productBrand", required = false)
    private String productBrand;

    @Element(name = "productID", required = false)
    private String productID;

    @Element(name = "productName", required = false)
    private String productName;

    @Element(name = "color", required = false)
    private String color;

    @Element(name = "sizeNo", required = false)
    private String sizeNo;

    @Element(name = "saleNum", required = false)
    private String saleNum;

    public String getProductCategory()
    {
        return productCategory;
    }

    public void setProductCategory(String productCategory)
    {
        this.productCategory = productCategory;
    }

    public String getSortName()
    {
        return sortName;
    }

    public void setSortName(String sortName)
    {
        this.sortName = sortName;
    }

    public String getProductBrand()
    {
        return productBrand;
    }

    public void setProductBrand(String productBrand)
    {
        this.productBrand = productBrand;
    }

    public String getProductID()
    {
        return productID;
    }

    public void setProductID(String productID)
    {
        this.productID = productID;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getSizeNo()
    {
        return sizeNo;
    }

    public void setSizeNo(String sizeNo)
    {
        this.sizeNo = sizeNo;
    }

    public String getSaleNum()
    {
        return saleNum;
    }

    public void setSaleNum(String saleNum)
    {
        this.saleNum = saleNum;
    }
}