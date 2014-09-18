Defining POJO Classes
===

```java

enum RowTypes {
	ROW_1
}

class RowParent {
	// Parent Class for all rows.
}

class Row1 extends RowParent {
	// Child-1
}

class ViewHolder1 {
	// To hold views present in Row1.
}

```
Linking your POJO to ViewHolder in a RowViewSetter class.
====

```java

class RowViewSetter1 implements ListRowViewSetter<Row1, ViewHolder1> {

	@Override
	public int getRowType() {
		// return unique row type identifier (0-based)
		return RowTypes.ROW_1.ordinal();
	}

	@Override
	public Row<ViewHolder1> getNewRow(ViewGroup parent) {
		// 1.Create Row programmatically (can be created by XML as well.)
		// 2.Setting up row view holder.
		return new Row<ViewHolder1>(view, viewHolder);
	}

	@Override
	public void setRowView(Row1 data, ViewHolder1 rowViewHolder, int position) {
		// Update view values using your data & viewHolder.
	}

	@Override
	public void registerChildrenViewClickEvents(ViewHolder1 rowViewHolder,
			ChildViewsClickHandler childViewsClickHandler) {
		// Register for child-view clicks if required.
	}

	@Override
	public void onChildViewClicked(View clickedChildView, Row1 rowData,
			int eventId) {
		// Click events for registerd chilren will be posted here
	}
}

```

Telling adapter about your row.
====

```java
class MyEasyListAdapter extends EasyListAdapter<RowParent> {

	public MyEasyAdapter(Context context) {
		super(context);
	}

	@Override
	public int getRowViewType(RowParent rowData) {
		// Return correct row type for given data object.
	}

	@Override
	protected ListRowViewSetter<?, ?>[] getListRowViewSetters() {
		// Return all types of rows you want to support.
		ListRowViewSetter<?, ?>[] rows = { new RowViewSetter1() };
		return rows;
	}
}
```

Adding new row becomes simple as shown below
====

```java

//Update RowTypes Enum
enum RowTypes {
	ROW_1,ROW_2
}

// Create New POJO & View Holder
class Row2 extends RowParent {
	// Child-2
}

class ViewHolder2 {
	// To hold views present in Row2.
}

// Link POJO to ViewHolder
class RowViewSetter2 implements ListRowViewSetter<Row2, ViewHolder2> {
	// Implement methods for this Row2 as shown in RowViewSetter1
}

// Last step is to tell your adapter about your new RowViewSetter class by updating 
ListRowViewSetter<?, ?>[] rows = { new RowViewSetter1() };
to 
ListRowViewSetter<?, ?>[] rows = { new RowViewSetter1(), new RowViewSetter2() };

```
Done
====
