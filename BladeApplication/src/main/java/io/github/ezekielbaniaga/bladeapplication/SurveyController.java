/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.ezekielbaniaga.bladeapplication;

import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.JSON;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.PostRoute;
import com.blade.mvc.http.Request;
import com.blade.mvc.ui.RestResponse;

/**
 *
 * @author Peakielsamgel
 */
@Path
public class SurveyController {
    
    @GetRoute("signup")
    public String signUp(Request req) {
        req.attribute("regcount", 10567);
        return "signup.html"; // ~3ms return when cached, ~16ms first load
    }
    
    @PostRoute("signup")
    @JSON
    public RestResponse<SignUpResponse> submit(@Param String name) {
        SignUpResponse resp = new SignUpResponse();
        resp.id = 1234;
        resp.name = name;
        return RestResponse.ok(resp); // ~30ms return with JSON mapping
    }
}
