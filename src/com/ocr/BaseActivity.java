package com.ocr;

import java.io.File;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;

import com.ocr.model.DataBaseHelper;
import com.ocr.utils.OCRConstants;

public class BaseActivity extends Activity implements OCRConstants {
	public Uri mImageCaptureUri = null;
	public DataBaseHelper dbHelper = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getActionBar().hide();
		dbHelper = new DataBaseHelper(this, DATABASE_NAME, null, DATABASE_VERSION);
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
	}

	/*
	 * open the gallery to set the profile picture
	 */
	public void onClickGallery() {
		Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		intent.setType("image/*");
		startActivityForResult(intent, PICK_FROM_GALLERY);
	}

	protected void shareText(String text) {

		// get available share intents
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.setType("text/plain");
		emailIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, text);
		startActivity(Intent.createChooser(emailIntent, "Share with"));
	}
	
	public static TranslateAnimation animateView(float fromX, float toX, float fromY, float toY, long duration, boolean fillAfter, AnimationListener animationListener) {
		TranslateAnimation translateAnimation = null;
		translateAnimation = new TranslateAnimation(fromX, toX, fromY, toY);
		translateAnimation.setDuration(duration);
		translateAnimation.setFillAfter(fillAfter);
		translateAnimation.setAnimationListener(animationListener);
		return translateAnimation;
	}
}
