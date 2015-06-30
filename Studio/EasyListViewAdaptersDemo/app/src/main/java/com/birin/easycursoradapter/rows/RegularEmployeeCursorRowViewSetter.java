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
package com.birin.easycursoradapter.rows;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.birin.easycursoradapter.datasetup.TestContentProviderSqlHelper;
import com.birin.easylistviewadapters.CursorRowViewSetter;
import com.birin.easylistviewadapters.Row;
import com.birin.easylistviewadapters.utils.ChildViewsClickHandler;
import com.birin.easylistviewadaptersdemo.R;
import com.birin.easylistviewadaptersdemo.common.CharacterDrawable;
import com.birin.easylistviewadaptersdemo.common.CharacterDrawable.CharacterDrawableInfo;
import com.birin.easylistviewadaptersdemo.common.Constants.EmployeeRowTypes;
import com.birin.easylistviewadaptersdemo.common.RegularEmployeeRowViewHolder;

public class RegularEmployeeCursorRowViewSetter implements
		CursorRowViewSetter<RegularEmployeeRowViewHolder> {

	private LayoutInflater inflater;

	public RegularEmployeeCursorRowViewSetter(Context context) {
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getRowType() {
		return EmployeeRowTypes.REGULAR_EMPLOYEE.ordinal();
	}

	@Override
	public Row<RegularEmployeeRowViewHolder> getNewRow(ViewGroup parent) {
		View rowView = inflater.inflate(R.layout.list_row_regular_employee,
				null);
		RegularEmployeeRowViewHolder rowViewHolder = initViewHolderUsing(rowView);
		return new Row<RegularEmployeeRowViewHolder>(rowView, rowViewHolder);
	}

	@Override
	public void setRowView(Cursor data,
			RegularEmployeeRowViewHolder regularEmployeeRowViewSetter,
			int position) {
		setViews(data, regularEmployeeRowViewSetter);
	}

	@Override
	public void registerChildrenViewClickEvents(
			RegularEmployeeRowViewHolder rowViewHolder,
			ChildViewsClickHandler childViewsClickHandler) {
		// No child registered.
	}

	@Override
	public void onChildViewClicked(View clickedChildView, Cursor rowData,
			int eventId) {
		// No child registered.
	}

	// Helper Methods.

	private RegularEmployeeRowViewHolder initViewHolderUsing(View rowView) {
		rowView.setBackgroundColor(Color.WHITE);
		RegularEmployeeRowViewHolder viewHolder = new RegularEmployeeRowViewHolder();
		viewHolder.imageview = (ImageView) rowView.findViewById(R.id.image);
		CharacterDrawable.tagNewDrawableToImageView(viewHolder.imageview);
		viewHolder.textview = (TextView) rowView.findViewById(R.id.textview);
		return viewHolder;
	}

	private void setViews(Cursor data,
			RegularEmployeeRowViewHolder regularEmployeeRowViewSetter) {
		regularEmployeeRowViewSetter.textview
				.setText(data.getString(data
						.getColumnIndexOrThrow(TestContentProviderSqlHelper.EMPLOYEE_NAME)));
		CharacterDrawableInfo info = new CharacterDrawableInfo();
		info.color = data
				.getInt(data
						.getColumnIndexOrThrow(TestContentProviderSqlHelper.EMPLOYEE_COLUMN_CHAR_COLOR));
		info.newChar = data
				.getString(
						data.getColumnIndexOrThrow(TestContentProviderSqlHelper.EMPLOYEE_COLUMN_CHAR))
				.charAt(0);
		CharacterDrawable.updateTaggedDrawableStateFromImageView(
				regularEmployeeRowViewSetter.imageview, info);
	}

}
