package me.yifeiyuan.headfirstcontentprovider

import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.os.CancellationSignal
import android.os.PersistableBundle
import android.util.Log
import me.yifeiyuan.adh.showcase.AdhShowcaseActivity
import me.yifeiyuan.adh.showcase.AdhShowcaseItem


/**
 *
 * content://authority/path/query
 *
 */

private const val TAG = "MainActivity"

class MainActivity : AdhShowcaseActivity() {

    val uri = Uri.parse("content://me.yifeiyuan.hf.contentprovider.provider")
    val columns = arrayOf("name", "age")  //null 表示全部都查询
    val queryArgs = Bundle().apply {
        putString("name", "程序亦非猿")
    }
    val cancellationSignal = CancellationSignal()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun provideShowcaseItems(): List<AdhShowcaseItem> {

        return listOf(

            /**
             * D/MainActivity: query columnNames : name
             * D/MainActivity: query columnNames : age
             * D/MainActivity: query columnNames : engName
             * D/MainActivity: query: 程序亦非猿 18 Fitz
             * D/MainActivity: query: 路飞 15 Luffy
             * D/MainActivity: query: 佐罗 16 Zoro
             */
            createShowcaseItem("query") {
                //ContextImpl$ApplicationContentResolver
                val uri = Uri.parse("content://me.yifeiyuan.hf.contentprovider.provider")
                val cursor = contentResolver.query(uri, null, null, null, null)

                cursor?.let {

                    for (columnName in cursor.columnNames) {
                        Log.d(TAG, "query columnNames : $columnName")
                    }

                    if (it.moveToFirst()) {
                        do {
                            val name = it.getString(it.getColumnIndex("name"))
                            val age = it.getString(it.getColumnIndex("age"))
                            val engName = it.getString(it.getColumnIndex("engName"))

                            Log.d(TAG, "query: $name $age $engName")

                        } while (it.moveToNext())
                    }

                }

                cursor?.close()
            },

            createShowcaseItem("insert") {},
            createShowcaseItem("delete") {},
            createShowcaseItem("insert") {},

            )
    }


    private fun query(
        uri: Uri,
        columns: Array<String>,
        queryArgs: Bundle,
        cancellationSignal: CancellationSignal
    ) {
        val cursor: Cursor? =
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                contentResolver.query(uri, columns, queryArgs, cancellationSignal)
            } else {
                TODO("VERSION.SDK_INT < O")
            }

        cursor?.close()
    }

}