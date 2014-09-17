EasyListViewAdapters
====================

Whenever you want to display custom items in listview, then only way to achieve this is to implement your own subclass of BaseAdapter, handle all rendering, recycling, click handling ,data browsing youself in getView() method. It becomes very messy as number of rows increase in your adapter, Making your code very messy & non-reusable. This library allows you to make Modular classes which will help you to introduce new row type easily.

This library is designed on [ViewHolder] (http://developer.android.com/training/improving-layouts/smooth-scrolling.html#ViewHolder) design pattern, it provides an easier way of linking multiple type rows and their underlying data. The EasyAdapters will do most of tedious work for you & all you have to do is create your small modular classes & link them together. 


Debugging 
=========

See the **[Debugging Exceptions](/Extras/Documentations/debugging_exceptions.txt)** to know about all Exceptions thrown by library & how to fix them.

License
=======
   Copyright 2014-present Biraj Patel

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

