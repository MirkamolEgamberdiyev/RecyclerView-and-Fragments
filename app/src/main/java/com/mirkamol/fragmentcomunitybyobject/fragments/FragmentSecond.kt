package com.mirkamol.fragmentcomunitybyobject.fragments

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.navigation.fragment.navArgs
import com.mirkamol.fragmentcomunitybyobject.R
import org.w3c.dom.Text


class FragmentSecond : Fragment() {

    private val args: FragmentSecondArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = args.secondFragment
        view.findViewById<AppCompatImageView>(R.id.image).setImageResource(data.image)
        view.findViewById<TextView>(R.id.name).text = data.name
        view.findViewById<TextView>(R.id.number).text = data.phoneNumber

//        Toast.makeText(context, "${data.phoneNumber}", Toast.LENGTH_SHORT).show()
    }
}
