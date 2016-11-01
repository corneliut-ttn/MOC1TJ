package main;

import main.model.WordFinder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Cornelius
 */
@WebServlet(name = "main.WordFinderServlet", urlPatterns = {"/wordfinderservlet"})
public class WordFinderServlet extends HttpServlet {

    static public String[] fileNames = {"words_eng.txt", "words_fra.txt", "words_ro.txt"};

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/input.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long startTime = System.currentTimeMillis();
        response.setContentType("text/html;charset=UTF-8");

        String sInput = request.getParameter("sInput");
        String sDictionary = request.getParameter("dictType");
        String sMinLength = request.getParameter("sMinLength");

        int nMinLength;
        nMinLength = Integer.parseInt(sMinLength);

        WordFinder wordFinderBean;

        if (sDictionary.equals("ENG")) {
            wordFinderBean = new WordFinder(fileNames[0]);
        } else if (sDictionary.equals("FRA")) {
            wordFinderBean = new WordFinder(fileNames[1]);
        } else {
            wordFinderBean = new WordFinder(fileNames[2]);
        }
        wordFinderBean.findWords(sInput, nMinLength);

        request.setAttribute("wordFinderResultBean", wordFinderBean.getWordFinderResultBean());
        request.setAttribute("requestTimeMillis", System.currentTimeMillis() - startTime);

        request.getRequestDispatcher("/result.jsp").forward(request, response);

        wordFinderBean.toLogFile();
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
