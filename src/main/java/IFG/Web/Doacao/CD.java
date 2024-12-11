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
import IFG.Class.Pessoa;
import IFG.DAOs.PessoaDAO;
import IFG.Class.Doacao;

//@WebServlet("/createDoacao")
public class CD extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        Doacao doacao = new Doacao();
        doacao.setEstado(estado);
        doacao.setDescricao(descricao);
        doacao.setDatadoa(datadoa);
        doacao.setDatarec(datarec);
        doacao.setAnimal(animal);
        doacao.setPessoa(pessoa);

 
        DoacaoDAO doacaoDAO = new DoacaoDAO();
        try {
            doacaoDAO.savedoa(doacao); 

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<html><body>");
            response.getWriter().write("<h1>Doacao criada com sucesso!</h1>");
            response.getWriter().write("<p>Estado: " + estado + "</p>");
            response.getWriter().write("<p>Descrição: " + descricao + "</p>");
            response.getWriter().write("<p>Data de Doação: " + datadoa + "</p>");
            response.getWriter().write("<p>Data de Recebimento: " + datarec + "</p>");
            response.getWriter().write("<p>Animal: " + animal.getNome() + "</p>");
            response.getWriter().write("<p>Pessoa: " + pessoa.getNome() + "</p>");
            response.getWriter().println("<a href='/menu.html'>Voltar ao menu</a>");
            response.getWriter().write("</body></html>");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erro ao salvar a doacao");
        }
    }
}
