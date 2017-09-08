package com.askconsultant.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Ignore;

@Ignore
public class FileUtil {

	//the below string contains the OS independent path for the directory containing the json files for the 
	//test
	static String basePath = "src" + File.separator + "test" + File.separator + "java" + File.separator + "com"
			+ File.separator + "askconsultant" + File.separator + "resource" + File.separator + "json" + File.separator;

	/**
	 * Reads the JSON file passed into a string
	 * @param fileName
	 * @return
	 */
	public static String readJSONFile(String fileName) {
		try {
			File file = new File(basePath + fileName);
			InputStream fileSteam = new FileInputStream(file);
			return IOUtils.toString(fileSteam);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}

}
