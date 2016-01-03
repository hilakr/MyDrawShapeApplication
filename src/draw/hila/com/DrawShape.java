package draw.hila.com;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//Shape is enum for the various shapes
enum Shape {CIRCLE, POLYGON, LINE, CURVE, CLEAR };
//This class is responsible to draw the shapes
public class DrawShape extends JPanel  implements MouseListener {
	
	public static  Shape shape = Shape.CLEAR;
	//List of points to save the points of each shape.
	List <Point> clicksforLine =  new ArrayList <Point>();
	List <Point> clicksforPoly =  new ArrayList <Point>();
	List <Point> clicksforCircle =  new ArrayList <Point>();
	List <Point> clicksforCurve =  new ArrayList <Point>();
	//DraswShape constructor is responsible to add Mouse Listener in order to get the user clicks
	DrawShape(){
        super();
        setBackground(Color.WHITE);
        addMouseListener(this);
    }
	//This method is responsible to draw the shapes    
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	/*print the boat*/
    	ReadFile file = new ReadFile();
 		file.openFile();       
 		/* Map include all the points of the boat*/
 		Map <String,ArrayList<Point>> map = new HashMap<String,ArrayList<Point>>();
 		map = file.parseFile(); 
 		for (String key : map.keySet()) {
 	        	if (key.startsWith("line"))
 	        	{
 	    	        System.out.println(key + " " + map.get(key));
 	        		int x1 = (int) map.get(key).get(0).getX();
 	        		 int y1 = (int) map.get(key).get(0).getY();
 	        		 int x2 = (int)map.get(key).get(1).getX();
 	        		 int y2 = (int)map.get(key).get(1).getY();
 	        		 drawLine(x1,y1,x2,y2,g);	        		
 	        	}
 	        	if (key.startsWith("circle"))
 	        	{
 	    	        System.out.println(key + " " + map.get(key));
 	        		int x1 = (int) map.get(key).get(0).getX();
 	        		 int y1 = (int) map.get(key).get(0).getY();
 	        		 int x2 = (int)map.get(key).get(1).getX();
 	        		 int y2 = (int)map.get(key).get(1).getY();
 	        		 drawCircle(x1,y1,x2,y2,g);	        		
 	        	}
 	        	if (key.startsWith("curve"))
 	        	{
 	    	        System.out.println(key + " " + map.get(key));
 	        		int x1 = (int) map.get(key).get(0).getX();
 	        		int y1 = (int) map.get(key).get(0).getY();
 	        		int x2 = (int)map.get(key).get(1).getX();
 	        		int y2 = (int)map.get(key).get(1).getY();
 	        		int x3 = (int)map.get(key).get(2).getX();
	        		int y3 = (int)map.get(key).get(2).getY();
	        		int x4 = (int)map.get(key).get(3).getX();
 	        		int y4 = (int)map.get(key).get(3).getY();
 	        		drawCurve(x1,y1,x2,y2,x3,y3,x4,y4,200,g); 	        	}    		
 		}
 		
 		
 		
