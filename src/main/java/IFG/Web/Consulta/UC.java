package IFG.Web.Consulta;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import IFG.Class.Animal;
import IFG.Class.Veterinario;
import IFG.Class.Consulta;
import IFG.DAOs.AnimalDAO;
import IFG.DAOs.ConsultaDAO;
import IFG.DAOs.VeterinarioDAO;

//@WebServlet("/updateConsulta")
public class UC extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String diagnostico = request.getParameter("diagnostico");
        String data = request.getParameter("data");
        String ida = request.getParameter("ida");
        String idv = request.getParameter("idv");

        Animal animal = null;
        Long aid = Long.parseLong(ida); 
        AnimalDAO animalDAO = new AnimalDAO();
        Optional<Animal> animalOptional = animalDAO.findByIdani(aid);
        animal = animalOptional.get(); 

        Veterinario veterinario = null;
        Long vid = Long.parseLong(idv); 
        VeterinarioDAO veterinarioDAO= new VeterinarioDAO();
        Optional<Veterinario> veterinarioOptional = veterinarioDAO.findByIdvet(vid);
        veterinario = veterinarioOptional.get(); 

        Consulta consulta = new Consulta(id, diagnostico, data, animal, veterinario);
        ConsultaDAO consultaDAO = new ConsultaDAO();
        
        try {
            consultaDAO.updatecon(consulta);

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<html><body>");
            response.getWriter().println("<h1>Registro atualizado com sucesso!</h1>");
            response.getWriter().println("<p>Diagnóstico: " + consulta.getDiagnostico() + "</p>");
            response.getWriter().println("<p>Data: " + consulta.getData() + "</p>");
            response.getWriter().println("<p>Veterinário: " + consulta.vetString() + "</p>");
            response.getWriter().println("<p>Animal: " + consulta.animalString() + "</p>");
            response.getWriter().println("<a href='/menu.html'>Voltar ao menu</a>");
            response.getWriter().write("</body></html>");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao atualizar a consulta");
        }
    }
}
