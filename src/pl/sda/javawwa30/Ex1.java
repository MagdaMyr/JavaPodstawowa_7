package pl.sda.javawwa30;

import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Ex1 {

    public static void main(String[] args) {
        String[] zonesId = {"Europe/Warsaw", "Europe/London", "PRC",
                "America/New_York", "America/Los_Angeles", "Asia/Tokyo",
                "Asia/Hong_Kong", "Europe/Tallinn", "Europe/Madrid",
                "Europe/Kiev", "Europe/Stockholm", "Europe/Berlin"};

        Instant machineTime = Instant.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm");
        for(String zoneId : zonesId)
            printZonedTime(machineTime, zoneId, dtf);
    }

    public static void printZonedTime(Instant pointInTime, String zoneId, DateTimeFormatter dtf) {
        System.out.printf("Time %s at %s: %s\n",
                dtf.format(LocalTime.ofInstant(pointInTime, ZoneId.of("CET"))), zoneId,
                dtf.format(pointInTime.atZone(ZoneId.of(zoneId)).toLocalTime()));
    }

    public static void printAvailableZones() {
        for (String zoneId : ZoneId.getAvailableZoneIds())
            System.out.println(zoneId);
    }

    public static void printAvailableContinentZones(String continent) {
        System.out.printf("- - - %s TIME ZONES - - -\n", continent);
        ZoneId.getAvailableZoneIds().stream()
                .filter(s -> s.startsWith(continent))
                .forEach(System.out::println);
    }

}
