package com.mirkamol.fragmentcomunitybyobject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mirkamol.fragmentcomunitybyobject.R
import com.mirkamol.fragmentcomunitybyobject.adapter.CustomAdapter
import com.mirkamol.fragmentcomunitybyobject.model.User


class FragmentFirst : Fragment(), CustomAdapter.OnItemClickListener {
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_first, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.apply {
            layoutManager=LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter=CustomAdapter(prepareUserList(), this@FragmentFirst)
        }
    }

    private fun prepareUserList(): List<User> {
        val users = ArrayList<User>()
        for (i in 0..50) {
            users.add(User("Mirkamol", "+998974697907", R.drawable.img))
        }
        return users
    }

    override fun clicked(user: User) {
        val action=FragmentFirstDirections.actionFragmentFirstToFragmentSecond(user)
        findNavController().navigate(action)
    }

}

