package by.htp.xml.run;

import by.htp.xml.parser.FamilyParser;
import by.htp.xml.parser.dom.FamilyDomParser;
import by.htp.xml.parser.sax.FamilySaxParser;

public class MainAppFamily {

	public static void main(String[] args) {
		FamilyParser familyParser = new FamilyDomParser();
		familyParser.parseFamilyDoc("resources/family.xml");

	}

}
