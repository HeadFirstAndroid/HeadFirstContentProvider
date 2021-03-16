package me.yifeiyuan.headfirstcontentprovider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.UriMatcher
import android.content.pm.ProviderInfo
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri
import android.util.Log
import me.yifeiyuan.adh.AdhLogger
import java.lang.NullPointerException

/**
 * Created by 程序亦非猿 on 2020/10/15.
 */

private const val TAG = "HFContentProvider"

class HFContentProvider : ContentProvider() {

    val uriMatcher = UriMatcher(UriMatcher.NO_MATCH).apply {
        addURI("","",1)
    }

    val columns = arrayOf("name","age","engName")

    override fun onCreate(): Boolean {
        Log.d(TAG, "onCreate() called: $context")
        return false
    }

    /**
     *
     */
    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor {

        Log.d(
            TAG,
            "query() called with: uri = $uri, projection = $projection, selection = $selection, selectionArgs = $selectionArgs, sortOrder = $sortOrder"
        )

        val cursor = MatrixCursor(columns)

        cursor.addRow(arrayOf("程序亦非猿","18","Fitz"))
        cursor.addRow(arrayOf("路飞","15","Luffy"))
        cursor.addRow(arrayOf("佐罗","16","Zoro"))

        return cursor
    }

    override fun getType(uri: Uri): String? {
        Log.d(TAG, "getType() called with: uri = $uri")
        return null
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        Log.d(TAG, "insert() called with: uri = $uri, values = $values")
        return null
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        Log.d(
            TAG,
            "delete() called with: uri = $uri, selection = $selection, selectionArgs = $selectionArgs"
        )
        return 0
    }

    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        Log.d(
            TAG,
            "update() called with: uri = $uri, values = $values, selection = $selection, selectionArgs = $selectionArgs"
        )
        return 0
    }
}