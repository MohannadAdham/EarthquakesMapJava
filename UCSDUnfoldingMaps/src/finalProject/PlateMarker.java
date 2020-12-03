package finalProject;

import java.util.HashMap;
import java.util.List;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.MultiFeature;
import de.fhpotsdam.unfolding.data.ShapeFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePolygonMarker;
import de.fhpotsdam.unfolding.utils.MapPosition;
import processing.core.PGraphics;

public class PlateMarker extends SimplePolygonMarker {

	public PlateMarker() {
		// TODO Auto-generated constructor stub
	}

	public PlateMarker(List<Location> location) {
		super(location);		
	}

	public PlateMarker(Feature plate) {
		super(((ShapeFeature)plate).getLocations(), plate.getProperties());
	}
	
//	public void draw(PGraphics pg, List<MapPosition> mapPositions) {
//		pg.pushStyle();
//		pg.fill(255, 0, 0, 50);
////		pg.popStyle();
//	}
	
	

}
