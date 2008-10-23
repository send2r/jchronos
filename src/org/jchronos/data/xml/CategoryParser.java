/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jchronos.data.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import static org.xmlpull.v1.XmlPullParser.*;
/**
 *
 * @author ranjith
 */
public class CategoryParser {
    public void parseCategory(InputStream inputStream) throws XmlPullParserException {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(inputStream, null);
                        boolean moreTags = true;

            while (moreTags) {
                try {
                    int event = parser.next();
                    switch (event) {
                        case START_DOCUMENT:
                            break;
                        case START_TAG:
                            processTag(parser);
                            break;

                        case END_DOCUMENT:
                            moreTags = false;
                            break;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(CategoryParser.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
    }

    private void processTag(XmlPullParser parser) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
