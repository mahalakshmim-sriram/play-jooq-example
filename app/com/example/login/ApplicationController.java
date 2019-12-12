package com.example.login;

import play.mvc.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ApplicationController extends Controller {

    public Result index() {
        return ok("Opening application");
    }

}
