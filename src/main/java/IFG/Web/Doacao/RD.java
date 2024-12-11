package IFG.Web.Doacao;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import IFG.DAOs.DoacaoDAO;
import IFG.Class.Doacao;

//@WebServlet("/selectDoacao")
public class RD extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        DoacaoDAO doacaoDAO = new DoacaoDAO();

        Optional<Doacao> doacaoOptional = doacaoDAO.findByIddoa(id);
        Doacao doacao = doacaoOptional.get(); 
        try {

            if (doacao == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Doacao não encontrada");
                return;
            }
            
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<html><body>");
            response.getWriter().println("<h1>Registro excluído com sucesso!</h1>");
            response.getWriter().write("<p>Estado: " + doacao.getEstado() + "</p>");
            response.getWriter().write("<p>Descrição: " + doacao.getDescricao() + "</p>");
            response.getWriter().write("<p>Data de Doação: " + doacao.getDatadoa() + "</p>");
            response.getWriter().write("<p>Data de Recebimento: " + doacao.getDatarec() + "</p>");
            response.getWriter().write("<p>Animal: " + doacao.animalString() + "</p>");
            response.getWriter().write("<p>Pessoa: " + doacao.pesString() + "</p>");
            response.getWriter().println("<a href='/menu.html'>Voltar ao menu</a>");
            response.getWriter().write("</body></html>");
        } catch (Exception e) {

            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao selecionar a doacao");
        }
    }
}
