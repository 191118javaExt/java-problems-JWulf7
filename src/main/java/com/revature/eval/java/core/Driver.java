package com.revature.eval.java.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Driver {

	// write code to test method here

	public static Temporal getGigasecondDate(Temporal given) {
		// TODO Write an implementation for this method declaration
		//TemporalUnit unit = (TemporalUnit) given;
		//ChronoUnit time = (ChronoUnit) unit;
		//unit = (TemporalUnit) time.addTo((Temporal)(TemporalUnit)ChronoUnit.SECONDS, 109000000000L);
				//given.plus(109000000000L, Seconds);
		
		
		return null;//(Temporal) unit;
	}
	

	public static void main(String[] args) {

		// test-run your method here

		System.out.println(getGigasecondDate(LocalDate.of(2011, Month.APRIL, 25)));

		System.out.println(getGigasecondDate(LocalDate.of(1977, Month.JUNE, 13)));

		System.out.println(getGigasecondDate(LocalDate.of(1959, Month.JULY, 19)));

		System.out.println(getGigasecondDate(LocalDateTime.of(2015, Month.JANUARY, 24, 22, 0, 0)));

		System.out.println(getGigasecondDate(LocalDateTime.of(2015, Month.JANUARY, 24, 23, 59, 59)));

	}

}
