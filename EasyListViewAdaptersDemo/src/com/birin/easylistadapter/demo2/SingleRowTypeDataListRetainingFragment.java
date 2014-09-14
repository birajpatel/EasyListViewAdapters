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
package com.birin.easylistadapter.demo2;

import java.util.ArrayList;

import com.birin.easylistadapter.base.BaseDataListRetainingFragment;
import com.birin.easylistadapter.datasetup.Employee;
import com.birin.easylistadapter.datasetup.ProjectManager;

public class SingleRowTypeDataListRetainingFragment extends
		BaseDataListRetainingFragment {

	protected ArrayList<Employee> generateNewDummyDataAndAddToList() {
		int currentSize = listData.size();
		ArrayList<Employee> newDummyData = new ArrayList<Employee>();
		for (int i = currentSize; i < (currentSize + 20); i++) {
			newDummyData.add(new ProjectManager(i));
		}
		listData.addAll(newDummyData);
		return newDummyData;
	}

}
