package com.ocr;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HomeScreenActivity extends BaseActivity implements OnClickListener {

	private TextView mCaptureText;
	private TextView mUploadText;
	private Button mSavedListButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		initViews();
		initListeners();
		checkSavedList();
	}

	private void initViews() {
		mCaptureText = (TextView) findViewById(R.id.capture_text);
		mUploadText = (TextView) findViewById(R.id.upload_text);
		mSavedListButton = (Button) findViewById(R.id.saved);
	}

	private void initListeners() {
		mCaptureText.setOnClickListener(this);
		mUploadText.setOnClickListener(this);
		mSavedListButton.setOnClickListener(this);
	}

	private void checkSavedList() {
		Cursor cursor = dbHelper.retrieveText();
		if (cursor.getCount() > 0) {
			mSavedListButton.setVisibility(View.VISIBLE);
		} else {
			mSavedListButton.setVisibility(View.GONE);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.capture_text:
			onClickCamera();
			break;
		case R.id.upload_text:
			onClickGallery();
			break;
		case R.id.saved :
			Intent intent = new Intent(this, SavedTextsActivty.class);
			startActivity(intent);
			animationStyle();
			finish();
			break;
		default:
			break;
		}
	}

}
