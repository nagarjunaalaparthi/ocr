//**************************************************************************************************
//**************************************************************************************************
//                                     Copyright (c) 2014 by 
//                                            ALL RIGHTS RESERVED
//**************************************************************************************************
//**************************************************************************************************
//
//        Project name                        : OCR
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

	public static final String OCR_INFO_TAG = "OCR_info";
	public static final String OCR_DEBUG_TAG = "OCR_debug";
	public static final String OCR_ERROR_TAG = "OCR_error";
	public static final String OCR_WARN_TAG = "OCR_warn";
	public static final String OCR_VERBOSE_TAG = "OCR_verbose";

	// prints message
	public static void message(String OCR_msg) {
		if (isEnabled) {
			System.out.println("MSG  " + OCR_msg);
		}
	}

	// prints debug msg on logcat
	public static void debugMsg(String OCR_msg) {
		if (isEnabled) {
			Log.d(OCR_DEBUG_TAG, OCR_msg);
		}
	}

	// prints info msg on logcat
	public static void infoMsg(String OCR_msg) {
		if (isEnabled) {
			Log.i(OCR_INFO_TAG, OCR_msg);
		}
	}

	// prints error msg on logcat
	public static void errorMsg(String OCR_msg) {
		if (isEnabled) {
			Log.e(OCR_ERROR_TAG, OCR_msg);
		}
	}

	// prints verbose msg on logcat
	public static void verboseMsg(String OCR_msg) {
		if (isEnabled) {
			Log.e(OCR_VERBOSE_TAG, OCR_msg);
		}

	}

}