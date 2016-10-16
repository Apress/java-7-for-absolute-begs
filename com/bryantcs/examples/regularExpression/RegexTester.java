package com.bryantcs.examples.regularExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTester {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile(args[0]);
		Matcher matcher = pattern.matcher(args[1]);
		while(matcher.find()) {
			String groupText = matcher.group();
			int matchBegin = matcher.start();
			int matchEnd  = matcher.end();
			StringBuilder sb = new StringBuilder("Found a match for ");
			sb.append(groupText);
			sb.append(" beginning at ");
			sb.append(matchBegin);
			sb.append(" and ending at ");
			sb.append(matchEnd);
			System.out.println(sb);
		}
	}
}