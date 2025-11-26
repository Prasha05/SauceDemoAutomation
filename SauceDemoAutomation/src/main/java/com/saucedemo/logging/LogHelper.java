package com.saucedemo.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHelper {
	public static Logger getLogger(Class<?> cls) {
		return LogManager.getLogger(cls);
	}
}
