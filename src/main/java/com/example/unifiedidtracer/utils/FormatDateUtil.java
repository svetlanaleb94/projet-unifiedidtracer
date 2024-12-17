package com.example.unifiedidtracer.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Utility class for formatting and manipulating date objects.
 * 
 * This class provides methods to convert dates into specific formats, 
 * parse date strings, and perform various date-related operations.
 */
public class FormatDateUtil {
	
	
	/** Format date with format passed as a parameter.*/
	public static String formatDate(String dateStr, String format) {		
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateStr, inputFormatter);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(format);
        return date.format(outputFormatter);
	}

}
