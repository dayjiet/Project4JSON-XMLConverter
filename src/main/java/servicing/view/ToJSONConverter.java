package servicing.view;

import servicing.dao.JSONFormatter;
import servicing.dao.XMLParser;
import servicing.service.AbstractConverter;

/**
 * A converter that converts text input to JSON format.
 */
public class ToJSONConverter extends AbstractConverter {

    /**
     * Constructs a new ToJSONConverter.
     * Initializes the converter with an XMLParser and JSONFormatter.
     */
    public ToJSONConverter() {
        super(new XMLParser(), new JSONFormatter());
    }
}
