/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resource;

import Analysis.AnalysisHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Martin
 */
@Path("analyze")
public class AnalysisResource {

    @Context
    private UriInfo context;
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    
    @Path("test")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String test(){
        return GSON.toJson("It works!");
    }
    
    @Path("postlog")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON})
    public String analyze(String jsonString) {
        JsonObject json = new JsonParser().parse(jsonString).getAsJsonObject();
        String initiator = json.get("initiator").getAsString();
        String data = json.get("data").getAsString();
        try {
            AnalysisHandler a = new AnalysisHandler(initiator, data);
            return GSON.toJson("der er hul igennem");
         
            //Return resultObject
        }
        catch (IOException e) {
            return GSON.toJson(e.toString());
        } catch (InterruptedException ex) {
            Logger.getLogger(AnalysisResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
