package com.ocr;

import java.util.ArrayList;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.ocr.model.Text;

public class SavedTextsActivty extends BaseActivity {

	private ListView mSavedTextsListView;
	private Cursor savedTextsCursor;
	private View mTextOptionsView;
	private Button mDelete;
	private Button mCopy;
	private Button mShare;
	private ArrayList<Text> textlist = new ArrayList<Text>();
	private int textPosition = -1;
	private TextListAdapter savedTextAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_saved_list);
		initViews();
		initListeners();
		getSavedTexts();
	}

	private void initViews() {
		mSavedTextsListView = (ListView) findViewById(R.id.savedlist);
		savedTextAdapter = new TextListAdapter(getBaseContext(), textlist);
		mSavedTextsListView.setAdapter(savedTextAdapter);
		mTextOptionsView = (View) findViewById(R.id.textoptions);
		mShare = (Button) findViewById(R.id.share);
		mCopy = (Button) findViewById(R.id.copy);
		mDelete = (Button) findViewById(R.id.save);
		mDelete.setText(getString(R.string.delete));
	}

	private void initListeners() {
		mSavedTextsListView.setOnItemClickListener(listItemClickListener);
		mShare.setOnClickListener(optionListener);
		mCopy.setOnClickListener(optionListener);
		mDelete.setOnClickListener(optionListener);
	}

	private void getSavedTexts() {
		savedTextsCursor = dbHelper.retrieveText();
		textlist = new ArrayList<Text>();
		if (savedTextsCursor != null && savedTextsCursor.getCount() > 0) {
			for (int i = 0; i < savedTextsCursor.getCount(); i++) {
				savedTextsCursor.moveToPosition(i);
				Text text = new Text();
				String savedText = savedTextsCursor.getString(savedTextsCursor.getColumnIndex(TEXT));
				String time = savedTextsCursor.getString(savedTextsCursor.getColumnIndex(TIME));
				String id = savedTextsCursor.getString(savedTextsCursor.getColumnIndex(KEY_ID));
				text.setText(savedText);
				text.setTime(time);
				text.setId(id);
				textlist.add(text);
			}
		}
		savedTextAdapter.setTextList(textlist);
	}

	protected void setVisibilityWithAnimation(int visibility) {
		mTextOptionsView.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
		int height = mTextOptionsView.getMeasuredHeight();
		if (visibility == View.VISIBLE) {
			TranslateAnimation animation = animateView(0, 0, height, 0, 500, true, null);
			mTextOptionsView.setAnimation(animation);
			mTextOptionsView.setVisibility(View.VISIBLE);
		} else {
			TranslateAnimation animation = animateView(0, 0, 0, height, 500, true, null);
			mTextOptionsView.setAnimation(animation);
			mTextOptionsView.setVisibility(View.GONE);
		}
	}

	private OnClickListener optionListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (textPosition != -1) {
				switch (v.getId()) {
				case R.id.save:
					deleteFromDB(textlist.get(textPosition).getId());
					break;
				case R.id.copy:
					copyDateToClipBoard(textlist.get(textPosition).getText());
					break;
				case R.id.share:
					shareText(textlist.get(textPosition).getText());
					break;
				}
			}
			setVisibilityWithAnimation(View.GONE);
		}
	};
	private void deleteFromDB(String id) {
		dbHelper.delete(id);
		getSavedTexts();
	}
	private OnItemClickListener listItemClickListener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			textPosition = position;
			if (mTextOptionsView.isShown()) {
				setVisibilityWithAnimation(View.GONE);
			} else {
				setVisibilityWithAnimation(View.VISIBLE);
			}
		}
	};
}
