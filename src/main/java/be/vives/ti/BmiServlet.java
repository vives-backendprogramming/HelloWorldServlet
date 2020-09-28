package be.vives.ti;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculateBmi")
public class BmiServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String height = req.getParameter("lengte");
        String weight = req.getParameter("gewicht");

        try {
            double bmi = calculateBMI(
                    Double.parseDouble(weight),
                    Double.parseDouble(height));

            System.out.println(bmi);

            req.setAttribute("bmi", bmi);
            resp.setHeader("BMI", String.valueOf(bmi));

            RequestDispatcher dispatcher
                    = req.getRequestDispatcher("BMIResult.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resp.sendRedirect("index.jsp");
        }
    }

    private Double calculateBMI(Double weight, Double height) {
        return weight / (height * height);
    }
}
