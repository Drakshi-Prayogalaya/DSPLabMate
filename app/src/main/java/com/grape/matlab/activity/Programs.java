package com.grape.matlab.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.grape.matlab.R;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;

/**
 * Created by rarodi on 12/15/2015.
 */
public class Programs extends Activity
{
    Button b1;
    TextView tv,tva;
    int k = 0;

    static String program1 = "i.<font color=\'#009000\'>% given sine wave frequency=100Hz</font><br>"+

            "\tFm=100;<br> " +
            "\t<font color=\'#009000\'>% for case fs=2Fm (fs-sampling frequency)</font><br>" +
            "\tFs=2*Fm;<br>" +
            "\t<font color=\'#009000\'>% sampling \tperiod<br></font>" +
            "\tTs=1/Fs;<br>" +
            "\t<font color=\'#009000\'>% Time vector; varies from 0 to 1 with step of Ts<br></font>" +
            "\tt=0:Ts:1<br>" +
            "\t<font color=\'#009000\'>% w computed (in rad/s) at t values (i.e w=2*pi*f)<br></font>" +
            "\tw=2*pi*Fm*t;<br>" +
            "\ta=sin(w);<br><br>" +
            "\tfigure(1)<br>" +
            "\t<font color=\'#009000\'>% divides window to 3 rows 1 column and place plot in the first place<br></font>" +
            "\tsubplot(3,1,1)<br>" +
            "\tplot(t,a)<br>" +
            "\t<font color=\'#009000\'>%x-axis (0,0.1) and y-axis (-1,1)<br></font>" +
            "\taxis([0 0.1 -1 1])<br><br>" +
            "\tfigure(2)<br>" +
            "\tsubplot(3,1,1)<br>" +
            "\tstem(t,a)<br>" +
            "\taxis([0 0.1 -1 1])<br><br>" +
            "\t<font color=\'#009000\'>% Sampling 4 times the highest frequency component of original signal<br></font>" +
            "\tFs=4*Fm;<br>" +
            "\tTs=1/Fs;<br>" +
            "\tt=0:Ts:1;<br>" +
            "\tw=2*pi*Fm*t;<br>" +
            "\ta=sin(w);<br>" +
            "\tfigure(1)<br>" +
            "\tsubplot(3,1,2)<br>" +
            "\tplot(t,a)<br>" +
            "\taxis([0 0.1 -1 1])<br>" +
            "\tfigure(2)<br>" +
            "\tsubplot(3,1,2)<br>" +
            "\tstem(t,a)<br>" +
            "\taxis([0 0.1 -1 1])<br><br>" +
            "\t<font color=\'#009000\'>% Sampling 10 times the highest frequency component of original signal<br></font><br>" +
            "\tFs=10*Fm;<br>" +
            "\tTs=1/Fs;<br>" +
            "\tt=0:Ts:1;<br> " +
            "\tw=2*pi*Fm*t;<br> " +
            "\ta=sin(w);<br>" +
            "\tfigure(1)<br>" +
            "\tsubplot(3,1,3)<br>" +
            "\tplot(t,a)<br>" +
            "\taxis([0 0.1 -1 1])<br>" +
            "\tfigure(2)<br>" +
            "\tsubplot(3,1,3)<br>" +
            "\tstem(t,a)<br>" +
            "\taxis([0 0.1 -1 1])<br><br>" +
            "ii.	Fm=400;<br>" +
            "\tFs=2*Fm;<br>" +
            "\tTs=1/Fs;<br>" +
            "\tt=0:Ts:1;<br> " +
            "\tw1=2*pi*100*t;<br>" +
            "\tw2=2*pi*300*t;<br>" +
            "\t<font color=\'#009000\'>% Given function<br></font>" +
            "\ta=sin(w1).*cos(w2);<br>" +
            "\tfigure(1)<br>" +
            "\t<font color=\'#009000\'>% divides window to 3 rows 1 column and place plot in the first place<br></font>" +
            "\tsubplot(3,1,1)<br>" +
            "\tplot(t,a)<br>" +
            "\t<font color=\'#009000\'>%x-axis (0,0.1) and y-axis (-1,1)<br></font>" +
            "\taxis([0 0.1 -1 1])<br><br>" +
            "\tfigure(2)<br>" +
            "\tsubplot(3,1,1)<br>" +
            "\tstem(t,a)<br>" +
            "\taxis([0 0.1 -1 1])<br><br>" +
            "\t<font color=\'#009000\'>% Sampling 4 times the highest frequency component of original signal<br></font>" +
            "\tFs=4*Fm;<br> " +
            "\tTs=1/Fs;<br>" +
            "\tt=0:Ts:1;<br> " +
            "\tw=2*pi*Fm*t;<br> " +
            "\ta=sin(w);<br>" +
            "\tfigure(1)<br>" +
            "\tsubplot(3,1,2)<br>" +
            "\tplot(t,a)<br>" +
            "\taxis([0 0.1 -1 1])<br>" +
            "\tfigure(2)<br>" +
            "\tsubplot(3,1,2)<br>" +
            "\tstem(t,a)<br>" +
            "\taxis([0 0.1 -1 1])<br><br>" +
            "\t<font color=\'#009000\'>% Sampling 10 times the highest frequency component of original signal<br></font><br>" +
            "\tFs=10*Fm;<br> " +
            "\tTs=1/Fs;<br>" +
            "\tt=0:Ts:1;<br> " +
            "\tw=2*pi*Fm*t;<br> " +
            "\ta=sin(w);<br>" +
            "\tfigure(1)<br>" +
            "\tsubplot(3,1,3)<br>" +
            "\tplot(t,a)<br>" +
            "\taxis([0 0.1 -1 1])<br>" +
            "\tfigure(2)<br>" +
            "\tsubplot(3,1,3)<br>" +
            "\tstem(t,a)<br>" +
            "\taxis([0 0.1 -1 1])<br>";

