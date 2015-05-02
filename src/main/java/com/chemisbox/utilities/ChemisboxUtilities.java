package com.chemisbox.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.chemisbox.constant.ChemisboxConstant;

public class ChemisboxUtilities {

	public static boolean isValidEmail(String source){
		boolean result = false;
		Pattern emailPattern = Pattern.compile(ChemisboxConstant.EMAIL_PATTERN);
		Matcher matcher = emailPattern.matcher(source);
		if(matcher.find()){
			result = true;
		}
		return result;
	}
	
	public static Long getLongInString(String source) {
		Long value = null;
		try {
			if(isNullOrEmpty(source)){
				return value;
			}
			value = Long.parseLong(source);
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
		return value;
	}
	
	public static Integer getIntegerInString(String source) {
		Integer value = null;
		try {
			if(isNullOrEmpty(source)){
				return value;
			}
			value = Integer.parseInt(source);
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
		return value;
	}

	// valid array is split
	public static List<String> validArrayIsSplit(String source,
			String patternForSplit) {
		List<String> dataList = new ArrayList<String>();
		String[] splitArr = source.split(patternForSplit);
		for (int i = 0; i < splitArr.length; i++) {
			String value = splitArr[i].trim();
			if (value.length() > 0) {
				dataList.add(value);
			}
		}
		return dataList;
	}

	public static String validFormat(String source) {
		String[] arrString = source.split(" ");
		String elementString = null;
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < arrString.length; i++) {
			elementString = arrString[i].trim();
			if (elementString.length() > 0) {
				buffer.append(elementString);
				buffer.append(" ");
			}
		}
		buffer.deleteCharAt(buffer.length() - 1);
		return buffer.toString();
	}

	public static String trimFullSize(String data) {
		return data.trim();
	}

	/*
	 * Validate List<?> is null or empty
	 * 
	 * @param list
	 * 
	 * @output true if list is null or empty false if list not null and not
	 * empty
	 */
	public static boolean isNullOrEmpty(List<?> list) {
		if (list == null) {
			return true;
		}

		if (list.isEmpty()) {
			return true;
		}
		return false;
	}

	/*
	 * Validate String is null or empty
	 * 
	 * @param stringData
	 * 
	 * @output true if stringData is null or empty false if stringData not null
	 * and not empty
	 */

	public static boolean isNullOrEmpty(String stringData) {
		if (stringData == null) {
			return true;
		}

		if (stringData.trim().isEmpty()) {
			return true;
		}

		return false;
	}

	/*
	 * Convert string data to equation format
	 * 
	 * @param rawData
	 * 
	 * @output equation format
	 */

	public static String convertStringToEquationFormat(String rawData) {
		String[] arr = rawData.split(",");
		StringBuffer inBuffer = new StringBuffer();
		StringBuffer outBuffer = new StringBuffer();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].charAt(0) == '0') {
				arr[i] = arr[i].replaceFirst("0", "");
			}
			String[] arrVal = arr[i].split(":");
			if (arrVal[2].equals("1")) {
				inBuffer.append(arrVal[0]);
				inBuffer.append(arrVal[1]);
				inBuffer.append(" + ");
			} else {
				outBuffer.append(arrVal[0]);
				outBuffer.append(arrVal[1]);
				outBuffer.append(" + ");
			}
		}

		inBuffer = inBuffer.delete(inBuffer.length() - 3, inBuffer.length());
		outBuffer = outBuffer
				.delete(outBuffer.length() - 3, outBuffer.length());
		inBuffer.append(" <span aria-hidden='true'>&rarr;</span> ");
		inBuffer.append(outBuffer);

		return inBuffer.toString();
	}

	/*
	 * Format string data to oxi_reduce ion equation
	 * 
	 * @param source
	 * 
	 * @output oxi_reduce ion format
	 */

	public static String displayOxiReduceIonEquation(String source) {
		Pattern pattern = Pattern.compile("(\\d)*(\\w)+[+−]?");
		Matcher matcher = pattern.matcher(source);
		Pattern patternChil = Pattern.compile("\\d?[+−]{1}");
		Matcher matcherChil = null;
		while (matcher.find()) {
			String temp = matcher.group();
			matcherChil = patternChil.matcher(temp);
			if (matcherChil.find()) {
				String sub = matcherChil.group();
				String temp1 = temp.replace(sub, "<sub>" + sub + "</sub>");
				source = source.replace(temp, temp1);
			}
		}
		return source;
	}

	/*
	 * Format string data to equation to display on browser for user
	 * 
	 * @param source
	 * 
	 * @output equation format ion format
	 */

	public static String displayOnBrowser(String source) {
		String patternStr = "[a-zA-Z()]\\d+";

		String patternNum = "\\d+";

		Pattern patternOfStr = Pattern.compile(patternStr);
		Matcher matcherOfStr = patternOfStr.matcher(source);

		Pattern patternOfNum = Pattern.compile(patternNum);
		Matcher matcherOfNum = null;

		String tempStr = "";

		while (matcherOfStr.find()) {
			tempStr = matcherOfStr.group();
			matcherOfNum = patternOfNum.matcher(tempStr);
			if (matcherOfNum.find()) {
				String tmp = tempStr.replace(matcherOfNum.group(), "<sub>"
						+ matcherOfNum.group() + "</sub>");
				source = source.replace(tempStr, tmp);

			}
		}
		
		Pattern patterCondition = Pattern.compile("\\({1}[a-zA-Z0-9]+\\){1}");
		Matcher matcherCondition = patterCondition.matcher(source);
		while(matcherCondition.find()){
			source = source.replace(matcherCondition.group(), "<sub>" + matcherCondition.group() + "<sub>");
		}
		
		return source;
	}
}
