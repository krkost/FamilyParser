package by.htp.xml.parser.dom;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.htp.xml.entity.Child;
import by.htp.xml.entity.Families;
import by.htp.xml.entity.Family;
import by.htp.xml.entity.Father;
import by.htp.xml.entity.Mother;
import by.htp.xml.parser.FamilyParser;
import by.htp.xml.parser.sax.FamilySaxHandler;

public class FamilyDomParser implements FamilyParser {

	public Families parseFamilyDoc(String path) {

		Families families = new Families();
		List<Family> listFamilies = new ArrayList<>();
		LinkedList<Child> childList = new LinkedList<>();

		File inputFile = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("family");
			
			putChildrenInList(doc, childList);

			for (int i = 0; i < nList.getLength(); i++) {

				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					Family family = new Family();
					family.setId(Integer.parseInt(eElement.getAttribute("id")));

					NodeList nFatherList = doc.getElementsByTagName("father");
					Node nFather = nFatherList.item(i);
					Element eFather = (Element) nFather;
					Father father = new Father();

					father.setName(getSingleChild(eFather, "name").getTextContent().trim());
					father.setSurname(getSingleChild(eFather, "surname").getTextContent().trim());
					father.setAge(Integer.parseInt(getSingleChild(eFather, "age").getTextContent().trim()));

					NodeList nMotherList = doc.getElementsByTagName("mother");
					Node nMother = nMotherList.item(i);
					Element eMother = (Element) nMother;
					Mother mother = new Mother();

					mother.setName(getSingleChild(eMother, "name").getTextContent().trim());
					mother.setSurname(getSingleChild(eMother, "surname").getTextContent().trim());
					mother.setAge(Integer.parseInt(getSingleChild(eMother, "age").getTextContent().trim()));
					mother.setMaidenName(eMother.getAttribute("maiden-name"));

					family.setFather(father);
					family.setMother(mother);
					
					ArrayList<Child> children = new ArrayList<Child>();
					
					children.add(childList.poll());
					children.add(childList.poll());
					
					family.setChildren(children);
					

					listFamilies.add(family);

				}

			}

			families.setFamilies(listFamilies);
			

			System.out.println(families);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		return families;
	}

	private void putChildrenInList(Document doc, LinkedList<Child> childList) {
		NodeList nChildrenList = doc.getElementsByTagName("child");

		for (int j = 0; j < nChildrenList.getLength(); j++) {
			Node nChild = nChildrenList.item(j);
			Element eChild = (Element) nChild;
			
			Child child = new Child();

			child.setName(getSingleChild(eChild, "name").getTextContent().trim());
			child.setSurname(getSingleChild(eChild, "surname").getTextContent().trim());
			child.setAge(Integer.parseInt(getSingleChild(eChild, "age").getTextContent().trim()));
			child.setGender(getSingleChild(eChild, "gender").getTextContent().trim());
			
			childList.add(child);
			
		}
		
	}

	private static Element getSingleChild(Element element, String childName) {
		NodeList nlist = element.getElementsByTagName(childName);
		Element child = (Element) nlist.item(0);
		return child;
	}

}
