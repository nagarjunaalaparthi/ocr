package com.ocr;

import java.io.File;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;

public class BaseActivity extends Activity {
	private static final int PICK_FROM_CAMERA = 10;
	private static final int PICK_FROM_GALLERY = 11;
	public Uri mImageCaptureUri = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getActionBar().hide();
	}

	public void onClickCamera() {
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		mImageCaptureUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "tmp_profile_" + String.valueOf(System.currentTimeMillis()) + ".jpg"));
		intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mImageCaptureUri);
		try {
			intent.putExtra("return-data", true);
			startActivityForResult(intent, PICK_FROM_CAMERA);
		} catch (ActivityNotFoundException e) {
			e.printStackTrace();
		}
		// Intent cameraintent = new Intent(BaseActivity.this,
		// CameraActivity.class);
		// mImageCaptureUri = Uri.fromFile(new
		// File(Environment.getExternalStorageDirectory(), "tmp_profile_" +
		// String.valueOf(System.currentTimeMillis()) + ".jpg"));
		// // cameraintent.putExtra("return-data", true);
		// startActivityForResult(cameraintent, PICK_FROM_CAMERA);
	}

	/*
	 * open the gallery to set the profile picture
	 */
	public void onClickGallery() {
		Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		intent.setType("image/*");
		startActivityForResult(intent, PICK_FROM_GALLERY);
	}
}
