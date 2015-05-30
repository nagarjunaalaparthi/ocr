package com.ocr;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class HomeScreenActivity extends BaseActivity implements OnClickListener{

	private TextView mCaptureText;
	private TextView mUploadText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		initViews();
		initListeners();
	}


	private void initViews() {
		mCaptureText = (TextView) findViewById(R.id.capture_text);
		mUploadText = (TextView) findViewById(R.id.upload_text);
	}
	private void initListeners() {
		mCaptureText.setOnClickListener(this);
		mUploadText.setOnClickListener(this);
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
		default:
			break;
		}
	}
	
	
}
