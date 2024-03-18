package feature.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.catnip.layoutingexample.layoutingexample.data.FoodDataSource
import com.catnip.layoutingexample.layoutingexample.data.FoodDataSourceImpl
import com.catnip.layoutingexample.layoutingexample.model.Food
import com.catnip.layoutingexample.layoutingexample.presentation.foodlist.adapter.FoodAdapter
import com.catnip.layoutingexample.layoutingexample.presentation.foodlist.adapter.OnItemClickedListener
import com.example.suek.R
import com.example.suek.databinding.FragmentFoodListBinding
import feature.detail.FoodDetailFragment

class FoodListFragment : Fragment() {

    private lateinit var binding: FragmentFoodListBinding
    private var adapter: FoodAdapter? = null
    private val dataSource: FoodDataSource by lazy { FoodDataSourceImpl() }
    private var isUsingGridMode: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFoodListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindFoodList(isUsingGridMode)
        setClickAction()
    }

    private fun setClickAction() {
        binding.btnChangeListMode.setOnClickListener {
            isUsingGridMode = !isUsingGridMode
            setButtonText(isUsingGridMode)
            bindFoodList(isUsingGridMode)
        }
    }

    private fun setButtonText(usingGridMode: Boolean) {
        val textResId = if (usingGridMode) R.string.text_list_mode else R.string.text_grid_mode
        binding.btnChangeListMode.setText(textResId)
    }


    private fun bindFoodList(isUsingGrid: Boolean) {
        val listMode = if (isUsingGrid) FoodAdapter.MODE_GRID else FoodAdapter.MODE_LIST
        adapter = FoodAdapter(
            listMode = listMode,
            listener = object : OnItemClickedListener<Food> {
                override fun onItemClicked(item: Food) {
                    //navigate to detail
                    navigateToDetail(item)
                }
            })
        binding.rvFoodList.apply {
            adapter = this@FoodListFragment.adapter
            layoutManager = GridLayoutManager(requireContext(), if (isUsingGrid) 2 else 1)
        }
        adapter?.submitData(dataSource.getFoodMembers())
    }

    private fun navigateToDetail(item: Food) {
        val navController = findNavController()
        val bundle = bundleOf(Pair(FoodDetailFragment.EXTRAS_ITEM, item))
        navController.navigate(R.id.action_FoodListFragment_to_FoodDetailFragment, bundle)
    }

}