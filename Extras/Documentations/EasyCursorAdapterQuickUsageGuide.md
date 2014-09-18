Basic setup classes
===

```java

enum RowTypes {
	ROW_1
}

class ViewHolder1 {
	// To hold views present in Row1.
}

```

Linking your Cursor to ViewHolder in a RowViewSetter class.
====

```java

class RowViewSetter1 implements CursorRowViewSetter<ViewHolder1> {

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
	public void setRowView(Cursor data, ViewHolder1 rowViewHolder, int position) {
		// Update view values using your data & viewHolder.
	}

	@Override
	public void registerChildrenViewClickEvents(ViewHolder1 rowViewHolder,
			ChildViewsClickHandler childViewsClickHandler) {
		// Register for child-view clicks if required.
	}

	@Override
	public void onChildViewClicked(View clickedChildView, Cursor rowData,
			int eventId) {
		// Click events for registerd chilren will be posted here
	}
}

```

Telling adapter about your row.
====

```java
class MyEasyCursorAdapter extends EasyCursorAdapter {

	public MyEasyAdapter(Context context,Cursor c) {
		super(context,Cursor c);
	}

	@Override
	public int getRowViewType(Cursor rowData) {
		// Return correct row type for given data object.
	}

	@Override
	protected CursorRowViewSetter<?, ?>[] getCursorRowViewSetters() {
		// Return all types of rows you want to support.
		CursorRowViewSetter<?, ?>[] rows = { new RowViewSetter1() };
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

class ViewHolder2 {
	// To hold views present in Row2.
}

// Link POJO to ViewHolder
class RowViewSetter2 implements CursorRowViewSetter<ViewHolder2> {
	// Implement methods for this Row2 as shown in RowViewSetter1
}

// Last step is to tell your adapter about your new RowViewSetter class by updating 
CursorRowViewSetter<?, ?>[] rows = { new RowViewSetter1() };
to 
CursorRowViewSetter<?, ?>[] rows = { new RowViewSetter1(), new RowViewSetter2() };

```
Done
====
