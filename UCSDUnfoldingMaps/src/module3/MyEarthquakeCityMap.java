package module3;

//Java utilities libraries
import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
import java.util.List;

//Processing library
import processing.core.PApplet;

//Unfolding libraries
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.EsriProvider;
import de.fhpotsdam.unfolding.utils.MapUtils;


//Parsing library
import parsing.ParseFeed;


public class MyEarthquakeCityMap extends PApplet {
	private UnfoldingMap map;
	
	public void setup() {
		size(950, 600, OPENGL);
		map = new UnfoldingMap(this, 200, 50, 700, 500, new EsriProvider.WorldPhysical());
	    map.zoomToLevel(2);
	    MapUtils.createDefaultEventDispatcher(this, map);	
	    
		//Define the features that will be used to create the markers
		Location valLoc = new Location(-38.14f, -73.03f);
		Feature valEq = new PointFeature(valLoc);
		valEq.addProperty("title", "Valdivia, Chile");
		valEq.addProperty("magnitude", "9.5");
		valEq.addProperty("date", "May 22, 1960");
		valEq.addProperty("year", "1960");
		Location alskLoc = new Location(61.02f, -147.65f);
		Feature alskEq = new PointFeature(alskLoc);
		alskEq.addProperty("title", "1964 Great Alaska Earthquake");
		alskEq.addProperty("magnitude", "9.2");
		alskEq.addProperty("date", "March 28, 1964");
		alskEq.addProperty("year", "1964");
		
		List<PointFeature> bigEqs = new ArrayList<PointFeature>();
		bigEqs.add((PointFeature) valEq);
		bigEqs.add((PointFeature) alskEq);
		
		List<Marker> markers = new ArrayList<Marker>();
		for (PointFeature eq: bigEqs) {
			markers.add(new SimplePointMarker(eq.getLocation(), eq.getProperties()));
		}
		
		int yellow = color(255, 255, 0);
		int gray = color(150, 150, 150);
		
		for (Marker mk: markers) {
			if ( Integer.parseInt((String) mk.getProperty("year")) > 1960) {
				mk.setColor(yellow);
			}
			else {
				mk.setColor(gray);
			}
		}
		
		map.addMarkers(markers);
	}
	
	public void draw() {
		background(210);
		map.draw();
	}
}