    static String program2 = "\tz=tf(\'z\');<br>" +
            "\t<font color=\'#009000\'>%<font color=\'#009000\'>% For (i) G1=1+0.5z^(-1)+0.06z^(-2)</font><br></font><br>" +
            "\t[Gn1,Gd1]=tfdata(G1,\'v\');<br><br>" +
            "\t<font color=\'#009000\'>% tfdata (G1,\'v\') assigns Gn1 and Gd1 the row vectors which contain coefficients of z in<br></font> " +
            "\t<font color=\'#009000\'>% decreasing order of power present in numerator and denominator of G1 respectively.<br><br></font>" +
            "\tsubplot(2,2,1)<br>" +
            "\ti1=impz(Gn1,Gd1)<br><br>" +
            "\t<font color=\'#009000\'>% \'impz\' gives impulse response for the given row vectors <br></font>" +
            "\t<font color=\'#009000\'>% which contain coefficients of \'z-1\' <br></font>" +
            "\t<font color=\'#009000\'>% and which represents numerator and denominator of given transfer function (G1)<br><br></font> " +
            "\timpz(Gn1,Gd1);<br>" +
            "\ttitle(\'Impulse response of G1\');<br>" +
            "\taxis([0 5 -0.5 1]);<br>" +
            "\tgrid on<br><br>" +
            "\t<font color=\'#009000\'>% For (ii)" +
            "\tG2= (1+z^-1)/(1+0.5*z^-1+0.06*z^-2)	<br></font>" +
            "\t[Gn2,Gd2]=tfdata(G2,\'v\');<br>" +
            "\tsubplot(2,2,2)<br>" +
            "\ti2=impz(Gn2,Gd2)<br>" +
            "\timpz(Gn2,Gd2);<br>" +
            "\ttitle(\'Impulse response of G2\');<br>" +
            "\taxis([0 5 -0.5 1]);<br>" +
            "\tgrid on<br><br>" +
            "\t<font color=\'#009000\'>% For (iii) G3=G1*G2;<br>" +
            "\t% For G1 and G2 in series let the final transfer function be their product<br> " +
            "\t% G3 can also be found by G3=series(G1,G2)<br></font>" +
            "\tsubplot(2,2,3)<br>" +
            "\ti3=impz(Gn3,Gd3)<br>" +
            "\timpz(Gn3,Gd3);<br>" +
            "\ttitle(\'Impulse response of G3=G1*G2\');<br>" +
            "\taxis([0 5 -0.5 1]);<br>" +
            "\tgrid on<br>" +
            "\t<font color=\'#009000\'>% For (iv)<br></font>" +
            "\tG3=G1+G2;<br> " +
            "\t<font color=\'#009000\'>% For G1 and G2 in series let the final transfer function be their sum<br></font>" +
            "\t<font color=\'#009000\'>% G3 can also be found by G3=parallel(G1,G2)<br><br></font>" +
            "\t[Gn4,Gd4]=tfdata(G4,\'v\');<br>" +
            "\tsubplot(2,2,4)<br>" +
            "\ti4=impz(Gn4,Gd4)<br>" +
            "\timpz(Gn4,Gd4);<br>" +
            "\ttitle(\'Impulse response of G4=G1+G2\');<br>" +
            "\taxis([0 5 -0.5 1]);<br>" +
            "\tgrid on<br>";

