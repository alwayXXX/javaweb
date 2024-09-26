package top.soft.class03response.response;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

@WebServlet("/res")
public class ResponseTypeDemo extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        System.out.println(type);
        switch (type) {
            case "html":
                getHtml(response);
                break;
            case "json":
                getJson(response);
            case "img":
                getImg(request, response);
                break;
            case "pdf":
                getPdf(request, response);
                break;

            default:
                break;
        }
    }

    private void getHtml(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "HTML" + "</h1>");
        out.println("</body></html>");
        out.flush();
        out.close();
    }

    private void getJson(HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String json = "{\n" +
                "  \"username\": \"zhangsan\",\n" +
                "  \"pwd\": \"123123\",\n" +
                "}";
        out.println(json);
        out.flush();
        out.close();
    }

    private void getImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/png");
        String path = request.getServletContext().getRealPath("");
        File file = new File(path + "/img/image.png");
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream out = response.getOutputStream();
        while ((read = in.read()) != -1) {
            out.write(read);

        }
        out.flush();
        out.close();
    }

    private void getPdf(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        String path = request.getServletContext().getRealPath("");
        File file = new File(path + "/pdf/1.pdf");
        InputStream in = new FileInputStream(file);
        int read = 0;
        ServletOutputStream out = response.getOutputStream();
        while ((read = in.read()) != -1) {
            out.write(read);

        }
        out.flush();
        out.close();
    }

}