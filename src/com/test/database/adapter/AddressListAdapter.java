package com.test.database.adapter;

import java.util.List;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.test.database.activity.R;
import com.test.database.model.AddressInfo;

public class AddressListAdapter extends BaseAdapter{
	
	private Context mContext;
	private List<AddressInfo> mInfos;

	public AddressListAdapter(Context mContext, List<AddressInfo> mInfos) {
		this.mContext = mContext;
		this.mInfos = mInfos;
	}

	@Override
	public int getCount() {
		return mInfos == null ? 0 : mInfos.size();
	}

	@Override
	public AddressInfo getItem(int position) {
		return mInfos.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		AddressInfo info = getItem(position);
		ListHolder vHolder;
		
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.adapter_address_list_item, null);
			vHolder = new ListHolder();
			
			vHolder.addr = (TextView) convertView.findViewById(R.id.addr_list_info);
			
			convertView.setTag(vHolder);
			
		}else {
			vHolder = (ListHolder) convertView.getTag();
		}
		if (!TextUtils.isEmpty(info.getAddrDetail())) {
			vHolder.addr.setText(info.getAddrDetail());
		}
		
		return convertView;
	}
	
	public class ListHolder{
		public TextView addr;
	}

}
