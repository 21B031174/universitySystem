package universitySystem.Faculty;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

import universitySystem.Faculty.Time;

public class Time implements Comparable<Time> {

	public LocalTime t;
	public DayOfWeek day;
	
	public Time(LocalTime t, DayOfWeek day) {
		this.t = t;
		this.day = day;
	}
	
	public Time() {
	}

	@Override
	public int compareTo(Time o) {
		if (t == o.t) return 0;
		else if ((t.getHour() > o.t.getHour()) || (t.getHour() == o.t.getHour() && t.getMinute() > o.t.getMinute())) return 1;
		else return -1;
	}
	
	public String toString() {
		return t.toString() + day.toString();
	}
}
