package material_design.soussi.com.material_drawer

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.util.Pair
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v4.app.Fragment

import java.util.ArrayList

import material_design.soussi.com.material_drawer.model.Events


class RecyclerViewFragment : Fragment(), RecyclerViewAdapter.RecyclerViewAdapterCallBack {

    var recyclerView_f: RecyclerView? = null
    var adapter: RecyclerViewAdapter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_recyclerview, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       recyclerView_f = view!!.findViewById(R.id.f_recyclerView) as RecyclerView

        val layoutManager = LinearLayoutManager(activity as Context?)
        (recyclerView_f as RecyclerView).layoutManager = layoutManager as RecyclerView.LayoutManager
        (recyclerView_f as RecyclerView).setHasFixedSize(true)

        adapter = RecyclerViewAdapter(this)
        (adapter as RecyclerViewAdapter).addObjects(createEvents())

        (recyclerView_f as RecyclerView).adapter = adapter
    }

    private fun createEvents(): List<Events> {
        val objects = ArrayList<Events>()

        objects.add(Events("Tunisie", "http://www.nachoua.com/Sahel/sousse-plage.jpg"))
        objects.add(Events("France", "http://www.telegraph.co.uk/travel/destination/article130148.ece/ALTERNATES/w620/parisguidetower.jpg"))
        objects.add(Events("Angleterre", "http://www.traditours.com/images/Photos%20Angleterre/ForumLondonBridge.jpg"))
        objects.add(Events("Allemagne", "http://tanned-allemagne.com/wp-content/uploads/2012/10/pano_rathaus_1280.jpg"))
        objects.add(Events("Espagne", "http://www.sejour-linguistique-lec.fr/wp-content/uploads/espagne-02.jpg"))
        objects.add(Events("Italie", "http://retouralinnocence.com/wp-content/uploads/2013/05/Hotel-en-Italie-pour-les-Vacances2.jpg"))
        objects.add(Events("Russie", "http://www.choisir-ma-destination.com/uploads/_large_russie-moscou2.jpg"))


        return objects
    }

    override fun onRecyclerViewElementClicked(view: View, position: Int, element: Events) {
        val intent = Intent(activity, Detail_events::class.java)
        intent.putExtra(Detail_events.MY_OBJECT, element)

        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                activity,
                Pair.create(view.findViewById(R.id.image), resources.getString(R.string.image))
        )

        ActivityCompat.startActivity(activity, intent, options.toBundle())
    }

    companion object {

        fun newInstance(): RecyclerViewFragment {
            return RecyclerViewFragment()
        }
    }

}
