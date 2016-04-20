package com.test.database.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.test.database.adapter.AddressListAdapter;
import com.test.database.constant.Constant;
import com.test.database.db.address.AddressDBManager;
import com.test.database.model.AddressInfo;

/**
 * 简单的数据库demo
 * 用数据库把地址信息存起来，然后做一个简易的搜索地址功能
 * @author Rayls
 *
 */
public class MainActivity extends Activity {
	
	private AddressDBManager mAddrDBManager;
	private AddressListAdapter mListAdapter;
	
	private ListView mAddrList;
	private EditText mInputEt;
	
	private List<AddressInfo> mInfos = new ArrayList<AddressInfo>();
	List<ContentValues> mValues = new ArrayList<ContentValues>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mAddrDBManager = new AddressDBManager(MainActivity.this);
        initData();
        initUI();
    }

	private void initData() {
		mInfos = mAddrDBManager.getAddressInfosFromDB();
		if (mInfos.isEmpty()) {
			for (int i = 0; i < 10; i++) {
				AddressInfo info = new AddressInfo();
				if (i % 2 == 0) {
					info.setAddrDetail("深圳市南山区南山"+i+"路"+(i*2+1)+"号");
					info.setAddrPinyin("shenzhenshi");
				}else {
					info.setAddrDetail("惠州市惠城区河南岸"+i+"路"+(i*2+1)+"号");
					info.setAddrPinyin("huizhoushi");
				}
				
				mInfos.add(info);
			}
			
			for (AddressInfo info : mInfos) {
				ContentValues value = new ContentValues();
				value.put(Constant.TABLE_COLUMN_ADDRDETAIL, info.getAddrDetail());
				value.put(Constant.TABLE_COLUMN_PINYIN, info.getAddrPinyin());
				mValues.add(value);
			}
			
			mAddrDBManager.Add(mValues);
		}
		
	}

	private void initUI() {
		mAddrList = (ListView) findViewById(R.id.search_result_list);
//		mAddrList.setVisibility(View.INVISIBLE);
		mListAdapter = new AddressListAdapter(MainActivity.this, mInfos);
		mAddrList.setAdapter(mListAdapter);
		
		mInputEt = (EditText) findViewById(R.id.search_edit);
		mInputEt.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				String str = mInputEt.getText().toString().trim();
				
				if (!mInfos.isEmpty()) {
					mInfos.clear();
				}
				List<AddressInfo> infos = new ArrayList<AddressInfo>();
				infos = mAddrDBManager.queryAddressInfoFromSearch(str);
				mInfos.addAll(infos);
				mListAdapter.notifyDataSetChanged();
			}
		});
		
		
	}
}
