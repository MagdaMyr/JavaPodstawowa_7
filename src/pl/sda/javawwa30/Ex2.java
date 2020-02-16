package pl.sda.javawwa30;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Ex2 {

    public static void main(String[] args) {
        //jak dlugo zyje czlowiek
        LocalDateTime birthday = LocalDateTime.of(1992, 5, 2, 23, 30);
        LocalDateTime timeDateNow = LocalDateTime.now();

        calcPeriodBetween(birthday.toLocalDate(), timeDateNow.toLocalDate());
        calcChronoUnitBetween(birthday, timeDateNow);

        //data z przyszlosci
        LocalDateTime futureDate = LocalDateTime.of(2039, 11, 7, 12, 00);
        calcPeriodBetween(birthday.toLocalDate(), futureDate.toLocalDate());
        calcChronoUnitBetween(birthday, futureDate);

        //data z przesunieciem czasowym
        calcPeriodBetween(birthday.toLocalDate(), timeDateNow.plusYears(20).toLocalDate());
        calcChronoUnitBetween(birthday, timeDateNow.plusYears(20));
    }

    //Od daty d1 do daty d2 minelo 14 lat, 5 miesiecy i 2 dni. - Period
    public static void calcPeriodBetween(LocalDate d1, LocalDate d2) {
        Period period = d1.until(d2);
        System.out.printf("Od daty %s do daty %s minelo:\nlat: %d\nmiesiecy: %d\ndni: %d\n",
                d1, d2, period.getYears(), period.getMonths(), period.getDays());
    }
    //Od daty d1 do daty d2 minelo 1 rok czyli 12 msc czyli 365 dni itd. - ChronoUnit.between
    public static void calcChronoUnitBetween(LocalDateTime d1, LocalDateTime d2) {
        System.out.printf("Od daty %s do daty %s minelo:\nlat: %d czyli...\nmiesiecy: %d czyli...\ndni: %d czyli...\nminut: %d\n",
                d1, d2,
                ChronoUnit.YEARS.between(d1, d2),
                ChronoUnit.MONTHS.between(d1, d2),
                ChronoUnit.DAYS.between(d1, d2),
                ChronoUnit.MINUTES.between(d1, d2));
    }

}
