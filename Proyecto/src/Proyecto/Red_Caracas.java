/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 *
 * @author rdbae
 */
public class Red_Caracas{
    private JsonArray context;
    private String type;
    private JsonObject geometry;
    private JsonObject properties;

    public Red_Caracas(JsonArray context, String type, JsonObject geometry, JsonObject properties) {
        this.context = context;
        this.type = type;
        this.geometry = geometry;
        this.properties = properties;
    }
    public Red_Caracas() {
        setContext(new JsonArray());
        setType("");
        setGeometry(new JsonObject());
        setProperties(new JsonObject());  
    }

    /**
     * @return the context
     */
    public JsonArray getContext() {
        return context;
    }

    /**
     * @param context the context to set
     */
    public void setContext(JsonArray context) {
        this.context = context;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the geometry
     */
    public JsonObject getGeometry() {
        return geometry;
    }

    /**
     * @param geometry the geometry to set
     */
    public void setGeometry(JsonObject geometry) {
        this.geometry = geometry;
    }

    /**
     * @return the properties
     */
    public JsonObject getProperties() {
        return properties;
    }

    /**
     * @param properties the properties to set
     */
    public void setProperties(JsonObject properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Red_Caracas{" + "context=" + context + ", type=" + type + ", geometry=" + geometry + ", properties=" + properties + '}';
    }
    
    
    


    
    
    
}    
    