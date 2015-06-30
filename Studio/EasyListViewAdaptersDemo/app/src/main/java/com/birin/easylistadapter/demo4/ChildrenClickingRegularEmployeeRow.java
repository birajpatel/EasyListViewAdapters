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
package com.birin.easylistadapter.demo4;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.birin.easylistadapter.datasetup.RegularEmployee;
import com.birin.easylistadapter.rows.RegularEmployeeListRowViewSetter;
import com.birin.easylistviewadapters.utils.ChildViewsClickHandler;
import com.birin.easylistviewadaptersdemo.common.Constants;
import com.birin.easylistviewadaptersdemo.common.RegularEmployeeRowViewHolder;

public class ChildrenClickingRegularEmployeeRow extends
		RegularEmployeeListRowViewSetter {

	protected Context context;
	protected EmployeeDataDeleter deleter;

	public ChildrenClickingRegularEmployeeRow(Context context) {
		super(context);
		this.context = context;
		if (this.context instanceof EmployeeDataDeleter) {
			this.deleter = (EmployeeDataDeleter) context;
		}
	}

	@Override
	public void registerChildrenViewClickEvents(
			RegularEmployeeRowViewHolder rowViewHolder,
			ChildViewsClickHandler childViewsClickHandler) {
		childViewsClickHandler.registerChildViewForClickEvent(
				rowViewHolder.imageview, Constants.ICON_CLICK_EVENT_ID);
	}

	@Override
	public void onChildViewClicked(View clickedChildView,
			RegularEmployee rowData, int eventId) {
		switch (eventId) {
		case Constants.ICON_CLICK_EVENT_ID:
			handleIconClick(rowData);
			break;

		default:
			break;
		}
	}

	protected void handleIconClick(RegularEmployee rowData) {
		Toast.makeText(context,
				"Regular Employee delete Click: " + rowData.getEmployeeName(),
				Toast.LENGTH_LONG).show();
		deleter.deleteItem(rowData);
	}
}
