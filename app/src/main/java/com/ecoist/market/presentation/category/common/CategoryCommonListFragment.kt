package com.ecoist.market.presentation.category.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ecoist.market.R
import com.ecoist.market.data.roomdb.CategoryModel
import com.ecoist.market.data.roomdb.RoomCatListAdapter
import org.koin.android.ext.android.inject

class CategoryCommonListFragment : Fragment(),RoomCatListAdapter.Listener {

    private val args: CategoryCommonListFragmentArgs by navArgs()
    private val viewModel: CategoryCommonListViewModel by inject()
    private val categoryListObserver = Observer<List<CategoryModel>>(::handleCategoryList)

    private var recyclerView: RecyclerView? = null
  //  private val adapter = CategoryListAdapter(this)
    private val adapter1 = RoomCatListAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category_main_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView?.adapter = adapter1
        recyclerView?.layoutManager =
            LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)
        viewModel.categoryListLiveDataRoom.observe(viewLifecycleOwner, categoryListObserver)
        viewModel.coffeFilter(args.categoryId)
    }

    override fun onClick1(category: CategoryModel) {
        val action =
            CategoryCommonListFragmentDirections.actionCategoryCommonListFragmentToProductListFragment(
                category
            )
        findNavController().navigate(action)
    }

    private fun handleCategoryList(categoryList: List<CategoryModel>?) {
        if (categoryList == null) return
        adapter1.submitList(categoryList)
    }
}