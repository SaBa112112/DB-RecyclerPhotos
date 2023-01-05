package com.example.dbrecyclerphotos.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dbrecyclerphotos.R
import com.example.dbrecyclerphotos.adapters.Adapter
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class Fragment_2: Fragment(R.layout.fragment_2) {
    private lateinit var recyclerView: RecyclerView

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseDatabase.getInstance().getReference("USER_INFO")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerview)


        var list = mutableListOf(
            Views("https://www.rollingstone.com/wp-content/uploads/2012/11/LedZeppelin.jpg?w=1581&h=1054&crop=1","LEd ZEPPELIN"),
            Views("https://media.npr.org/assets/img/2020/10/06/gettyimages-74299482_wide-5ac106c73086aa63c495089c35f4811d0bb1ce5b-s800-c85.webp","VAN HALLEN"),
            Views("https://cdn.britannica.com/52/175552-050-3090FE37/Kirk-Hammett-James-Hetfield-Metallica-2013.jpg","METALLICA"),
            Views("https://www.metaledgemag.com/.image/ar_4:3%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cq_auto:good%2Cw_1200/MTg5MDU2NzU5MjI1MTMyODcz/pantera-1997.jpg","PANTERA"),
            Views("https://www.billboard.com/wp-content/uploads/2022/09/megadeth-billboard-pro-b-1260.jpg?w=606&h=404&crop=1","MEGADETH"),
            Views("https://upload.wikimedia.org/wikipedia/en/thumb/d/d6/Pink_Floyd_-_all_members.jpg/250px-Pink_Floyd_-_all_members.jpg","PINK FLOYD"),
            Views("https://www.photoshelter.com/img-get/I0000ubKKEeqrLW0/s/600","AVENGED SEVENFOLD"),
            Views("https://ychef.files.bbci.co.uk/976x549/p0278f0f.jpg","JIMI HENDRIX"),
            //Views(PersonInfo().name,PersonInfo().url)
        )

//        db.child(auth.currentUser?.uid!!).setValue(list)
//        db.child(auth.currentUser?.uid!!).setValue(PersonInfo().name,PersonInfo().url)


        val adapter = Adapter(list)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

    }
}