    static String program3 = "\tA=input(\'Enter matrix A\');<br>" +
            "\tB= input(\'Enter matrix B\');<br>" +
            "\tla=length(A);<br>" +
            "\tlb=length(B);<br>" +
            "\trow=[b(1), zeroes(1,(la-1))];<br><br>" +
            "\t<font color=\'#009000\'>% Row matrix with the first element as the first element of B matrix followed by zeroes.<br></font>" +
            "\t<font color=\'#009000\'>% zeroes(x,y) provides a zero matrix with x rows and y columns.<br><br></font>" +
            "\tcol=[b\';zeroes((la-1),1)];<br><br>" +
            "\t<font color=\'#009000\'>% col is a column matrix with first element as the transpose of matrix B followed by zeroes.<br><br></font>" +
            "\tH=toeplitz(col,row)<br><br>" +
            "\t<font color=\'#009000\'>% Toeplitz(a,b) genera" +
            "tes a toeplitz matrix with \'a\' as first column and \'b\' as first row.<br><br></font>" +
            "\tn=H*A\'<br>" +
            "\t<font color=\'#009000\'>% n is the required output.</font>";

    static String program4 = "\t<font color=\'#009000\'>% To read the sequences<br> </font>" +
            "\tx=input(\'Enter the sequence x(n)>>\');<br>" +
            "\th=input(\'Enter the sequence h(n)>>\');<br><br>" +
            "\t<font color=\'#009000\'>% To calculate the length of the read sequence<br><br></font>" +
            "\tlx=length(x);<br>" +
            "\tlh=length(h);<br>" +
            "\t<font color=\'#009000\'>% To compute circular convolution, the length of both the sequences must be equal.<br></font>" +
            "\t<font color=\'#009000\'>% Hence extra zeroes are appended to the shorter sequence.<br><br> </font>" +
            "\tif(lx>lh)<br>" +
            "\t\th=[h zeroes(1,(lh-lx))];<br>" +
            "\telse<br>" +
            "\t\tx=[x zeroes(1,(lx-lh))];<br>" +
            "\tend<br>" +
            "\tcol=x\';<br>" +
            "\trow=circshift(seqreverse(x),[0,1]);<br><br>" +
            "\t<font color=\'#009000\'>% row and col are respectively the row and column of the toeplitz matrix to be constructed.<br></font>" +
            "\t<font color=\'#009000\'>% \'seqreverse (seqNT)\' : Returns a reversed string in the same format<br></font>" +
            "\t<font color=\'#009000\'>% \\'circshift(A,[x,y])\\' : Circularly shifts array A by x elements down (x greater than 0) or up (x less than 0) and if<br></font>" +
            "\t<font color=\'#009000\'>% elements right (y>0) or left (y>0). If x=0 or y=0 then no change in position.<br><br></font>" +
            "\tX=toeplitz(col,row);<br>" +
            "\ty=X*h\';<br><br>" +
            "\t<font color=\'#009000\'>% To verify using FFT<br></font>" +
            "\t<font color=\'#009000\'>% fft(x) : Returns the discrete Fourier Transform of x computed with Fast Fourier Algorithm.<br></font>" +
            "\t<font color=\'#009000\'>%ifft(x) : Returns Inverse Fourier Transform of x computed using Fourier Transform Algorithm<br><br></font>" +
            "\txf=fft(x);<br>" +
            "\thf=fft(h);<br>" +
            "\tyf=xf.*hf;<br>" +
            "\tyt=ifft(yf)<br>";

    static String program5 = "\ta=input(\'Enter the coefficients of y(n)\');<br>" +
            "\tb=input(\'Enter the coefficients of x(n)\');<br>" +
            "\tx= input(\'Enter the sequence of x(n)\');<br>" +
            "\tyi=input(\'Enter the initial conditions of y(n)\');<br>" +
            "\txi= input(\'Enter the initial conditions of x(n)\');<br>" +
            "\tzi=filtic(b,a,yi,xi);<br><br>" +
            "\t<font color=\'#009000\'>% filtic(b,a,y,x) : b and a represents numerator and denominator coefficients of filter\'s<br></font>" +
            "\t<font color=\'#009000\'>% transfer function where y and x provides initial conditions<br><br></font> " +
            "\tyt=filter(b,a,x);<br>" +
            "\tywith=filter(b,a,zi);<br>" +
            "\t<font color=\'#009000\'>% with initial condition<br>" +
            "\t% filter(b,a,x) : filters the data in vector x with the filter described vectors \'a\' and \'b\'<br><br></font>" +
            "\tstem(ywith);<br>" +
            "\txlabel(\'Samples (n)\');<br>" +
            "\tylabel(\'y(n)\');<br>" +
            "\ttitle(\'Solution of difference equation with initial conditions for a given input\');<br>";

