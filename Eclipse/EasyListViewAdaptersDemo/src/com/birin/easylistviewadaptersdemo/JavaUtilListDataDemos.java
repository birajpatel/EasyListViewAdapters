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
package com.birin.easylistviewadaptersdemo;

import com.birin.easylistadapter.demo1.SimplestEasyListAdapterUsageDemoActivity;
import com.birin.easylistadapter.demo2.SingleRowTypeActivity;
import com.birin.easylistadapter.demo3.TwoRowTypesActivity;
import com.birin.easylistadapter.demo4.ChildrenClickingDemoActivity;
import com.birin.easylistadapter.demo5.UnlimitedItemsTwoRowTypesActivityAutoloadMore;
import com.birin.easylistadapter.demo6.UnlimitedItemsTwoRowTypesActivityAutoloadMoreMax100Items;
import com.birin.easylistadapter.demo7.UnlimitedItemsTwoRowTypesActivityClickToloadMore;

public class JavaUtilListDataDemos extends BaseDemoMenuList {

	public static final Demo<?>[] AVAILABLE_DEMOS = {

			// From java.util.List
			new Demo<SimplestEasyListAdapterUsageDemoActivity>(
					"Demo 1 : Step by step guide for basic usage of EasyListAdapter + supporting multiple Row-Types."
							+ "\n(Recommended for beginner users of EasyListViewAdapters lib )",
					SimplestEasyListAdapterUsageDemoActivity.class),
			new Demo<SingleRowTypeActivity>(
					"Demo 2 : Single row type + Fixed Items",
					SingleRowTypeActivity.class),
			new Demo<TwoRowTypesActivity>(
					"Demo 3 : Two row types + Fixed Items",
					TwoRowTypesActivity.class),
			new Demo<ChildrenClickingDemoActivity>(
					"Demo 4 : Two row types + Easy way to handle children view clicks (to delete items from list)",
					ChildrenClickingDemoActivity.class),
			new Demo<UnlimitedItemsTwoRowTypesActivityAutoloadMore>(
					"Demo 5 : Two row types + Unlimited Items with auto load more.",
					UnlimitedItemsTwoRowTypesActivityAutoloadMore.class),
			new Demo<UnlimitedItemsTwoRowTypesActivityAutoloadMoreMax100Items>(
					"Demo 6 : Two row types + 100 Items with auto load more ",
					UnlimitedItemsTwoRowTypesActivityAutoloadMoreMax100Items.class),
			new Demo<UnlimitedItemsTwoRowTypesActivityClickToloadMore>(
					"Demo 7 : Two row types + Unlimited Items with click to load more ",
					UnlimitedItemsTwoRowTypesActivityClickToloadMore.class) };

	@Override
	protected Demo<?>[] getDemos() {
		return AVAILABLE_DEMOS;
	}

}
