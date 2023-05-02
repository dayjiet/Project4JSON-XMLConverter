# JSON - XML converter

This project is a command-line tool for converting JSON files to XML and vice versa. The project includes a
`ToXMLConverter` class and an `ToJSONConverter` class to convert between the two formats. The tool also includes 
a `XmlParser` class to parse XML files, a `JsonFormatter` class to format JSON files and a `JsonParser` class to parse 
JSON files, a `XmlFormatter` class to format XML files.

## Features

- Conversion from JSON to XML
- Conversion from XML to JSON
- XML parsing and JSON formatting
- JSON parsing and XML formatting

## Usage

1. The project can be run from the command line by executing the `Main` class. The input file path is hardcoded in the
`Main` class, and by default, it is set to `src/test/java/test.txt`. This file can be changed to the desired input 
file path.
2. To use the tool, simply run the `Main` class. The tool will read the input file and automatically determine whether 
it is in JSON or XML format. The tool will then convert the file to the opposite format and print the result to the 
console.
3. Note that if the tool is unable to determine the input file format or is unable to convert the file, it will print 
an error message to the console.
4. The tool can be further customized by modifying the `ToXMLConverter`, `ToJSONConverter`, `XmlParser`, 
`JsonFormatter`, `JsonParser` and `XmlParser` classes to fit specific requirements.

## Dependencies
The project has no external dependencies and can be run on any system with Java installed.