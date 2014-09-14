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

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.Toast;

import com.birin.easycursoradapter.datasetup.TestContentProvider;
import com.birin.easycursoradapter.datasetup.TestContentProviderSqlHelper;
import com.birin.easycursoradapter.rows.ProjectManagerCursorRowViewSetter;
import com.birin.easylistviewadapters.utils.ChildViewsClickHandler;
import com.birin.easylistviewadaptersdemo.common.Constants;
import com.birin.easylistviewadaptersdemo.common.ProjectManagerRowViewHolder;

public class ChildrenClickingProjectManagerRow extends
		ProjectManagerCursorRowViewSetter {

	protected Context context;

	public ChildrenClickingProjectManagerRow(Context context) {
		super(context);
		this.context = context;
	}

	@Override
	public void registerChildrenViewClickEvents(
			ProjectManagerRowViewHolder rowViewHolder,
			ChildViewsClickHandler childViewsClickHandler) {
		childViewsClickHandler.registerChildViewForClickEvent(
				rowViewHolder.imageview, Constants.ICON_CLICK_EVENT_ID);
	}

	@Override
	public void onChildViewClicked(View clickedChildView, Cursor rowData,
			int eventId) {
		switch (eventId) {
		case Constants.ICON_CLICK_EVENT_ID:
			handleIconClick(rowData);
			break;
		default:
			break;
		}
	}

	protected void handleIconClick(Cursor rowData) {
		int id = rowData.getInt(rowData
				.getColumnIndexOrThrow(TestContentProviderSqlHelper.INDEX));
		String where = TestContentProviderSqlHelper.INDEX + " = " + id;
		context.getContentResolver().delete(
				TestContentProvider.CONTENT_URI_EMPLOYEE, where, null);
		Toast.makeText(context, "Project Manager delete Click: " + id,
				Toast.LENGTH_LONG).show();
	}
}
