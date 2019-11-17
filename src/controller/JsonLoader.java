package controller;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import model.Obstacle;


public class JsonLoader {
	public JsonLoader() {
		
	}

	public ArrayList<Obstacle> getObstacles(String pFileName) throws Exception{  
		ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
		try {
	        InputStream is = getClass().getResourceAsStream(pFileName);
	        if (is == null) {
	            throw new NullPointerException("Cannot find resource file " + pFileName);
	        }

	        JSONTokener tokener = new JSONTokener(is.toString());
	        JSONObject objects = new JSONObject(tokener);
			JSONArray obstaculos = (JSONArray) objects.get("obstaculos");
			for (int index = 0; index < obstaculos.length(); index++) {
				JSONObject object = (JSONObject)obstaculos.get(index);
				String x1 = ((String)object.get("x1"));
				String y1 = ((String)object.get("y1"));
				String x2 = ((String)object.get("x2"));
				String y2 = ((String)object.get("y2"));
				int width = Math.abs(Integer.parseInt(x1) - Integer.parseInt(x2));
				int height = Math.abs(Integer.parseInt(y1) - Integer.parseInt(y2));
				Obstacle obstacle = new Obstacle(Integer.parseInt(x1), Integer.parseInt(y1), width, height);
				obstacles.add(obstacle);
			}
			}catch (Exception e) {
				throw new Exception("ERROR: couldn't read json file");
			}
		return obstacles;
	}
}
