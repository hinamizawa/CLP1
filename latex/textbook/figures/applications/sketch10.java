                  /*  File:  sketch10.java    */

import figPac.* ;
import fnPac.* ;
import java.applet.* ;
import java.awt.* ;

public class sketch10 extends Template {

     static {templateClass = new sketch10() ; }

     public void setup() {
          filePrefix = "sketch10" ;
          outputPsFile = true ;
          outputLblFile = true ;
          xsize = 4.0*0.6 ;   
          ysize = 2.7*0.6 ;   
          xmin = -2.0 ;
          xmax = 2.0 ;
          ymin = -0.7 ;
          ymax = 2.0 ;
          topmargin = 0.0 ;
          bottommargin = 0 ;
          leftmargin = 0 ;
          rightmargin = 0 ;
          useZoom = true ;
          useDrag = true ;
          showCoords = true ;
          showCanvasBoundary = true ;
     }

     public  void prepareFigure(Figure canvas) {
          String Blue = "0  0.26667 0.53333 setrgbcolor " ;
          String Black  = "0 0 0 setrgbcolor " ;
          canvas.append( new fPsWrite(Blue+"\n")) ;
          fEnv("useColorPs", "true") ;
          fEnv("lineWidth", 1.0) ;
          fCurve("[t*t*t , t*t]", 1, -1.26, 1.26, OPEN) ;
          canvas.append( new fPsWrite(Black+"\n")) ;
          fEnv("useColorPs", "false") ;
          fEnv("lineWidth", 0.5) ;
          fLine(xmin,0, xmax, 0) ;
          fLine(0,-0.3, 0, ymax) ;

          double aspect = (ymax-ymin)*xsize/(xmax-xmin)/ysize ; // = 4.44
          double r = 0.04 ;
          fDisk(0, 0, r,r*aspect, FILLED) ;
          fTeXlabel(0.05, -0.05, "tl", "$(0, 0)$") ;

          fTeXlabel(xmax, -0.1, "tr", "$x$") ;
          fTeXlabel(-0.05, ymax, "tr", "$y$") ;

          fTeXlabel(1.0, 1.06, "tl", "$y=g(x)=x^{2/3}$") ;

          fBracket bracket4 = new fBracket(xmax, -0.35, 0.02, -0.35, 0.05) ;
          bracket4.configure("ar",  0.15*aspect*0.4) ;     // default 0.15
          bracket4.configure("endscale", 1.1*aspect*0.4) ; // default 1.1
          bracket4.configure("centerscale",  1.0*aspect*0.45) ; // default 1.0
          bracket4.configure("centerangle",  40) ;   // default 60
//          bracket4.configure("endangle",  50) ;      // default 50
          canvas.append(bracket4) ;
          fTeXlabel( (0.02+xmax)/2.0, -0.5, "tc", 
                         "${\\scriptstyle g'>0,\\ g{\\rm\\  increasing}}$" ) ;
          fTeXlabel( (0.02+xmax)/2.0, -0.75, "tc", 
                    "${\\ \\ \\ \\ \\scriptstyle g''<0,\\ g{\\rm\\  concave\\ down}}$" ) ;


          fBracket bracket5 = new fBracket(-0.02, -0.35, xmin, -0.35, 0.05) ;
          bracket5.configure("ar",  0.15*aspect*0.4) ;     // default 0.15
          bracket5.configure("endscale", 1.1*aspect*0.4) ; // default 1.1
          bracket5.configure("centerscale",  1.0*aspect*0.45) ; // default 1.0
          bracket5.configure("centerangle",  40) ;   // default 60
//          bracket5.configure("endangle",  50) ;      // default 50
          canvas.append(bracket5) ;
          fTeXlabel( (-0.02+xmin)/2.0, -0.5, "tc", 
                         "${\\scriptstyle g'<0,\\ g{\\rm\\  decreasing}}$" ) ;
          fTeXlabel( (-0.02+xmin)/2.0, -0.75, "tc", 
                         "${\\scriptstyle g''<0,\\ g{\\rm\\  concave\\ down}}$" ) ;

     }
}
