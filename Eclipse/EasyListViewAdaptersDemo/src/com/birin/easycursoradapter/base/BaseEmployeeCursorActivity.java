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
package com.birin.easycursoradapter.base;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.birin.easycursoradapter.datasetup.CursorRetainingFragment;
import com.birin.easycursoradapter.datasetup.TestContentProvider;
import com.birin.easylistviewadaptersdemo.R;

public abstract class BaseEmployeeCursorActivity extends Activity implements
		LoaderCallbacks<Cursor> {

	protected ListView listView;
	private static final String TAG_RETAINED_FRAGMENT = "retained_fragment";

	protected BaseEmployeeEasyCursorAdapter listviewAdapter;
	protected CursorRetainingFragment dataRetainingFragment;
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
		getLoaderManager().initLoader(0, null, this);
	}

	protected void bindAdapterToList() {
		listView.setAdapter(listviewAdapter);
	}

	private void loadRetainedFragment() {
		FragmentManager fm = getFragmentManager();
		dataRetainingFragment = (CursorRetainingFragment) fm
				.findFragmentByTag(TAG_RETAINED_FRAGMENT);

		// If the Fragment is non-null, then it is currently being
		// retained across a configuration
		// changgenerateSomeDummyDataAndAddToList();e.
		if (dataRetainingFragment == null) {
			dataRetainingFragment = getCursorRetainingFragment();
			if (dataRetainingFragment != null) {
				fm.beginTransaction()
						.add(dataRetainingFragment, TAG_RETAINED_FRAGMENT)
						.commit();
			}
		}
	}

	protected CursorRetainingFragment getCursorRetainingFragment() {
		return new CursorRetainingFragment();
	}

	@Override
	public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
		return new CursorLoader(getApplicationContext(),
				TestContentProvider.CONTENT_URI_EMPLOYEE, null, null, null,
				null);
	}

	@Override
	public void onLoadFinished(Loader<Cursor> arg0, Cursor data) {
		if (null != data && data.getCount() > 0) {
			findViewById(R.id.place_holder_text).setVisibility(View.GONE);
			listView.setVisibility(View.VISIBLE);
			listviewAdapter.swapCursor(data);
		}
	}

	@Override
	public void onLoaderReset(Loader<Cursor> arg0) {
		listviewAdapter.swapCursor(null);
	}

	protected abstract BaseEmployeeEasyCursorAdapter getListViewAdapter();

}
