package com.grape.matlab.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.grape.matlab.R;

/**
 * Created by Ravi on 29/07/15.
 */
public class FriendsFragment extends Fragment implements View.OnClickListener {

    Button b[] = new Button[12];
    int buttonId[] = {R.id.button1,
            R.id.button2,
            R.id.button3,
            R.id.button4,
            R.id.button5,
            R.id.button6,
            R.id.button7,
            R.id.button8,
            R.id.button9,
            R.id.button10,
            R.id.button11,
            R.id.button12};

        static String aim1 = "\tAim:\n" +
                "\t(i)\tGenerate sine wave of frequency Fm=100Hz with sampling rate \n" +
                "\ta.	Fs=2Fm\n" +
                "\tb.	Fs=4Fm\n" +
                "\tc.	Fs=10Fm\n\n" +
                "\n" +
                "\tPlot them using \'stem\' command on a single window.\n" +
                "\tPlot also using \'plot\' command on another window.\n" +
                "\t(ii)\tRepeat the above with sin(2*pi(100*t)).cos(2*pi(300*t).\n";

        static String aim2 = "\tAim:\n" +
                "\tObtain impulse response for the following systems:\n" +
                "\t(i) \t G1(z) = 1+0.5z-1+z-2\n" +
                "\t(ii)\tG2(z) = (1+z^(-1))/(1+0.5z^(-1)+0.06z^(-2))\n" +
                "\t(iii)\tSystem G1(z) and G2(z) in series.\n" +
                "\t(iv)\tSystem G1(z) and G2(z) in series.\n";

        static String aim3 = "To obtain the linear convolution of two finite length sequences.\n" +
                " If two sequences are x(n) and h(n), obtain the \n" +
                "convoluted signal y(n) using matrix multiplication y=H.x,\n" +
                "where H is defined appropriately using time shifted sequences of h(n).";

        static String aim4 = "To obtain circular convolution of two\n" +
                " finite length sequences using matrix multiplication y=H.x,\n" +
                " where H is defined using shifted sequence of h(n).\n";

        static String aim5 = "\tTo solve the difference equation of the form\n" +
                "\t(i)	y(n)-a1y(n-1)-a2y(n-2)=b0x(n)\n" +
                "\tconsidering initial conditions y(-1), y(-2)\n" +
                "\t(ii)	y(n)-a1y(n-1)-a2y(n-2)=b0x(n)+b1x(n-1)\n" +
                "\tconsidering initial conditions y(-1), y(-2), x(-1).\n";

        static String aim6 = "To obtain cross correlation of two finite length sequences.\n " +
                "Verify Parseval\'s theorem and other properties using the program.\n";

        static String aim7 = "\tObtain the DFT of the following:\n" +
                "\t(i)	x(n)={1,2,2,1}\n" +
                "\t(ii)	x(n)= cos(0.64*pi*n)+cos(0.72*pi*n) .Plot the magnitude and \n" +
                "phase spectrum using Matlab by choosing N=4,8,16.\n" +
                "\t(iii)	x(t)= cos(2*pi*100*t)+cos(3*pi*300*t) sampled with fs=1500Hz.\n" +
                " Take N=64,128.\n";

        static String aim8 = "\tObtain the parallel and lattice realization for the filters\n" +
                "\ti.  H(z)=z4+0.1z2+0.5z+0.05\n" +
                "\tii. H(z)=(z^2+0.1z+0.05)/(z^3+0.2z^2+0.1z+0.04)\n";

        static String aim9 = "\tTo design a Low pass FIR filter with cut-off frequency wc=pi/2 rad/s\n" +
                "\t(i)	 Using Hamming window with allowed maximum transition width (pi/16)c/s \n" +
                " with minimum stop-band attenuation of 50dB.\n" +
                "\t(ii)    Using Kaiser window for stop-band attenuation of 60dB \n" +
                "for the transition width of (pi/32)c/s. Use appropriate input signal x(n)\n" +
                " (sampled at a rate of fs) to observe the filter output.\n";

        static String aim10 = "\tTo design IIR digital Butterworth with the following specifications:\n" +
                "\ta)	Passband ripple = 1dB\n" +
                "\tb)	Passband edge = 4kHz\n" +
                "\tc)	Stopband attenuation >=40dB\n" +
                "\td)	Stopband edge = 6kHz\n" +
                "\te)	Sample rate = 24kHz\n\n" +
                "\tApply the following input:\n" +
                "\ta)	x(t)= sin( 2*pi*1000*t)\n" +
                "\tb)	x(t)= cos( 2*pi*8000*t)\n" +
                "\tc)	x(t)= sin( 2*pi*1000*t)+ cos( 2*pi*8000*t)\n";

        static String aim11 = "To verify symmetric property of DFT for a 8 point real sequence.\n";

        static String aim12 = "\tTo design a Chebyshev type II band pass digital \n" +
                "IIR filter with following specifications\n" +
                "\twc1=2kHz	wc2=6kHz	fs=20khz\n" +
                "\tstop band attenuation>=40dB.\n ";

    public FriendsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends, container, false);

        for(int i = 0; i< 12; i++)
        {
            b[i] = (Button) view.findViewById(buttonId[i]);
            b[i].setOnClickListener(this);
        }
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        int btnid = v.getId();
        Intent i;
        //Toast.makeText(this.getActivity(),"Button is clicked!", Toast.LENGTH_LONG).show();
        switch (btnid)
        {
            case R.id.button1:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c1", aim1);
                startActivity(i);
                break;
            case R.id.button2:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c2", aim2);
                startActivity(i);
                break;
            case R.id.button3:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c3", aim3);
                startActivity(i);
                break;
            case R.id.button4:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c4", aim4);
                startActivity(i);
                break;
            case R.id.button5:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c5",aim5);
                startActivity(i);
                break;
            case R.id.button6:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c6", aim6);
                startActivity(i);
                break;
            case R.id.button7:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c7", aim7);
                startActivity(i);
                break;
            case R.id.button8:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c8", aim8);
                startActivity(i);
                break;
            case R.id.button9:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c9", aim9);
                startActivity(i);
                break;
            case R.id.button10:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c10", aim10);
                startActivity(i);
                break;
            case R.id.button11:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c11", aim11);
                startActivity(i);
                break;
            case R.id.button12:
                i = new Intent(this.getActivity(),Programs.class); i.putExtra("c12", aim12);
                startActivity(i);
                break;
        }

    }
}
