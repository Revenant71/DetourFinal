package com.detour.detourfinal

import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import android.widget.TableRow
import android.widget.TextView
import com.detour.detourfinal.databinding.ActivityProductsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Products : AppCompatActivity() {
    private lateinit var bindProducts: ActivityProductsBinding
    private lateinit var DB_DETOUR: DatabaseDetour

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindProducts = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(bindProducts.root)

        DB_DETOUR = DatabaseDetour.getDatabase(this)

    getAll()
    }

    override fun onStart() {
        super.onStart()

        bindProducts.btnBack.setOnClickListener {
            SharedFuncs.goActivity(applicationContext, Home::class.java)
        }
    }

    private fun getAll() {
        val table = bindProducts.tbItems

        CoroutineScope(Dispatchers.IO).launch {
            val contents: List<Item> = DB_DETOUR.detourDao().findAllItem()

            withContext(Dispatchers.Main) {
                for (item in contents) {
                    // row width and height
                    val row = TableRow(this@Products)
                    val layoutParams = TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT
                    )

                    // fill ID column
                    val tvID = TextView(this@Products)
                    tvID.text = item.ID.toString()
                    tvID.gravity = Gravity.CENTER
                    tvID.setPadding(10, 10, 10, 10)

                    // fill name column
                    val tvName = TextView(this@Products)
                    tvName.text = item.name
                    tvName.gravity = Gravity.CENTER
                    tvName.setPadding(10, 10, 10, 10)

                    // fill category column
                    val tvCategory = TextView(this@Products)
                    tvCategory.text = item.category
                    tvCategory.gravity = Gravity.CENTER
                    tvCategory.setPadding(10, 10, 10, 10)

                    // create row
                    row.layoutParams = layoutParams
                    row.addView(tvID)
                    row.addView(tvName)
                    row.addView(tvCategory)

                    table.addView(row)
                }
            }
        }
    }
}
