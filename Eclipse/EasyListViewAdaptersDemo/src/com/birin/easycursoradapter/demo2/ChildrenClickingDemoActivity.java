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
package com.birin.easycursoradapter.demo2;

import android.os.Bundle;
import android.widget.Toast;

import com.birin.easycursoradapter.base.BaseEmployeeCursorActivity;
import com.birin.easycursoradapter.base.BaseEmployeeEasyCursorAdapter;

public class ChildrenClickingDemoActivity extends BaseEmployeeCursorActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Toast.makeText(getApplicationContext(),
				"Click on any icons to delete row...", Toast.LENGTH_LONG)
				.show();
	}

	@Override
	protected BaseEmployeeEasyCursorAdapter getListViewAdapter() {
		return new ChildrenClickingDemoAdapter(getApplicationContext(), null);
	}

}
