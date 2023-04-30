import base.AbstractConverter;
import json.JsonFormatter;
import xml.XmlParser;

public class XmlToJsonConverter extends AbstractConverter {
    public XmlToJsonConverter() {
        super(new XmlParser(), new JsonFormatter());
    }
}
