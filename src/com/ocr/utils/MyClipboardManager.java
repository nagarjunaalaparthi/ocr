package com.ocr.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import com.ocr.R;

public class MyClipboardManager {

	private Context context;
	private ClipboardManager clipboard;

	public MyClipboardManager(Context context) {
		this.context = context;
		clipboard = (ClipboardManager) context.getSystemService(context.CLIPBOARD_SERVICE);
	}

	public ClipboardManager getClipBoard() {
		return clipboard;
	}

	public boolean copyTextToClipboard(String text) {
		try {
			int sdk = android.os.Build.VERSION.SDK_INT;
			if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
				clipboard.setText(text);
			} else {
				ClipData clip = ClipData.newPlainText(context.getResources().getString(R.string.copy_message), text);
				clipboard.setPrimaryClip(clip);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void copyImageToClipboard(String imagePath) {
		try {
			int sdk = android.os.Build.VERSION.SDK_INT;
			if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
				clipboard.setText(imagePath);
			} else {
				File fileName = new File(imagePath);
				ClipboardManager mClipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
				ContentValues values = new ContentValues(2);
				values.put(MediaStore.Images.Media.MIME_TYPE, "Image/jpg");
				values.put(MediaStore.Images.Media.DATA, fileName.getAbsolutePath());
				ContentResolver theContent = context.getContentResolver();
				Uri imageUri = theContent.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
				ClipData theClip = ClipData.newUri(context.getContentResolver(), "Image", imageUri);
				mClipboard.setPrimaryClip(theClip);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressLint("NewApi")
	public String readFromClipboard() {
		int sdk = android.os.Build.VERSION.SDK_INT;
		if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
			return clipboard.getText().toString();
		} else {
			// Gets a content resolver instance
			ContentResolver cr = context.getContentResolver();

			// Gets the clipboard data from the clipboard
			ClipData clip = clipboard.getPrimaryClip();
			if (clip != null) {

				String text = null;
				String title = null;

				// Gets the first item from the clipboard data
				ClipData.Item item = clip.getItemAt(0);

				// Tries to get the item's contents as a URI pointing to a note
				Uri uri = item.getUri();

				// If the contents of the clipboard wasn't a reference to a
				// note, then
				// this converts whatever it is to text.
				if (text == null) {
					text = coerceToText(item).toString();
				}
				Toast.makeText(context, text, Toast.LENGTH_LONG).show();
				return text;
			}
		}
		return "";
	}

	@SuppressLint("NewApi")
	public CharSequence coerceToText(ClipData.Item item) {
		// If this Item has an explicit textual value, simply return that.
		CharSequence text = item.getText();
		if (text != null) {
			return text;
		}

		// If this Item has a URI value, try using that.
		Uri uri = item.getUri();
		if (uri != null) {

			// First see if the URI can be opened as a plain text stream
			// (of any sub-type). If so, this is the best textual
			// representation for it.
			FileInputStream stream = null;
			try {
				// Ask for a stream of the desired type.
				AssetFileDescriptor descr = context.getContentResolver().openTypedAssetFileDescriptor(uri, "text/*", null);
				stream = descr.createInputStream();
				InputStreamReader reader = new InputStreamReader(stream, "UTF-8");

				// Got it... copy the stream into a local string and return it.
				StringBuilder builder = new StringBuilder(128);
				char[] buffer = new char[8192];
				int len;
				while ((len = reader.read(buffer)) > 0) {
					builder.append(buffer, 0, len);
				}
				return builder.toString();

			} catch (FileNotFoundException e) {
				// Unable to open content URI as text... not really an
				// error, just something to ignore.

			} catch (IOException e) {
				// Something bad has happened.
				Log.w("ClippedData", "Failure loading text", e);
				return e.toString();

			} finally {
				if (stream != null) {
					try {
						stream.close();
					} catch (IOException e) {
					}
				}
			}

			// If we couldn't open the URI as a stream, then the URI itself
			// probably serves fairly well as a textual representation.
			return uri.toString();
		}

		// Finally, if all we have is an Intent, then we can just turn that
		// into text. Not the most user-friendly thing, but it's something.
		Intent intent = item.getIntent();
		if (intent != null) {
			return intent.toUri(Intent.URI_INTENT_SCHEME);
		}

		// Shouldn't get here, but just in case...
		return "";
	}

}