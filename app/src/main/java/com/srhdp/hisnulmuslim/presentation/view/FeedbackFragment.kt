package com.srhdp.hisnulmuslim.presentation.view

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.srhdp.hisnulmuslim.R
import com.srhdp.hisnulmuslim.databinding.FragmentFeedbackBinding


class FeedbackFragment : Fragment() {
    private lateinit var binding: FragmentFeedbackBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feedback, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFeedbackBinding.bind(view)

        binding.sendEmailBtn.setOnClickListener {
            //get input from EditTexts and save in variables
            val recipient = binding.recipientEt.text.toString().trim()
            val subject = binding.subjectEt.text.toString().trim()
            val message = binding.messageEt.text.toString().trim()

            //method call for email intent with these inputs as parameters
            sendEmail(recipient, subject, message)
        }

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
    @SuppressLint("IntentReset")
    private fun sendEmail(recipient: String, subject: String, message: String) {
        /*ACTION_SEND action to launch an email client installed on your Android device.*/
        val mIntent = Intent(Intent.ACTION_SENDTO)
        /*To send an email you need to specify mailto: as URI using setData() method
        and data type will be to text/plain using setType() method*/
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"
        // put recipient email in intent
        /* recipient is put as array because you may wanna send email to multiple emails
           so enter comma(,) separated emails, it will be stored in array*/
        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
        //put the Subject in the intent
        mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        //put the message in the intent
        mIntent.putExtra(Intent.EXTRA_TEXT, message)


        try {
            //start email intent
            startActivity(Intent.createChooser(mIntent, "Choose Email Client..."))
        }
        catch (e: Exception){
            //if any thing goes wrong for example no email client application or any exception
            //get and show exception message
            Toast.makeText(this.requireContext(), e.message, Toast.LENGTH_LONG).show()
        }
    }

}