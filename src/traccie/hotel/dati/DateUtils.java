package traccie.hotel.dati;

import java.util.GregorianCalendar;

public class DateUtils {

	public static String display(GregorianCalendar date) {
		return date.get(GregorianCalendar.DAY_OF_MONTH) + "-" + date.get(GregorianCalendar.MONTH) + "-"
				+ date.get(GregorianCalendar.YEAR);
	}

	public static GregorianCalendar getFrom(String date) {
		String[] ins = date.split("-");
		return new GregorianCalendar(Integer.parseInt(ins[2]), Integer.parseInt(ins[1]), Integer.parseInt(ins[0]));
	}

}
