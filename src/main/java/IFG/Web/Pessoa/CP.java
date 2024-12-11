package IFG.Web.Pessoa;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import IFG.Class.Pessoa;
import IFG.DAOs.PessoaDAO;

//@WebServlet("/createPessoa")
public class CP extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        String datanasc = request.getParameter("datanasc");

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setEndereco(endereco);
        pessoa.setTelefone(telefone);
        pessoa.setEmail(email);
        pessoa.setData(datanasc);

 
        PessoaDAO pessoaDAO = new PessoaDAO();
        try {
            pessoaDAO.savepes(pessoa); 

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<html><body>");
            response.getWriter().write("<h1>Pessoa criada com sucesso!</h1>");
            response.getWriter().write("<p>Nome: " + nome + "</p>");
            response.getWriter().write("<p>Endereço: " + endereco + "</p>");
            response.getWriter().write("<p>Telefone: " + telefone + "</p>");
            response.getWriter().write("<p>Email: " + email + "</p>");
            response.getWriter().write("<p>Data de Nascimento: " + datanasc + "</p>");
            response.getWriter().println("<a href='/menu.html'>Voltar ao menu</a>");
            response.getWriter().write("</body></html>");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao salvar a pessoa");
        }
    }
}