    static String program6 = "\ta=input(\'Enter the first sequence x1(n)\');<br>" +
            "\tb=input(\'Enter the second sequence x2(n)\');<br>" +
            "\ty=xcorr(a,b);<br>" +
            "\tdisplay(y);<br>" +
            "\tz=xcorr(b,a);<br><br> " +
            "\t<font color=\'#009000\'>% xcorr(x,y) : returns the cross correlation sequence in a vector of length 2*N-1<br><br></font>" +
            "\tdisplay(z);<br><br>" +
            "\t<font color=\'#009000\'>% To calculate cross correlation using matrix multiplication<br><br></font>" +
            "\tc=seqreverse(b);<br>" +
            "\tla=length(a);<br>" +
            "\tlb=length(b);<br>" +
            "\trow=[b(la) zeroes(1,(la-1))];<br>" +
            "\tcol=[c\' zeroes((la-1),1)];<br>" +
            "\tX=toeplitz(col,row);<br>" +
            "\tY=X*a\';<br>" +
            "\tdisplay(Y);<br><br>" +
            "\t<font color=\'#009000\'>% To verify Parseval\'s theorem<br><br></font>" +
            "\tlf=min(la,lb);<br>" +
            "\tdisplay(lf);<br><br>" +
            "\t<font color=\'#009000\'>% Preset power (p) and energy (e) variables to zero<br><br></font>" +
            "\tp=0;<br>" +
            "\te=0;<br>" +
            "\taf=fft(a);<br>" +
            "\tbf=fft(b);<br>" +
            "\ti=1;<br>" +
            "\twhile(i &lt=lf)" +"<br>"+
            "\te=e+(a(i)*(conj(b(i))));<br>" +
            "\tp=p+(af(i)*(conj(bf(i))));<br>" +
            "\ti=i+1;<br>" +
            "\tend<br>" +
            "\tdisplay(e)<br>" +
            "\tP=p/lf;<br>" +
            "\tdisplay(P);<br>";

    static String program7 = "\ta=[1 2 2 1];<br>" +
            "\tA=dftmtx(4);<br><br>" +
            "\t<font color=\'#009000\'>% A discrete Fourier Transform matrix is a complex matrix of values around the unit circle <br></font> " +
            "\t<font color=\'#009000\'>% whose matrix product with a vector computes DFT of the vector.<br></font>" +
            "\t<font color=\'#009000\'>% dftmtx(n) : Returns n-by-n complex matrix. When this is multiplied into a column vector \'x\' of length n, computes the DFT of x<br><br></font>" +
            "\tAy=A*a\';<br>" +
            "\tdisplay(Ay);<br><br>" +
            "\tAm=abs(Ay);<font color=\'#009000\'>% Returns an array containing the absolute value of each element in Ay<br></font>" +
            "\tAp=angle(Ay);<font color=\'#009000\'>% Returns an array containing phase angle (in radians) of each element in Ay<br><br></font>" +
            "\tfigure(1);<br>" +
            "\tsubplot(1,2,1);<br>" +
            "\tstem(Am);<br>" +
            "\txlabels(\'Samples\');<br>" +
            "\tylabels(\'Magnitude\');<br>" +
            "\ttitle(\'Magnitude of x1(n)\');<br>" +
            "\tfigure(1);<br>" +
            "\tsubplot(1,2,2);<br>" +
            "\tstem(Ap);<br>" +
            "\txlabels(\'Samples\');<br>" +
            "\tylabels(\'Angle\');<br>" +
            "\ttitle(\'Phase of x1(n)\');<br>" +
            "\t<font color=\'#009000\'>(ii)<br></font>" +
            "\tk=input(\'Enter the length of the sequence \');<br>" +
            "\ti=0;<br>" +
            "\twhile(i<k)<br>" +
            "\tb(i+1)= cos(0.64*pi*i)+cos(0.72*pi*i);<br>" +
            "\ti=i+1;<br>" +
            "\tend<br>" +
            "\tdisplay(b);<br>" +
            "\tB=dftmtx(k);<br>" +
            "\tBy=B*b\';<br>" +
            "\tdisplay(By);<br>" +
            "\tBm=abs(By);<br>" +
            "\tBp=angle(By);<br>" +
            "\tfigure(2);<br>" +
            "\tsubplot(1,2,1);<br>" +
            "\tstem(Bm);<br>" +
            "\txlabels(\'Samples\');<br>" +
            "\tylabels(\'Magnitude\');<br>" +
            "\ttitle(\'Magnitude of x2(n)\');<br>" +
            "\tfigure(2);<br>" +
            "\tsubplot(1,2,2);<br>" +
            "\tstem(Bp);<br>" +
            "\txlabels(\'Samples\');<br>" +
            "\tylabels(\'Angle\');<br>" +
            "\ttitle(\'Phase of x2(n)\');<br>" +
            "\t<font color=\'#009000\'>(iii)<br></font>" +
            "\tl=input(\'Enter the length of the sequence \');<br>" +
            "\tfs=1500;<br>" +
            "\tts=1/fs;<br>" +
            "\tt=0:ts:(l-1)/1500;<br>" +
            "\tw1=2*pi*100*t;<br>" +
            "\tw2=3*pi*300*t;<br>" +
            "\tc=cos(w1)+cos(w2);<br>" +
            "\tdisplay(c);<br>" +
            "\tC=dftmtx(l);<br>" +
            "\tCy=C*c\';<br>" +
            "\tdisplay(Cy);<br>" +
            "\tCm=abs(Cy);<br>" +
            "\tCp=angle(Cy);<br>" +
            "\tfigure(3);<br>" +
            "\tsubplot(1,2,1);<br>" +
            "\tstem(Cm);<br>" +
            "\txlabels(\'Samples\');<br>" +
            "\tylabels(\'Magnitude\');<br>" +
            "\ttitle(\'Magnitude of x3(n)\');<br>" +
            "\tfigure(3);<br>" +
            "\tsubplot(1,2,2);<br>" +
            "\tstem(Cp);<br>" +
            "\txlabels(\'Samples\');<br>" +
            "\tylabels(\'Angle\');<br>" +
            "\ttitle(\'Phase of x3(n)\');<br>";

