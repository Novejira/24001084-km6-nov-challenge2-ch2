package feature.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.suek.databinding.ActivityDetailBinding
import feature.model.Catalog

class DetailActivity : AppCompatActivity() {
    companion object{

        const val EXTRAS_DETAIL_DATA = "EXTRAS_DETAIL_DATA"
        fun startActivity(context: Context, catalog:Catalog){
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRAS_DETAIL_DATA,catalog)
            context.startActivity(intent)
        }

    }

    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getIntentData()
    }

    private fun getIntentData() {
        //receive data
        intent.extras?.getParcelable<Catalog>(EXTRAS_DETAIL_DATA)?.let {
            setProfileImage(it.image)
            setProfileData(it)
        }

    }

    private fun setProfileData(catalog: Catalog) {
        binding.tvName.text = catalog.name
        binding.tvFoodPrice.text = catalog.formattedPrice
        binding.tvFoodDesc.text = catalog.foodDesc
        binding.tvLoca.text = catalog.locaDesc

    }

    private fun setProfileImage(imgResDrawable: Int?) {
        imgResDrawable?.let { binding.ivProfile.setImageResource(it) }

    }
}