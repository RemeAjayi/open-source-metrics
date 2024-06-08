package com.reme.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;


public abstract class Utils {
 public static String getTodayMidnight(){
     LocalDate today = LocalDate.now();
     LocalDateTime midnight = today.atStartOfDay();
     ZonedDateTime midnightUTC = midnight.atZone(ZoneId.of("UTC"));
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
     return midnightUTC.format(formatter);
 }
}
