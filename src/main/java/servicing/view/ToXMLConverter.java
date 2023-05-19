package servicing.view;

import servicing.dao.JSONParser;
import servicing.dao.XMLFormatter;
import servicing.service.AbstractConverter;

/**
 A converter that converts text input to XML format.
 */
public class ToXMLConverter extends AbstractConverter {

    /**
     * Constructs a new ToXMLConverter.
     * Initializes the converter with a JSONParser and XMLFormatter.
     */
    public ToXMLConverter() {
        super(new JSONParser(), new XMLFormatter());
    }
}