    static String program8 = "\t<font color=\'#009000\'>(i)<br></font>" +
            "\tz=tf(\'z\');<br>" +
            "\tg=z^4+0.1*z^2+0.5*z+0.05;<br>" +
            "\t[num,den]=tfdata[g,\'v\'];<br>" +
            "\t[k]=tf2latc[num];<br><br>" +
            "\t<font color=\'#009000\'>% \'tf2latc\' converts transfer function filter parameters<br></font>" +
            "\t<font color=\'#009000\'>%to the lattice filter form; it finds the<br></font>" +
            "\t<font color=\'#009000\'>% lattice parameters for an FIR filter with x(1) normalized.<br><br></font>" +
            "<font color=\'#009000\'>(ii)<br></font>" +
            "\tz=tf(\'z\');<br>" +
            "\tg=(z^2+0.1*+0.05)/( z^3+0.2*z^2+0.1*z+0.04);<br>" +
            "\t[num,den]=tfdata[g,\'v\'];<br>" +
            "\t[l,v]=tf2latc(num,den);<br><br>" +
            "\t<font color=\'#009000\'>%[l,v] -> l = scalar ladder coefficients and v = lattice parameters<br><br></font>" +
            "\t[r,p,k]=residuez(num,den);<br><br> " +
            "\t<font color=\'#009000\'>% Z-Transform partial fraction expansion. This converts discrete time<br></font>" +
            "\t<font color=\'#009000\'>% system expressed as ratio of polymers to partial fraction expansion<br></font>";

