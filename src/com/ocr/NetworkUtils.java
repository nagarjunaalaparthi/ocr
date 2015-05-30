//**************************************************************************************************
//**************************************************************************************************
//                                     Copyright (c) 2014 by 
//                                            ALL RIGHTS RESERVED
//**************************************************************************************************
//**************************************************************************************************
//
//        Project name                        : Cuckuu
//        Class Name                          : NetworkUtils
//        Date                                : 
//        Author                              : [x]cube LABS
//        Version                             : 1.0
//
//***************************************************************************************************
//        Class Description: checks network status
//						
//***************************************************************************************************
//        Update history:
//        Date :                            Developer Name :     Modification Comments :
package com.ocr;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtils {

	public static boolean isNetworkAvailable(Context context) {
		ConnectivityManager connection = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo nInfo = null;
		if (connection != null) {
			nInfo = connection.getActiveNetworkInfo();
		}
		if (nInfo == null || !nInfo.isConnectedOrConnecting()) {
			return false;
		}

		if (nInfo == null || !nInfo.isConnected()) {
			return false;
		}
		if (nInfo != null
				&& ((nInfo.getType() == ConnectivityManager.TYPE_MOBILE) || (nInfo
						.getType() == ConnectivityManager.TYPE_WIFI))) {
			if (nInfo.getState() != NetworkInfo.State.CONNECTED
					|| nInfo.getState() == NetworkInfo.State.CONNECTING) {
				return false;
			}
		}
		return true;
	}

}
