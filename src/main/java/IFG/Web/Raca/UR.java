package IFG.Web.Raca;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import IFG.Class.Raca;
import IFG.Class.Tipo;
import IFG.DAOs.RacaDAO;
import IFG.DAOs.TipoDAO;

//@WebServlet("/updateRaca")
public class UR extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String idt = request.getParameter("idt");

        Tipo tipo = null;
        Long tid = Long.parseLong(idt); 
        TipoDAO tipoDAO = new TipoDAO();
        Optional<Tipo> tipoOptional = tipoDAO.findByIdtip(tid);
        tipo = tipoOptional.get(); 
        
        Raca raca = new Raca(id, nome, descricao, tipo);
        RacaDAO racaDAO = new RacaDAO();

        try {
            racaDAO.updaterac(raca);

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<html><body>");
            response.getWriter().println("<h1>Registro atualizado com sucesso!</h1>");
            response.getWriter().println("<p>Nome: " + raca.getNome() + "</p>");
            response.getWriter().println("<p>Descrição: " + raca.getDescricao() + "</p>");
            response.getWriter().println("<p>Tipo: " + raca.tipoString() + "</p>");
            response.getWriter().println("<a href='/menu.html'>Voltar ao menu</a>");
            response.getWriter().write("</body></html>");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao atualizar a raca");
        }
    }
}
