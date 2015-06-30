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

import android.content.Context;
import android.database.Cursor;

import com.birin.easycursoradapter.datasetup.TestContentProviderSqlHelper;
import com.birin.easylistviewadapters.EasyCursorAdapter;

public abstract class BaseEmployeeEasyCursorAdapter extends EasyCursorAdapter {

	public BaseEmployeeEasyCursorAdapter(Context context, Cursor c) {
		super(context, c);
	}

	@Override
	public int getRowViewType(Cursor rowData) {
		return rowData
				.getInt(rowData
						.getColumnIndexOrThrow(TestContentProviderSqlHelper.EMPLOYEE_TYPE));
	}

}
