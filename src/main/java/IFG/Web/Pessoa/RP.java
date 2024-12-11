package IFG.Web.Pessoa;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import IFG.Class.Pessoa;
import IFG.DAOs.PessoaDAO;


//@WebServlet("/selectPessoa")
public class RP extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        PessoaDAO pessoaDAO = new PessoaDAO();

        Optional<Pessoa> pessoaOptional = pessoaDAO.findByIdpes(id);
        Pessoa pessoa = pessoaOptional.get(); 
     

        try {

            if (pessoa == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Pessoa não encontrada");
                return;
            }
            
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<html><body>");
            response.getWriter().println("<h1>Pessoa Selecionada</h1>");
            response.getWriter().println("<p>Nome: " + pessoa.getNome() + "</p>");
            response.getWriter().println("<p>Endereço: " + pessoa.getEndereco() + "</p>");
            response.getWriter().println("<p>Telefone: " + pessoa.getTelefone() + "</p>");
            response.getWriter().println("<p>Email: " + pessoa.getEmail() + "</p>");
            response.getWriter().println("<p>Data de Nascimento: " + pessoa.getData() + "</p>");
            response.getWriter().println("<a href='/menu.html'>Voltar ao menu</a>");
            response.getWriter().write("</body></html>");
        } catch (Exception e) {

            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao selecionar a pessoa");
        }
    }
}
