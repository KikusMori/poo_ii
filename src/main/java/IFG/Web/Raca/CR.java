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

//@WebServlet("/createRaca")
public class CR extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String idt = request.getParameter("idt");

        Tipo tipo = null;
        Long tid = Long.parseLong(idt); 
        TipoDAO tipoDAO = new TipoDAO();
        Optional<Tipo> tipoOptional = tipoDAO.findByIdtip(tid);
        tipo = tipoOptional.get(); 
 
        Raca raca = new Raca();
        raca.setNome(nome);
        raca.setDescricao(descricao);
        raca.setTipo(tipo);

        RacaDAO racaDAO = new RacaDAO();
        try {
            racaDAO.saverac(raca); 

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<html><body>");
            response.getWriter().write("<h1>Raça criada com sucesso!</h1>");
            response.getWriter().write("<p>Nome: " + nome + "</p>");
            response.getWriter().write("<p>Descrição: " + descricao + "</p>");
            response.getWriter().write("<p>Tipo: " + tipo.getNome() + "</p>");
            response.getWriter().println("<a href='/menu.html'>Voltar ao menu</a>");
            response.getWriter().write("</body></html>");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao salvar a raça");
        }
    }
}