    	for (int i = 0; i < clicksforLine.size(); i++ )
		{
    		g.drawRect((int)Math.round(clicksforLine.get(i).getX()),(int) Math.round(clicksforLine.get(i).getY()),2,2);

		}
    	for (int j = 0; j < clicksforCircle.size(); j++ )
		{
    		g.drawRect((int)Math.round(clicksforCircle.get(j).getX()),(int) Math.round(clicksforCircle.get(j).getY()),2,2);

		}
    	for (int j = 0; j < clicksforPoly.size(); j++ )
		{
    		g.drawRect((int)Math.round(clicksforPoly.get(j).getX()),(int) Math.round(clicksforPoly.get(j).getY()),2,2);

		}
    	for (int j = 0; j < clicksforCurve.size(); j++ )
		{
    		g.drawRect((int)Math.round(clicksforCurve.get(j).getX()),(int) Math.round(clicksforCurve.get(j).getY()),2,2);

		}
            
  	
    	//check is the list of the shape LINE has at least 2 points to draw line
      	if (clicksforLine.size() >= 2)
        {
        	for (int i=0; i < clicksforLine.size(); i+=2 )
    	    		{
    		            int x1=0, y1=0, x2=0, y2=0;
    		    		System.out.println("Line case");
    			        x1 = (int) clicksforLine.get(i).getX();
    			        y1 = (int) clicksforLine.get(i).getY();
    			        x2 = (int) clicksforLine.get(i+1).getX();
    			        y2 = (int) clicksforLine.get(i+1).getY();
    			        drawLine(x1,y1,x2,y2,g);
    	       	    		
    	    	}
        }
      //check is the list of the shape CIRCLE has at least 2 points to draw circle
        if (clicksforCircle.size() >= 2)
        {	
        	for (int i=0; i < clicksforCircle.size(); i+=2 )
    		    	{
    		            int x1=0, y1=0, x2=0, y2=0;
    		    		System.out.println("Line case");
    			        x1 = (int) clicksforCircle.get(i).getX();
    			        y1 = (int) clicksforCircle.get(i).getY();
    			        x2 = (int) clicksforCircle.get(i+1).getX();
    			        y2 = (int) clicksforCircle.get(i+1).getY();
    			        drawCircle(x1,y1,x2,y2,g);
    	       	    		
    		    	}
    	    }
      //check is the list of the shape LINE has at least 2 points to draw line
      if (clicksforPoly.size() >= 2)
    	    {
    		       	for (int i=0; i < clicksforPoly.size(); i+=2 )
    		    	{
    		            int x1=0, y1=0, x2=0, y2=0;
    		    		System.out.println("Line case");
    			        x1 = (int) clicksforPoly.get(i).getX();
    			        y1 = (int) clicksforPoly.get(i).getY();
    			        x2 = (int) clicksforPoly.get(i+1).getX();
    			        y2 = (int) clicksforPoly.get(i+1).getY();
    			        String text = MyWindow.input.getText();
    			        drawPolygon(x1,y1,x2,y2,Integer.parseInt(text),g);
    	       	    		
    		    	}
    	    }
    //check is the list of the shape CURVE has at least 2 points to draw curve
      if (clicksforCurve.size() >= 4)
    	    {
    		       	for (int i=0; i < clicksforCurve.size(); i+=4 )
    		    	{
    	            int x1=0, y1=0, x2=0, y2=0, x3=0,y3=0,x4=0,y4=0;
    	    		System.out.println("Line case");
    		        x1 = (int) clicksforCurve.get(i).getX();
    		        y1 = (int) clicksforCurve.get(i).getY();
    		        x2 = (int) clicksforCurve.get(i+1).getX();
    		        y2 = (int) clicksforCurve.get(i+1).getY();
    		        x3 = (int) clicksforCurve.get(i+2).getX();
    		        y3 = (int) clicksforCurve.get(i+2).getY();
    		        x4 = (int) clicksforCurve.get(i+3).getX();
    		        y4 = (int) clicksforCurve.get(i+3).getY();
    		        String text = MyWindow.input.getText();
    		        drawCurve(x1,y1,x2,y2,x3,y3,x4,y4,Integer.parseInt(text),g);
     	    	}
    	    }
	
    }
    
    //drawLine method implements the algorithm of draw line
    public void drawLine(int x1, int y1, int x2, int y2 ,  Graphics g)  {
    	float dY, dX;
    	float x,y;
    	dX = x2-x1;
    	dY = y2-y1;
    	x = x1;
    	y = y1;
    			
    	float range =  Math.max(Math.abs(dX), Math.abs(dY));
    	dY = dY/range;
    	dX = dX/range;
    	
    	for (int i =0 ; i < range ; i++  ) { 
    		g.drawRect(Math.round(x), Math.round(y),1,1);
    		x = x + dX;
    		y = y + dY;
    	}

       	
    }
    
    /*Get Min X and Max X */
    public int minXValue (Map <String,ArrayList<Point>> map){
    	int min = 0 , i = 0;
 		for (String key : map.keySet()) {
 			if ( min < map.get(key).get(i).getX())
 				min = (int) map.get(key).get(i).getX();
 			i++;
 		}
    	return min;	
    }
    
    
    public int maxXValue (Map <String,ArrayList<Point>> map){
    	int max = 0 , i = 0;
 		for (String key : map.keySet()) {
 			if ( max < map.get(key).get(i).getX())
 				max = (int) map.get(key).get(i).getX();
 			i++;
 			
 		}
    	return max;	
    }
    /*Get Min Y and Max Y */

    public int minYValue (Map <String,ArrayList<Point>> map){
    	int min = 0 , i = 0;
 		for (String key : map.keySet()) {
 			if ( min < map.get(key).get(i).getY())
 				min = (int) map.get(key).get(i).getY();
 			i++;
 		}
    	return min;	
    }
    
    
    public int maxYValue (Map <String,ArrayList<Point>> map){
    	int max = 0 , i = 0;
 		for (String key : map.keySet()) {
 			if ( max < map.get(key).get(i).getY())
 				max = (int) map.get(key).get(i).getY();
 			i++;
 		}
    	return max;	
    }
    /*normaliztion include : Transcation , Scaling, Transcation */
    public void normalization(Map <String,ArrayList<Point>> map){
    	/*First Translation*/
    	int minX,minY,x,y,i = 0;
    	minX = minXValue(map);
    	minY = minYValue(map);
    	int indexTrans = 0;
    	for (String key : map.keySet()) {
    		x = (int) (map.get(key).get(indexTrans).getX() - minX);
    		y = (int) (map.get(key).get(indexTrans).getY()- minY);
    		/*set new x and y*/
    		map.get(key).set(i, new Point(x,y));
    		indexTrans++;
 		}
    	/*Scaling */
    	/*x = x*s ; y = y*s */
    	/*initialize s*/
    	int xMaxWindow= 600,yMaxWindow = 600,s;
    	if ((xMaxWindow/maxXValue(map)) < (yMaxWindow/maxYValue(map)))
    	{
    			s = (int) (0.8*(xMaxWindow/maxXValue(map)));
    	}
   		else
   		{
    		s = (int) (0.8*(yMaxWindow/maxYValue(map)));
   		}
    	int indexScaling = 0;
    	for (String key : map.keySet()) {
    		x = (int) (map.get(key).get(indexScaling).getX()*s);
    		y = (int) (map.get(key).get(indexScaling).getY()*s);
    		/*set new x and y*/
    		map.get(key).set(i, new Point(x,y));
    		indexScaling++;
 		}
    	/*Translation Back*/
    	/* x = x + 0.1*xMaxWindow ; y = y + 0.1*yMaxWindow */
    	int iSecTrans = 0;
    	for (String key : map.keySet()) {
    		x = (int) (map.get(key).get(i).getX() + 0.1*xMaxWindow);
    		y = (int) (map.get(key).get(i).getY() + 0.1*yMaxWindow);
    		/*set new x and y*/
    		map.get(key).set(i, new Point(x,y));
    		iSecTrans++;
 		}
   
    	
    	
    }
    //drawSymmetricalPoints method draw the symmetrical points of x and y
    public void drawSymmetricalPoints (int xc, int x, int yc, int y,  Graphics g ){
    	g.drawRect(xc + x, yc + y,1,1);
    	g.drawRect(xc - x, yc + y,1,1);
    	g.drawRect(xc + x, yc - y,1,1);
    	g.drawRect(xc - x, yc - y,1,1);
    	g.drawRect(xc + y, yc + x,1,1);
    	g.drawRect(xc - y, yc + x,1,1);
    	g.drawRect(xc + y, yc - x,1,1);
    	g.drawRect(xc - y, yc - x,1,1);
    }
    

    //drawCircle is method that implements the  circle algorithm 
    public void drawCircle(int xC, int yC, int xP,int yP,  Graphics g)  {
    	float x, y;
    	int partA = xC-xP;
    	int partB= yC-yP;
    	int r = (int) Math.sqrt(Math.pow(partA, 2)+ Math.pow(partB,2));
    	double delta = Math.PI / (2*Math.sqrt(2)*r);
    	    	for (int i = 0; i < (Math.sqrt(2) * r) / 2; i++) {
        	x = (float) (r * Math.cos( i * delta));
        	y = (float) (r * Math.sin( i * delta));
        	drawSymmetricalPoints(Math.round(xC),Math.round(x),Math.round(yC),Math.round(y),g);
    		
    	}
    
    }

    //drawPolygon is method that implements the  polygon algorithm 
    public void drawPolygon (int xC, int yC, int xP, int yP,int ribs, Graphics g){
    
    	int n = ribs; 
    	//delta keep the the original delta , this size of delta will increase in delta size each time.
    	double delta = (2* Math.PI)/ n;
    	double deltaTemp = delta;
    	//List of Points that I keep during n rotation.
    	List <Point> points; 
    	float x,y,newX,newY;
    	//First Sliding
    	x = xP - xC;
    	y = yP - yC;
    	newX = x;    	
    	newY = y;    	
    	List <Point> vertexs = new ArrayList();
    	//Follow delta angle rotation n times and write a list of vertices to vertexs list.
    	for (int i = 0; i < n ; i++)
    	{
    		newX =  (int) ((x*Math.cos(delta) - y*Math.sin(delta)));
    		newY =  (int) ((x*Math.sin(delta) + y*Math.cos(delta))); 
    		vertexs.add(new Point(Math.round(newX),Math.round(newY)));    	
    		System.out.println(vertexs.get(i).x+","+vertexs.get(i).y);
    		delta = delta + deltaTemp;
    	}
    	//Sliding back
    	for (int i = 0; i < vertexs.size(); i++ ){
    		vertexs.get(i).x = (int) (vertexs.get(i).getX() + xC);
    		vertexs.get(i).y = (int) (vertexs.get(i).getY() + yC);
    		g.drawRect(vertexs.get(i).x, vertexs.get(i).y ,1,1);
     	}
    	//draw line between the list of the points we got.
    	for (int z = 0 ; z < vertexs.size(); z++){
    		if (z == vertexs.size()-1)
    			drawLine((int) Math.round(vertexs.get(z).getX()), (int)(vertexs.get(z).getY()),(int)(vertexs.get(0).getX()), (int)(vertexs.get(0).getY()),g);
    		else
    			drawLine((int)(vertexs.get(z).getX()), (int)(vertexs.get(z).getY()),(int)(vertexs.get(z+1).getX()), (int)(vertexs.get(z+1).getY()),g);

    		}
           	
    }

    //This method calculates multiplication between Matrixs
	private static double[] matrixMultiply(double[][] bezier, double[] matrixVars) {
		double[] result = {0,0,0,0};
		for (int i = 0; i < bezier.length; i++) {
			for (int j=0; j < matrixVars.length; j++) {
				result[i] += bezier[i][j]*matrixVars[j];
			}
		}
		return result;
    }
	
	
    //drawCurve is method that implements the bezier curve algorithm     
    public void drawCurve (int x1, int y1, int x2, int y2, int x3, int y3 , int x4, int y4,int mylines, Graphics g ){
    	List<Point> points = new ArrayList();
    	//step is var that describes the  
    	double step = 1/ (double)mylines;
    	//X matrix
    	double[] arrX = {x1,x2,x3,x4};
    	//Y matrix
    	double[] arrY = {y1,y2,y3,y4};
    	//bezier matrix
    	final double [][]bezier = {{-1,3,-3,1},{3,-6,3,0},{-3,3,0,0},{1,0,0,0}};
    	//create the paramters for x and y {a,b,c,d}
    	double [] resultX = matrixMultiply(bezier,arrX);
    	double [] resultY = matrixMultiply(bezier,arrY);
    	//x,y - the new points calculated on the curve
    	double x,y;
    	//calculate points on the curve accroding the Folinm .
		for (double t = 0; t < 1 ; t+=step)
		{
			x =  (double) (resultX[0]*t*t*t +resultX[1]*t*t+ resultX[2]*t + resultX[3]);
    		y =  (double) (resultY[0]*t*t*t +resultY[1]*t*t+ resultY[2]*t + resultY[3]);
	    	points.add(new Point((int)x,(int)y));
    	}
		
		//The curve should end in the (x4,y4) check point
		points.add(new Point (x4,y4));
		
		//draw line between all the points 
	    for (int i = 0; i < points.size() - 1; i++) {
	    	drawLine((int)points.get(i).getX(),(int)points.get(i).getY(), (int)points.get(i+1).getX(),(int)points.get(i+1).getY(),g);
	    }
	  
	    
    }

    
    //Override the methods of MouseListenr Abstract class .(implements only the method: mousePressed)
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Point point = new Point();
		point.x = e.getX();
		point.y = e.getY();

	    switch (shape) {
	    
	    case LINE :

	    	this.clicksforLine.add(point);
	    	break;
	    case CIRCLE:

	    	this.clicksforCircle.add(point);
	    	break;
	    case POLYGON:

	    	this.clicksforPoly.add(point);
	    	break;
	    case CURVE:

	    	this.clicksforCurve.add(point);
	    	break;
	    case CLEAR:
	    {
	    }
	    	break;
	    default:
	    	break;
	    }
       
		System.out.println(point.x+ ","+point.y);
        repaint();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
    
}



