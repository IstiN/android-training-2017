/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Servlet Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloWorld
*/

package com.epam.training.backend.calculator;

import com.epam.training.backend.calculator.domain.Result;
import com.google.gson.Gson;
import com.udojava.evalex.Expression;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {
    @Override
    public void doGet(final HttpServletRequest pRequest, final HttpServletResponse pResponse)
            throws IOException {
        pResponse.setContentType("application/json");

        final Result result = new Result();
        try {
            final String input = pRequest.getParameter("input");
            BigDecimal value = new Expression(input).eval();
            result.setSum(value.toString());
        } catch (final Exception e) {
            result.setError(e.toString());
        }

        //TODO what is faster?

        //1
        new Gson().toJson(result, pResponse.getWriter());

        //2
//        final String resultAsString = new Gson().toJson(result);
//        pResponse.getWriter().print(resultAsString);
    }

    @Override
    public void doPost(final HttpServletRequest req, final HttpServletResponse resp)
            throws IOException {
        final String name = req.getParameter("name");
        resp.setContentType("text/plain");
        if (name == null || "".equals(name)) {
            resp.getWriter().println("Please enter a name");
        }
        resp.getWriter().println("Hello " + name);
    }
}
