package main;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.CharArrayWriter;
import java.io.PrintWriter;

/**
 * Created by Cornelius on 03.11.2016.
 */
public class CharResponseWrapper extends HttpServletResponseWrapper {

    private CharArrayWriter output;

    public CharResponseWrapper(HttpServletResponse response) {
        super(response);
        output = new CharArrayWriter();
    }

    @Override
    public PrintWriter getWriter() {
        return new PrintWriter(output);
    }

    public String toString() {
        return output.toString();
    }

}
