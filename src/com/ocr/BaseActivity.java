package com.ocr;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.Charset;

import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.json.JSONObject;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;

import com.ocr.model.CloudConnector;
import com.ocr.model.CloudConnector.JSONCallback;
import com.ocr.model.DataBaseHelper;
import com.ocr.utils.MyClipboardManager;
import com.ocr.utils.OCRConstants;

public class BaseActivity extends Activity implements OCRConstants {
	public Uri mImageCaptureUri = null;
	private CloudConnector cloudConnector = null;
	public DataBaseHelper dbHelper = null;
	private Dialog progressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		cloudConnector = new CloudConnector(this);
		getActionBar().hide();
		dbHelper = new DataBaseHelper(this, DATABASE_NAME, null, DATABASE_VERSION);
		progressDialog = new Dialog(BaseActivity.this, R.style.CustomDialogAnimTheme);
		progressDialog.setContentView(R.layout.dialog_progress);
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
	protected void animationStyle() {
		overridePendingTransition(R.anim.anim_push_left_in, R.anim.anim_push_left_out);
	}

	/*
	 * open the gallery to set the profile picture
	 */
	public void onClickGallery() {
		Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
		intent.setType("image/*");
		startActivityForResult(intent, PICK_FROM_GALLERY);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		String picturePath;
		if (requestCode == PICK_FROM_GALLERY && resultCode == RESULT_OK && data != null && data.getData() != null) {
			Uri uri = data.getData();
			picturePath = getPath(uri);
		} else {
			picturePath = mImageCaptureUri.getPath();
		}
		String url = "https://api.idolondemand.com/1/api/sync/ocrdocument/v1";

		File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
		Bitmap b = BitmapFactory.decodeFile(picturePath);
		Bitmap out = Bitmap.createScaledBitmap(b, 640, 960, false);

		File file = new File(dir, "resize.png");
		FileOutputStream fOut;
		try {
			fOut = new FileOutputStream(file);
			out.compress(Bitmap.CompressFormat.PNG, 100, fOut);
			fOut.flush();
			fOut.close();
			b.recycle();
			out.recycle();

		} catch (Exception e) { // TODO
			e.printStackTrace();
		}

		cloudConnector.postMultipart(this, url, getMultiPartEntity(file), new JSONCallback() {

			@Override
			public void getJsonData(byte error, JSONObject data) {
				// TODO Auto-generated method stub

			}
		});
	}

	private MultipartEntity getMultiPartEntity(File file) {
		MultipartEntity signUpEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE, null, Charset.forName("UTF-8"));
		try {
			FileBody fileBody = new FileBody(file, "image/jpeg");
			signUpEntity.addPart("file", fileBody);
			return signUpEntity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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

	public String getPath(Uri uri) {
		String[] filePathColumn = { MediaStore.Images.Media.DATA };

		Cursor cursor = getContentResolver().query(uri, filePathColumn, null, null, null);
		cursor.moveToFirst();
		int columnIndex = cursor.getColumnIndex(filePathColumn[0]);

		return cursor.getString(columnIndex);
	}

	protected void copyDateToClipBoard(String text) {
		MyClipboardManager clipboardManager = new MyClipboardManager(this);
		clipboardManager.copyTextToClipboard(text);
	}
}
