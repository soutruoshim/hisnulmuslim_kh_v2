package com.srhdp.hisnulmuslim

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.navigation.fragment.findNavController
import com.srhdp.hisnulmuslim.databinding.FragmentTranslatorBinding

class TranslatorFragment : Fragment() {
    private lateinit var binding: FragmentTranslatorBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_translator, container, false)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTranslatorBinding.bind(view)

        binding.webView.settings.javaScriptEnabled = true
        binding.webView.isVerticalScrollBarEnabled=false
        binding.webView.isHorizontalScrollBarEnabled=false

        binding.webView.loadUrl("file:///android_asset/translator/index.html")

        binding.webView.webViewClient = object : WebViewClient() {
            @Deprecated("Deprecated in Java")
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                url?.let { view?.loadUrl(it) }
                return true
            }
        }

        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}