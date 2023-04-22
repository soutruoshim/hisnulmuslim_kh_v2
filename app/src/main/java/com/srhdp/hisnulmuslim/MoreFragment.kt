package com.srhdp.hisnulmuslim

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.play.core.review.ReviewInfo
import com.google.android.play.core.review.ReviewManager
import com.google.android.play.core.review.ReviewManagerFactory
import com.google.android.play.core.tasks.Task
import com.srhdp.hisnulmuslim.databinding.FragmentMoreBinding


class MoreFragment : Fragment() {
    private val reviewManager: ReviewManager? = null
    private lateinit var binding: FragmentMoreBinding
    private val titles = arrayOf<String>("អារម្មកថា","ជំនួយ និងផ្តល់មាតិ","ក្រុមអ្នកបកប្រែ","អំពីកម្មវិធី","ចែកចាយកម្មវិធី","វាយតម្លៃកម្មវិធី","កម្មវិធីផ្សេងៗទៀត")
    private val icons = arrayOf<Int>(R.drawable.info, R.drawable.help, R.drawable.people, R.drawable.copyright, R.drawable.share, R.drawable.start,R.drawable.more_verticle)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMoreBinding.bind(view)
        val myListAdapter = MoreListAdpater(this.requireActivity(),titles,icons)
        binding.listview1.adapter = myListAdapter

        binding.listview1.setOnItemClickListener(){ adapterView, view, position, id ->
            val itemAtPos = adapterView.getItemAtPosition(position)
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)
            when(position){
                0 -> findNavController().navigate(
                    R.id.action_moreFragment_to_introFragment,
                )
                1 -> findNavController().navigate(
                    R.id.action_moreFragment_to_feedbackFragment,
                )
                2 -> findNavController().navigate(
                    R.id.action_moreFragment_to_translatorFragment,
                )
                3 -> findNavController().navigate(
                    R.id.action_moreFragment_to_aboutFragment,
                )

                4 -> shareApp(this.requireContext())
                5 -> inAppReview()
                6 -> moreApp()
                else -> {
                    Toast.makeText(activity, "Click on item at $itemAtPos its item id $itemIdAtPos", Toast.LENGTH_LONG).show()
                    Log.d("MYTAG", "Not found")
                }
            }
//            findNavController().navigate(
//                R.id.action_moreFragment_to_introFragment,
//            )
            //Toast.makeText(activity, "Click on item at $itemAtPos its item id $itemIdAtPos", Toast.LENGTH_LONG).show()
        }
    }
    fun shareApp(context: Context) {
        val appPackageName = context.packageName;
        val appName = context.getString(R.string.app_name)
        val shareBodyText = "https://play.google.com/store/apps/details?id=$appPackageName"

        val sendIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TITLE, appName)
            putExtra(Intent.EXTRA_TEXT, shareBodyText)
        }
        context.startActivity(Intent.createChooser(sendIntent, null))
    }
    fun showRateApp() {
        val manager = ReviewManagerFactory.create(this.requireContext())
        val request = manager.requestReviewFlow()
        request.addOnCompleteListener { request ->
            if (request.isSuccessful) {
                // We got the ReviewInfo object
                val reviewInfo = request.result
                val flow = manager.launchReviewFlow(this.requireActivity(), reviewInfo)
                flow.addOnCompleteListener { _ ->
                }
            } else {
                // There was some problem, continue regardless of the result.
                // you can show your own rate dialog alert and redirect user to your app page
                // on play store.
            }
        }
    }
    private fun inAppReview() {
        val reviewManager = ReviewManagerFactory.create(this.requireContext())
        val requestReviewFlow = reviewManager.requestReviewFlow()
        requestReviewFlow.addOnCompleteListener { request ->
            if (request.isSuccessful) {
                // We got the ReviewInfo object
                val reviewInfo = request.result
                val flow = reviewManager.launchReviewFlow(this.requireActivity(), reviewInfo)
                flow.addOnCompleteListener {
                    // The flow has finished. The API does not indicate whether the user
                    // reviewed or not, or even whether the review dialog was shown. Thus, no
                    // matter the result, we continue our app flow.
                }
                Log.d("MYTAG", "Working")
            } else {
                Log.d("Error: ", request.exception.toString())
                // There was some problem, continue regardless of the result.
            }
        }
    }
    private fun moreApp(){
        try {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://play.google.com/store/apps/developer?id=Srh+Dp+Islam&hl=en&gl=US")))
        } catch (e: ActivityNotFoundException) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=Srh+Dp+Islam&hl=en&gl=US")))
        }
    }

}