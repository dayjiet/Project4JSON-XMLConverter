package servicing;

import servicing.base.AbstractConverter;
import servicing.json.JSONFormatter;
import servicing.xml.XMLParser;

public class ToJSONConverter extends AbstractConverter {
    public ToJSONConverter() {
        super(new XMLParser(), new JSONFormatter());
    }
}
