package core.quest.answer.bot.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dateUtil {
	
	private static final String FORMATO_NO_EXTENSO = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 *
	 * @return dateString
	 */
	public static String fechaHoyString() {
		SimpleDateFormat format = new SimpleDateFormat(FORMATO_NO_EXTENSO);
		String dateString = format.format(new Date());
		return dateString;
	}
}
