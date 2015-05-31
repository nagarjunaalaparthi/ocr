package com.ocr;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PreviewActvity extends BaseActivity {

	private EditText mPreview;
	private Button mShare;
	private Button mCopy;
	private Button mSave;
	private String text = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actvity_preview);
		getBundleData();
		initViews();
		initListeners();
	}

	private void getBundleData() {
		Bundle bundle = getIntent().getExtras();
		if (bundle != null && bundle.containsKey(KEY_TEXT)) {
			text = bundle.getString(KEY_TEXT);
		}
	}

	private void initViews() {

		mPreview = (EditText) findViewById(R.id.textarea);
		mShare = (Button) findViewById(R.id.share);
		mCopy = (Button) findViewById(R.id.copy);
		mSave = (Button) findViewById(R.id.save);
		mPreview.setText(text);
	}

	private void initListeners() {
		mShare.setOnClickListener(optionClickListener);
		mSave.setOnClickListener(optionClickListener);
		mCopy.setOnClickListener(optionClickListener);
	}

	private OnClickListener optionClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.save:
				insertToDatabase();
				break;
			case R.id.copy:
				copyDateToClipBoard(text);
				break;
			case R.id.share:
				shareText(text);
				break;
			}
		}
	};

	private void insertToDatabase() {
		ContentValues cv = new ContentValues();
		cv.put(TIME, getSavedTime());
		cv.put(TEXT, text);
		dbHelper.insertText(cv);
		Toast.makeText(getBaseContext(), "saved successfully", Toast.LENGTH_LONG).show();
	}

	public static String getSavedTime() {
		try {
			Date date = new Date(System.currentTimeMillis());

			SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a dd:MM:yyyy", Locale.ENGLISH);
			String convertedTime = dateFormat.format(date);
			return convertedTime;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return "";
	}
}
