package com.ocr;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ocr.model.Text;

public class TextListAdapter extends BaseAdapter {

	protected ArrayList<Text> textlist;
	protected Context context;
	private LayoutInflater inflater;

	public TextListAdapter(Context context, ArrayList<Text> textList) {
		this.context = context;
		this.textlist = textList;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	protected void setTextList(ArrayList<Text> textList) {
		this.textlist = textList;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		if (textlist != null) {
			return textlist.size();
		} else {
			return 0;
		}
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.list_item_texts, null);
			viewHolder = new ViewHolder();
			viewHolder.text = (TextView) convertView.findViewById(R.id.text);
			viewHolder.time = (TextView) convertView.findViewById(R.id.time);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		Text text = textlist.get(position);
		viewHolder.text.setText(text.getText());
		viewHolder.time.setText(text.getTime());
		return convertView;
	}

	public class ViewHolder {
		TextView text;
		TextView time;
	}

}
