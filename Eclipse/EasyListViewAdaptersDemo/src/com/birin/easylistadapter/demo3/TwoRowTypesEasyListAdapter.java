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
package com.birin.easylistadapter.demo3;

import android.content.Context;

import com.birin.easylistadapter.base.BaseEmployeeEasyListAdapter;
import com.birin.easylistadapter.rows.ProjectManagerListRowViewSetter;
import com.birin.easylistadapter.rows.RegularEmployeeListRowViewSetter;
import com.birin.easylistviewadapters.ListRowViewSetter;

public class TwoRowTypesEasyListAdapter extends BaseEmployeeEasyListAdapter {

	public TwoRowTypesEasyListAdapter(Context context) {
		super(context);
	}

	@Override
	protected ListRowViewSetter<?, ?>[] getListRowViewSetters() {
		Context context = getContext();
		ListRowViewSetter<?, ?>[] rows = {
				new ProjectManagerListRowViewSetter(context),
				new RegularEmployeeListRowViewSetter(context) };
		return rows;
	}

}
