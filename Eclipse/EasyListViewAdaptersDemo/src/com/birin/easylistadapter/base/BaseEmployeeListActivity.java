/**
 * Copyright 2014-present Biraj Patel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.birin.easylistadapter.base;

import java.util.ArrayList;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.birin.easylistadapter.base.BaseDataListRetainingFragment.DummyDataGeneratorCallback;
import com.birin.easylistadapter.datasetup.Employee;
import com.birin.easylistviewadaptersdemo.R;

public abstract class BaseEmployeeListActivity extends Activity implements
		DummyDataGeneratorCallback {

	protected ListView listView;
	private static final String TAG_RETAINED_FRAGMENT = "retained_fragment";

	protected BaseEmployeeEasyListAdapter listviewAdapter;
	protected BaseDataListRetainingFragment dataRetainingFragment;
	protected LayoutInflater inflater;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		inflater = LayoutInflater.from(getApplicationContext());
		loadRetainedFragment();
		listView = (ListView) findViewById(R.id.list_view);
		listviewAdapter = getListViewAdapter();
		bindAdapterToList();
		addItemsInList(dataRetainingFragment.getListData());
	}

	protected void bindAdapterToList() {
		listView.setAdapter(listviewAdapter);
	}

	private void loadRetainedFragment() {
		FragmentManager fm = getFragmentManager();
		dataRetainingFragment = (BaseDataListRetainingFragment) fm
				.findFragmentByTag(TAG_RETAINED_FRAGMENT);

		// If the Fragment is non-null, then it is currently being
		// retained across a configuration
		// changgenerateSomeDummyDataAndAddToList();e.
		if (dataRetainingFragment == null) {
			dataRetainingFragment = getDataListRetainingFragment();
			fm.beginTransaction()
					.add(dataRetainingFragment, TAG_RETAINED_FRAGMENT).commit();
		}
	}

	protected int getCurrentOrientation() {
		return getResources().getConfiguration().orientation;
	}

	@Override
	public void onNewDummyDataGenerated(ArrayList<Employee> newDataList) {
		addItemsInList(newDataList);
	}

	protected void addItemsInList(ArrayList<Employee> newDataList) {
		if (null != newDataList && newDataList.isEmpty() == false) {
			findViewById(R.id.place_holder_text).setVisibility(View.GONE);
			listView.setVisibility(View.VISIBLE);
			listviewAdapter.addItemsInList(newDataList);
		}
	}

	@Override
	public void onDataGeneratorTaskExecuting() {

	}

	@Override
	public void onDataGeneratorTaskCancelled() {

	}

	protected abstract BaseEmployeeEasyListAdapter getListViewAdapter();

	protected abstract BaseDataListRetainingFragment getDataListRetainingFragment();

}
