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
package com.birin.easylistviewadaptersdemo;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.birin.easycursoradapter.datasetup.TestContentProvider;
import com.birin.easycursoradapter.demo1.TwoRowTypesActivity;
import com.birin.easycursoradapter.demo2.ChildrenClickingDemoActivity;
import com.birin.easycursoradapter.demo3.UnlimitedItemsTwoRowTypesActivityAutoloadMore;
import com.birin.easycursoradapter.demo4.UnlimitedItemsTwoRowTypesActivityClickToloadMore;
import com.birin.easylistviewadaptersdemo.common.Constants;

public class CursorDataDemos extends BaseDemoMenuList {

	public static final Demo<?>[] AVAILABLE_DEMOS = {

			// From using Cursor Loader mechanism
			new Demo<TwoRowTypesActivity>(
					"Demo 1 : Two row types + Fixed Items",
					TwoRowTypesActivity.class),
			new Demo<ChildrenClickingDemoActivity>(
					"Demo 2 : Two row types + Easy way to handle children view clicks (to delete items from DB)  ",
					ChildrenClickingDemoActivity.class),
			new Demo<UnlimitedItemsTwoRowTypesActivityAutoloadMore>(
					"Demo 3 : Two row types + Unlimited Items with auto load more.",
					UnlimitedItemsTwoRowTypesActivityAutoloadMore.class),
			new Demo<UnlimitedItemsTwoRowTypesActivityClickToloadMore>(
					"Demo 4 : Two row types + Unlimited Items with click to load more ",
					UnlimitedItemsTwoRowTypesActivityClickToloadMore.class) };

	@Override
	protected Demo<?>[] getDemos() {
		return AVAILABLE_DEMOS;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		findViewById(R.id.clear_db).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new EmployeeDataCleanerTask().execute();
			}
		});

	}

	@Override
	protected int getLayoutId() {
		return R.layout.cursor_demo_menu_screen_layout;
	}

	class EmployeeDataCleanerTask extends AsyncTask<Void, Void, Void> {

		ProgressDialog cleanerProgress;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			cleanerProgress = new ProgressDialog(CursorDataDemos.this);
			cleanerProgress.setCancelable(false);
			cleanerProgress
					.setMessage(getString(R.string.cleaning_employee_table_dialog_msg));
			cleanerProgress.show();
		}

		@Override
		protected Void doInBackground(Void... params) {
			try {
				Thread.sleep(Constants.DUMMY_DELAY_IN_MILLIS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			getContentResolver().delete(
					TestContentProvider.CONTENT_URI_EMPLOYEE, null, null);
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			if (cleanerProgress != null && cleanerProgress.isShowing()) {
				cleanerProgress.dismiss();
			}
		}

	}

}
