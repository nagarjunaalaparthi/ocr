//**************************************************************************************************
//**************************************************************************************************
//                                     Copyright (c) 2014 by 
//                                            ALL RIGHTS RESERVED
//**************************************************************************************************
//**************************************************************************************************
//
//        Project name                        : Cuckuu
//        Class Name                          : LogUtils
//        Date                                : 
//        Author                              : [x]cube LABS
//        Version                             : 1.0
//
//***************************************************************************************************
//        Class Description: displaying log on logcat
//						
//***************************************************************************************************
//        Update history:
//        Date :                            Developer Name :     Modification Comments :
package com.ocr;

import android.util.Log;

public class LogUtils {

	private static boolean isEnabled = true;

	public static final String CUCKUU_INFO_TAG = "cuckuu_info";
	public static final String CUCKUU_DEBUG_TAG = "cuckuu_debug";
	public static final String CUCKUU_ERROR_TAG = "cuckuu_error";
	public static final String CUCKUU_WARN_TAG = "cuckuu_warn";
	public static final String CUCKUU_VERBOSE_TAG = "cuckuu_verbose";

	// prints message
	public static void message(String cuckuu_msg) {
		if (isEnabled) {
			System.out.println("MSG  " + cuckuu_msg);
		}
	}

	// prints debug msg on logcat
	public static void debugMsg(String cuckuu_msg) {
		if (isEnabled) {
			Log.d(CUCKUU_DEBUG_TAG, cuckuu_msg);
		}
	}

	// prints info msg on logcat
	public static void infoMsg(String cuckuu_msg) {
		if (isEnabled) {
			Log.i(CUCKUU_INFO_TAG, cuckuu_msg);
		}
	}

	// prints error msg on logcat
	public static void errorMsg(String cuckuu_msg) {
		if (isEnabled) {
			Log.e(CUCKUU_ERROR_TAG, cuckuu_msg);
		}
	}

	// prints verbose msg on logcat
	public static void verboseMsg(String cuckuu_msg) {
		if (isEnabled) {
			Log.e(CUCKUU_VERBOSE_TAG, cuckuu_msg);
		}

	}

}