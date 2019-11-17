package controller;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

import jdk.nashorn.internal.parser.JSONParser;
import model.Obstacle;


public class JsonLoader {

	public JsonLoader() {
		
	}

	public ArrayList<Obstacle> getObstacles(String pFileName) throws Exception{  
		ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
		try {
			JSONObject jsonObject = new JSONObject(pFileName);
			JSONArray obstaculos = (JSONArray) jsonObject.get("obstaculos");
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
