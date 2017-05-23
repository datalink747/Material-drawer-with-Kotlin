package material_design.soussi.com.material_drawer

import android.os.Build
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.transition.Explode
import android.transition.Fade
import android.view.View
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Switch
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var viewPager: ViewPager? = null
    private var tabLayout: TabLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar?
        setSupportActionBar(toolbar)





        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        setupWindowAnimations() // func for animation here

        viewPager = findViewById(R.id.viewpager) as ViewPager?
        tabLayout = findViewById(R.id.tabs1) as TabLayout?

        val fab = findViewById(R.id.fab) as FloatingActionButton?
        fab!!.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)

                    .setAction("Retour") { Toast.makeText(this@MainActivity, "Retour", Toast.LENGTH_SHORT).show() }.show()
        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout?
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer!!.setDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById(R.id.nav_view) as NavigationView?
        navigationView!!.setNavigationItemSelectedListener(this)

        //on remplit notre viewpager

        viewPager!!.adapter = object : FragmentPagerAdapter(supportFragmentManager) {
            override fun getItem(position: Int): Fragment? {

                var f: Fragment? = null
                when (position) {
                    0 -> f = RecyclerViewFragment.newInstance()
                    1 -> f = PlusOneFragment.newInstance()
                    2 -> f = RecyclerViewFragment.newInstance()
                    3 -> f = RecyclerViewFragment.newInstance()
                }

                return f
            }


            override fun getPageTitle(position: Int): CharSequence {
                var tab_name = ""

                when (position) {
                    0 -> tab_name = "tab n 1"
                    1 -> tab_name = "tab n 2"
                    2 -> tab_name = "tab n 3"
                    3 -> tab_name = "tab n 4"
                }
                return tab_name
            }

            override fun getCount(): Int {
                return 4
            }
        }

        //indique au tablayout quel est le viewpager à écouter
        tabLayout!!.setupWithViewPager(viewPager)


    }

    //animation for window
    private fun setupWindowAnimations() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            val explode = Explode()
            window.exitTransition = explode

            val fade = Fade()
            window.reenterTransition = fade
        }
    }

    override fun onBackPressed() {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout?
        if (drawer!!.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        if (id == R.id.nav_camara) {
            // Handle the camera action
            Toast.makeText(this@MainActivity, "camera here", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout?
        drawer!!.closeDrawer(GravityCompat.START)
        return true
    }
}
