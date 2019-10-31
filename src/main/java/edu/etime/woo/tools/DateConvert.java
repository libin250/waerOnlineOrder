package edu.etime.woo.tools;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.etime.woo.pojo.SysUser;
import org.springframework.core.convert.converter.Converter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 公共类
 */
public class DateConvert implements Converter<String, Date> {
	/**
	 * 获取当前用户
	 *
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static SysUser getCurrentUser(HttpServletRequest request) throws IOException{
		HttpSession session = request.getSession();
		return (SysUser) session.getAttribute("currentUser");
	}

	@Override
	public Date convert(String arg0) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = df.parse(arg0);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}





}
