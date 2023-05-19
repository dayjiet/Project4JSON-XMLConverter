package servicing;

import servicing.base.AbstractConverter;
import servicing.json.JSONParser;
import servicing.xml.XMLFormatter;

public class ToXMLConverter extends AbstractConverter {
    public ToXMLConverter() {
        super(new JSONParser(), new XMLFormatter());
    }
}