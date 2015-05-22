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
package com.birin.easylistadapter.demo6;

import android.os.Bundle;

import com.birin.easylistadapter.base.BaseDataListRetainingFragment;
import com.birin.easylistadapter.demo5.UnlimitedItemsTwoRowTypesActivityAutoloadMore;

public class UnlimitedItemsTwoRowTypesActivityAutoloadMoreMax100Items extends
		UnlimitedItemsTwoRowTypesActivityAutoloadMore {

	@Override
	protected BaseDataListRetainingFragment getDataListRetainingFragment() {
		BaseDataListRetainingFragment retainedDataFragment = super
				.getDataListRetainingFragment();
		Bundle extraArguments = new Bundle();
		extraArguments.putInt(BaseDataListRetainingFragment.KEY_MAX_ITEMS, 100);
		retainedDataFragment.setArguments(extraArguments);
		return retainedDataFragment;
	}

}
