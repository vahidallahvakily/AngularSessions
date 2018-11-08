package ir.co.isc.software.angulartraining.rs;

import java.io.IOException;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 *  *
 *  * @author V_Alahvakil
 *    CreateDateTime 10/20/2018
 *  
 */
@WebFilter(filterName = "AddHeaderFilter", urlPatterns = {"/*"})
public class CROSFilter implements Filter {


    private final static Logger log = Logger.getLogger(CROSFilter.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (response instanceof HttpServletResponse) {
            HttpServletResponse http = (HttpServletResponse) response;
            http.addHeader("Access-Control-Allow-Origin", "*");
            http.addHeader("Access-Control-Allow-Credentials", "true");
            http.addHeader("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT");
            http.addHeader("Access-Control-Allow-Headers",
                    "Access-Control-Allow-Headers, Origin,Accept, X-Requested-With,Content-Type");

        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}

