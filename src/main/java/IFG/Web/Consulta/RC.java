package IFG.Web.Consulta;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import IFG.Class.Consulta;
import IFG.DAOs.ConsultaDAO;

//@WebServlet("/selectConsulta")
public class RC extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        ConsultaDAO consultaDAO = new ConsultaDAO();

        Optional<Consulta> consultaOptional = consultaDAO.findByIdcon(id);
        Consulta consulta = consultaOptional.get(); 
        try {

            if (consulta == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Consulta não encontrada");
                return;
            }
            
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<html><body>");
            response.getWriter().println("<h1>Consulta Selecionada</h1>");
            response.getWriter().println("<p>Diagnóstico: " + consulta.getDiagnostico() + "</p>");
            response.getWriter().println("<p>Data: " + consulta.getData() + "</p>");
            response.getWriter().println("<p>Veterinário: " + consulta.vetString() + "</p>");
            response.getWriter().println("<p>Animal: " + consulta.animalString() + "</p>");
            response.getWriter().println("<a href='/menu.html'>Voltar ao menu</a>");
            response.getWriter().write("</body></html>");
        } catch (Exception e) {

            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao selecionar a consulta");
        }
    }
}
