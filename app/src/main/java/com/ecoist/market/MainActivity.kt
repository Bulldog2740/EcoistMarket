package com.ecoist.market

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ecoist.market.domain.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG: String = "MainActivity"

        /**
         * Id = 1 it id of top level categories on the site.
         */
        private const val TOP_LEVEL_CATEGORY_PARENT_ID: Int = 1
    }

    private val categoryRepository: CategoryRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {


            categoryRepository
                .getChildCategoriesOf(TOP_LEVEL_CATEGORY_PARENT_ID)
                .forEach { category ->
                    Log.d(TAG, "Parent category: $category")

                    categoryRepository.getChildCategoriesOf(category.id)
                        .forEach { childCategory ->
                            Log.d(TAG, "\t\tChild category: $childCategory")
                        }
                }
        }
    }
}