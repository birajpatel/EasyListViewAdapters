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
package com.birin.easycursoradapter.demo1;

import android.content.Context;
import android.database.Cursor;

import com.birin.easycursoradapter.base.BaseEmployeeEasyCursorAdapter;
import com.birin.easycursoradapter.rows.ProjectManagerCursorRowViewSetter;
import com.birin.easycursoradapter.rows.RegularEmployeeCursorRowViewSetter;
import com.birin.easylistviewadapters.CursorRowViewSetter;

public class TwoRowTypesEasyCursorAdapter extends BaseEmployeeEasyCursorAdapter {

	public TwoRowTypesEasyCursorAdapter(Context context, Cursor c) {
		super(context, c);
	}

	@Override
	protected CursorRowViewSetter<?>[] getCursorRowViewSetters() {
		Context context = getContext();
		CursorRowViewSetter<?>[] rows = {
				new ProjectManagerCursorRowViewSetter(context),
				new RegularEmployeeCursorRowViewSetter(context) };
		return rows;
	}

}
