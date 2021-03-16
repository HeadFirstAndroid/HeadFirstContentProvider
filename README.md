# HeadFirstContentProvider


## 简易实现

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

## 启动

运行日志：
```
I/System.out: HFContentProvider onCreate : me.yifeiyuan.headfirstcontentprovider.App@beb970b
I/System.out: before Application onCreate
I/System.out: after Application onCreate
I/System.out: MainActivity onCreate
```

原来 ContentProvider.onCreate 调用时机比 Application.onCreate 还要早，难怪这么多 SDK 开始用 ContentProvider 来初始化。
