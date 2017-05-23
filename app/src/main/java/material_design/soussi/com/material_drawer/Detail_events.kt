package material_design.soussi.com.material_drawer

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.support.design.widget.CollapsingToolbarLayout
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.transition.Explode
import android.transition.Fade
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

import butterknife.ButterKnife
import butterknife.InjectView
import kotlinx.android.synthetic.main.activity_detail_events.*
import material_design.soussi.com.material_drawer.model.Events


class Detail_events : AppCompatActivity() {
   // @InjectView(R.id.toolbar2)
  //  internal var toolbar: Toolbar? = null
   // @InjectView(R.id.collapsing_toolbar)
  //   var collapsingToolbar: CollapsingToolbarLayout? = null
  //  var myObject: Events? = null

   // @InjectView(R.id.backgroundImageView)
  //  internal var backgroundImageView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_events)

        ButterKnife.inject(this)



       val toolbar_f =findViewById(R.id.toolbar_f) as Toolbar;
        setSupportActionBar(toolbar_f)

        toolbar_f!!.setNavigationOnClickListener {
            setupWindowAnimations2() //Exit animation
            finish()
        }

        //animation
        setupWindowAnimations()

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
       val collapsing_toolbar_f =findViewById(R.id.collapsing_toolbar_f) as CollapsingToolbarLayout
     //  val  myObject :Events
      val myObject = intent.getSerializableExtra(MY_OBJECT) as Events //get intent from recylerview fragment
        collapsing_toolbar_f.title = myObject.text

        supportPostponeEnterTransition()
        val backgroundImageView_f =findViewById(R.id.backgroundImageView_f) as ImageView
        Picasso.with(this).load(myObject.imageUrl).centerCrop().fit().into(backgroundImageView_f)

      /*  Picasso.with(this).load(myObject.imageUrl).centerCrop().fit().into(backgroundImageView!!, object : Callback {
            override fun onSuccess() {
                supportStartPostponedEnterTransition()
            }

            override fun onError() {

            }
        })*/


        val fab = findViewById(R.id.fab) as FloatingActionButton?
        fab!!.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    private fun setupWindowAnimations() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val fade = Fade()
            window.returnTransition = fade
        }
    }

    private fun setupWindowAnimations2() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val fade = Fade()
            window.exitTransition = fade
        }
    }

    companion object {

        val MY_OBJECT = "MY_OBJECT"
    }

}
