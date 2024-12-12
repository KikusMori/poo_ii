package IFG.Web.Doacao;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import IFG.Class.Animal;
import IFG.DAOs.AnimalDAO;
import IFG.DAOs.DoacaoDAO;
import IFG.DAOs.PessoaDAO;
import IFG.Class.Pessoa;
import IFG.Class.Doacao;


//@WebServlet("/updateDoacao")
public class UD extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String estado = request.getParameter("estado");
        String descricao = request.getParameter("descricao");
        String datadoa = request.getParameter("datadoa");
        String datarec = request.getParameter("datarec");
        String ida = request.getParameter("ida");
        String idp = request.getParameter("idp");

        Animal animal = null;
        Long aid = Long.parseLong(ida); 
        AnimalDAO animalDAO = new AnimalDAO();
        Optional<Animal> animalOptional = animalDAO.findByIdani(aid);
        animal = animalOptional.get(); 

        Pessoa pessoa = null;
        Long pid = Long.parseLong(idp); 
        PessoaDAO pessoaDAO = new PessoaDAO();
        Optional<Pessoa> pessoaOptional = pessoaDAO.findByIdpes(pid);
        pessoa = pessoaOptional.get(); 

        Doacao doacao = new Doacao(id, estado, descricao, datadoa, datarec, animal, pessoa);
        DoacaoDAO doacaoDAO = new DoacaoDAO();
        
        try {
            doacaoDAO.updatedoa(doacao);

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<html><body>");
            response.getWriter().println("<h1>Registro excluído com sucesso!</h1>");
            response.getWriter().write("<p>Estado: " + doacao.getEstado() + "</p>");
            response.getWriter().write("<p>Descrição: " + doacao.getDescricao() + "</p>");
            response.getWriter().write("<p>Data de Doação: " + doacao.getDatadoa() + "</p>");
            response.getWriter().write("<p>Data de Recebimento: " + doacao.getDatarec() + "</p>");
            response.getWriter().write("<p>Animal: " + animal.getNome() + "</p>");
            response.getWriter().write("<p>Pessoa: " + pessoa.getNome() + "</p>");
            response.getWriter().println("<a href='/menu.html'>Voltar ao menu</a>");
            response.getWriter().write("</body></html>");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao atualizar a doacao");
        }
    }
}
