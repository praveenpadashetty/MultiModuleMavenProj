package com.java8.dateapis;

import static java.time.DayOfWeek.THURSDAY;
import static java.time.temporal.TemporalAdjusters.next;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DateDemo {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		LocalDate yesterday;
		System.out.println(localDate);
		yesterday = localDate.minusDays(1);
		System.out.println(yesterday);

		// 1. Write a predicate to check if the given date is yesterday date.
		Predicate<LocalDate> date = d -> yesterday.equals(d);
		System.out.println(date.test(localDate));

		// 2. Write a Supplier to get Date for next Thursday.
		Supplier<LocalDate> supply = () -> {
			LocalDate da = LocalDate.now();
			return da.with(next(THURSDAY));
		};
		System.out.println(supply.get());

		// 3. Write a Supplier to get CurrentTime in EST timezone

		Supplier<ZonedDateTime> timezone = () -> {
			Instant now = Instant.now();
			System.out.println(ZoneId.getAvailableZoneIds());
			return ZonedDateTime.ofInstant(now, ZoneId.of("EST5EDT"));
		};
		System.out.println(timezone.get());
		
		//4. Write a Function to calculate the age of a person given date of birth.
		Function<String, Integer> age= (dob)->{
			LocalDate cur = LocalDate.now();
			int day = Integer.parseInt(dob.split("-")[0]);
			int month = Integer.parseInt(dob.split("-")[1]);
			int year = Integer.parseInt(dob.split("-")[2]);
			LocalDate sd = LocalDate.of(year, month, day);
			Period period = Period.between(cur, sd);
			return Math.abs(period.getYears());
		};
		
		System.out.println(age.apply("07-11-1995"));
	}
}
