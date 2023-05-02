import base.AbstractConverter;
import json.JSONParser;
import xml.XMLFormatter;

public class ToXMLConverter extends AbstractConverter {
    public ToXMLConverter() {
        super(new JSONParser(), new XMLFormatter());
    }
}