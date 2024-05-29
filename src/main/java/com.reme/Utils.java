package com.reme;

import java.time.*;
import java.time.format.DateTimeFormatter;


public abstract class Utils {
 public static String getTodayMidnight(){
     // Get the current date
     LocalDate today = LocalDate.now();

     // Create a LocalDateTime representing midnight (start of the day)
     LocalDateTime midnight = today.atStartOfDay();

     // Convert LocalDateTime to ZonedDateTime in UTC
     ZonedDateTime midnightUTC = midnight.atZone(ZoneId.of("UTC"));

     // Define the formatter to match the desired output format
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

     // Format the ZonedDateTime
     return midnightUTC.format(formatter);

 }
}
