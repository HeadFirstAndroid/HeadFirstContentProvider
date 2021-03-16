package me.yifeiyuan.headfirstcontentprovider

import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.os.CancellationSignal
import me.yifeiyuan.adh.showcase.AdhShowcaseActivity
import me.yifeiyuan.adh.showcase.AdhShowcaseItem


/**
 *
 * content://authority/path/query
 *
 */
class MainActivity : AdhShowcaseActivity() {

    val uri = Uri.parse("content://me.yifeiyuan.hf.contentprovider.provider")
    val columns = arrayOf("name", "age")  //null 表示全部都查询
    val queryArgs = Bundle().apply {
        putString("name", "程序亦非猿")
    }
    val cancellationSignal = CancellationSignal()

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        println("MainActivity onCreate")
//
//        query(uri, columns, queryArgs, cancellationSignal)
//    }

    override fun provideShowcaseItems(): List<AdhShowcaseItem> {

        return listOf(

            createShowcaseItem("query") {
                val cursor = contentResolver.query(uri, null, null, null, null)

                cursor?.let {

                    while (!cursor.isLast) {

                        cursor.moveToFirst()

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