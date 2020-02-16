package pl.sda.javawwa30;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DateAndTimeAPIDemo {

    public static void main(String[] args) {
        //wystartuj pomiar czasu - 'zapisuje' moment w czasie
        Instant startTime = Instant.now();

        //porownywanie dat
        LocalDate birthdate = LocalDate.of(1992, 5, 2);
        LocalDate birthdate2 = LocalDate.of(1992, Month.MAY, 2);
        System.out.printf("Czy data %s i %s sa takie same [isEqual]? %s\n",
                birthdate, birthdate2, birthdate.isEqual(birthdate2));
        System.out.printf("Czy data %s i %s sa takie same [equals]? %s\n",
                birthdate, birthdate2, birthdate.equals(birthdate2));

        //wyznaczanie roznicy czasu miedzy datami (tylko jedna z metod)
        //Period wyznacza miedzy datami roznice dni, miesiecy, lat (liczone tylko per dana jednostka)
        LocalDate oliviaBirthday = LocalDate.of(2018, 11, 7);
        Period period = birthdate.until(oliviaBirthday);
        System.out.printf("Ile dni uplynelo od %s do %s? %d\n",
                birthdate, oliviaBirthday, period.getDays());
        System.out.printf("Ile miesiecy uplynelo od %s do %s? %d\n",
                birthdate, oliviaBirthday, period.getMonths());
        System.out.printf("Ile lat uplynelo od %s do %s? %d\n",
                birthdate, oliviaBirthday, period.getYears());

        //ChronoUnit.DAYS.between policzy calkowita roznice dni - "prawdziwy uplyw czasu"
        System.out.printf("Ile dni uplynelo od %s do %s? %d\n",
                birthdate, oliviaBirthday, ChronoUnit.DAYS.between(birthdate, oliviaBirthday));
        //poniewaz liczymy ChronoUnit.SECONDS nasze dane wejsciowe musza reprezentowac sekundy,
        //stad konwersja (rozszerzenie) z LocalDate -> LocalDateTime
        System.out.printf("Ile sekund uplynelo od %s do %s? %d\n",
                birthdate, oliviaBirthday,
                ChronoUnit.SECONDS.between(LocalDateTime.of(birthdate, LocalTime.parse("23:30")),
                        LocalDateTime.of(oliviaBirthday, LocalTime.parse("20:30"))));

        //zoned time
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime ldtZoned = LocalDateTime.now(ZoneId.of("Europe/Warsaw"));
        LocalDateTime ldtZoned2 = LocalDateTime.now(ZoneId.of("Europe/Berlin"));
        LocalDateTime ldtZoned3 = LocalDateTime.now(ZoneId.of("Europe/Madrid"));
        System.out.printf("Teraz jest: %s\nWarsaw: %s\nBerlin: %s\nMadrid: %s\n",
                ldt, ldtZoned, ldtZoned2, ldtZoned3);
        System.out.printf("Czy jest roznica w czasie miedzy Warsaw a Madrid? %s\n",
                ChronoUnit.HOURS.between(ldt, ldtZoned3));

        //reprezentacja danego czasu w roznych strefach czasowych
        Instant machineTime = Instant.now();
        ZonedDateTime warsawTime = machineTime.atZone(ZoneId.of("Europe/Warsaw"));
        ZonedDateTime londonTime = machineTime.atZone(ZoneId.of("Europe/London"));
        ZonedDateTime prcTime = machineTime.atZone(ZoneId.of("PRC"));
        ZonedDateTime nyTime = machineTime.atZone(ZoneId.of("America/New_York"));

        System.out.printf("Machine time: %s\nWarsaw: %s\nLondon: %s\nPRC: %s\nNew York: %s\n",
                machineTime, warsawTime, londonTime, prcTime, nyTime);

        //"plus"
        System.out.printf("Jaka bedzie godzina za 12h? %s\n", ldt.plusHours(12));
        System.out.printf("Jaka bedzie godzina za 12h w Madrycie? %s\n", ldtZoned3.plusHours(12));

        //fluid interface
        LocalDateTime ldtModified =
                ldt.withHour(22).withMonth(12).withDayOfMonth(24).withMinute(22).withYear(2022);
        System.out.println(ldtModified);

        //pomiar czasu wykonania z uzyciem Duration
        //koniec pomiaru czasu
        Instant endTime = Instant.now();
        Duration durationOfExec = Duration.between(startTime, endTime);
        System.out.printf("Ten program wykonywal sie %s ns",
                durationOfExec.getNano());
    }

}
