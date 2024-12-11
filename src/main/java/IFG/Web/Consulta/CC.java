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


//@WebServlet("/createConsulta")
public class CC extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        Consulta consulta = new Consulta();
        consulta.setDiagnostico(diagnostico);
        consulta.setData(data);
        consulta.setAnimal(animal);
        consulta.setVet(veterinario);

 
        ConsultaDAO consultaDAO = new ConsultaDAO();
        try {
            consultaDAO.savecon(consulta); 

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<html><body>");
            response.getWriter().write("<h1>Consulta criada com sucesso!</h1>");
            response.getWriter().write("<p>Diagnóstico: " + diagnostico + "</p>");
            response.getWriter().write("<p>Data: " + data + "</p>");
            response.getWriter().write("<p>Animal: " + animal.getNome() + "</p>");
            response.getWriter().write("<p>Veterinário: " + veterinario.getNome() + "</p>");
            response.getWriter().println("<a href='/menu.html'>Voltar ao menu</a>");
            response.getWriter().write("</body></html>");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao salvar a consulta");
        }
    }
}
