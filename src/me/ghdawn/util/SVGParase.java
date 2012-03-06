package me.ghdawn.util;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import me.ghdawn.form.Circle;
import me.ghdawn.form.Line;
import me.ghdawn.form.Polygon;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class SVGParase
{
	private File _svgFile;
	Document doc;
	NodeList nList;
	public SVGParase(File svgFile) throws SAXException, IOException
	{
		_svgFile=svgFile;
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory
		        .newInstance();
		DocumentBuilder dBuilder;
        try
        {
	        dBuilder = dbFactory.newDocumentBuilder();
	        doc = dBuilder.parse(_svgFile);
			doc.getDocumentElement().normalize();
			
        }
        catch (ParserConfigurationException e)
        {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }
		
	}
	
	public ArrayList<Line> getLines()
	{
		ArrayList<Line> lines=new ArrayList<Line>(100);
		Line line;
		nList = doc.getElementsByTagName("polyline");
		for (int temp = 0; temp < nList.getLength(); temp++)
		{

			Node nNode = nList.item(temp);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE)
			{

				Element eElement = (Element) nNode;
				String points = eElement.getAttribute("points");
				line=new Line();
				line.add(points);
				lines.add(line);
			}
		}
		return lines;
	}
	
	public ArrayList<Circle> getCircles()
	{
		ArrayList<Circle> circles=new ArrayList<Circle>(100);
		Circle circle;
		nList = doc.getElementsByTagName("circle");
		for (int temp = 0; temp < nList.getLength(); temp++)
		{

			Node nNode = nList.item(temp);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE)
			{

				Element eElement = (Element) nNode;
				String cx = eElement.getAttribute("cx");
				String cy = eElement.getAttribute("cy");
				String r = eElement.getAttribute("r");
				circle=new Circle(cx, cy, r);
				circles.add(circle);
			}
		}
		return circles;
	}
	
	public ArrayList<Polygon> getPolygons()
	{
		ArrayList<Polygon> polygons=new ArrayList<Polygon>(100);
		Polygon polygon;
		nList = doc.getElementsByTagName("polygon");
		for (int temp = 0; temp < nList.getLength(); temp++)
		{

			Node nNode = nList.item(temp);
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE)
			{

				Element eElement = (Element) nNode;
				String points = eElement.getAttribute("points");
				polygon=new Polygon();
				polygon.add(points);
				polygons.add(polygon);
			}
		}
		return polygons;
	}
	//TODO:: text,path
}
