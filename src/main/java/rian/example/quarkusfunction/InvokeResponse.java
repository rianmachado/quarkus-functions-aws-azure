package rian.example.quarkusfunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InvokeResponse {
    public Map<String, Object> Outputs;
    public ArrayList<String> Logs;
    public Object ReturnValue; 

    public InvokeResponse(){
        Outputs = new HashMap<String,Object>();
        Logs = new ArrayList<String>();
    }
}
