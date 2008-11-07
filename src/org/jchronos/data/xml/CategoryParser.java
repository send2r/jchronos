package org.jchronos.data.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public final class CategoryParser {
    private static CategoryParser INSTANCE = null;
    private static List<String> categories = new ArrayList<String>();
    private static final String CATEGORY_XML_FILE = "Categories.xml";
    private static final String CATEGORY_TAG_NAME = "category";
    private static final String NAME_TAG_NAME = "name";
    private CategoryParser() {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            factory.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, Boolean.TRUE);
            factory.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, Boolean.FALSE);
            readCategoryXML(factory);
        } catch (XMLStreamException ex) {
            Logger.getLogger(CategoryParser.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalStateException("Can not initialize Category Parser");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CategoryParser.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalStateException("Can not initialize Category Parser");
        }

    }
    public static synchronized CategoryParser getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new CategoryParser();
        }
        return INSTANCE;
    }

    public List<String> getCategories() {
        return categories;
    }

    private void readCategoryXML(XMLInputFactory factory) throws XMLStreamException, FileNotFoundException {
        URL url = ClassLoader.getSystemResource(CATEGORY_XML_FILE);
        FileInputStream xmlStream = new FileInputStream(new File(url.getFile()));
        XMLStreamReader reader = factory.createXMLStreamReader(xmlStream);
        while(reader.hasNext()){
            reader.next();
            if(reader.isStartElement() && reader.getName().toString().equals(NAME_TAG_NAME)){
                reader.next();
                categories.add(reader.getText());
            }
        }

    }

    public static void main(String[] args) {
        CategoryParser parser = CategoryParser.getInstance();
        System.out.println(parser.getCategories());
    }
}