    static String program9 = "\t<font color=\'#009000\'>% For hamming window<br><br></font>" +
            "\tk=4;<br>" +
            "\tfw=input(\'Transition width = \');<br>" +
            "\twc=input(\'Cut off frequency = \');<br>" +
            "\twc1=wc/pi;<br>" +
            "\tm=2*k*pi/fw;<br>" +
            "\tn=ceil(m);<br><br>" +
            "\t<font color=\'#009000\'>% ceil : rounds x to the nearest integer greater than or equal to x<br><br></font>" +
            "\tif(mod(n,2)==0)<br>" +
            "\t\tn=n+1;<br>" +
            "\tend<br>" +
            "\tlow=hamming(n+1);<br>" +
            "\t<font color=\'#009000\'>% hamming(a) : return a point hamming window which is symmetric<br></font>" +
            "\tn1=fir1(n,wc1,low);<br>" +
            "\t<font color=\'#009000\'>% gives window based finite impulse response filter design<br></font>" +
            "\tt=0:1/300:1;<br>" +
            "\tw=2*pi*100*t;<br>" +
            "\ts=sin(w);<br>" +
            "\ty=conv(s,n1);<br>" +
            "\tsubplot(2,1,2);<br>" +
            "\tstem(y);<br>" +
            "\tt=0:1/1000:1;<br>" +
            "\tw=2*pi*100*t;<br>" +
            "\ts=sin(w);<br>" +
            "\ty=conv(s,n1);<br>" +
            "\tsubplot(2,1,1)<br>" +
            "\tstem(y);<br>" +
            "\tfigure(2);<br>" +
            "\tfreqz(n1);<br><br>" +
            "\t<font color=\'#009000\'>% \'freqz\' Gives frequency response of digital filter.<br></font>" +
            "\t<font color=\'#009000\'>% For Kaiser window<br><br></font>" +
            "\tfw=input(\'Transition width = \');<br>" +
            "\twc=input(\'Cut off frequency = \');<br>" +
            "\tsn=input)\'Stopband ripple = \');<br>" +
            "\tsr=-20+log(sn);<br>" +
            "\tdf=fw/(2*pi);<br>" +
            "\tr=(sr-7.95)/((14.36)*df);<br>" +
            "\tn=ceil(r);<br>" +
            "\tif(mod(n,2)==0)<br>" +
            "\t\tn=n+1;<br>" +
            "\tend<br>" +
            "\tw1=kaiser(n+1);<br>" +
            "\tn1=fir1(n,wc/pi,w1);<br><br>" +
            "\t<font color=\'#009000\'>% gives window based finite impulse response filter design<br><br></font>" +
            "\tt=0:1/300:1;<br>" +
            "\tw=2*pi*100*t;<br>" +
            "\ts=sin(w);<br>" +
            "\ty=conv(s,n1);<br>" +
            "\tsubplot(2,1,2);<br>" +
            "\tstem(y);<br>" +
            "\tt=0:1/1000:1;<br>" +
            "\tw=2*pi*100*t;<br>" +
            "\ts=sin(w);<br>" +
            "\ty=conv(s,n1);<br>" +
            "\tsubplot(2,1,1)<br>" +
            "\tstem(y);<br>" +
            "\tfigure(2);<br>" +
            "\tfreqz(n1);<br><br>" +
            "\t<font color=\'#009000\'>% Gives frequency response of digital filter.</font>";

    static String program10 = "\tfp=input(\'Enter passband frequency\');<br>" +
            "\tfs= input(\'Enter stopband frequency\');<br>" +
            "\trp= input(\'Enter passband ripple\');<br>" +
            "\trs= input(\'Enter stopband attenuation\');<br>" +
            "\tf= input(\'Enter sampling frequency\');<br>" +
            "\twp=2*fp/f;<br>" +
            "\tws=2*fs/f;<br>" +
            "\t[n,wn]=buttord(wp,ws,rp,rs);<br>" +
            "\t[b,a]=butter(n,wn,\'low\');<br>" +
            "\tfreqz(b,a);<br>" +
            "\tt=0:1:100;<br><br>" +
            "\tx1=sin( 2*pi*1000*t);<br>" +
            "\tsubplot(3,2,1);<br>" +
            "\tplot(x1);<br>" +
            "\txlabel(\'Time\');<br>" +
            "\tylabel(\'Amplitude\');<br>" +
            "\ttitle(\'Input: sin( 2*pi*1000*t)\');<br>" +
            "\ty1=filter(b,a,x1);<br>" +
            "\tsubplot(3,2,2);<br>" +
            "\tplot(y1);<br>" +
            "\txlabel(\'Time\');<br>" +
            "\tylabel(\'Amplitude\');<br>" +
            "\ttitle(\'Filtered output for sin( 2*pi*1000*t)\');<br><br>" +
            "\tx2= cos( 2*pi*8000*t);<br>" +
            "\tsubplot(3,2,3);<br>" +
            "\tplot(x2);<br>" +
            "\txlabel(\'Time\');<br>" +
            "\tylabel(\'Amplitude\');<br>" +
            "\ttitle(\'Input: cos( 2*pi*8000*t)\');<br>" +
            "\ty2=filter(b,a,x2);<br>" +
            "\tsubplot(3,2,4);<br>" +
            "\tplot(y2);<br>" +
            "\txlabel(\'Time\');<br>" +
            "\tylabel(\'Amplitude\');<br>" +
            "\ttitle(\'Filtered output for cos( 2*pi*8000*t)\');<br>" +
            "\tx3=x1+x2;<br>" +
            "\tsubplot(3,2,5);<br>" +
            "\tplot(x3);<br>" +
            "\txlabel(\'Time\');<br>" +
            "\tylabel(\'Amplitude\');<br>" +
            "\ttitle(\'Input: sin( 2*pi*1000*t)+ cos( 2*pi*8000*t)\');<br>" +
            "\ty3=filter(b,a,x3);<br>" +
            "\tsubplot(3,2,6);<br>" +
            "\tplot(y3);<br>" +
            "\txlabel(\'Time\');<br>" +
            "\tylabel(\'Amplitude\');<br>" +
            "\ttitle(\'Filtered output for sin( 2*pi*1000*t)+ cos( 2*pi*8000*t)\');<br>";

