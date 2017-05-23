package material_design.soussi.com.material_drawer

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.plus.PlusOneButton

/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * [//PlusOneFragment.//OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [PlusOneFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlusOneFragment : Fragment() {
    /* // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";*/

    // TODO: Rename and change types of parameters
    /* private String mParam1;
    private String mParam2;*/

    // The URL to +1.  Must be a valid URL.
    private val PLUS_ONE_URL = "http://developer.android.com"

    private var mPlusOneButton: PlusOneButton? = null

    private val mListener: OnFragmentInteractionListener? = null

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.

     * @param //param1 Parameter 1.
     * *
     * @param //param2 Parameter 2.
     * *
     * @return A new instance of fragment PlusOneFragment.
     */
    // TODO: Rename and change types and number of parameters
    /* public static PlusOneFragment newInstance(String param1, String param2) {
        PlusOneFragment fragment = new PlusOneFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

    /* public PlusOneFragment() {
        // Required empty public constructor
    }*/

    /* @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_plus_one, container, false)

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Find the +1 button
        mPlusOneButton = view!!.findViewById(R.id.plus_one_button) as PlusOneButton
    }

    override fun onResume() {
        super.onResume()

        // Refresh the state of the +1 button each time the activity receives focus.
        mPlusOneButton!!.initialize(PLUS_ONE_URL, PLUS_ONE_REQUEST_CODE)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        mListener?.onFragmentInteraction(uri)
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match

        fun newInstance(): PlusOneFragment {
            return PlusOneFragment()
        }

        // The request code must be 0 or greater.
        private val PLUS_ONE_REQUEST_CODE = 0
    }

}
