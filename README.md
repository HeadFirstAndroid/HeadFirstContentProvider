# HeadFirstContentProvider


ContentProvider.onCreate 调用时机比 Application.onCreate 还要早。

```kotlin
class HFContentProvider : ContentProvider() {

    override fun onCreate(): Boolean {
        println("HFContentProvider onCreate : $context")
        return false
    }

    override fun query(
        p0: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        return null
    }

    override fun getType(p0: Uri): String? {
        return null
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        return null
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        return 0
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        return 0
    }
}
```

清单：
```xml
<provider
    android:authorities="${applicationId}.hf.content.provider"
    android:name=".HFContentProvider"
    android:exported="false"
    />
```