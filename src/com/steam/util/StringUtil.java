package com.steam.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringUtil {
	
	public static String ArrayToString(List<String> list) {
		String str = "";
		for(Iterator<String> it = list.iterator();it.hasNext();) {
			str += it.next() + ";";
		}
		return str;
	}
	
	public static List<String> StringToArray(String str){
		List<String> list = new ArrayList();
		String [] tempList = str.split(";");
		for(int i=0;i<tempList.length;i++) {
			list.add(tempList[i]);
		}
		return list;
	}
	
	public static String getFileName() {
		String name = "";
		
		return name;
	}
}
