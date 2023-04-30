import base.AbstractConverter;
import json.JsonParser;
import xml.XmlFormatter;

public class JsonToXmlConverter extends AbstractConverter {
    public JsonToXmlConverter() {
        super(new JsonParser(), new XmlFormatter());
    }
}