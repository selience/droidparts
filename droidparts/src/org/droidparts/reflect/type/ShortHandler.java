/**
 * Copyright 2013 Alex Yanchenko
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package org.droidparts.reflect.type;

import static org.droidparts.util.Arrays2.toPrimitive;

import java.util.ArrayList;

import org.droidparts.reflect.util.TypeHelper;

import android.content.ContentValues;
import android.database.Cursor;

public class ShortHandler extends TypeHandler<Short> {

	@Override
	public boolean canHandle(Class<?> cls) {
		return TypeHelper.isShort(cls);
	}

	@Override
	public String getDBColumnType() {
		return INTEGER;
	}

	@Override
	protected Short parseFromString(Class<Short> cls, String str) {
		return Short.valueOf(str);
	}

	@Override
	public void putToContentValues(ContentValues cv, String key, Short val) {
		cv.put(key, val);
	}

	@Override
	public Short readFromCursor(Class<Short> cls, Cursor cursor, int columnIndex) {
		return cursor.getShort(columnIndex);
	}

	@Override
	public Object parseTypeArr(Class<Short> arrValType, String[] arr) {
		ArrayList<Short> list = parseTypeColl(arrValType, arr);
		Short[] tArr = list.toArray(new Short[list.size()]);
		return (arrValType == short.class) ? toPrimitive(tArr) : tArr;
	}

}