    static String program11 = "\tx=input(\'Input 8 point sequence\')<br>" +
            "\ty=fft(x);<br>" +
            "\tfor i=1:8<br>" +
            "\t\tz(i)=y(mod(9-i,8)+1);<br>" +
            "\tend<br>" +
            "\tdisplay(z);<br>" +
            "\tdisp(\'X*[N-k]=\');<br>" +
            "\tc1=conj(z);<br>" +
            "\tdisp(c1);<br>" +
            "\tsubplot(5,2,1);<br>" +
            "\tstem(y);<br>" +
            "\ttitle(\'X(k)\');<br>" +
            "\txlabel(\'k\');<br>" +
            "\tylabel(\'Magnitude\');<br>" +
            "\tgrid on;<br>" +
            "\tsubplot(5,2,2);<br>" +
            "\tstem(c1);<br>" +
            "\ttitle(\'X*(N-k)\');<br>" +
            "\txlabel(\'k\');<br>" +
            "\tylabel(\'Magnitude\');<br>" +
            "\tgrid on;<br>" +
            "\ty1=real(y);<br>" +
            "\tz1=real(z);<br>" +
            "\tsubplot(5,2,3);<br>" +
            "\tstem(y1);<br>" +
            "\ttitle(\'Xr(k)\');<br>" +
            "\txlabel(\'k\');<br>" +
            "\tylabel(\'Magnitude\');<br>" +
            "\tgrid on;<br>" +
            "\tsubplot(5,2,4);<br>" +
            "\tstem(z1);" +
            "\ttitle(\'Xr(N-k)\');<br>" +
            "\txlabel(\'k\');<br>" +
            "\tylabel(\'Magnitude\');<br>" +
            "\tgrid on;<br>" +
            "\ty2=imag(y);<br>" +
            "\tz2=-imag(z);<br>" +
            "\tsubplot(5,2,5);<br>" +
            "\tstem(y2);<br>" +
            "\ttitle(\'Xi(k)\');<br>" +
            "\txlabel(\'k\');<br>" +
            "\tylabel(\'Magnitude\');<br>" +
            "\tgrid on;<br>" +
            "\tsubplot(5,2,6);<br>" +
            "\tstem(z2);<br>" +
            "\ttitle(\'Xi(N-k)\');<br>" +
            "\txlabel(\'k\');<br>" +
            "\tylabel(\'Magnitude\');<br>" +
            "\tgrid on;<br>" +
            "\tfor i=1:8;<br>" +
            "\t\tx1(i)=x(mod((9-i),8)+1)<br>" +
            "\tend<br>" +
            "\tsubplot(5,2,7);<br>" +
            "\tstem(x);<br>" +
            "\ttitle(\'x(n)\');<br>" +
            "\txlabel(\'n\');<br>" +
            "\tylabel(\'Magnitude\');<br>" +
            "\tgrid on;<br>" +
            "\tsubplot(5,2,8);<br>" +
            "\tstem(x1);<br>" +
            "\ttitle(\'x(N-n)\');<br>" +
            "\txlabel(\'n\');<br>" +
            "\tylabel(\'Magnitude\');<br>" +
            "\tgrid on;<br>" +
            "\txe=0.5*(x+x1);<br>" +
            "\tXe=fft(xe);<br>" +
            "\tsubplot(5,2,9);<br>" +
            "\tstem(xe);<br>" +
            "\ttitle(\'Xe(n)\');<br>" +
            "\txlabel(\'n\');<br>" +
            "\tylabel(\'Magnitude\');<br>" +
            "\tgrid on;<br>" +
            "\txo=0.5*(x-x1);<br>" +
            "\tXo=fft(xo);<br>" +
            "\tsubplot(5,2,10);<br>" +
            "\tstem(xo);<br>" +
            "\ttitle(\'Xo(n)\');<br>" +
            "\txlabel(\'n\');<br>" +
            "\tylabel(\'Magnitude\');<br>";

