package screen_fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.mikhaellopez.circularfillableloaders.CircularFillableLoaders;

import java.util.Timer;
import java.util.TimerTask;

import CustomFunctionalities.FragmentsCustomization;
import Utilities.Filters;
import Utilities.RoundedImageView;
import app.anonymous.sunny.gamepage.R;

import static com.google.android.gms.internal.zzip.runOnUiThread;

public class AskQuestions extends FragmentsCustomization {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private OnFragmentInteractionListener mListener;
    int i,j;
    private RoundedImageView user_image,opponent_image;
    private TextView clock_timer;
    private EditText et_question;
    private Timer progress_timer;
    CircularFillableLoaders circularFillableLoaders;
    public AskQuestions() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View ask_question_view = inflater.inflate(R.layout.fragment_ask_questions, container, false);
        user_image =(RoundedImageView)ask_question_view.findViewById(R.id.user_character);
        opponent_image =(RoundedImageView)ask_question_view.findViewById(R.id.opponent_character);

        user_image.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.profile_icon));

        opponent_image.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.progress_logo));

        clock_timer=(TextView)ask_question_view.findViewById(R.id.clock_timer);
et_question =(EditText)ask_question_view.findViewById(R.id.ask_edit_text);
        requestFocus(et_question);
        clock_timer.setTypeface(changeFont());
        clock_timer.setTextSize(45);
        clock_timer.setTextColor(Color.YELLOW);
        circularFillableLoaders = (CircularFillableLoaders)ask_question_view.findViewById(R.id.circularFillableLoaders);
// Set Progress

// Set Wave Amplitude (between 0.00f and 0.10f)
        circularFillableLoaders.setAmplitudeRatio(0.04f);


        progress_timer =new Timer();
        i=0;
         j = 20;
        progress_timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                        circularFillableLoaders.setProgress(5*(j));
                        --j;
                        ++i;
                        Log.d("Scheduler", "" + 5 * i);
                        clock_timer.setText("" + j);


                            circularFillableLoaders.setAmplitudeRatio((float)j/200);

                        //use filter from utilities
if(filter(j,10))
{
    clock_timer.setTextColor(Color.BLACK);
}
                        if(j==0)
                    {
                        circularFillableLoaders.setProgress(0);
                        progress_timer.cancel();
                        et_question.setClickable(false);

                    }
                    }
                });
            }
        }, 1000,1000);

        return ask_question_view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

}
