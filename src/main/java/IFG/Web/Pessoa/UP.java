package IFG.Web.Pessoa;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import IFG.Class.Pessoa;
import IFG.DAOs.PessoaDAO;


//@WebServlet("/updatePessoa")
public class UP extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String datanasc = request.getParameter("datanasc");

        Pessoa pessoa = new Pessoa(id, nome, endereco, telefone, email, datanasc);
        PessoaDAO pessoaDAO = new PessoaDAO();
        
        try {
            pessoaDAO.updatepes(pessoa);

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<html><body>");
            response.getWriter().println("<h1>Registro atualizado com sucesso!</h1>");
            response.getWriter().println("<p>Nome: " + pessoa.getNome() + "</p>");
            response.getWriter().println("<p>Endereço: " + pessoa.getEndereco() + "</p>");
            response.getWriter().println("<p>Telefone: " + pessoa.getTelefone() + "</p>");
            response.getWriter().println("<p>Email: " + pessoa.getEmail() + "</p>");
            response.getWriter().println("<p>Data de Nascimento: " + pessoa.getData() + "</p>");
            response.getWriter().println("<a href='/menu.html'>Voltar ao menu</a>");
            response.getWriter().write("</body></html>");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao atualizar a pessoa");
        }
    }
}
