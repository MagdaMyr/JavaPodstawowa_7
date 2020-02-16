package pl.sda.javawwa30;

import java.time.ZoneId;

public class Ex1 {

    public static void main(String[] args) {
        //printAvailableZones();
        printAvailableContinentZones("Europe");
        printAvailableContinentZones("Asia");
        printAvailableContinentZones("America");
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
