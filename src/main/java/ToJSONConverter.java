import base.AbstractConverter;
import json.JSONFormatter;
import xml.XMLParser;

public class ToJSONConverter extends AbstractConverter {
    public ToJSONConverter() {
        super(new XMLParser(), new JSONFormatter());
    }
}