    static String program12 = "\tAs=input(\\'Enter stopband attenuation\\');<br>" +
            "\tw1=input(\'Enter wc1\');<br>" +
            "\tw2= input(\'Enter wc2\');<br>" +
            "\tfs=input(\'Enter fs\');<br>" +
            "\twc1=w1*2/fs;<br>" +
            "\twc2=w2*2/fs;<br>" +
            "\twp=[wc1 wc2];<br>" +
            "\tws=[(wc1-300) (wc2+300)]*2/fs;<br>" +
            "\t[N,wn]=cheb2ord(wp,ws,1,As);<br>" +
            "\t[b,a]=cheby2(N,As,wn);<br>" +
            "\tfigure(1);<br>" +
            "\tfreqz(b,a,fs);<br>";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.programs);

        //TextView tv,tva;

        tva = (TextView)findViewById(R.id.textView1);
        tv = (TextView)findViewById(R.id.textView3);

        String fontpath = "fonts/Slabo27px-Regular.ttf";
        Typeface tf = Typeface.createFromAsset(getAssets(), fontpath);

        tv.setTypeface(tf);
        tva.setTypeface(tf);

        b1 = (Button)findViewById(R.id.button1);
        final Intent i = getIntent();

        if(i.hasExtra("c1"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            tv.setText(i.getStringExtra("c1"));
            tva.setText("Verification of Sampling Theorem");
            mymarquee(tva);
            k = 1;
        }

        if(i.hasExtra("c2"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            tv.setText(i.getStringExtra("c2"));
            tva.setText("Calculation of Impulse response");
            mymarquee(tva);
            k = 2;
        }

        if(i.hasExtra("c3"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            tv.setText(i.getStringExtra("c3"));
            tva.setText("Verification of Linear Convolution");
            mymarquee(tva);
            k = 3;
        }

        if(i.hasExtra("c4"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            tv.setText(i.getStringExtra("c4"));
            tva.setText("Verification of Circular Convolution");
            mymarquee(tva);
            k = 4;
        }

        if(i.hasExtra("c5"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            tv.setText(i.getStringExtra("c5"));
            tva.setText("Solving the Difference Equations"); mymarquee(tva);
            k = 5;
        }

        if(i.hasExtra("c6"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            tv.setText(i.getStringExtra("c6"));
            tva.setText("Verification of Cross Correlation"); mymarquee(tva);
            k = 6;
        }

        if(i.hasExtra("c7"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            tv.setText(i.getStringExtra("c7"));
            tva.setText("Discrete Fourier Transform"); mymarquee(tva);
            k = 7;
        }

        if(i.hasExtra("c8"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            tv.setText(i.getStringExtra("c8"));
            tva.setText("Parallel and Lattice Realization"); mymarquee(tva);
            k = 8;
        }

        if(i.hasExtra("c9"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            tv.setText(i.getStringExtra("c9"));
            tva.setText("Low Pass FIR Filter Design"); mymarquee(tva);
            k = 9;
        }

        if(i.hasExtra("c10"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            tv.setText(i.getStringExtra("c10"));
            tva.setText("IIR Butterworth Filter Design"); mymarquee(tva);
            k = 10;
        }

        if(i.hasExtra("c11"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            tv.setText(i.getStringExtra("c11"));
            tva.setText("Symmetric Properties of DFT"); mymarquee(tva);
            k = 11;
        }

        if(i.hasExtra("c12"))
        {
            tv = (TextView)findViewById(R.id.textView3);
            tva = (TextView)findViewById(R.id.textView1);
            tv.setText(i.getStringExtra("c12"));
            tva.setText("Chebyshev Type-2 Filter Design"); mymarquee(tva);
            k = 12;
        }


        AdBuddiz.showAd(this);
    }

    public void showcode(View v)
    {
        b1 = (Button)findViewById(R.id.button3);
        Intent ip = new Intent(Programs.this,Code_View.class);

        if(k==1)
        {
            ip.putExtra("a1", program1);
            startActivity(ip); finish();
        }

        if(k==2)
        {
            ip.putExtra("a2", program2);
            startActivity(ip); finish();
        }

        if(k==3)
        {
            ip.putExtra("a3", program3);
            startActivity(ip); finish();
        }

        if(k==4)
        {
            ip.putExtra("a4", program4);
            startActivity(ip); finish();
        }

        if(k==5)
        {
            ip.putExtra("a5", program5);
            startActivity(ip); finish();
        }

        if(k==6)
        {
            ip.putExtra("a6", program6);
            startActivity(ip); finish();
        }

        if(k==7)
        {
            ip.putExtra("a7", program7);
            startActivity(ip); finish();
        }

        if(k==8)
        {
            ip.putExtra("a8", program8);
            startActivity(ip); finish();
        }

        if(k==9)
        {
            ip.putExtra("a9", program9);
            startActivity(ip); finish();
        }

        if(k==10)
        {
            ip.putExtra("a10", program10);
            startActivity(ip); finish();
        }

        if(k==11)
        {
            ip.putExtra("a11", program11);
            startActivity(ip); finish();
        }

        if(k==12)
        {
            ip.putExtra("a12", program12);
            startActivity(ip); finish();
        }
    }

    public void mymarquee(TextView t)
    {
        t.setSelected(true);
        t.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        t.setSingleLine(true);
        t.setMarqueeRepeatLimit(999999999);
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        AdBuddiz.showAd(this);
    }
}
