package by.htp.xml.parser.sax;

import java.util.Arrays;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FamilySaxHandler extends DefaultHandler {

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		super.characters(ch, start, length);
		System.out.println("characters:" + new StringBuilder().append(ch, start, length));
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		System.out.println("startElement");

		switch (localName) {
		case "mother":
			System.out.println("************M" + localName);
			break;
		case "father":
			System.out.println("------------F" + localName);
			break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("endElement");
		super.endElement(uri, localName, qName);
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("startDocument");
		super.startDocument();
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("endDocument");
		super.endDocument();
	}

}
