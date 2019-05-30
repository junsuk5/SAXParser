package com.company;

import com.company.models.Item;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MySaxParser {

    SAXParserFactory spf = SAXParserFactory.newInstance();
    SAXParser parser;

    public MySaxParser() throws ParserConfigurationException, SAXException {
        parser = spf.newSAXParser();
    }

    public List<Item> getResults(String uri) {
        XmlParserHandler handler = new XmlParserHandler();
        try {
            parser.parse(uri, handler);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        return handler.getItems();
    }

    private static class XmlParserHandler extends DefaultHandler {

        private StringBuilder sb;

        private List<Item> items = new ArrayList<>();
        private Item item;

        public List<Item> getItems() {
            return items;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase("item")) {
                item = new Item();
            }

            sb = new StringBuilder();
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equalsIgnoreCase("item")) {
                items.add(item);
            } else if (qName.equalsIgnoreCase("regId")) {
                item.setRegId(sb.toString());
            } else if (qName.equalsIgnoreCase("taMax10")) {
                item.setTaMax10(sb.toString());
            } else if (qName.equalsIgnoreCase("taMax3")) {
                item.setTaMax3(sb.toString());
            } else if (qName.equalsIgnoreCase("taMax4")) {
                item.setTaMax4(sb.toString());
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            sb.append(new String(ch, start, length));
        }
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        MySaxParser parser = new MySaxParser();
        List<Item> items = parser.getResults("https://gist.githubusercontent.com/junsuk5/a78465cc0dc33c0f9b6cb6fd76138073/raw/0051d4f76b5345e616ab2625e7f4994caf9736bb/xmldata.xml");

        System.out.println(items);
    }
}