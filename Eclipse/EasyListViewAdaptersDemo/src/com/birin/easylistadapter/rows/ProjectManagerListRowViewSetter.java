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
package com.birin.easylistadapter.rows;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.birin.easylistadapter.datasetup.ProjectManager;
import com.birin.easylistviewadapters.ListRowViewSetter;
import com.birin.easylistviewadapters.Row;
import com.birin.easylistviewadapters.utils.ChildViewsClickHandler;
import com.birin.easylistviewadaptersdemo.R;
import com.birin.easylistviewadaptersdemo.common.CharacterDrawable;
import com.birin.easylistviewadaptersdemo.common.CharacterDrawable.CharacterDrawableInfo;
import com.birin.easylistviewadaptersdemo.common.Constants.EmployeeRowTypes;
import com.birin.easylistviewadaptersdemo.common.ProjectManagerRowViewHolder;

public class ProjectManagerListRowViewSetter implements
		ListRowViewSetter<ProjectManager, ProjectManagerRowViewHolder> {

	private LayoutInflater inflater;

	public ProjectManagerListRowViewSetter(Context context) {
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getRowType() {
		return EmployeeRowTypes.PROJECT_MANAGER.ordinal();
	}

	@Override
	public Row<ProjectManagerRowViewHolder> getNewRow(ViewGroup parent) {
		View rowView = inflater
				.inflate(R.layout.list_row_project_manager, null);
		ProjectManagerRowViewHolder rowViewHolder = initViewHolderUsing(rowView);
		return new Row<ProjectManagerRowViewHolder>(rowView, rowViewHolder);
	}

	@Override
	public void setRowView(ProjectManager data,
			ProjectManagerRowViewHolder projectManagerRowViewHolder,
			int position) {
		setViews(data, projectManagerRowViewHolder);
	}

	@Override
	public void registerChildrenViewClickEvents(
			ProjectManagerRowViewHolder rowViewHolder,
			ChildViewsClickHandler childViewsClickHandler) {
		// No child registered.
	}

	@Override
	public void onChildViewClicked(View clickedChildView,
			ProjectManager rowData, int eventId) {
		// No child registered.
	}

	// Helper Methods.

	private ProjectManagerRowViewHolder initViewHolderUsing(View rowView) {
		rowView.setBackgroundColor(Color.LTGRAY);
		ProjectManagerRowViewHolder viewHolder = new ProjectManagerRowViewHolder();
		viewHolder.imageview = (ImageView) rowView.findViewById(R.id.image);
		CharacterDrawable.tagNewDrawableToImageView(viewHolder.imageview);
		viewHolder.textview = (TextView) rowView.findViewById(R.id.textview);
		return viewHolder;
	}

	private void setViews(ProjectManager data,
			ProjectManagerRowViewHolder projectManagerRowViewHolder) {
		projectManagerRowViewHolder.textview.setText(data.getEmployeeName());
		CharacterDrawableInfo info = new CharacterDrawableInfo();
		info.color = data.getIconCharColor();
		info.newChar = data.getIconChar();
		CharacterDrawable.updateTaggedDrawableStateFromImageView(
				projectManagerRowViewHolder.imageview, info);
	}

}
