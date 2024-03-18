package feature.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.catnip.layoutingexample.layoutingexample.model.Food
import com.example.suek.databinding.FragmentFoodDetailBinding

class FoodDetailFragment : Fragment() {
    private lateinit var binding: FragmentFoodDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFoodDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgumentData()

    }

    private fun getArgumentData() {
        val item = arguments?.getParcelable<Food>(EXTRAS_ITEM)
        Toast.makeText(requireContext(), item?.name, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val EXTRAS_ITEM = "EXTRAS_ITEM"

        }
    }
